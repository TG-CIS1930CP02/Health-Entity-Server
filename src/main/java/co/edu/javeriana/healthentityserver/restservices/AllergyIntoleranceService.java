package co.edu.javeriana.healthentityserver.restservices;

import java.sql.Timestamp;
import java.util.UUID;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
public class AllergyIntoleranceService {
	@Autowired
	private MongoDBClient mongoDBClient;
	@Autowired
	private ServerIdentification serverIdentification;
	@Autowired
	private JWTTokenProcessor jwtTokenProcessor;
	
	@PostMapping("{identificationType}/{identificationNumber}/allergy-intolerance")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity()) and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> createAllergyIntolerance(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber, @RequestBody String allergyIntolerance) {
		MongoCollection<Document> collection = mongoDBClient.getAllergyIntoleranceCollection();
		Document allergyIntoleranceDocument = Document.parse(allergyIntolerance);
		String uuid = UUID.randomUUID().toString();	
		if (allergyIntoleranceDocument.containsKey("id"))
			allergyIntoleranceDocument.replace("id", uuid);
		else
			allergyIntoleranceDocument.put("id", uuid);
		collection.insertOne(allergyIntoleranceDocument);
		
		Transaction mTransaction = new Transaction();
		mTransaction.setInstitution(Integer.toString(serverIdentification.getHealthEntityId()));
		Document recorder, patient;
		recorder = (Document) allergyIntoleranceDocument.get("recorder");
		patient = (Document) allergyIntoleranceDocument.get("patient");
		
		mTransaction.setSenderRole(RoleEnum.ROLE_DOCTOR.toString());
		mTransaction.setSender(recorder.getString("type") + "_" + recorder.getInteger("id").toString() );
		mTransaction.setRecipientRole(RoleEnum.ROLE_PATIENT.toString());
		mTransaction.setRecipient(patient.getString("type") + "_" + patient.getInteger("id").toString());	
		mTransaction.setOperation(OperationEnum.ADD);
		mTransaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
		mTransaction.setResourceType(ResourceTypeEnum.AllergyIntolerance);
		String idType, idNumber, resourceId;
		idType = patient.getString("type"); idNumber = patient.getInteger("id").toString(); 
		resourceId = allergyIntoleranceDocument.getString("id");
		mTransaction.setResourcePath(serverIdentification.getServerUrl()+ idType + "/" + idNumber + "/allergy-intolerance/" + resourceId);
		
		if(allergyIntoleranceDocument.containsKey("_id"))
			allergyIntoleranceDocument.remove("_id");
		String hashedDocument = Sha256.generateSha256(Sha256.DocumentToJsonString(allergyIntoleranceDocument));
		mTransaction.setResourceIntegrity(hashedDocument);
		
		NetworkTransaction.sendTransaction(mTransaction, serverIdentification.getBcserverUrl());
		
		return new ResponseEntity<Object>(null, HttpStatus.CREATED);
	}
	
	@GetMapping("{identificationType}/{identificationNumber}/allergy-intolerance/{resourceId}")
	@PreAuthorize("(hasRole('ROLE_DOCTOR') or hasRole('ROLE_NURSE') or hasRole('ROLE_PATIENT'))"
			+ "and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> getAllergyIntolerance(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber,
			@PathVariable String resourceId, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getAllergyIntoleranceCollection();
		Document allergyIntolerance = collection.find(Filters.and(Filters.eq("id", resourceId), Filters.eq("patient.type", 
				identificationType.toString()), Filters.eq("patient.id", identificationNumber))).first();
		if(allergyIntolerance != null) {
			
			if(allergyIntolerance.containsKey("_id"))
				allergyIntolerance.remove("_id");
			Transaction mTransaction = new Transaction();
			mTransaction.setInstitution(Integer.toString(serverIdentification.getHealthEntityId()));
			Document recorder, patient;
			recorder = (Document) allergyIntolerance.get("recorder");
			patient = (Document) allergyIntolerance.get("patient");
			mTransaction.setSenderRole(jwtTokenProcessor.getAuthorities(token));
			mTransaction.setSender(recorder.getString("type") + "_" + recorder.getInteger("id").toString() );
			mTransaction.setRecipientRole(RoleEnum.ROLE_PATIENT.toString());
			mTransaction.setRecipient(patient.getString("type") + "_" + patient.getInteger("id").toString());	
			mTransaction.setOperation(OperationEnum.READ);
			mTransaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
			mTransaction.setResourceType(ResourceTypeEnum.AllergyIntolerance);
			String idType, idNumber, mResourceId;
			idType = patient.getString("type"); idNumber = patient.getInteger("id").toString(); 
			mResourceId = allergyIntolerance.getString("id");
			mTransaction.setResourcePath(serverIdentification.getServerUrl()+ idType + "/" + idNumber + "/allergy-intolerance/" + mResourceId);
			// TODO : should check that the hashedDocument equals the hash when added in blockchain			
			String hashedDocument = Sha256.generateSha256(Sha256.DocumentToJsonString(allergyIntolerance));
			mTransaction.setResourceIntegrity(hashedDocument);
			NetworkTransaction.sendTransaction(mTransaction, serverIdentification.getBcserverUrl());
			
			return new ResponseEntity<>(allergyIntolerance, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
