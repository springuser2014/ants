package com.kscs.tech.spring.creator.dao.condition;

import org.junit.Assert;
import org.junit.Test;

import com.kscs.ants.test.page.Page;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public class AndConditionBuilderTest {

	@Test
	public void extractSelectQueryTest() {
		AndConditionBuilder condition = new AndConditionBuilder();
		condition.addMoreCondition("integer", 3);
		condition.addMoreCondition("String", "Hello");
		Assert.assertEquals(
				"FROM String t WHERE t.integer = :integer AND t.String = :String",
				condition.extractSelectQuery(String.class));
	}

	@Test
	public void extractCountQueryTest() {
		AndConditionBuilder condition = new AndConditionBuilder();
		condition.addMoreCondition("integer", 3);
		condition.addMoreCondition("String", "Hello");
		Assert.assertEquals(
				"SELECT COUNT(t) FROM String t WHERE t.integer = :integer AND t.String = :String",
				condition.extractCountQuery(String.class));
	}

	@Test
	public void extractSelectQueryTest2() {
		String url = "test";
		AndConditionBuilder searchPageCondition = new AndConditionBuilder();
		searchPageCondition.addMoreCondition("url", url);
		
		String hql = searchPageCondition.extractSelectQuery(Page.class);
		System.out.println(hql);
		Assert.assertEquals(
				"SELECT COUNT(t) FROM String t WHERE t.integer = :integer AND t.String = :String",
				hql);
	}
}
