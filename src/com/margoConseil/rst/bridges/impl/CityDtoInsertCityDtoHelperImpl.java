package com.margoConseil.rst.bridges.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margoConseil.rst.bridges.CityDtoInsertCityDtoHelper;
import com.margoConseil.rst.dao.AttractionDao;
import com.margoConseil.rst.dao.CountryDao;
import com.margoConseil.rst.dto.InsertCityDto;
import com.margoConseil.rst.model.Attraction;
import com.margoConseil.rst.model.City;
import com.margoConseil.rst.model.Country;

@Service
public class CityDtoInsertCityDtoHelperImpl implements CityDtoInsertCityDtoHelper {

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private AttractionDao attractionDao;

	@Override
	public City extractCity(InsertCityDto insertCityDto) {
		// rechercher si country exist , sinon creation
		Country country = extractCountry(insertCityDto.getCountry());
		// rechercher un par un les attraction sinon creation
		List<Attraction> attractions = extractAttractionList(insertCityDto.getAttractions());
		City city = new City(country, insertCityDto.getCity(), Boolean.FALSE, attractions);
		return city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.margoConseil.rst.bridges.CityDtoInsertCityDtoHelper#
	 * extractCityDtoList(java.util.List) creation du bon object à partir de
	 * l'object insertCityDto
	 */
	@Override
	public List<City> extractCityList(List<InsertCityDto> insertCityDtoList) {
		List<City> cityList = new ArrayList<>();
		for (InsertCityDto insertCityDto : insertCityDtoList) {
			cityList.add(extractCity(insertCityDto));
		}
		return cityList;
	}

	/**
	 * 
	 * @param countryName
	 * @return
	 */
	private Country extractCountry(String countryName) {

		Country country = countryDao.findByName(countryName);
		if (country == null) {
			country = new Country(countryName);
			country = countryDao.create(country);
		}
		return country;
	}

	/**
	 * 
	 * @param attractions
	 * @return
	 */
	private List<Attraction> extractAttractionList(List<String> attractions) {
		List<Attraction> attractionList = new ArrayList<>();
		for (String attractionName : attractions) {
			Attraction attraction = attractionDao.findByName(attractionName);
			if (attraction == null) {
				attraction = new Attraction(attractionName);
				attraction = attractionDao.create(attraction);
			}
			attractionList.add(attraction);
		}
		return attractionList;
	}

}
