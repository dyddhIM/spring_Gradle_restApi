package com.example.openApiTest;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class tetController {
	
	

    @GetMapping("/")
    public String start() {
    	return "초기화면 실행"; 
    }
    
    
    
    @GetMapping("/open-api")
    public String fetch() throws ParseException {
    	String servicekey ="m+jWax36HRMZ+mS44p4r3qcTCENATlqqUUFVRKaUeit5DDnBW/gbbrdL/x07DGGQgh1RrIpzQH3I8S8CyCrBxA==";
    	String a = 
"https://apis.data.go.kr/B551011/KorService1/locationBasedList1?"
+ "serviceKey="+
		servicekey
+ "numOfRows=10&"
+ "pageNo=1"
+ "&MobileOS=ETC"
+ "&MobileApp=AppTest"
+ "&_type=json&listYN=Y"
+ "&arrange=A"
+ "&mapX=126.981611"
+ "&mapY=37.568477&radius=1000"
+ "&contentTypeId=15";    			

		RestTemplate restTemplate = new RestTemplate();		
    	JSONParser jsonParser = new JSONParser();

		/*Map<String, Object> result1 = restTemplate.getForObject(a, Map.class);
		System.out.println("result1 ==> "+result1);
		System.out.println("result1.get(\"response\") ==> "+result1.get("response"));
		
		Map<String, Object> result2 = (Map<String, Object>) result1.get("response");
		System.out.println("result2 ==> "+result1.get("body"));
		
		*/
		
		
		String jsonString = restTemplate.getForObject(a, String.class);
		System.out.println("jsonString => "+jsonString);

		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
	    System.out.println("jsonObject => "+jsonObject);

	    JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
	    System.out.println("jsonResponse => "+jsonResponse);
	    
	    JSONObject jsonBody = (JSONObject) jsonResponse.get("body");
	    System.out.println("jsonBody => "+jsonBody);
	    
	    JSONObject jsonItems = (JSONObject) jsonBody.get("items");
	    System.out.println("jsonItems => "+jsonItems);
	    
	    List<Map<String, String>> jsonItem = (List<Map<String, String>>) jsonItems;
	    System.out.println("jsonItem => "+ jsonItem);
	    
	    
	    
		return "index"; 
	}

}


