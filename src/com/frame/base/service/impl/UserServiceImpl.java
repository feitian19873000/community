package com.frame.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.base.dao.OrgDao;
import com.frame.base.dao.UserDao;
import com.frame.base.model.Org;
import com.frame.base.model.User;
import com.frame.base.service.UserService;
import com.util.generator.IdGenerator;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private OrgDao orgDao;

	/**
	 * 保存
	 */
	@Override
	public void save(User user) {
		if(null!=user.getId()){
			userDao.update(user);
		}
		else{			
			user.setId(IdGenerator.getInstance().getId());
			userDao.save(user);
		}
		Org o=new Org();
		o.setId(IdGenerator.getInstance().getId());
		o.setName("ninini");
		orgDao.save(o);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
		
	}

	@Override
	public boolean check(User user) {
		int count=userDao.check(user);
		if(count>=1){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public User getUser(User user) {
		user=userDao.getUser(user);
		return user;
	}

	@Override
	public void delte(String id) {
		userDao.delete(id);
		
	}

	@Override
	public User getById(String id) {
		return userDao.get(id);
		
	}

}
