package co.edu.javeriana.healthentityserver.blockchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.javeriana.healthentityserver.enums.OperationEnum;
import co.edu.javeriana.healthentityserver.enums.ResourceTypeEnum;
import co.edu.javeriana.healthentityserver.enums.RoleEnum;
import co.edu.javeriana.healthentityserver.security.ServerIdentification;

public class NetworkSearch {
	
	public static List<Transaction> sendSearch(String path, String blockchainUrl) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		try {
			//http://localhost:5000/search?search=Resources&recipient=bbb3
			URL url = new URL(blockchainUrl+path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				System.out.println("Response: ok ");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				
				JSONArray jsonResponse = null;
				try {
					jsonResponse = new JSONArray(response.toString());
				} catch(Exception e){
					if(jsonResponse == null) {
						return transactions; 
					}
				}
				
				
		        for (int i = 0; i < jsonResponse.length(); i++){
		            JSONObject jsonObj = jsonResponse.getJSONObject(i);
		            
		            //System.out.println(jsonObj);
		            
		            //Create transaction
		            Transaction mTransaction = new Transaction();
		    		mTransaction.setInstitution(jsonObj.get("institution").toString());
		    		mTransaction.setSenderRole( jsonObj.get("senderRole").toString());
		    		mTransaction.setSender(jsonObj.get("sender").toString());
		    		mTransaction.setRecipientRole(jsonObj.get("recipientRole").toString());
		    		mTransaction.setRecipient(jsonObj.get("recipient").toString());	
		    		mTransaction.setOperation(Enum.valueOf(OperationEnum.class, jsonObj.get("operation").toString()));
		    		mTransaction.setTimestamp(new Timestamp(  Long.parseLong(jsonObj.get("timestamp").toString())  ));
		    		mTransaction.setResourceIntegrity( jsonObj.get("resourceIntegrity").toString() );
		    		mTransaction.setResourceType(ResourceTypeEnum.valueOf(jsonObj.getString("resourceType")));
		    		mTransaction.setResourcePath(jsonObj.get("resourcePath").toString());
		    		mTransaction.setResourceId(jsonObj.getString("resourceId"));
		    		transactions.add(mTransaction);
		    		
		        }
		        // print result
				//System.out.println(response.toString());
			
			} else {
				
			}
			return transactions;	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactions;
		
	}
	
	
}
