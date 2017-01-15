package com.margoConseil.rst.busniessTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.margoConseil.rst.business.impl.CitiesBusinessImpl;
import com.margoConseil.rst.dto.CityDto;
import com.margoConseil.rst.dto.CountersDto;

public class CityBusniessTest {

	@Mock
	private CityDto cityDto;
	@Mock
	private CountersDto countersDto;
	@Mock
	private CitiesBusinessImpl citiesBusinessImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		cityDto = new CityDto("cityName1", Boolean.TRUE);
		countersDto = new CountersDto(11, 10);
	}

	@Test
	public void test1MockCreation() {
		assertNotNull(citiesBusinessImpl);
	}

	@Test
	public void test2FindCityByName() {
		String cityName = "cityName1";
		Mockito.doReturn(cityDto).when(citiesBusinessImpl).findCityByName(cityName);
		assertEquals(cityDto.getCityName(), citiesBusinessImpl.findCityByName(cityName).getCityName());
	}

	@Test
	public void test3GetCounters() {
		Mockito.doReturn(countersDto).when(citiesBusinessImpl).getCounters();
		assertEquals(countersDto, citiesBusinessImpl.getCounters());
	}

	@Test
	public void test4FindAllCity() {
		List<CityDto> cityDtoList = new ArrayList<>();
		Mockito.doReturn(cityDtoList).when(citiesBusinessImpl).findAllCity();
		assertEquals(cityDtoList, citiesBusinessImpl.findAllCity());

	}
}
