package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.Shopcart;

import tk.mybatis.mapper.common.Mapper;

public interface IShopcarMapper extends Mapper<Shopcart>{
	Integer add(Shopcart shopcart);
    Shopcart findone(Shopcart shopcart);
    Integer upd(Shopcart shopcart);
    List<Shopcart> findall(Integer u_id);
    Integer delone(Integer id);
    Shopcart findbyid(Integer id);
}
