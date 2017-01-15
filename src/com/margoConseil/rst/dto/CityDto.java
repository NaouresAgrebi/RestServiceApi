package com.margoConseil.rst.dto;

import java.util.List;

public class CityDto {

	private Integer cityId;
	private CountryDto country;
	private String cityName;
	private Boolean visited;
	public List<AttractionDto> attractions;

	public CityDto() {
		super();
	}

	public CityDto(String cityName, Boolean visited) {
		super();
		this.cityName = cityName;
		this.visited = visited;

	}

	public CityDto(CountryDto country, String cityName, Boolean visited, List<AttractionDto> attractions) {
		super();
		this.country = country;
		this.cityName = cityName;
		this.visited = visited;
		this.attractions = attractions;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public CountryDto getCountry() {
		return country;
	}

	public void setCountry(CountryDto country) {
		this.country = country;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	public List<AttractionDto> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<AttractionDto> attractions) {
		this.attractions = attractions;
	}

	@Override
	public String toString() {
		return "CityDto [cityId=" + cityId + ", country=" + country + ", cityName=" + cityName + ", visited=" + visited
				+ ", attractions=" + attractions + "]";
	}
	
	
	

}
