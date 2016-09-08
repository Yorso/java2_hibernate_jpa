package com.jorge.bean;

// Persistent class. This class uses Message.hbm.xml mapping file
// It will be <mapping resource="com/jorge/bean/Message.hbm.xml"/> in hibernate.cfg.xml config file
public class Message {

	private Long id; // Identifier attribute
	private String text;
	
	public Message(){};
	
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
