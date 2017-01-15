package com.margoConseil.rst.helper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.margoConseil.rst.dto.AttractionDto;
import com.margoConseil.rst.helper.AttractionHelper;
import com.margoConseil.rst.model.Attraction;

@Service
public class AttractionHelperImpl implements AttractionHelper {

	@Override
	public Attraction extractModel(AttractionDto attractionDto) {
		// mapping   List of AttractionDto To Attraction
		Attraction attraction = new Attraction();
		attraction.setAttractionId(attractionDto.getAttractionId());
		attraction.setAttractionName(attractionDto.getAttractionName());
		return attraction;
	}

	@Override
	public List<Attraction> extractModelList(List<AttractionDto> attractionDtoList) {
		// mapping   List of AttractionDto To List Attraction
		List<Attraction> attractionList = new ArrayList<>();
		for (AttractionDto attractionDto : attractionDtoList) {
			attractionList.add(extractModel(attractionDto));
		}
		return attractionList;
	}

	@Override
	public AttractionDto extractDto(Attraction attraction) {
		// mapping  Attraction To AttractionDto
		AttractionDto attractionDto = new AttractionDto();
		attractionDto.setAttractionId(attraction.getAttractionId());
		attractionDto.setAttractionName(attraction.getAttractionName());
		return attractionDto;
	}

	@Override
	public List<AttractionDto> extractDtoList(List<Attraction> attractionList) {
		// mapping   List of Attraction To List AttractionDto
		List<AttractionDto> attractionDtoList = new ArrayList<>();
		for (Attraction attraction : attractionList) {
			attractionDtoList.add(extractDto(attraction));
		}
		return attractionDtoList;
	}
}
