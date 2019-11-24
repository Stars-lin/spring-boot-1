package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.Collection;
import com.dzkj.pojo.Foot;

public interface ICollectionService {
	   boolean add(Collection collection);
	   List<Collection> findbyu_id(Integer u_id);
	   boolean del(Integer id);
	   Collection findone(Collection collection);
}
