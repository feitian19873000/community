package com.frame.core;


/**
 * DAO父类接口
 *
 * @version 1.0,2013-8-31
 * @author Wymann
 * @param <T> 实体模型
 */
public interface BaseDao<T> {
	
	public T save(T model);
	
	public void update(T model);
	
	public void delete(String id);
	
	public T get(String id);
}
