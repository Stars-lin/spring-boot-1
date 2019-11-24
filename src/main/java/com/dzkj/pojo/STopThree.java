package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class STopThree  implements Serializable{
	@Id
    private Integer s_three_id;
    private Integer s_two_id;
    private String s_three_name;
    
	public STopThree() {
		super();
	}
	public Integer getS_three_id() {
		return s_three_id;
	}
	public void setS_three_id(Integer s_three_id) {
		this.s_three_id = s_three_id;
	}
	public Integer getS_two_id() {
		return s_two_id;
	}
	public void setS_two_id(Integer s_two_id) {
		this.s_two_id = s_two_id;
	}
	public String getS_three_name() {
		return s_three_name;
	}
	public void setS_three_name(String s_three_name) {
		this.s_three_name = s_three_name;
	}
	@Override
	public String toString() {
		return "STopThree [s_three_id=" + s_three_id + ", s_two_id=" + s_two_id + ", s_three_name=" + s_three_name
				+ "]";
	}
	
    
}
