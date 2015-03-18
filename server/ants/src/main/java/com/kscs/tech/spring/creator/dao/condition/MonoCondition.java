package com.kscs.tech.spring.creator.dao.condition;

/**
 * Mar 16, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public class MonoCondition {
	private String field;
	private Object value;
	private SearchType condition;

	public MonoCondition(String field, Object value, SearchType condition) {
		super();
		this.field = field;
		this.value = value;
		this.condition = condition;
	}

	public MonoCondition() {
		super();
	}

	public MonoCondition(String field, Object value) {
		super();
		condition = SearchType.EQUAL;
		this.field = field;
		this.value = value;
	}

	public String queryCondition() {
		StringBuffer queryCondition = new StringBuffer();
		queryCondition.append(field).append(" ").append(contructCondition())
				.append(" ").append(":").append(getQueryInputParameterName());
		return queryCondition.toString();
	}

	private String contructCondition() {
		switch (condition) {
		case EQUAL:
			return "=";
		case LIKE:
			return "like";
		case NOT_EQUAL:
			return "!=";
		case GREATER_THAN:
			return ">";
		case GREATER_THAN_OR_EQUAL:
			return ">=";
		case LESS_THAN:
			return "<";
		case LESS_THAN_OR_EQUAL:
			return "<=";
		default:
			return "";
		}
	}

	public String getQueryInputParameterName() {
		String[] patterns = field.split("\\.");
		if (patterns.length == 1) {
			return field;
		}

		field = removeDots(patterns);
		return field;
	}

	private String removeDots(String[] patterns) {
		StringBuffer queryInputParameter = new StringBuffer();
		for (String element : patterns) {
			queryInputParameter.append(element);
		}
		return queryInputParameter.toString();
	}

	public Object getValue() {
		return value;
	}

}
