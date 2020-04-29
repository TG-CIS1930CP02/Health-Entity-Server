package co.edu.javeriana.healthentityserver.blockchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.javeriana.healthentityserver.security.ServerIdentification;

public class NetworkTransaction {
	
	public static void sendTransaction(Transaction tx, String blockchainUrl) {
		
		String tx_json = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			tx_json = mapper.writeValueAsString(tx);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if(tx_json==null) return;
		}
		
		try {
			URL url = new URL(blockchainUrl+"transactions/new");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = tx_json.getBytes("utf-8");
			    os.write(input, 0, input.length);
			    os.flush();
			    os.close();
			}
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_CREATED) {
				System.out.println("CREATED: ");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
			} else {
				
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
