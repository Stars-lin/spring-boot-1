package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class Ordertotal  implements Serializable{
	@Id
    private Integer t_id;
    private Integer u_id;
    private String o_bh;
    private Integer t_price;
    private String t_time;
    private Integer t_state;
    private String a_consigneename;
    private String a_province;
    private String a_city;
    private String a_area;
    private String a_details;
    private String a_phone;
    
	public Ordertotal(Integer u_id, String o_bh, Integer t_price, String t_time) {
		super();
		this.u_id = u_id;
		this.o_bh = o_bh;
		this.t_price = t_price;
		this.t_time = t_time;
	}



	public Ordertotal() {
		super();
	}
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getO_bh() {
		return o_bh;
	}
	public void setO_bh(String o_bh) {
		this.o_bh = o_bh;
	}
	public Integer getT_price() {
		return t_price;
	}
	public void setT_price(Integer t_price) {
		this.t_price = t_price;
	}
	public String getT_time() {
		return t_time;
	}
	public void setT_time(String t_time) {
		this.t_time = t_time;
	}
	public Integer getT_state() {
		return t_state;
	}
	public void setT_state(Integer t_state) {
		this.t_state = t_state;
	}

	public String getA_consigneename() {
		return a_consigneename;
	}

	public void setA_consigneename(String a_consigneename) {
		this.a_consigneename = a_consigneename;
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



	public String getA_phone() {
		return a_phone;
	}

	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}

    
}
