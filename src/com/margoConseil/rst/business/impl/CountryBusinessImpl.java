package com.margoConseil.rst.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margoConseil.rst.business.CountryBusiness;
import com.margoConseil.rst.dao.CountryDao;
import com.margoConseil.rst.dto.CountryDto;
import com.margoConseil.rst.helper.CountryHelper;
import com.margoConseil.rst.model.Country;

@Service
public class CountryBusinessImpl implements CountryBusiness {

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CountryHelper countryHelper;

	@Override
	public List<CountryDto> findAllCountry() {
		List<Country> countryList = countryDao.findAll();
		return countryHelper.extractDtoList(countryList);
	}

}
