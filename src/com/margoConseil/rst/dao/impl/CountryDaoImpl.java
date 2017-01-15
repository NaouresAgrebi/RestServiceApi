package com.margoConseil.rst.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.margoConseil.rst.dao.CountryDao;
import com.margoConseil.rst.model.Country;

@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country, Integer> implements CountryDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Country findByName(String countryName) {
		Query query = entityManager
				.createQuery("select c from Country c where c.countryName = " + "'" + countryName + "'");
		@SuppressWarnings("unchecked")
		List<Country> objects = query.getResultList();
		Country country = null;
		if (objects != null && !objects.isEmpty()) {
			country = (Country) objects.get(0);
		}
		return country;
	}

}
