package com.web.emailOS.bean;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int  user_id;
	private String user_name;
	private String user_pwd;
	private String user_phone;
	private String user_id_card;
	private String user_content;


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_id_card() {
		return user_id_card;
	}

	public void setUser_id_card(String user_id_card) {
		this.user_id_card = user_id_card;
	}

	public String getUser_content() {
		return user_content;
	}

	public void setUser_content(String user_content) {
		this.user_content = user_content;
	}
}
