package com.fis.subscription.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.subscription.model.Subscription;
import com.fis.subscription.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	public List<Subscription> getSubscriptions()
	{
		List<Subscription> subscriptions=new ArrayList<Subscription>();
		subscriptionRepository.findAll().forEach(subscription -> subscriptions.add(subscription));
		return subscriptions;
	}
	public void saveSubscriptions(Subscription sub)
	{
		subscriptionRepository.save(sub);
	}
	

}
