package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class Foot  implements Serializable{
	@Id
   private Integer id;
	private Integer u_id;
	private Commodity commodity;

	public Foot() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

}
