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
public class DiagnosticReportService {
	@Autowired
	MongoDBClient mongoDBClient;
	
	@PostMapping("/diagnostic_report")
	public void createDiagnosticReport(@RequestBody String diagnosticReport) {
		MongoCollection<Document> collection = mongoDBClient.getDiagnosticReportCollection();
		Document diagnosticReportDocument = Document.parse(diagnosticReport);
		collection.insertOne(diagnosticReportDocument);
	}
}
