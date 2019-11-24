package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.Orderabout;
import com.dzkj.pojo.Shopcart;

import tk.mybatis.mapper.common.Mapper;

public interface IOrderaboutMapper extends Mapper<Orderabout>{
   List<Orderabout> findbyid(String o_bh);
   Integer add(Orderabout orderAbout);
}
