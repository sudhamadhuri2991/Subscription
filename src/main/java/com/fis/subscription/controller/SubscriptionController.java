package com.fis.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fis.subscription.model.Subscription;
import com.fis.subscription.service.SubscriptionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class SubscriptionController {

	@Autowired
	RestTemplate restTemplate=null;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	
	@RequestMapping("/subscriptions")
	public List<Subscription> getSubscriptions(){
		
		return subscriptionService.getSubscriptions();
		
	}
	
	
	@PostMapping("/savsubscriptions")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public ResponseEntity<String> Subscriptions(@RequestBody Subscription sub){
		
		int availCopies=restTemplate.getForObject("http://bookservice/book/"+sub.getBook_id(), Integer.class);
		System.out.println("2222   "+availCopies);
		if(availCopies>0) {
			
			subscriptionService.saveSubscriptions(sub);
			return ResponseEntity.status(201).body("Successful Creation of subscription record");
		}
		else
		{
			return ResponseEntity.status(422).body("Book copies are not available for subscription");
		}
		
		
	}
	public ResponseEntity<String> fallbackMethod(@RequestBody Subscription sub){
		
		return ResponseEntity.status(450).body("Book service is down");
	}
}
