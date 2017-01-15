package com.margoConseil.rst.dao;

import com.margoConseil.rst.model.City;

public interface CityDao extends GenericDao<City, Integer> {

	/**
	 * find city by name
	 * @param cityName
	 * @return
	 */
	City findByName(String cityName);
}
