package co.edu.javeriana.healthentityserver.restservices;

import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mongodb.client.MongoCollection;

import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

public class AllergyIntoleranceService {
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping("/allergy-intollerance")
	public void createAllergyIntolerance(@RequestBody String allergyIntolerance) {	
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document allergyIntoleranceDocument = Document.parse(allergyIntolerance);
		String uuid = UUID.randomUUID().toString();	
		allergyIntoleranceDocument.replace("id", uuid);
		collection.insertOne(allergyIntoleranceDocument);
	}
}
