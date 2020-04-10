package co.edu.javeriana.healthentityserver.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class KeyStore {	
	private PublicKey publicAuthenticationKey;	
	
	private static final Logger log = LoggerFactory.getLogger(KeyStore.class);
	
	public KeyStore(@Value("${ras.url}") String rasUrl) {
		try {
			SSLFix.execute();
			URL url = new URL(rasUrl + "public-key");
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setConnectTimeout(10000);
			con.setReadTimeout(10000);
			con.setRequestMethod(RequestMethod.GET.name());
			
			int status = con.getResponseCode();
			if(status > 299) {
				log.error("Error contacting RAS for public authentication key: " + HttpStatus.valueOf(status).toString());
			}
			else {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line = "";
				StringBuffer content = new StringBuffer();
				while ((line = in.readLine()) != null) {
					content.append(line);
				}
				String publicKeyBase64 = content.toString();
				log.info("Public key for authentication received from RAS: " + publicKeyBase64);
				byte[] bytesPublicKey = Base64.getDecoder().decode(publicKeyBase64);
				publicAuthenticationKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytesPublicKey));
			}
			con.disconnect();
		} catch (Exception e) {
			log.error("Error contacting RAS for public authentication key: "+ e.getMessage());	
		}		
	}

	public PublicKey getPublicAuthenticationKey() {
		return publicAuthenticationKey;
	}

	public void setPublicAuthenticationKey(PublicKey publicAuthenticationKey) {
		this.publicAuthenticationKey = publicAuthenticationKey;
	}
	
	
	
}
