package com.kscs.ants.test.log;

import java.util.List;

import com.kscs.tech.spring.creator.service.TemplateService;

public interface LogService extends TemplateService<Long, Log> {

	List<Log> getAll();

	Log addNewLog(String url, Float duration, String browser);

	List<Log> getByPageId(Long pageId);

}
