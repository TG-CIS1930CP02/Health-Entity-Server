package co.edu.javeriana.healthentityserver.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Component
public class MongoDBClient {
	@Value("${spring.data.mongodb.uri}")
	private String uri;
	
	public MongoClient getMongoClient() {
		return new MongoClient(new MongoClientURI(uri));
	}
	
}
