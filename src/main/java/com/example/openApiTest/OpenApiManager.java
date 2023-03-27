package com.example.openApiTest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;




public class OpenApiManager {
    private final String BASE_URL = "https://api.odcloud.kr/api/15105540/v1";
    private final String apiUri = "/uddi:759b90cf-dbcb-4a1e-a269-be8faeb0c380";
    private final String serviceKey = "?ServiceKey=m+jWax36HRMZ+mS44p4r3qcTCENATlqqUUFVRKaUeit5DDnBW/gbbrdL/x07DGGQgh1RrIpzQH3I8S8CyCrBxA==";
    private final String defaultQueryParam = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
    private final String numOfRows = "&numOfRows=100";
    private final String areaCode = "&areaCode=1";
    private final String contentTypeId = "&contentTypeId=12";


    private String makeUrl() throws UnsupportedEncodingException {
        return "https://api.odcloud.kr/api/15105540/v1/uddi:759b90cf-dbcb-4a1e-a269-be8faeb0c380?page=1&perPage=10&serviceKey=m%2BjWax36HRMZ%2BmS44p4r3qcTCENATlqqUUFVRKaUeit5DDnBW%2FgbbrdL%2Fx07DGGQgh1RrIpzQH3I8S8CyCrBxA%3D%3D";
    }

    public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
        System.out.println(makeUrl());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl(), HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return resultMap;

    }
}