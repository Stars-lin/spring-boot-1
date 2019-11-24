package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Id;

public class STopTwo  implements Serializable{
	@Id
    private Integer s_two_id;
    private Integer s_one_id;
    private String s_two_name;
    private List<STopThree> sThrees;
    
	public STopTwo() {
		super();
	}
	public Integer getS_two_id() {
		return s_two_id;
	}
	public void setS_two_id(Integer s_two_id) {
		this.s_two_id = s_two_id;
	}
	public Integer getS_one_id() {
		return s_one_id;
	}
	public void setS_one_id(Integer s_one_id) {
		this.s_one_id = s_one_id;
	}
	public String getS_two_name() {
		return s_two_name;
	}
	public void setS_two_name(String s_two_name) {
		this.s_two_name = s_two_name;
	}
	
	public List<STopThree> getsThrees() {
		return sThrees;
	}
	public void setsThrees(List<STopThree> sThrees) {
		this.sThrees = sThrees;
	}
	@Override
	public String toString() {
		return "STopTwo [s_two_id=" + s_two_id + ", s_one_id=" + s_one_id + ", s_two_name=" + s_two_name + ", sThrees="
				+ sThrees + "]";
	}
	
    
}
