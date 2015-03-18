package com.kscs.ants.test.log;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kscs.tech.spring.creator.dao.condition.AndConditionBuilder;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
@Controller
@RequestMapping("rest/log")
public class LogController {
	@Autowired
	private LogService logService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Log> getAll(
			@RequestParam(value = "pageId", required = false) Long pageId) {
		if (pageId == null) {
			return logService.getAll();
		}
		return logService.getByPageId(pageId);
	}

	@RequestMapping(value = "/{logId}", method = RequestMethod.GET)
	public @ResponseBody Log getById(@PathVariable("logId") Long id,
			HttpServletResponse response) {
		try {
			return logService.getByKey(id);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Log addNewLog(
			@RequestParam("url") String url,
			@RequestParam("duration") Float duration,
			@RequestHeader(value = "User-Agent", required = false) String browser,
			HttpServletResponse response) {
		try {
			return logService.addNewLog(url, duration, browser);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
}
