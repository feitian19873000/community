package com.frame.base.dao;

import java.util.List;

import com.frame.base.model.User;
import com.frame.core.BaseDao;


public interface UserDao extends BaseDao<User>{

	List<User> findAll();

	int check(User user);

	User getUser(User user);

}
