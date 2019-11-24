package com.dzkj.mapper;

import com.dzkj.pojo.Ordertotal;

import tk.mybatis.mapper.common.Mapper;

public interface IOrdertotalMapper extends Mapper<Ordertotal>{
	Integer updstates(Ordertotal ordertotal);
}
