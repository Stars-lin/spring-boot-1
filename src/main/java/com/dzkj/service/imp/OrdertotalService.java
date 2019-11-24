package com.dzkj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.IOrdertotalMapper;
import com.dzkj.pojo.Ordertotal;
import com.dzkj.service.IOrdertotalService;

@Service
@Transactional
public class OrdertotalService implements IOrdertotalService{
	
	@Autowired
	IOrdertotalMapper ordertotalMapper;

	public boolean add(Ordertotal orderTotal) {
		return ordertotalMapper.insert(orderTotal)>0;
	}

	@Override
	public Ordertotal findbyo_bh(String o_bh) {
		Ordertotal orderTotal = new Ordertotal();
		orderTotal.setO_bh(o_bh);
		return ordertotalMapper.selectOne(orderTotal);
	}

	@Override
	public boolean updstates(Ordertotal o_bh) {
		return ordertotalMapper.updstates(o_bh)>0;
	}

	@Override
	public List<Ordertotal> findbyu_id(Integer u_id) {
		Ordertotal ordertotal = new Ordertotal();
		ordertotal.setU_id(u_id);
		return ordertotalMapper.select(ordertotal);
	}

	@Override
	public boolean del(Ordertotal ordertotal) {
		return ordertotalMapper.delete(ordertotal)>0;
	}

}
