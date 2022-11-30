package com.fis.subscription.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Subscription {
	
	
	@Id
	@Column
	private int subscriber_id;
	@Column
	private String subscriber_name;
	
	@Column
	private String date_subscribed;
	
	@Column
	private String date_returned;
	
	@Column
	private int book_id;
	
	public int getSubscriber_id() {
		return subscriber_id;
	}

	public void setSubscriber_id(int subscriber_id) {
		this.subscriber_id = subscriber_id;
	}

	public String getSubscriber_name() {
		return subscriber_name;
	}

	public void setSubscriber_name(String subscriber_name) {
		this.subscriber_name = subscriber_name;
	}

	public String getDate_subscribed() {
		return date_subscribed;
	}

	public void setDate_subscribed(String date_subscribed) {
		this.date_subscribed = date_subscribed;
	}

	public String getDate_returned() {
		return date_returned;
	}

	public void setDate_returned(String date_returned) {
		this.date_returned = date_returned;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	

}
