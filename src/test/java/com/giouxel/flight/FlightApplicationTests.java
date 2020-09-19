package com.giouxel.flight;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

@SpringBootTest
class FlightApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetFlightListSuccess() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8080/api/flight";
		
		URI uri = new URI(baseUrl);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("origin"));
	}
	
	@Test
	public void testGetFlightListOfSingleAirportSuccess() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8080/api/flight?airport=ATH";
		
		URI uri = new URI(baseUrl);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("origin"));
	}
	
	@Test
	public void testGetFlightListOfSingleAirportBadRequest() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8080/api/flight?airport=PPP";
		
		URI uri = new URI(baseUrl);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		
		Assert.assertEquals(204, result.getStatusCodeValue());
		Assert.assertEquals(true,  result.getStatusCode().getReasonPhrase().contains("No Content"));
	}

}
