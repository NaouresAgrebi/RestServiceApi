package com.margoConseil.rst.dto;

import java.util.List;

public class InsertCityDto {

	private String city;
	private String country;
	private List<String> attractions;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<String> attractions) {
		this.attractions = attractions;
	}

	@Override
	public String toString() {
		return "InsertCityDto [city=" + city + ", country=" + country + ", attractions=" + attractions + "]";
	}

}
