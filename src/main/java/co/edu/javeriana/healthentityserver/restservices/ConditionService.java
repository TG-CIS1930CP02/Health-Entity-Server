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
public class ConditionService {
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping("/condition")
	public void createCondition(@RequestBody String condition) {
		MongoCollection<Document> collection = mongoDBClient.getConditionCollection();
		Document conditionDocument = Document.parse(condition);
		collection.insertOne(conditionDocument);
	}
}
