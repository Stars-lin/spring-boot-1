package com.dzkj.mapper;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.User;

import tk.mybatis.mapper.common.Mapper;

public interface IUserMapper extends Mapper<User>{
   User login(@Param("name")String name,@Param("pwd")String pwd);
}
