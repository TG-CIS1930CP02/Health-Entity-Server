package co.edu.javeriana.healthentityserver.restservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestService {
	
	@GetMapping()
	public String test() {
		return "Server is Up!";
	}
}
