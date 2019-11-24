package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.Foot;

import tk.mybatis.mapper.common.Mapper;

public interface IFootMapper extends Mapper<Foot>{
  List<Foot> findbyu_id(Integer u_id);
  Integer add(Foot foot);
  Foot findone(Foot foot);
}
