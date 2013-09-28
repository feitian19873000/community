package com.frame.core;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * DAOImpl父类
 * @version 1.0,2013-9-1
 * @author Wymann
 * @param <T> 实体模型
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	public Logger log=Logger.getLogger(BaseDaoImpl.class);
	
	protected Class<T> entity;
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;	//创建hibernate操作数据库session
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;		//spring访问数据库
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		this.entity=(Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.log=Logger.getLogger(this.getClass());
	}

	/**
	 * 保存实体
	 * @param 实体
	 * @return model
	 */
	@Override
	public T save(T model) {
		log.info("saving "+model.getClass().getSimpleName()+" instance! ");
		try {
			getSession().save(model);
			return model;
		} catch (RuntimeException e) {
			log.error("saving "+model.getClass().getSimpleName()+" fail! ", e);
			throw e;
		}
	}
	
	/**
	 * 修改实体
	 * @param model：实体模型
	 * @return
	 */
	@Override
	public void update(T model) {
		log.info("updating "+model.getClass().getSimpleName()+" instance! ");
		try {
			getSession().update(model);
		} catch (RuntimeException e) {
			log.error("updating "+model.getClass().getSimpleName()+" fail! ",e);
			throw e;
		}
	}
	
	/**
	 * 删除实体
	 * @param id：主键
	 */
	@Override
	public void delete(String id) {
		log.info("deleting "+entity.getSimpleName()+" instance by Id:"+id);
		try {
			getJdbcTemplate().update("delete from user where id="+id);
		} catch (RuntimeException e) {
			log.error("deleting "+entity.getSimpleName()+" instance by Id:"+id+" fail! ", e);
			throw e;
		}
	}
	
	/**
	 * 通过 Id获取实体
	 * @param id：主键id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T get(String id) {
		log.info("getting "+entity.getSimpleName()+" instance by Id:"+id);
		try {
			T t=(T)getSession().get(this.entity, id);
			return t;
		} catch (RuntimeException e) {
			log.error("getting "+entity.getSimpleName()+" instance by Id:"+id+" fail! ", e);
			throw e;
		}
	}
	
	/**
	 * 创建hibernate的session
	 * @return
	 */
	protected Session getSession(){
		return (Session) sessionFactory.getCurrentSession();
	}
	
	protected JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}

}
