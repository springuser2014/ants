package com.kscs.tech.spring.creator.dao.condition;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

/**
 * Mar 16, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public class AndConditionBuilder {
	private static final int DONT_HAVE_CONDITION = -100;
	private int limitResult = DONT_HAVE_CONDITION;
	private int firstResult = DONT_HAVE_CONDITION;

	private List<MonoCondition> listAndConditions = new ArrayList<MonoCondition>();

	public void addMoreCondition(String searchField, Object value) {
		listAndConditions.add(new MonoCondition(searchField, value));
	}

	public void addMoreCondition(String searchField, Object value,
			SearchType condition) {
		listAndConditions.add(new MonoCondition(searchField, value, condition));
	}

	public String extractSelectQuery(Class<? extends Object> classType) {
		StringBuffer query = new StringBuffer();
		query.append("FROM ").append(classType.getSimpleName())
				.append(" t");

		query.append(addConditions());
		return query.toString();
	}

	private StringBuffer addConditions() {
		StringBuffer query = new StringBuffer();

		if (listAndConditions.size() != 0) {
			query.append(" WHERE");
		}
		for (int index = 0; index < listAndConditions.size(); index++) {
			MonoCondition condition = listAndConditions.get(index);
			query.append(" t.").append(condition.queryCondition());

			if (isNotTheLastCondition(index)) {
				query.append(" AND");
			}
		}
		return query;
	}

	private boolean isNotTheLastCondition(int index) {
		return index != listAndConditions.size() - 1;
	}

	public String extractCountQuery(Class<? extends Object> classType) {

		StringBuffer query = new StringBuffer();
		query.append("SELECT COUNT(t) FROM ")
				.append(classType.getSimpleName()).append(" t");

		query.append(addConditions());
		return query.toString();
	}

	public void passParameters(Query query) {
		for (MonoCondition condition : listAndConditions) {
			query.setParameter(condition.getQueryInputParameterName(),
					condition.getValue());
		}

		if (isHadFistResultCondition()) {
			query.setFirstResult(firstResult);
		}

		if (isHadLimitCondition()) {
			query.setMaxResults(limitResult);
		}
	}

	public void setLimitCondition(int limit) {
		this.limitResult = limit;
	}

	public void setFirstResultCondition(int first) {
		this.firstResult = first;
	}

	private boolean isHadLimitCondition() {
		return limitResult != DONT_HAVE_CONDITION;
	}

	private boolean isHadFistResultCondition() {
		return firstResult != DONT_HAVE_CONDITION;
	}
}
