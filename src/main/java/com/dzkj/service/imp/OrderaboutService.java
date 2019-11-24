package com.dzkj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.IOrderaboutMapper;
import com.dzkj.pojo.Orderabout;
import com.dzkj.service.IOrderaboutService;

@Service
@Transactional
public class OrderaboutService implements IOrderaboutService{
	
	@Autowired
	IOrderaboutMapper orderaboutmapper;

	@Override
	public List<Orderabout> findbyo_bh(String o_bh) {
		return orderaboutmapper.findbyid(o_bh);
	}

	@Override
	public boolean add(Orderabout orderAbout) {
		return orderaboutmapper.add(orderAbout)>0;
	}

	@Override
	public boolean del(Orderabout orderabout) {
		return orderaboutmapper.delete(orderabout)>0;
	}

}
