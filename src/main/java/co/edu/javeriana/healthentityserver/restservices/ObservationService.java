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
public class ObservationService {
	@Autowired
	private MongoDBClient mongoDBClient;
	
	@PostMapping("/observation")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity())")
	public void createObservation(@RequestBody String observation) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document observationDocument = Document.parse(observation);
		String uuid = UUID.randomUUID().toString();	
		if (observationDocument.containsKey("id"))
			observationDocument.replace("id", uuid);
		else
			observationDocument.put("id", uuid);
		collection.insertOne(observationDocument);
	}
}
