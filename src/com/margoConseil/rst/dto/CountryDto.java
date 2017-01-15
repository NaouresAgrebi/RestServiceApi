package com.margoConseil.rst.dto;

public class CountryDto {

	private Integer countryId;
	private String countryName;

	public CountryDto() {
		super();
	}

	public CountryDto(String countryName) {
		super();
		this.countryName = countryName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "CountryDto [countryId=" + countryId + ", countryName=" + countryName + "]";
	}

}
