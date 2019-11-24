package com.dzkj.mapper;

import java.util.List;
import java.util.Map;

import com.dzkj.pojo.Commodity;

import tk.mybatis.mapper.common.Mapper;

public interface ICommodityMapper extends Mapper<Commodity>{
	//搜索框查询
   List<Commodity> find(Map<String, Object> map);
   //根据二级id查询
   List<Commodity> findByTwo(Integer s_two_id);
   //根据三级id查询
   List<Commodity> findByThreeId(Integer s_three_id);
   //按销量排序查询
   List<Commodity> findbysale();
}
