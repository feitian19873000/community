package com.frame.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.frame.base.dao.UserDao;
import com.frame.base.model.User;
import com.frame.core.BaseDaoImpl;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
	public UserDaoImpl(){
		super();
	}

	@Override
	public List<User> findAll() {
		log.info("finding all user ");
		try{
			Query query=getSession().createQuery("from User");
			return query.list();
		}catch(RuntimeException e){
			log.error("finded error", e);
			throw e;
		}
		
	}

	@Override
	public int check(User user) {
		log.info("checking user ");
		try{
			String sql="select count(*) from user where "+
			" user.name='"+user.getName()+"' and "+
			" user.password='"+user.getPassword()+"'";
			return getJdbcTemplate().queryForInt(sql);
		}catch(RuntimeException e){
			log.error("checked failed", e);
			throw e;
		}
	}

	@Override
	public User getUser(User user) {
		log.info("finding user by condition");
		try{
			String sql="from User where "+
			" name='"+user.getName()+"' and "+
			" password='"+user.getPassword()+"'";
			Query query=getSession().createQuery(sql);
			return (User)query.list().get(0);
		}catch(RuntimeException e){
			log.error("finding failed", e);
			throw e;
		}
	}
	
}
