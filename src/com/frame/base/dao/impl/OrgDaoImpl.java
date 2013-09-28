package com.frame.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.frame.base.dao.OrgDao;
import com.frame.base.model.Org;
import com.frame.core.BaseDaoImpl;

@Repository
public class OrgDaoImpl extends BaseDaoImpl<Org> implements OrgDao{
	
	public OrgDaoImpl(){
		super();
	}
	
}
