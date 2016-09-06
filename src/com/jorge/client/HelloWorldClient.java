package com.jorge.client;

import org.hibernate.Session;

import com.jorge.pojo.Message;
import com.jorge.pojo.MessageJPA;
import com.jorge.util.HibernateUtil;

public class HelloWorldClient {

	public static void main(String[] args){
		
		System.out.println("Main method: getting session factory form HibernateUtil.java");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("Main method: beginning transaction");
		session.beginTransaction();
		
		System.out.println("Main method: setting message in Message object");
		Message message = new Message("Testing messages with Hibernate using hbm mapping file");// Using hbm mapping file, check hibernate.cfg.xml
		System.out.println("Main method: Message: Testing messages with Hibernate using hbm mapping file");
		//MessageJPA message = new MessageJPA("Testing messages with Hibernate using JPA");// Using JPA, check hibernate.cfg.xml
		//System.out.println("Main method: Message: Testing messages with Hibernate using JPA");
		
		System.out.println("Main method: saving message in DB => INSERT INTO MESSAGE (TEXT) VALUES (?)");
		session.save(message);
		
		System.out.println("Main method: making commit");
		session.getTransaction().commit();
		
		System.out.println("Main method: close session");
		session.close();
	}
	
}