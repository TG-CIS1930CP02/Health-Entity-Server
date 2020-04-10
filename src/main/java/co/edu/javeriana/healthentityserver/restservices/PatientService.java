package co.edu.javeriana.healthentityserver.restservices;

import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;

import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

@RestController
public class PatientService {
	
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping
	@RequestMapping("/patient")
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	public void createPatient(@RequestBody String patient, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document patientDocument = Document.parse(patient);
		String uuid = UUID.randomUUID().toString();	
		patientDocument.replace("id", uuid);
		collection.insertOne(patientDocument);
	}
}
