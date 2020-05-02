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
public class ProcedureService {
	@Autowired
	private MongoDBClient mongoDBClient;
	@Autowired
	private ServerIdentification serverIdentification;
	@Autowired
	private JWTTokenProcessor jwtTokenProcessor;
	
	@PostMapping("{identificationType}/{identificationNumber}/procedure")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity()) and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> createProcedure(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber,@RequestBody String procedure) {
		MongoCollection<Document> collection = mongoDBClient.getProcedureCollection();
		Document procedureDocument = Document.parse(procedure);
		String uuid = UUID.randomUUID().toString();	
		if (procedureDocument.containsKey("id"))
			procedureDocument.replace("id", uuid);
		else
			procedureDocument.put("id", uuid);
		collection.insertOne(procedureDocument);
		
		Transaction mTransaction = new Transaction();
		mTransaction.setInstitution(Integer.toString(serverIdentification.getHealthEntityId()));
		Document recorder, patient;
		recorder = (Document) procedureDocument.get("performer");
		patient = (Document) procedureDocument.get("subject");
		mTransaction.setSenderRole(RoleEnum.ROLE_DOCTOR.toString());
		mTransaction.setSender(recorder.getString("type") + "_" + recorder.getInteger("id").toString() );
		mTransaction.setRecipientRole(RoleEnum.ROLE_PATIENT.toString());
		mTransaction.setRecipient(patient.getString("type") + "_" + patient.getInteger("id").toString());	
		mTransaction.setOperation(OperationEnum.ADD);
		mTransaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
		// TODO : should check that the hashedDocument equals the hash when added in blockchain
		if(procedureDocument.containsKey("_id"))
			procedureDocument.remove("_id");
		String hashedDocument = Sha256.generateSha256(Sha256.DocumentToJsonString(procedureDocument));
		mTransaction.setResourceIntegrity(hashedDocument);
		mTransaction.setResourceType(ResourceTypeEnum.Procedure);
		String idType, idNumber, mResourceId;
		idType = patient.getString("type"); idNumber = patient.getInteger("id").toString(); 
		mResourceId = procedureDocument.getString("id");
		mTransaction.setResourcePath(serverIdentification.getServerUrl()+ idType + "/" + idNumber + "/procedure/" + mResourceId);
		
		NetworkTransaction.sendTransaction(mTransaction, serverIdentification.getBcserverUrl());
		
		return new ResponseEntity<Object>(null, HttpStatus.CREATED);
	}
	
	@GetMapping("{identificationType}/{identificationNumber}/procedure/{resourceId}")
	@PreAuthorize("(hasRole('ROLE_DOCTOR') or hasRole('ROLE_NURSE') or hasRole('ROLE_PATIENT'))"
			+ "and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> getProcedure(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber,
			@PathVariable String resourceId, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getProcedureCollection();
		Document procedure = collection.find(Filters.and(Filters.eq("id", resourceId), Filters.eq("subject.type", 
				identificationType.toString()), Filters.eq("subject.id", identificationNumber))).first();
		if(procedure != null) {
			
			if(procedure.containsKey("_id"))
				procedure.remove("_id");
			Transaction mTransaction = new Transaction();
			mTransaction.setInstitution(Integer.toString(serverIdentification.getHealthEntityId()));
			Document recorder, patient;
			recorder = (Document) procedure.get("performer");
			patient = (Document) procedure.get("subject");
			mTransaction.setSenderRole(jwtTokenProcessor.getAuthorities(token));
			mTransaction.setSender(recorder.getString("type") + "_" + recorder.getInteger("id").toString() );
			mTransaction.setRecipientRole(RoleEnum.ROLE_PATIENT.toString());
			mTransaction.setRecipient(patient.getString("type") + "_" + patient.getInteger("id").toString());	
			mTransaction.setOperation(OperationEnum.READ);
			mTransaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
			mTransaction.setResourceType(ResourceTypeEnum.Procedure);
			String idType, idNumber, mResourceId;
			idType = patient.getString("type"); idNumber = patient.getInteger("id").toString(); 
			mResourceId = procedure.getString("id");
			mTransaction.setResourcePath(serverIdentification.getServerUrl()+ idType + "/" + idNumber + "/procedure/" + mResourceId);
			// TODO : should check that the hashedDocument equals the hash when added in blockchain			
			String hashedDocument = Sha256.generateSha256(Sha256.DocumentToJsonString(procedure));
			mTransaction.setResourceIntegrity(hashedDocument);
			NetworkTransaction.sendTransaction(mTransaction, serverIdentification.getBcserverUrl());
			
			return new ResponseEntity<>(procedure, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
