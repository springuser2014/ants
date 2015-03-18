package com.kscs.ants.test.page;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.kscs.tech.spring.creator.dao.condition.AndConditionBuilder;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public class PageServiceImpl implements PageService {

	private PageDao pageDao;

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void storage(Page entity) {
		pageDao.addNewEntityToDatabase(entity);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void delete(Page entity) {
		pageDao.deleteFromDatabase(entity);
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void update(Page entity) {
		pageDao.updateToDatabase(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Page> getAll() {
		AndConditionBuilder condition = new AndConditionBuilder();
		return pageDao.searchWithCondition(condition);
	}

	@Override
	@Transactional(readOnly = true)
	public Page getByKey(Long key) {
		return pageDao.findById(key);
	}

	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

}
