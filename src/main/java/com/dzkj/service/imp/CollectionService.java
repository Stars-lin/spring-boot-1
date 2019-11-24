package com.dzkj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.ICollectionMapper;
import com.dzkj.pojo.Collection;
import com.dzkj.pojo.Foot;
import com.dzkj.service.ICollectionService;

@Service
@Transactional
public class CollectionService implements ICollectionService{

	@Autowired
	ICollectionMapper collectionMapper;

	@Override
	public boolean add(Collection collection) {
		return collectionMapper.add(collection)>0;
	}

	@Override
	public List<Collection> findbyu_id(Integer u_id) {
		return collectionMapper.findbyu_id(u_id);
	}

	@Override
	public boolean del(Integer id) {
		return collectionMapper.deleteByPrimaryKey(id)>0;
	}

	@Override
	public Collection findone(Collection collection) {
		return collectionMapper.findone(collection);
	}
}
