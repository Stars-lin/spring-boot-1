package com.dzkj.pojo;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.persistence.Id;

public class Orderabout  implements Serializable{
	@Id
	private Integer o_id;
	private String o_bh;
	private Commodity commodity;
	private Integer sc_number;
	private Integer sc_price;


	public Orderabout(String o_bh, Commodity commodity, Integer sc_number, Integer sc_price) {
		super();
		this.o_bh = o_bh;
		this.commodity = commodity;
		this.sc_number = sc_number;
		this.sc_price = sc_price;
	}




	public Orderabout() {
		super();
	}

	public Integer getO_id() {
		return o_id;
	}

	public void setO_id(Integer o_id) {
		this.o_id = o_id;
	}

	public String getO_bh() {
		return o_bh;
	}

	public void setO_bh(String o_bh) {
		this.o_bh = o_bh;
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


   
}
