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
public class ProcedureService {
	@Autowired
	private MongoDBClient mongoDBClient;
	
	@PostMapping("/procedure")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity())")
	public void createProcedure(@RequestBody String procedure) {
		MongoCollection<Document> collection = mongoDBClient.getPatientCollection();
		Document procedureDocument = Document.parse(procedure);
		String uuid = UUID.randomUUID().toString();	
		procedureDocument.replace("id", uuid);
		collection.insertOne(procedureDocument);
	}
}
