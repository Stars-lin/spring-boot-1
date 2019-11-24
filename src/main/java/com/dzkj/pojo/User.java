package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class User implements Serializable{
	@Id
	private Integer u_id;
	private String u_pwd;
	private String u_nickname;
	private String u_balance;
	private String u_phone; 
	private String u_email;
	private String u_sex;
	private String u_url;
	private String u_birth;
	private String u_name;
	private String u_paypassword;
	
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public String getU_balance() {
		return u_balance;
	}
	public void setU_balance(String u_balance) {
		this.u_balance = u_balance;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_url() {
		return u_url;
	}
	public void setU_url(String u_url) {
		this.u_url = u_url;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_paypassword() {
		return u_paypassword;
	}
	public void setU_paypassword(String u_paypassword) {
		this.u_paypassword = u_paypassword;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public String getU_birth() {
		return u_birth;
	}

	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}
	
}
