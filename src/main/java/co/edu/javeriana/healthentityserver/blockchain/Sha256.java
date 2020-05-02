package co.edu.javeriana.healthentityserver.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.json.JSONObject;

public class Sha256 {
	public static String generateSha256(String json) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(digest==null) return "";
		}
		
		byte[] hash = digest.digest(json.getBytes(StandardCharsets.UTF_8));
		return Sha256.bytesToHex(hash);
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public static String DocumentToJsonString(Document document){	
		String s = "{";
		String[] mSet = document.keySet().toArray(new String[0]);
		Arrays.sort(mSet);
		
		for(int i=0;i<mSet.length; ++i) {
			s+="\"" + mSet[i]+ "\":";
			Object obj = document.get(mSet[i]); 
			if(obj instanceof List){
				List<Object> mList = (List<Object>) obj;
				s+=Sha256.listToJsonString(mList);
			} else if(obj instanceof Document) {
				s+= DocumentToJsonString( (Document) obj);
			} else if(obj instanceof String) {
				s+="\"" + obj.toString() + "\"";
			}
			else {
				s+=obj.toString();
			}
			if(i!=mSet.length-1)
				s+=",";
		}
		s+="}";
		
		return s;
	}
	
	private static String listToJsonString(List<Object> mList) {
		String s = "[";
		for(int i=0;i<mList.size();++i) {
			if(mList.get(i) instanceof List) {
				s+=listToJsonString(mList);
			} else if(mList.get(i) instanceof Document) {
				s+= DocumentToJsonString( (Document) mList.get(i));
			} else if(mList.get(i) instanceof String) {
				s+="\"" + mList.get(i).toString() + "\"";
			} else {
				s+=mList.get(i).toString();
			}
			if(i!=mList.size()-1)
				s+=",";
		}
		s+="]";
		return s;
	}
}
