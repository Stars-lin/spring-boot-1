package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.STopOne;

import tk.mybatis.mapper.common.Mapper;

public interface ISTopOneMapper extends Mapper<STopOne>{
   List<STopOne> findAll();
}
