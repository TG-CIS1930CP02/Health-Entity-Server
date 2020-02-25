package co.edu.javeriana.healthentityserver.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String>{

}
