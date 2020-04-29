package co.edu.javeriana.healthentityserver.security;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JWTTokenProcessor {
	
	public List<String> getAuthorities(String token){
		List<String> parts = new ArrayList<String>();
		StringTokenizer stok = new StringTokenizer(token, ".");
		while (stok.hasMoreTokens()){
			parts.add(stok.nextToken());
		}
		String payload = new String(Base64.getDecoder().decode(parts.get(1)));
		JSONObject payloadObject = new JSONObject(payload);
		JSONArray arr = payloadObject.getJSONArray("authorities");
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < arr.length(); i++){
		    list.add(arr.getJSONObject(i).toString());
		}
		return list;
	}
	
	public String getAuthenticationMode(String token){
		List<String> parts = new ArrayList<String>();
		StringTokenizer stok = new StringTokenizer(token, ".");
		while (stok.hasMoreTokens()){
			parts.add(stok.nextToken());
		}
		String payload = new String(Base64.getDecoder().decode(parts.get(1)));
		JSONObject payloadObject = new JSONObject(payload);
		return payloadObject.get("authenticationMode").toString();	
	}
	
	public String getLoginTime(String token){
		List<String> parts = new ArrayList<String>();
		StringTokenizer stok = new StringTokenizer(token, ".");
		while (stok.hasMoreTokens()){
			parts.add(stok.nextToken());
		}
		String payload = new String(Base64.getDecoder().decode(parts.get(1)));
		JSONObject payloadObject = new JSONObject(payload);
		return payloadObject.get("iat").toString();	
	}
	
	public String getInformationFromToken(String token, String parameter){
		List<String> parts = new ArrayList<String>();
		StringTokenizer stok = new StringTokenizer(token, ".");
		while (stok.hasMoreTokens()){
			parts.add(stok.nextToken());
		}
		String payload = new String(Base64.getDecoder().decode(parts.get(1)));
		JSONObject payloadObject = new JSONObject(payload);
		return payloadObject.get(parameter).toString();	
	}
	
}
