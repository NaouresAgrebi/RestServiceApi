package com.margoConseil.rst.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margoConseil.rst.dto.CityDto;
import com.margoConseil.rst.helper.AttractionHelper;
import com.margoConseil.rst.helper.CityHelper;
import com.margoConseil.rst.helper.CountryHelper;
import com.margoConseil.rst.model.City;

@Service
public class CityHelperImpl implements CityHelper {

	@Autowired
	private CountryHelper countryHelper;

	@Autowired
	private AttractionHelper attractionHelper;

	/*
	 * mapping CityDto To City (non-Javadoc)
	 * 
	 * @see
	 * com.margoConseil.rst.helper.CityHelper#extractModel(com.margoConseil.rst.
	 * dto.CityDto)
	 */
	@Override
	public City extractModel(CityDto cityDto) {
		City city = new City();
		city.setCityId(cityDto.getCityId());
		city.setCityName(cityDto.getCityName());
		city.setCountry(countryHelper.extractModel(cityDto.getCountry()));
		city.setAttractions(attractionHelper.extractModelList(cityDto.getAttractions()));
		city.setVisited(cityDto.getVisited());
		return city;
	}

	/*
	 * mapping City To CityDto (non-Javadoc)
	 * 
	 * @see
	 * com.margoConseil.rst.helper.CityHelper#extractModelList(java.util.List)
	 */
	@Override
	public List<City> extractModelList(List<CityDto> cityDtolist) {
		List<City> citylist = new ArrayList<>();
		for (CityDto cityDto : cityDtolist) {
			citylist.add(extractModel(cityDto));
		}
		return citylist;
	}

	/*
	 * mapping CityDto To City (non-Javadoc)
	 * 
	 * @see
	 * com.margoConseil.rst.helper.CityHelper#extractDto(com.margoConseil.rst.
	 * model.City)
	 */
	@Override
	public CityDto extractDto(City city) {

		CityDto cityDto = new CityDto();
		cityDto.setCityId(city.getCityId());
		cityDto.setCityName(city.getCityName());
		cityDto.setCountry(countryHelper.extractDto(city.getCountry()));
		cityDto.setAttractions(attractionHelper.extractDtoList(city.getAttractions()));
		cityDto.setVisited(city.getVisited());
		return cityDto;
	}

	/*
	 * mapping List CityDto To List City (non-Javadoc)
	 * 
	 * @see
	 * com.margoConseil.rst.helper.CityHelper#extractDtoList(java.util.List)
	 */
	@Override
	public List<CityDto> extractDtoList(List<City> cityList) {
		List<CityDto> cityDtolist = new ArrayList<>();
		for (City city : cityList) {
			cityDtolist.add(extractDto(city));
		}
		return cityDtolist;
	}
}
