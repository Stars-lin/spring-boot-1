package com.dzkj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.IFootMapper;
import com.dzkj.pojo.Foot;
import com.dzkj.service.IFootService;

@Service
@Transactional
public class FootService implements IFootService{
   
	 @Autowired
	 IFootMapper footMapper;

	@Override
	public boolean add(Foot foot) {
		return footMapper.add(foot)>0;
	}

	@Override
	public List<Foot> findbyu_id(Integer u_id) {
		return footMapper.findbyu_id(u_id);
	}

	@Override
	public boolean del(Integer id) {
		return footMapper.deleteByPrimaryKey(id)>0;
	}

	@Override
	public Foot findone(Foot foot) {
		return footMapper.findone(foot);
	}

	 
}
