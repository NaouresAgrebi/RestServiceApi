package com.margoConseil.rst.business;

import java.util.List;

import com.margoConseil.rst.dto.CountryDto;

public interface CountryBusiness {

	List<CountryDto> findAllCountry();
}
