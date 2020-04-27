package co.edu.javeriana.healthentityserver.restservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.healthentityserver.enums.IdentificationTypeEnum;
import co.edu.javeriana.healthentityserver.blockchain.*;

@RestController
public class BlockchainService {
	
	@GetMapping("/transactions/patient/{identicationType}/{identificationNumber}")
	public List<Transaction> getTransactions (@PathVariable IdentificationTypeEnum identificationType, 
			@PathVariable Long identificationNumber ){
		//AQUI BUSQUEDA DE TRANSACCIONES
		return new ArrayList<>();		
	}
		
}
