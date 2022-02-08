package com.example.callweatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController

public class CallweatherapiApplication {

	static RestTemplate restTemplate = new RestTemplate();
	static String currentweather;
		
	public static void main(String[] args) {
		SpringApplication.run(CallweatherapiApplication.class, args);
		//useExchangeMethodsOfRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("X-Rapidapi-Host", "weatherapi-com.p.rapidapi.com");
		headers.add("X-Rapidapi-Key", "35860790bbmshcee53cc2df3ebd0p14cf8bjsn6e36e8d03e7d");
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://weatherapi-com.p.rapidapi.com/current.json?q=huntington beach",HttpMethod.GET,requestEntity,String.class);
		//HttpStatus statusCode = responseEntity.getStatusCode();
		//System.out.println("status code - " + statusCode);
		currentweather = responseEntity.getBody();
		//System.out.println("response body - " + currentweather);
		
	}

	//private static void useExchangeMethodsOfRestTemplate() {
		
		
		
		
	//}
	
	@GetMapping("/hello")
	
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	//return String.format("Hello %s!", name);
	return String.format("Hello %s ji! Today's weather forecast -" + currentweather, name);
	}
}
