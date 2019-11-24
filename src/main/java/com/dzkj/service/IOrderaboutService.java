package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.Orderabout;

public interface IOrderaboutService{
   List<Orderabout> findbyo_bh(String o_bh);
   boolean add(Orderabout orderAbout);
   boolean del(Orderabout orderabout);
}
