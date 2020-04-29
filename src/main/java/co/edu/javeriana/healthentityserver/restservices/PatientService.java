package co.edu.javeriana.healthentityserver.restservices;

import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import co.edu.javeriana.healthentityserver.enums.IdentificationTypeEnum;
import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;
import co.edu.javeriana.healthentityserver.security.JWTTokenProcessor;
import co.edu.javeriana.healthentityserver.security.ServerIdentification;

@RestController
public class PatientService {
	
	@Autowired
	private MongoDBClient mongoDBClient;
	@Autowired
	private ServerIdentification serverIdentification;
	@Autowired
	private JWTTokenProcessor jwtTokenProcessor;
		
	@PostMapping("/patient")
	@PreAuthorize("hasRole('ROLE_ADMINISTRATIVE_ASSISTANT') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity())")
	public void createPatient(@RequestBody String patient, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document patientDocument = Document.parse(patient);
		String uuid = UUID.randomUUID().toString();
		if (patientDocument.containsKey("id"))
			patientDocument.replace("id", uuid);
		else
			patientDocument.put("id", uuid);
		collection.insertOne(patientDocument);
	}
	
	@GetMapping("{identificationType}/{identificationNumber}/patient/{resourceId}")
	@PreAuthorize("(hasRole('ROLE_DOCTOR') or hasRole('ROLE_NURSE') or hasRole('ROLE_PATIENT'))"
			+ "and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> getPatient(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber,
			@PathVariable String resourceId, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document patient = collection.find(Filters.and(Filters.eq("id", resourceId), Filters.eq("identifier.type", 
				identificationType.toString()), Filters.eq("identifier.id", identificationNumber))).first();
		if(patient != null) {
			patient.remove("_id");
			return new ResponseEntity<>(patient, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
