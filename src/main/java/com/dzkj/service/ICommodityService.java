package com.dzkj.service;

import java.util.List;
import java.util.Map;

import com.dzkj.pojo.Commodity;

public interface ICommodityService {
	//查所有以及分页
	List<Commodity> findbylike(Map<String, Object> map);
	List<Commodity> findbylike_page(Map<String, Object> map,Integer pageNum,Integer pageSize);
	//商品显示
	List<Commodity> findByTwo(Integer id);
	//商品详细信息
	Commodity findById(Integer s_id);
	//根据三级id查询
	List<Commodity> findByThreeId(Integer s_three_id);
	//修改商品数量和销量
	boolean updbyid(Commodity commodity);
	//按销量查询
	List<Commodity> findbysale();
}
