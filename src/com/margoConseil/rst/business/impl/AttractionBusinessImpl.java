package com.margoConseil.rst.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margoConseil.rst.business.AttractionBusiness;
import com.margoConseil.rst.dao.AttractionDao;
import com.margoConseil.rst.dto.AttractionDto;
import com.margoConseil.rst.helper.AttractionHelper;
import com.margoConseil.rst.model.Attraction;

@Service
public class AttractionBusinessImpl implements AttractionBusiness {

	@Autowired
	private AttractionDao attractionDao;
	@Autowired
	private AttractionHelper attractionHelper;

	@Override
	public List<AttractionDto> findAllAttraction() {
		List<Attraction> attractionList = attractionDao.findAll();
		return attractionHelper.extractDtoList(attractionList);
	}

}
