package com.margoConseil.rst.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.margoConseil.rst.dao.AttractionDao;
import com.margoConseil.rst.model.Attraction;

@Repository
public class AttractionDaoImpl extends GenericDaoImpl<Attraction, Integer> implements AttractionDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Attraction findByName(String attractionName) {
		Query query = entityManager
				.createQuery("select c from Attraction c where c.attractionName = " + "'" + attractionName + "'");
		@SuppressWarnings("unchecked")
		List<Attraction> objects = query.getResultList();
		Attraction attraction = null;
		if (objects != null && !objects.isEmpty()) {
			attraction = (Attraction) objects.get(0);
		}
		return attraction;
	}

}
