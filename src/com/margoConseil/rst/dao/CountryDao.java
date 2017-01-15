package com.margoConseil.rst.dao;

import com.margoConseil.rst.model.Country;

public interface CountryDao extends GenericDao<Country, Integer> {
	
	/**
	 * find country by name
	 * @param countryName
	 * @return
	 */
	public Country findByName(String countryName);
}
