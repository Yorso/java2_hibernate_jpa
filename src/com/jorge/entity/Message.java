package com.jorge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Class using JPA annotations. We don't need Message.hbm.xml mapping file
//It will be <mapping class="com.jorge.entity.Message"/> in hibernate.cfg.xml config file
@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TEXT")
	private String text;
	
	public Message(){}
	
	public Message(String text){
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}
}
