package com.margoConseil.rst.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.margoConseil.rst.dao.CityDao;
import com.margoConseil.rst.model.City;

@Repository
public class CityDaoImpl extends GenericDaoImpl<City, Integer> implements CityDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public City findByName(String cityName) {
		Query query = entityManager.createQuery("select c from City c where c.cityName = " + "'" + cityName + "'");
		@SuppressWarnings("unchecked")
		List<City> objects = query.getResultList();
		City city = null;
		if (objects != null && !objects.isEmpty()) {
			city = (City) objects.get(0);
		}
		return city;
	}

}
