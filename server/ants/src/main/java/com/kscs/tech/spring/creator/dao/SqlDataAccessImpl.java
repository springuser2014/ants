package com.kscs.tech.spring.creator.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kscs.tech.spring.creator.dao.condition.AndConditionBuilder;
import com.kscs.tech.spring.creator.dao.exception.DbExecuteFail;

/**
 * Mar 16, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public abstract class SqlDataAccessImpl<KeyType, EntityType> implements
		DataAccess<KeyType, EntityType> {
	protected SessionFactory sessionFactory;

	@Override
	public EntityType findById(KeyType key) throws EntityNotFoundException {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		EntityType entity = (EntityType) session.get(getGoalClass(),
				(Serializable) key);

		if (entity == null) {
			throw new EntityNotFoundException();
		}
		return entity;
	}

	@Override
	public void updateToDatabase(EntityType willToBe) throws DbExecuteFail {
		try {
			sessionFactory.getCurrentSession().update(willToBe);
		} catch (Exception e) {
			throw new DbExecuteFail();
		}

	}

	@Override
	public void deleteFromDatabase(EntityType dropper) throws DbExecuteFail {
		try {
			sessionFactory.getCurrentSession().delete(dropper);
		} catch (Exception e) {
			throw new DbExecuteFail();
		}
	}

	@Override
	public void addNewEntityToDatabase(EntityType comming) throws DbExecuteFail {
		try {
			sessionFactory.getCurrentSession().save(comming);
		} catch (Exception e) {
			throw new DbExecuteFail();
		}
	}

	@Override
	public long getTableSize() throws DbExecuteFail {
		try {
			Session session = sessionFactory.getCurrentSession();
			AndConditionBuilder conditionBuilder = new AndConditionBuilder();

			return ((Long) session.createQuery(
					conditionBuilder.extractCountQuery(getGoalClass()))
					.uniqueResult());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbExecuteFail();
		}
	}

	@Override
	public List<EntityType> searchWithCondition(AndConditionBuilder condition)
			throws DbExecuteFail {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = condition.extractSelectQuery(getGoalClass());
			Query query = session.createQuery(hql);
			
			condition.passParameters(query);

			@SuppressWarnings("unchecked")
			List<EntityType> resultList = (List<EntityType>) query.list();

			if (resultList == null) {
				return Collections.emptyList();
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbExecuteFail();
		}
	}

	@Override
	public long countWithCondition(AndConditionBuilder condition)
			throws DbExecuteFail {
		try {
			Session session = sessionFactory.getCurrentSession();
			AndConditionBuilder conditionBuilder = new AndConditionBuilder();
			Query query = session.createQuery(conditionBuilder
					.extractCountQuery(getGoalClass()));
			conditionBuilder.passParameters(query);

			return (Long) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbExecuteFail();
		}
	}

	public abstract Class<? extends Object> getGoalClass();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
