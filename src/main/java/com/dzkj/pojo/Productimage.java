package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class Productimage  implements Serializable{
	@Id
    private Integer p_id;
    private Integer s_id;
    private String p_url1;
    private String p_url2;
    private String p_url3;
    
	public Productimage() {
		super();
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getP_url1() {
		return p_url1;
	}
	public void setP_url1(String p_url1) {
		this.p_url1 = p_url1;
	}
	public String getP_url2() {
		return p_url2;
	}
	public void setP_url2(String p_url2) {
		this.p_url2 = p_url2;
	}
	public String getP_url3() {
		return p_url3;
	}
	public void setP_url3(String p_url3) {
		this.p_url3 = p_url3;
	}
    
}
