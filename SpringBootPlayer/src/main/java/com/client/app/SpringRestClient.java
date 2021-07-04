package com.client.app;

import java.util.Arrays;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.training.pojo.Player;

public class SpringRestClient {
	
	public static void main(String args[]) {
		String url="http://localhost:8090/player";
		
		RestTemplate restTemplate=new RestTemplate();
		Player result=restTemplate.postForObject(url, new Player(5, "Govind", "m", 1234561234, "Govind@gmail.com", "Shw", 23, new Date(), 98),
				Player.class);
		System.out.println(result);
//		Player p=restTemplate.getForObject(url, Player.class);
//		System.out.println(p);
		
//		HttpHeaders headers=new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		
//		HttpEntity<String> entity=new HttpEntity<String>("parameters",headers);
//		
//		ResponseEntity<String> result=restTemplate.exchange(url, HttpMethod.GET,
//				entity, String.class);
//		
//		System.out.println(result);
//		
	}

}
