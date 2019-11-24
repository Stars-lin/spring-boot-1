package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class Shopcart  implements Serializable{
	@Id
    private Integer id;
    private Integer u_id;
    private Commodity commodity;
    private Integer sc_number;
	private Integer sc_price;
	
	public Shopcart() {
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

	public Integer getSc_number() {
		return sc_number;
	}

	public void setSc_number(Integer sc_number) {
		this.sc_number = sc_number;
	}

	public Integer getSc_price() {
		return sc_price;
	}

	public void setSc_price(Integer sc_price) {
		this.sc_price = sc_price;
	}

	@Override
	public String toString() {
		return "Shopcart [id=" + id + ", u_id=" + u_id + ", commodity=" + commodity + ", sc_number=" + sc_number
				+ ", sc_price=" + sc_price + "]";
	}

}
