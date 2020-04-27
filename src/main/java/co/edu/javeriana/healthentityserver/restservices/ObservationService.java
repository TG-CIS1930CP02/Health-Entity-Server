package co.edu.javeriana.healthentityserver.restservices;

import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import co.edu.javeriana.healthentityserver.enums.IdentificationTypeEnum;
import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

@RestController
public class ObservationService {
	@Autowired
	private MongoDBClient mongoDBClient;
	
	@PostMapping("{identificationType}/{identificationNumber}/observation")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity()) and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> createObservation(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber, @RequestBody String observation) {
		MongoCollection<Document> collection = mongoDBClient.getObservationCollection();
		Document observationDocument = Document.parse(observation);
		String uuid = UUID.randomUUID().toString();	
		if (observationDocument.containsKey("id"))
			observationDocument.replace("id", uuid);
		else
			observationDocument.put("id", uuid);
		collection.insertOne(observationDocument);
		return new ResponseEntity<Object>(null, HttpStatus.CREATED);
	}
	
	@GetMapping("{identificationType}/{identificationNumber}/observation/{resourceId}")
	@PreAuthorize("(hasRole('ROLE_DOCTOR') or hasRole('ROLE_NURSE') or hasRole('ROLE_PATIENT'))"
			+ "and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> getObservation(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber,
			@PathVariable String resourceId, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getObservationCollection();
		Document observation = collection.find(Filters.and(Filters.eq("id", resourceId), Filters.eq("identifier.type", 
				identificationType.toString()), Filters.eq("identifier.id", identificationNumber))).first();
		if(observation != null) {
			observation.remove("_id");
			return new ResponseEntity<>(observation, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
