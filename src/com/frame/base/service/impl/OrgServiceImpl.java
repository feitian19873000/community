package com.frame.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.base.dao.OrgDao;
import com.frame.base.model.Org;
import com.frame.base.service.OrgService;

/**
 * 
 * @version 1.0,2013-9-3
 * @author Wymann
 */
@Service
public class OrgServiceImpl implements OrgService{
	
	@Resource
	private OrgDao orgDao;
	
	public void save(){
		Org org=new Org();
		org.setId("00001");
		org.setName("bbb");
		orgDao.save(org);
	}
}
