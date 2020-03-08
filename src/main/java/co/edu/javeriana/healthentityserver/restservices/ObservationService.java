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
public class ObservationService {
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping("/observation")
	public void createObservation(@RequestBody String observation) {
		MongoCollection<Document> collection = mongoDBClient.getObservationCollection();
		Document observationDocument = Document.parse(observation);
		collection.insertOne(observationDocument);
	}
}
