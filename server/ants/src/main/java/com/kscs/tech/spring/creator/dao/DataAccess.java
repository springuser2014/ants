package com.kscs.tech.spring.creator.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.kscs.tech.spring.creator.dao.condition.AndConditionBuilder;
import com.kscs.tech.spring.creator.dao.exception.DbExecuteFail;

/**
 * Mar 16, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public interface DataAccess<KeyType, EntityType> {
	public EntityType findById(KeyType key) throws EntityNotFoundException;

	public void updateToDatabase(EntityType willToBe) throws DbExecuteFail;

	public void deleteFromDatabase(EntityType dropper) throws DbExecuteFail;

	public void addNewEntityToDatabase(EntityType comming) throws DbExecuteFail;

	public long getTableSize() throws DbExecuteFail;

	public List<EntityType> searchWithCondition(AndConditionBuilder condition)
			throws DbExecuteFail;

	public long countWithCondition(AndConditionBuilder condition)
			throws DbExecuteFail;
}
