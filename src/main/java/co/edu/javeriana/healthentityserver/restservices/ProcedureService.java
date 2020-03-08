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
public class ProcedureService {
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping("/procedure")
	public void createProcedure(@RequestBody String procedure) {
		MongoCollection<Document> collection = mongoDBClient.getProcedureCollection();
		Document procedureDocument = Document.parse(procedure);
		collection.insertOne(procedureDocument);
	}
}
