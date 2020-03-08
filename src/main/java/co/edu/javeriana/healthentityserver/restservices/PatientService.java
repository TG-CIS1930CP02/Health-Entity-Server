package co.edu.javeriana.healthentityserver.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import co.edu.javeriana.healthentityserver.mongodb.MongoDBClient;

@RestController
public class PatientService {
	
	@Autowired
	MongoDBClient mongoDBClient;
	
	@GetMapping("/test")
	public String test() {
		MongoClient mongoClient = mongoDBClient.getMongoClient();
		DB database = mongoClient.getDB("HE-1");
		DBCollection collection = database.getCollection("patient");
		String example = 
				"{\r\n" + 
				"  \"resourceType\": \"Patient\",\r\n" + 
				"  \"id\": \"example\",\r\n" + 
				"  \"text\": {\r\n" + 
				"    \"status\": \"generated\",\r\n" + 
				"    \"div\": \"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">\\n\\t\\t\\t<table>\\n\\t\\t\\t\\t<tbody>\\n\\t\\t\\t\\t\\t<tr>\\n\\t\\t\\t\\t\\t\\t<td>Name</td>\\n\\t\\t\\t\\t\\t\\t<td>Peter James \\n              <b>Chalmers</b> (&quot;Jim&quot;)\\n            </td>\\n\\t\\t\\t\\t\\t</tr>\\n\\t\\t\\t\\t\\t<tr>\\n\\t\\t\\t\\t\\t\\t<td>Address</td>\\n\\t\\t\\t\\t\\t\\t<td>534 Erewhon, Pleasantville, Vic, 3999</td>\\n\\t\\t\\t\\t\\t</tr>\\n\\t\\t\\t\\t\\t<tr>\\n\\t\\t\\t\\t\\t\\t<td>Contacts</td>\\n\\t\\t\\t\\t\\t\\t<td>Home: unknown. Work: (03) 5555 6473</td>\\n\\t\\t\\t\\t\\t</tr>\\n\\t\\t\\t\\t\\t<tr>\\n\\t\\t\\t\\t\\t\\t<td>Id</td>\\n\\t\\t\\t\\t\\t\\t<td>MRN: 12345 (Acme Healthcare)</td>\\n\\t\\t\\t\\t\\t</tr>\\n\\t\\t\\t\\t</tbody>\\n\\t\\t\\t</table>\\n\\t\\t</div>\"\r\n" + 
				"  },\r\n" + 
				"  \"identifier\": [\r\n" + 
				"    {\r\n" + 
				"      \"use\": \"usual\",\r\n" + 
				"      \"type\": {\r\n" + 
				"        \"coding\": [\r\n" + 
				"          {\r\n" + 
				"            \"system\": \"http://terminology.hl7.org/CodeSystem/v2-0203\",\r\n" + 
				"            \"code\": \"MR\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      \"system\": \"urn:oid:1.2.36.146.595.217.0.1\",\r\n" + 
				"      \"value\": \"12345\",\r\n" + 
				"      \"period\": {\r\n" + 
				"        \"start\": \"2001-05-06\"\r\n" + 
				"      },\r\n" + 
				"      \"assigner\": {\r\n" + 
				"        \"display\": \"Acme Healthcare\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"active\": true,\r\n" + 
				"  \"name\": [\r\n" + 
				"    {\r\n" + 
				"      \"use\": \"official\",\r\n" + 
				"      \"family\": \"Chalmers\",\r\n" + 
				"      \"given\": [\r\n" + 
				"        \"Peter\",\r\n" + 
				"        \"James\"\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"use\": \"usual\",\r\n" + 
				"      \"given\": [\r\n" + 
				"        \"Jim\"\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"use\": \"maiden\",\r\n" + 
				"      \"family\": \"Windsor\",\r\n" + 
				"      \"given\": [\r\n" + 
				"        \"Peter\",\r\n" + 
				"        \"James\"\r\n" + 
				"      ],\r\n" + 
				"      \"period\": {\r\n" + 
				"        \"end\": \"2002\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"telecom\": [\r\n" + 
				"    {\r\n" + 
				"      \"use\": \"home\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"system\": \"phone\",\r\n" + 
				"      \"value\": \"(03) 5555 6473\",\r\n" + 
				"      \"use\": \"work\",\r\n" + 
				"      \"rank\": 1\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"system\": \"phone\",\r\n" + 
				"      \"value\": \"(03) 3410 5613\",\r\n" + 
				"      \"use\": \"mobile\",\r\n" + 
				"      \"rank\": 2\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"system\": \"phone\",\r\n" + 
				"      \"value\": \"(03) 5555 8834\",\r\n" + 
				"      \"use\": \"old\",\r\n" + 
				"      \"period\": {\r\n" + 
				"        \"end\": \"2014\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"gender\": \"male\",\r\n" + 
				"  \"birthDate\": \"1974-12-25\",\r\n" + 
				"  \"_birthDate\": {\r\n" + 
				"    \"extension\": [\r\n" + 
				"      {\r\n" + 
				"        \"url\": \"http://hl7.org/fhir/StructureDefinition/patient-birthTime\",\r\n" + 
				"        \"valueDateTime\": \"1974-12-25T14:35:45-05:00\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  \"deceasedBoolean\": false,\r\n" + 
				"  \"address\": [\r\n" + 
				"    {\r\n" + 
				"      \"use\": \"home\",\r\n" + 
				"      \"type\": \"both\",\r\n" + 
				"      \"text\": \"534 Erewhon St PeasantVille, Rainbow, Vic  3999\",\r\n" + 
				"      \"line\": [\r\n" + 
				"        \"534 Erewhon St\"\r\n" + 
				"      ],\r\n" + 
				"      \"city\": \"PleasantVille\",\r\n" + 
				"      \"district\": \"Rainbow\",\r\n" + 
				"      \"state\": \"Vic\",\r\n" + 
				"      \"postalCode\": \"3999\",\r\n" + 
				"      \"period\": {\r\n" + 
				"        \"start\": \"1974-12-25\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"contact\": [\r\n" + 
				"    {\r\n" + 
				"      \"relationship\": [\r\n" + 
				"        {\r\n" + 
				"          \"coding\": [\r\n" + 
				"            {\r\n" + 
				"              \"system\": \"http://terminology.hl7.org/CodeSystem/v2-0131\",\r\n" + 
				"              \"code\": \"N\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"name\": {\r\n" + 
				"        \"family\": \"du Marché\",\r\n" + 
				"        \"_family\": {\r\n" + 
				"          \"extension\": [\r\n" + 
				"            {\r\n" + 
				"              \"url\": \"http://hl7.org/fhir/StructureDefinition/humanname-own-prefix\",\r\n" + 
				"              \"valueString\": \"VV\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"given\": [\r\n" + 
				"          \"Bénédicte\"\r\n" + 
				"        ]\r\n" + 
				"      },\r\n" + 
				"      \"telecom\": [\r\n" + 
				"        {\r\n" + 
				"          \"system\": \"phone\",\r\n" + 
				"          \"value\": \"+33 (237) 998327\"\r\n" + 
				"        }\r\n" + 
				"      ],\r\n" + 
				"      \"address\": {\r\n" + 
				"        \"use\": \"home\",\r\n" + 
				"        \"type\": \"both\",\r\n" + 
				"        \"line\": [\r\n" + 
				"          \"534 Erewhon St\"\r\n" + 
				"        ],\r\n" + 
				"        \"city\": \"PleasantVille\",\r\n" + 
				"        \"district\": \"Rainbow\",\r\n" + 
				"        \"state\": \"Vic\",\r\n" + 
				"        \"postalCode\": \"3999\",\r\n" + 
				"        \"period\": {\r\n" + 
				"          \"start\": \"1974-12-25\"\r\n" + 
				"        }\r\n" + 
				"      },\r\n" + 
				"      \"gender\": \"female\",\r\n" + 
				"      \"period\": {\r\n" + 
				"        \"start\": \"2012\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"managingOrganization\": {\r\n" + 
				"    \"reference\": \"Organization/1\"\r\n" + 
				"  }\r\n" + 
				"}";
		DBObject dbObject = (DBObject)JSON.parse(example);
		collection.insert(dbObject);		
		return "Hello!";
	}
}
