package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class Commodity  implements Serializable{
	@Id
    private Integer s_id;
    private String s_name;
    private Integer s_price;
    private Integer s_repertory;
    private Integer s_sales;
    private Integer s_three_id;
    private String s_url;
    private String s_describe;
    private String s_brand;
    
    
    
	public Commodity() {
		super();
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public Integer getS_price() {
		return s_price;
	}
	public void setS_price(Integer s_price) {
		this.s_price = s_price;
	}
	public Integer getS_repertory() {
		return s_repertory;
	}
	public void setS_repertory(Integer s_repertory) {
		this.s_repertory = s_repertory;
	}
	public Integer getS_sales() {
		return s_sales;
	}
	public void setS_sales(Integer s_sales) {
		this.s_sales = s_sales;
	}
	public Integer getS_three_id() {
		return s_three_id;
	}
	public void setS_three_id(Integer s_three_id) {
		this.s_three_id = s_three_id;
	}
	public String getS_url() {
		return s_url;
	}
	public void setS_url(String s_url) {
		this.s_url = s_url;
	}
	public String getS_describe() {
		return s_describe;
	}
	public void setS_describe(String s_describe) {
		this.s_describe = s_describe;
	}
	public String getS_brand() {
		return s_brand;
	}
	public void setS_brand(String s_brand) {
		this.s_brand = s_brand;
	}
	@Override
	public String toString() {
		return "Commodity [s_id=" + s_id + ", s_name=" + s_name + ", s_price=" + s_price + ", s_repertory="
				+ s_repertory + ", s_sales=" + s_sales + ", s_three_id=" + s_three_id + ", s_url=" + s_url
				+ ", s_describe=" + s_describe + ", s_brand=" + s_brand + "]";
	}
    
}
