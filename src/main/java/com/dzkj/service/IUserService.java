package com.dzkj.service;

import com.dzkj.pojo.User;

public interface IUserService {
    User findOneByEmailOrPhone(User user);
	boolean addUser(User user);
	User findoneUser(String name,String pwd);
	boolean update(User user);
	User findById(Integer id);
}
