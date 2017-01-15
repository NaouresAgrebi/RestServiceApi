package com.margoConseil.rst.bridges;

import java.util.List;

import com.margoConseil.rst.dto.InsertCityDto;
import com.margoConseil.rst.model.City;

public interface CityDtoInsertCityDtoHelper {

	/**
	 * set cityDto from insertCityDto
	 * 
	 * @param insertCityDto
	 * @return
	 */
	City extractCity(InsertCityDto insertCityDto);

	/**
	 * @param insertCityDtoList
	 * @return
	 */
	List<City> extractCityList(List<InsertCityDto> insertCityDtoList);
}
