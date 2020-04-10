package co.edu.javeriana.healthentityserver.restservices;

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
	public void createAllergyIntolerance(@RequestBody String condition) {
		MongoCollection<Document> collection = mongoDBClient.getConditionCollection();
		Document conditionDocument = Document.parse(condition);
		collection.insertOne(conditionDocument);
	}
}
