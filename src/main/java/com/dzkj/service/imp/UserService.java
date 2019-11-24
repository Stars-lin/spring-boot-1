package com.dzkj.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.IUserMapper;
import com.dzkj.pojo.User;
import com.dzkj.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService{
	
	@Autowired
	IUserMapper user_mapper;

	//注册判断邮箱手机号是否存在
	@Override
	public User findOneByEmailOrPhone(User user) {
		return user_mapper.selectOne(user);
	}

	//注册
	@Override
	public boolean addUser(User user) {
		return user_mapper.insert(user)>0;
	}

	//登录
	@Override
	public User findoneUser(String name,String pwd) {
		return user_mapper.login(name, pwd);
	}

	@Override
	public boolean update(User user) {
		return user_mapper.updateByPrimaryKey(user)>0;
	}

	@Override
	public User findById(Integer id) {
		return user_mapper.selectByPrimaryKey(id);
	}

}
