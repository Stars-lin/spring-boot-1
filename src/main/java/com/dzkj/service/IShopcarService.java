package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.Shopcart;

public interface IShopcarService {
	//添加购物车
    boolean add(Shopcart shopcart);
    //查找购物车是否存在该商品
    Shopcart findone(Shopcart shopcart);
    //修改已存在商品的数量及总价格
    boolean upd(Shopcart shopcart);
    //获取该用户购物车所有商品
    List<Shopcart> findall(Integer u_id);
    //删除商品
    boolean delone(Integer id);
    //删除多条商品
    boolean delarr(List<Integer> items);
    //根据id查单条
    Shopcart findbyid(Shopcart shopcart);
}
