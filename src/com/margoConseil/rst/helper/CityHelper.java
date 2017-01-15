package com.margoConseil.rst.helper;

import java.util.List;

import com.margoConseil.rst.dto.CityDto;
import com.margoConseil.rst.model.City;

public interface CityHelper {

	 City extractModel(CityDto cityDto);

	 List<City> extractModelList(List<CityDto> cityDtoList);

	 CityDto extractDto(City city);

	 List<CityDto> extractDtoList(List<City> cityList);
}
