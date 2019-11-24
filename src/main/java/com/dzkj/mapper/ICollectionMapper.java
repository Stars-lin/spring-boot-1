package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.Collection;
import com.dzkj.pojo.Foot;

import tk.mybatis.mapper.common.Mapper;

public interface ICollectionMapper extends Mapper<Collection>{
	  List<Collection> findbyu_id(Integer u_id);
	  Integer add(Collection collection);
	  Collection findone(Collection collection);
}
