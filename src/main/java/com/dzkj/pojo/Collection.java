package com.dzkj.pojo;

import java.io.Serializable;

import javax.persistence.Id;

public class Collection implements Serializable{
	@Id
	   private Integer c_id;
		private Integer u_id;
		private Commodity commodity;

		
		public Collection() {
			super();
		}

		public Integer getC_id() {
			return c_id;
		}

		public void setC_id(Integer c_id) {
			this.c_id = c_id;
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
