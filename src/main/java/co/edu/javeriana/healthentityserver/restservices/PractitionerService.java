package co.edu.javeriana.healthentityserver.restservices;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;

import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

@RestController
public class PractitionerService {
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping("/practitioner")
	public void createPractitioner(@RequestBody String practitioner) {
		MongoCollection<Document> collection = mongoDBClient.getPractitionerCollection();
		Document practitionerDocument = Document.parse(practitioner);
		collection.insertOne(practitionerDocument);
	}
}
