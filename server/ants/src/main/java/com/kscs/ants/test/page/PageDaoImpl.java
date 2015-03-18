package com.kscs.ants.test.page;

import com.kscs.tech.spring.creator.dao.SqlDataAccessImpl;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public class PageDaoImpl extends SqlDataAccessImpl<Long, Page> implements
		PageDao {

	@Override
	public Class<? extends Object> getGoalClass() {
		return Page.class;
	}

}
