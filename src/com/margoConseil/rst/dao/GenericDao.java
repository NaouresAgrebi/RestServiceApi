package com.margoConseil.rst.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	T create(T t);

	T read(PK id);

	T update(T t);

	List<T> findAll();

	void delete(T t);

}
