package com.margoConseil.rst.dto;

import java.util.List;

import com.margoConseil.rst.model.City;

public class AttractionDto {
	private Integer attractionId;
	private String attractionName;

	public AttractionDto() {
		super();
	}

	public AttractionDto(String attractionName, List<City> cities) {
		super();
		this.attractionName = attractionName;
	}

	public Integer getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Integer attractionId) {
		this.attractionId = attractionId;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

	@Override
	public String toString() {
		return "AttractionDto [attractionId=" + attractionId + ", attractionName=" + attractionName + "]";
	}

}
