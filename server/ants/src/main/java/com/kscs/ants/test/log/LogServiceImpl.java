package com.kscs.ants.test.log;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.kscs.ants.test.page.Page;
import com.kscs.ants.test.page.PageDao;
import com.kscs.tech.spring.creator.dao.condition.AndConditionBuilder;

public class LogServiceImpl implements LogService {
	private LogDao logDao;
	private PageDao pageDao;

	@Override
	@Transactional(readOnly = true)
	public List<Log> getByPageId(Long pageId) {
		AndConditionBuilder condition = new AndConditionBuilder();
		condition.addMoreCondition("page.id", pageId);
		return logDao.searchWithCondition(condition);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void storage(Log entity) {
		logDao.addNewEntityToDatabase(entity);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void delete(Log entity) {
		logDao.deleteFromDatabase(entity);
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void update(Log entity) {
		logDao.updateToDatabase(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Log getByKey(Long key) {
		return logDao.findById(key);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Log> getAll() {
		AndConditionBuilder condition = new AndConditionBuilder();
		return logDao.searchWithCondition(condition);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Log addNewLog(String url, Float duration, String browser) {
		AndConditionBuilder searchPageCondition = new AndConditionBuilder();
		searchPageCondition.addMoreCondition("url", url);
		List<Page> pages = pageDao.searchWithCondition(searchPageCondition);
		System.out.println(url);
		Page page = null;
		if (pages.size() == 0) {
			page = new Page();
			page.setUrl(url);
			page.setTimes(1L);
			pageDao.addNewEntityToDatabase(page);
		} else {
			page = pages.get(0);
			page.setTimes(page.getTimes() + 1);
			pageDao.updateToDatabase(page);
		}

		Log log = new Log();
		log.setBrowser(browser);
		log.setDuration(duration);
		log.setPage(page);

		logDao.addNewEntityToDatabase(log);
		return log;
	}

	public LogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

}
