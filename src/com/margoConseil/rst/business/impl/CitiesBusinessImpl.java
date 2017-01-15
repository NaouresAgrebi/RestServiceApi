package com.margoConseil.rst.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.margoConseil.rst.bridges.CityDtoInsertCityDtoHelper;
import com.margoConseil.rst.business.CitiesBusiness;
import com.margoConseil.rst.dao.CityDao;
import com.margoConseil.rst.dto.CityDto;
import com.margoConseil.rst.dto.CountersDto;
import com.margoConseil.rst.dto.InsertCityDto;
import com.margoConseil.rst.helper.CityHelper;
import com.margoConseil.rst.model.City;

@Service
public class CitiesBusinessImpl implements CitiesBusiness {

	private static final Logger LOGGER = LoggerFactory.getLogger(CitiesBusinessImpl.class);
	@Autowired
	private CityDao cityDao;
	@Autowired
	private CityDtoInsertCityDtoHelper cityDtoInsertCityDtoHelper;
	@Autowired
	private CityHelper cityHelper;

	@Override
	@Transactional(readOnly = false)
	public void addCity(CityDto cityDto) {
		LOGGER.debug("CityDto to add :"+cityDto.toString());
		City city = cityHelper.extractModel(cityDto);
		cityDao.create(city);
	}
	
	@Override
	public List<CityDto> findAllCity() {
		List<City> cityList = cityDao.findAll();
		return cityHelper.extractDtoList(cityList);
	}

	/*
	 * recherche par nom 
	 * (non-Javadoc)
	 * @see com.margoConseil.rst.business.CitiesBusiness#findCityByName(java.lang.String)
	 */
	@Override
	public CityDto findCityByName(String cityName) {
		CityDto cityDto = null;
		LOGGER.debug("Recherche par nom cityName"+cityName);
		City city = cityDao.findByName(cityName);
		if (city != null) {		
			cityDto = cityHelper.extractDto(city);
			LOGGER.debug("City trouvee : "+cityDto.toString());
		}
		return cityDto;
	}

	/*
	 * insertion en masse des donnees
	 * (non-Javadoc)
	 * @see com.margoConseil.rst.business.CitiesBusiness#insertCities(java.util.List)
	 */
	@Override
	@Transactional(readOnly = false)
	public void insertCities(List<InsertCityDto> insertCityDtoList) {
		List<City> listCity = cityDtoInsertCityDtoHelper.extractCityList(insertCityDtoList);
		for (City city : listCity) {
			LOGGER.debug("City a ajouter : cityName"+city.getCityName());
			if (cityDao.findByName(city.getCityName()) == null) {
				cityDao.create(city);
			}
		}

	}
	
	/*
	 * un service pour le calcul des visited unvisited 
	 * (non-Javadoc)
	 * @see com.margoConseil.rst.business.CitiesBusiness#getCounters()
	 */
	@Override
	public CountersDto getCounters() {
		LOGGER.debug("Nombre de visited , unvisited ");
		List<CityDto> cityDtoList = findAllCity();
		CountersDto countersDto = new CountersDto();
		for (CityDto cityDto : cityDtoList) {
			if (cityDto.getVisited().equals(Boolean.TRUE)) {
				countersDto.setVisitedCounter(countersDto.getVisitedCounter() + 1);
			} else {
				countersDto.setUnVisitedCounter(countersDto.getUnVisitedCounter() + 1);
			}
		}
		return countersDto;
	}

}
