package co.edu.javeriana.healthentityserver.restservices;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

@RestController
public class PatientService {
	
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping
	@RequestMapping("/patient")
	public void createPatient(@RequestBody String patient) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document patientDocument = Document.parse(patient);
		collection.insertOne(patientDocument);
	}
}
