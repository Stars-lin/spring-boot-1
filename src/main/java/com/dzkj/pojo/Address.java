package com.dzkj.pojo;

import java.io.Serializable;

import javax.persistence.Id;

public class Address implements Serializable{
	@Id
	private Integer a_id;
	private Integer u_id;
	private Integer a_status;
	private String a_phone;
	private String a_consigneename;
	private String a_province;
	private String a_city;
	private String a_area;
	private String a_details;
	
	public Address() {
	}
	
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Integer getA_status() {
		return a_status;
	}
	public void setA_status(Integer a_status) {
		this.a_status = a_status;
	}
	public String getA_consigneename() {
		return a_consigneename;
	}
	public void setA_consigneename(String a_consigneename) {
		this.a_consigneename = a_consigneename;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}

	public String getA_province() {
		return a_province;
	}

	public void setA_province(String a_province) {
		this.a_province = a_province;
	}

	public String getA_city() {
		return a_city;
	}

	public void setA_city(String a_city) {
		this.a_city = a_city;
	}

	public String getA_area() {
		return a_area;
	}

	public void setA_area(String a_area) {
		this.a_area = a_area;
	}

	public String getA_details() {
		return a_details;
	}

	public void setA_details(String a_details) {
		this.a_details = a_details;
	}
	
}
