package com.kscs.ants.test.page;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
@Controller
@RequestMapping("rest/page")
public class PageController {

	@Autowired
	private PageService pageService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Page> getAll() {
		return pageService.getAll();
	}

	@RequestMapping(value = "/{pageId}", method = RequestMethod.GET)
	public @ResponseBody Page getById(@PathVariable("pageId") Long id,
			HttpServletResponse response) {
		try {
			return pageService.getByKey(id);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
}
