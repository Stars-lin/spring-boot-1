package com.dzkj.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

public class OrderAll  implements Serializable{
	@Id
	private Ordertotal oTotal;
	private List<Orderabout> oAbouts;

	public OrderAll(Ordertotal oTotal, List<Orderabout> oAbouts) {
		super();
		this.oTotal = oTotal;
		this.oAbouts = oAbouts;
	}

	public OrderAll() {
		super();
	}

	public Ordertotal getoTotal() {
		return oTotal;
	}

	public void setoTotal(Ordertotal oTotal) {
		this.oTotal = oTotal;
	}

	public List<Orderabout> getoAbouts() {
		return oAbouts;
	}

	public void setoAbouts(List<Orderabout> oAbouts) {
		this.oAbouts = oAbouts;
	}
  
}
