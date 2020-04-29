package co.edu.javeriana.healthentityserver.restservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.healthentityserver.enums.IdentificationTypeEnum;
import co.edu.javeriana.healthentityserver.security.ServerIdentification;
import co.edu.javeriana.healthentityserver.blockchain.*;

@RestController
public class BlockchainService {
	@Autowired
	private ServerIdentification serverIdentification;
	
	@GetMapping("/transactions/patient/{identificationType}/{identificationNumber}")
	public List<Transaction> getTransactions (@PathVariable IdentificationTypeEnum identificationType, 
			@PathVariable Long identificationNumber ){
		
		String path = String.format("search?search=Resources&recipient=%s", identificationNumber);

		List<Transaction> response = NetworkSearch.sendSearch(path, serverIdentification.getBcserverUrl());
		
		return response;		
	}
	
	@GetMapping("/transactions/medical-history/patient/{identificationType}/{identificationNumber}")
	public List<Transaction> getMedicalRecords (@PathVariable IdentificationTypeEnum identificationType, 
			@PathVariable Long identificationNumber ){

		String path = String.format("search?search=History&recipient=%s", identificationNumber);

		List<Transaction> response = NetworkSearch.sendSearch(path, serverIdentification.getBcserverUrl());

		return response;		
	}
	
	@GetMapping("/transactions/emergency-medical-history/patient/{identificationType}/{identificationNumber}")
	public List<Transaction> getEmergencyMedicalHistory (@PathVariable IdentificationTypeEnum identificationType, 
			@PathVariable Long identificationNumber ){

		String path = String.format("search?search=Emergency&recipient=%s", identificationNumber);

		List<Transaction> response = NetworkSearch.sendSearch(path, serverIdentification.getBcserverUrl());
		
		return response;		
	}
		
}
