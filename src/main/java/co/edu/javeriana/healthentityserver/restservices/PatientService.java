package co.edu.javeriana.healthentityserver.restservices;

import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;

import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;
import co.edu.javeriana.healthentityserver.security.ServerIdentification;

@RestController
public class PatientService {
	
	@Autowired
	private MongoDBClient mongoDBClient;
		
	@PostMapping("/patient")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity())")
	public void createPatient(@RequestBody String patient, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document patientDocument = Document.parse(patient);
		String uuid = UUID.randomUUID().toString();	
		patientDocument.replace("id", uuid);
		collection.insertOne(patientDocument);
	}
}
