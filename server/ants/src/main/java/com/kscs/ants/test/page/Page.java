package com.kscs.ants.test.page;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public class Page {
	private Long id;
	private String url;
	private Long times;

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
