package com.jorge.client;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jorge.pojo.Message;
import com.jorge.util.HibernateUtil;

public class HelloWorldClient {

	public static void main(String[] args){
		BasicConfigurator.configure(); // Necessary for configure log4j. It must be the first line in main method
									   // log4j.properties must be in /src directory
		System.out.println("Main method: log4j configured correctly");
		
		System.out.println("Main method: getting session factory form HibernateUtil.java");
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Insert example with Hibernate
		System.out.println("Main method: beginning transaction");
		session.beginTransaction(); // ==> session.getTransaction().begin();
		
		System.out.println("Main method: setting message in Message object");
		Message message = new Message("Testing messages with Hibernate using hbm mapping file");// Using hbm mapping file, check hibernate.cfg.xml
		System.out.println("Main method: Message: Testing messages with Hibernate using hbm mapping file");
		//MessageJPA message = new MessageJPA("Testing messages with Hibernate using JPA");// Using JPA, check hibernate.cfg.xml
		//System.out.println("Main method: Message: Testing messages with Hibernate using JPA");
		
		System.out.println("Main method: saving message in DB => INSERT INTO MESSAGE (TEXT) VALUES (?)");
		session.save(message);
		
		System.out.println("Main method: making commit");
		session.getTransaction().commit();
		
		//System.out.println("Main method: close session");
		//session.close();
		
		//******************************************************************************
		// Transaction example with Hibernate. Transactions is a group of operations that are run as a single unit of work
		Transaction txn = session.getTransaction();
		try {
			System.out.println("Main method: beginning transaction");
			txn.begin(); // Beginning transaction
	
			//Finding objects
			System.out.println("Main method: finding object");
			Message msg = (Message) session.get(Message.class, 3L); // 3L = line 3 in DB. L is for its type (ID field is Long type). get(Message.class, 3L) needs a default constructor in Message.java
			System.out.println("Main method: object found, row 3 in DB: " + msg.toString());
			
			//Updating objects
			System.out.println("Main method: updating object");
			msg = (Message) session.get(Message.class, 2L);
			msg.setText("Changing text field in DB");
			System.out.println("Main method: object updated, row 2 in DB: " + msg.toString());
			
			//Deleting objects
			System.out.println("Main method: deleting object");
			msg = (Message) session.get(Message.class, 1L);  
			session.delete(msg);
			System.out.println("Main method: object deleted, row 1 in DB");
    
			System.out.println("Main method: making commit of transactions");
    		txn.commit(); // Making commit
		}	catch(Exception e) {
    			if(txn != null){
    				System.err.println("Main method: something was wrong, making rollback of transactions");
    				txn.rollback(); // If something was wrong, we make rollback
    			}
    			System.err.println("Main method: Exception: " + e.getMessage().toString());
		}	finally {
				if(session != null){
					System.out.println("Main method: close session");
					session.close();
				}
		}
	}
	
}