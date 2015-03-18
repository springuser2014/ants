package com.kscs.tech.spring.creator.dao.condition;

import org.junit.Assert;
import org.junit.Test;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public class MonoConditionTest {

	@Test
	public void testExtractQuery() throws Exception {
		MonoCondition monoCondition = new MonoCondition("hello", 5);
		Assert.assertEquals("hello = :hello", monoCondition.queryCondition());
	}

	@Test
	public void testExtractQuery2() throws Exception {
		MonoCondition monoCondition = new MonoCondition("hello.world.test", 5);
		Assert.assertEquals("hello.world.test = :helloworldtest",
				monoCondition.queryCondition());
	}

	@Test
	public void testExtractQuery3() throws Exception {
		MonoCondition monoCondition = new MonoCondition("hello.world.test", 5,
				SearchType.LIKE);
		Assert.assertEquals("hello.world.test like :helloworldtest",
				monoCondition.queryCondition());
	}
}
