package com.dzkj.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.ISTopThreeMapper;
import com.dzkj.pojo.STopThree;
import com.dzkj.service.ISTopThreeService;

@Service
@Transactional
public class STopThreeService implements ISTopThreeService{
	
	@Autowired
	ISTopThreeMapper stopthreemap;

	@Override
	public STopThree findById(Integer id) {
		return stopthreemap.selectByPrimaryKey(id);
	}

}
