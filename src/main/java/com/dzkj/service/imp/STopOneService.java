package com.dzkj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.ISTopOneMapper;
import com.dzkj.pojo.STopOne;
import com.dzkj.service.ISTopOneService;

@Service
@Transactional
public class STopOneService implements ISTopOneService{
	
	@Autowired
	ISTopOneMapper onemapper;

	@Override
	public List<STopOne> findAll() {
		
		return onemapper.findAll();
	}

}
