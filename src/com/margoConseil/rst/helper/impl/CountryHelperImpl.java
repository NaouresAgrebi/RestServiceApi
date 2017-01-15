package com.margoConseil.rst.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.margoConseil.rst.dto.CountryDto;
import com.margoConseil.rst.helper.CountryHelper;
import com.margoConseil.rst.model.Country;

@Service
public class CountryHelperImpl implements CountryHelper {

	/*
	 * mapping    CountryDto To  Country
	 * (non-Javadoc)
	 * @see com.margoConseil.rst.helper.CountryHelper#extractModel(com.margoConseil.rst.dto.CountryDto)
	 */
	@Override
	public Country extractModel(CountryDto countryDto) {
		Country country = new Country();
		country.setCountryId(countryDto.getCountryId());
		country.setCountryName(countryDto.getCountryName());
		return country;
	}

	/*
	 * mapping   List CountryDto To List Country
	 * (non-Javadoc)
	 * @see com.margoConseil.rst.helper.CountryHelper#extractModelList(java.util.List)
	 */
	@Override
	public List<Country> extractModelList(List<CountryDto> countryDtoList) {

		List<Country> countryList = new ArrayList<>();
		for (CountryDto countryDto : countryDtoList) {
			countryList.add(extractModel(countryDto));
		}
		return countryList;
	}

	/*
	 *  mapping   Country To CountryDto
	 * (non-Javadoc)
	 * @see com.margoConseil.rst.helper.CountryHelper#extractDto(com.margoConseil.rst.model.Country)
	 */
	@Override
	public CountryDto extractDto(Country country) {

		CountryDto countryDto = new CountryDto();
		countryDto.setCountryId(country.getCountryId());
		countryDto.setCountryName(country.getCountryName());
		return countryDto;
	}

	/*
	 *   mapping   List CountryDto To List Country
	 * (non-Javadoc)
	 * @see com.margoConseil.rst.helper.CountryHelper#extractDtoList(java.util.List)
	 */
	@Override
	public List<CountryDto> extractDtoList(List<Country> countryList) {
		List<CountryDto> countryDtoList = new ArrayList<>();
		for (Country country : countryList) {
			countryDtoList.add(extractDto(country));
		}
		return countryDtoList;
	}
}
