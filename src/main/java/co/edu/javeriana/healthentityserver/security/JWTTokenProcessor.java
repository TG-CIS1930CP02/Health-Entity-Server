package co.edu.javeriana.healthentityserver.security;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JWTTokenProcessor {
	
	public String getPayloadBase64(String token){
		List<String> parts = new ArrayList<String>();
		StringTokenizer stok = new StringTokenizer(token, ".");
		while (stok.hasMoreTokens()){
			parts.add(stok.nextToken());
		}
		return parts.get(1);
	}
	
}
