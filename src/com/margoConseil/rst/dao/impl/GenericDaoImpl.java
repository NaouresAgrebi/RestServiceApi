package com.margoConseil.rst.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.margoConseil.rst.dao.GenericDao;


public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	public T read(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	public T update(T t) {
		return this.entityManager.merge(t);
	}

	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> objects = null;
		Query query = entityManager.createQuery("from " + entityClass.getName());
		objects = query.getResultList();
		return objects;
	}
}
