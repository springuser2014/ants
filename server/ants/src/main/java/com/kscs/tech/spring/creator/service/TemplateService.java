package com.kscs.tech.spring.creator.service;

/**
 * Mar 17, 2015
 * 
 * @author khacsinhcs
 * @version 0.0.1
 */
public interface TemplateService<Key, Entity> {

	public void storage(Entity entity);

	public void delete(Entity entity);

	public void update(Entity entity);

	public Entity getByKey(Key key);
}
