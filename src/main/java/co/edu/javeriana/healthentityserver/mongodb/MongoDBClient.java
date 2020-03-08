package co.edu.javeriana.healthentityserver.mongodb;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class MongoDBClient {
	@Value("${spring.data.mongodb.uri}")
	private String uri;
	
	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Value("${mongodb.collection.patient}")
	private String patientCollection;
	
	@Value("${mongodb.collection.condition}")
	private String conditionCollection;
	
	@Value("${mongodb.collection.diagnosticreport}")
	private String diagnosticReportCollection;
	
	@Value("${mongodb.collection.procedure}")
	private String procedureCollection;
	
	@Value("${mongodb.collection.observation}")
	private String observationCollection;
	
	@Value("${mongodb.collection.practitioner}")
	private String practitionerCollection;
	
	public MongoClient getMongoClient() {
		return new MongoClient(new MongoClientURI(uri));
	}
	
	public MongoDatabase getDatabase() {
		return getMongoClient().getDatabase(database);
	}
	
	public MongoCollection<Document> getPatientCollection(){
		return getDatabase().getCollection(patientCollection);
	}
	
	public MongoCollection<Document> getObservationCollection(){
		return getDatabase().getCollection(observationCollection);
	}
	
	public MongoCollection<Document> getConditionCollection(){
		return getDatabase().getCollection(conditionCollection);
	}
	
	public MongoCollection<Document> getDiagnosticReportCollection(){
		return getDatabase().getCollection(diagnosticReportCollection);
	}
	
	public MongoCollection<Document> getProcedureCollection(){
		return getDatabase().getCollection(procedureCollection);
	}
	
	public MongoCollection<Document> getPractitionerCollection(){
		return getDatabase().getCollection(practitionerCollection);
	}
	
	
}
