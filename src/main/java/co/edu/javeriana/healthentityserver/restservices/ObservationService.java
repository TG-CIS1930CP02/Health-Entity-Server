package co.edu.javeriana.healthentityserver.restservices;

import java.sql.Timestamp;
import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import co.edu.javeriana.healthentityserver.blockchain.NetworkTransaction;
import co.edu.javeriana.healthentityserver.blockchain.Sha256;
import co.edu.javeriana.healthentityserver.blockchain.Transaction;
import co.edu.javeriana.healthentityserver.enums.IdentificationTypeEnum;
import co.edu.javeriana.healthentityserver.enums.OperationEnum;
import co.edu.javeriana.healthentityserver.enums.ResourceTypeEnum;
import co.edu.javeriana.healthentityserver.enums.RoleEnum;
import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;
import co.edu.javeriana.healthentityserver.security.JWTTokenProcessor;
import co.edu.javeriana.healthentityserver.security.ServerIdentification;

@RestController
public class ObservationService {
	@Autowired
	private MongoDBClient mongoDBClient;
	@Autowired
	private ServerIdentification serverIdentification;
	@Autowired
	private JWTTokenProcessor jwtTokenProcessor;
	
	@PostMapping("{identificationType}/{identificationNumber}/observation")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity()) and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> createObservation(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber, @RequestBody String observation) {
		MongoCollection<Document> collection = mongoDBClient.getObservationCollection();
		Document observationDocument = Document.parse(observation);
		String uuid = UUID.randomUUID().toString();	
		if (observationDocument.containsKey("id"))
			observationDocument.replace("id", uuid);
		else
			observationDocument.put("id", uuid);
		collection.insertOne(observationDocument);
		
		Transaction mTransaction = new Transaction();
		mTransaction.setInstitution(Integer.toString(serverIdentification.getHealthEntityId()));
		Document recorder, patient;
		recorder = (Document) observationDocument.get("performer");
		patient = (Document) observationDocument.get("subject");
		mTransaction.setSenderRole(RoleEnum.ROLE_DOCTOR.toString());
		mTransaction.setSender(recorder.getString("type") + "_" + recorder.getInteger("id").toString() );
		mTransaction.setRecipientRole(RoleEnum.ROLE_PATIENT.toString());
		mTransaction.setRecipient(patient.getString("type") + "_" + patient.getInteger("id").toString());	
		mTransaction.setOperation(OperationEnum.ADD);
		mTransaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
		// TODO : should check that the hashedDocument equals the hash when added in blockchain
		if(observationDocument.containsKey("_id"))
			observationDocument.remove("_id");
		String hashedDocument = Sha256.generateSha256(Sha256.DocumentToJsonString(observationDocument));;
		mTransaction.setResourceIntegrity(hashedDocument);
		mTransaction.setResourceType(ResourceTypeEnum.Observation);
		String idType, idNumber, mResourceId;
		idType = patient.getString("type"); idNumber = patient.getInteger("id").toString(); 
		mResourceId = observationDocument.getString("id");
		mTransaction.setResourcePath(serverIdentification.getServerUrl()+ idType + "/" + idNumber + "/observation/" + mResourceId);
		
		NetworkTransaction.sendTransaction(mTransaction, serverIdentification.getBcserverUrl());
		
		return new ResponseEntity<Object>(null, HttpStatus.CREATED);
	}
	
	@GetMapping("{identificationType}/{identificationNumber}/observation/{resourceId}")
	@PreAuthorize("(hasRole('ROLE_DOCTOR') or hasRole('ROLE_NURSE') or hasRole('ROLE_PATIENT'))"
			+ "and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> getObservation(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber,
			@PathVariable String resourceId, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getObservationCollection();
		Document observation = collection.find(Filters.and(Filters.eq("id", resourceId), Filters.eq("subject.type", 
				identificationType.toString()), Filters.eq("subject.id", identificationNumber))).first();
		if(observation != null) {
			
			if(observation.containsKey("_id"))
				observation.remove("_id");
			Transaction mTransaction = new Transaction();
			mTransaction.setInstitution(Integer.toString(serverIdentification.getHealthEntityId()));
			Document recorder, patient;
			recorder = (Document) observation.get("performer");
			patient = (Document) observation.get("subject");
			mTransaction.setSenderRole(jwtTokenProcessor.getAuthorities(token));
			mTransaction.setSender(recorder.getString("type") + "_" + recorder.getInteger("id").toString() );
			mTransaction.setRecipientRole(RoleEnum.ROLE_PATIENT.toString());
			mTransaction.setRecipient(patient.getString("type") + "_" + patient.getInteger("id").toString());	
			mTransaction.setOperation(OperationEnum.READ);
			mTransaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
			mTransaction.setResourceType(ResourceTypeEnum.Observation);
			String idType, idNumber, mResourceId;
			idType = patient.getString("type"); idNumber = patient.getInteger("id").toString(); 
			mResourceId = observation.getString("id");
			mTransaction.setResourcePath(serverIdentification.getServerUrl()+ idType + "/" + idNumber + "/observation/" + mResourceId);
			// TODO : should check that the hashedDocument equals the hash when added in blockchain			
			String hashedDocument = Sha256.generateSha256(Sha256.DocumentToJsonString(observation));
			mTransaction.setResourceIntegrity(hashedDocument);
			NetworkTransaction.sendTransaction(mTransaction, serverIdentification.getBcserverUrl());
			
			return new ResponseEntity<>(observation, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
