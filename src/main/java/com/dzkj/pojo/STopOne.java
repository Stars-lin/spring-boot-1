package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Id;

public class STopOne  implements Serializable{
	@Id
	private Integer s_one_id;
	private String s_one_name;
	private String s_one_img;
	private List<STopTwo> sTwos;
	
	public STopOne() {
		super();
	}

	public Integer getS_one_id() {
		return s_one_id;
	}

	public void setS_one_id(Integer s_one_id) {
		this.s_one_id = s_one_id;
	}

	public String getS_one_name() {
		return s_one_name;
	}

	public void setS_one_name(String s_one_name) {
		this.s_one_name = s_one_name;
	}

	public String getS_one_img() {
		return s_one_img;
	}

	public void setS_one_img(String s_one_img) {
		this.s_one_img = s_one_img;
	}

	public List<STopTwo> getsTwos() {
		return sTwos;
	}

	public void setsTwos(List<STopTwo> sTwos) {
		this.sTwos = sTwos;
	}
	

	@Override
	public String toString() {
		return "STopOne [s_one_id=" + s_one_id + ", s_one_name=" + s_one_name + ", s_one_img=" + s_one_img + ", sTwos="
				+ sTwos + "]";
	}
	
	

}
