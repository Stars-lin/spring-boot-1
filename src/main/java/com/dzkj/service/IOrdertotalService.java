package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.Ordertotal;

public interface IOrdertotalService {
  boolean add(Ordertotal orderTotal);
  Ordertotal findbyo_bh(String o_bh);
  boolean updstates(Ordertotal ordertotal);
  List<Ordertotal> findbyu_id(Integer u_id);
  boolean del(Ordertotal ordertotal);
}
