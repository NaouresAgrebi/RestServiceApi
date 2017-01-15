package com.margoConseil.rst.helper;

import java.util.List;

import com.margoConseil.rst.dto.CountryDto;
import com.margoConseil.rst.model.Country;

public interface CountryHelper {

	 Country extractModel(CountryDto countryDto);

	 List<Country> extractModelList(List<CountryDto> countryDtoList);

	 CountryDto extractDto(Country country);

	 List<CountryDto> extractDtoList(List<Country> countryList);
}
