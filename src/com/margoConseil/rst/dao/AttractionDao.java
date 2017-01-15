package com.margoConseil.rst.dao;

import com.margoConseil.rst.model.Attraction;

public interface AttractionDao extends GenericDao<Attraction, Integer> {
	
	/**
	 * find attraction by name
	 * @param attractionName
	 * @return
	 */
	 Attraction findByName(String attractionName);
}
