package com.margoConseil.rst.business;

import java.util.List;

import com.margoConseil.rst.dto.CityDto;
import com.margoConseil.rst.dto.CountersDto;
import com.margoConseil.rst.dto.InsertCityDto;

public interface CitiesBusiness {

	/**
	 * Ajouter une city
	 * 
	 * @param cityDTO
	 */
	void addCity(CityDto cityDto);

	/**
	 * recuperer la liste des cities
	 * 
	 * @return
	 */
	List<CityDto> findAllCity();

	/**
	 * recherche par nom
	 * 
	 * @param cityName
	 * @return
	 */
	CityDto findCityByName(String cityName);

	/**
	 * 
	 * @param insertCityDtoList
	 */
	void insertCities(List<InsertCityDto> insertCityDtoList);

	CountersDto getCounters();

}
