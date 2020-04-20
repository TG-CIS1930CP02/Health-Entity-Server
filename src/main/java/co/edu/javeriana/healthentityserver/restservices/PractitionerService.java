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
public class PractitionerService {
	@Autowired
	private MongoDBClient mongoDBClient;
	
	@PostMapping("/practitioner")
	@PreAuthorize("hasRole('ROLE_ADMINISTRATOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity())")
	public void createPractitioner(@RequestBody String practitioner) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document practitionerDocument = Document.parse(practitioner);
		String uuid = UUID.randomUUID().toString();	
		practitionerDocument.replace("id", uuid);
		collection.insertOne(practitionerDocument);
	}
}
