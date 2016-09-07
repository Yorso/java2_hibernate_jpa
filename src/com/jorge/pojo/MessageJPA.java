package com.jorge.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Class using JPA annotations. We don't need Message.hbm.xml mapping file
//It will be <mapping class="com.jorge.pojo.MessageJPA"/> in hibernate.cfg.xml config file
@Entity
@Table(name="message")
public class MessageJPA {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TEXT")
	private String text;
	
	public MessageJPA(){}
	
	public MessageJPA(String text){
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
		return "MessageJPA [id=" + id + ", text=" + text + "]";
	}
}
