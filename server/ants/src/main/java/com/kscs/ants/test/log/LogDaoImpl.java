package com.kscs.ants.test.log;

import com.kscs.tech.spring.creator.dao.SqlDataAccessImpl;

public class LogDaoImpl extends SqlDataAccessImpl<Long, Log> implements LogDao {

	@Override
	public Class<? extends Object> getGoalClass() {
		return Log.class;
	}

}
