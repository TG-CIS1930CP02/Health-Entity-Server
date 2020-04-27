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
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import co.edu.javeriana.healthentityserver.enums.IdentificationTypeEnum;
import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

@RestController
public class AllergyIntoleranceService {
	@Autowired
	private MongoDBClient mongoDBClient;
	
	@PostMapping("{identificationType}/{identificationNumber}/allergy-intolerance")
	@PreAuthorize("hasRole('ROLE_DOCTOR') and hasAuthority('PASSWORD_AND_FINGERPRINT_AUTHENTICATED_USER') and "
			+ "hasAuthority(@serverIdentification.getRoleHealthEntity()) and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> createAllergyIntolerance(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber, @RequestBody String allergyIntolerance) {
		MongoCollection<Document> collection = mongoDBClient.getAllergyIntoleranceCollection();
		Document allergyIntoleranceDocument = Document.parse(allergyIntolerance);
		String uuid = UUID.randomUUID().toString();	
		if (allergyIntoleranceDocument.containsKey("id"))
			allergyIntoleranceDocument.replace("id", uuid);
		else
			allergyIntoleranceDocument.put("id", uuid);
		collection.insertOne(allergyIntoleranceDocument);
		return new ResponseEntity<Object>(null, HttpStatus.CREATED);
	}
	
	@GetMapping("{identificationType}/{identificationNumber}/allergy-intolerance/{resourceId}")
	@PreAuthorize("(hasRole('ROLE_DOCTOR') or hasRole('ROLE_NURSE') or hasRole('ROLE_PATIENT'))"
			+ "and hasAuthority('PATIENT_'+#identificationType+'_'+#identificationNumber)")
	public ResponseEntity<Object> getAllergyIntolerance(@PathVariable IdentificationTypeEnum identificationType, @PathVariable Long identificationNumber,
			@PathVariable String resourceId, @RequestHeader("Authorization") String token) {
		MongoCollection<Document> collection = mongoDBClient.getAllergyIntoleranceCollection();
		Document allergyIntolerance = collection.find(Filters.and(Filters.eq("id", resourceId), Filters.eq("identifier.type", 
				identificationType.toString()), Filters.eq("identifier.id", identificationNumber))).first();
		if(allergyIntolerance != null) {
			allergyIntolerance.remove("_id");
			return new ResponseEntity<>(allergyIntolerance, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
