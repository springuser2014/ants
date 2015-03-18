package com.kscs.ants.test.page;

import java.util.List;

import com.kscs.tech.spring.creator.service.TemplateService;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public interface PageService extends TemplateService<Long, Page> {
	List<Page> getAll();
}
