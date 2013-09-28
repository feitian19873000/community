package com.frame.base.service;

import java.util.List;

import com.frame.base.model.User;

public interface UserService {

	void save(User user);

	List<User> findAll();

	boolean check(User user);

	User getUser(User user);

	void delte(String id);

	User getById(String id);

}
