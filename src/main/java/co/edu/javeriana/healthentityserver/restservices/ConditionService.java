package co.edu.javeriana.healthentityserver.restservices;

import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;

import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

@RestController
public class ConditionService {
	@Autowired
	private MongoDBClient mongoDBClient;
	
	@PostMapping("/condition")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity())")
	public void createCondition(@RequestBody String condition) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document conditionDocument = Document.parse(condition);
		String uuid = UUID.randomUUID().toString();	
		conditionDocument.replace("id", uuid);
		collection.insertOne(conditionDocument);
	}
}
