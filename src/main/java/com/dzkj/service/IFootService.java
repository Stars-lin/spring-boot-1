package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.Foot;

public interface IFootService {
   boolean add(Foot foot);
   List<Foot> findbyu_id(Integer u_id);
   boolean del(Integer id);
   Foot findone(Foot foot);
}
