package com.margoConseil.rst.helper;

import java.util.List;

import com.margoConseil.rst.dto.AttractionDto;
import com.margoConseil.rst.model.Attraction;

public interface AttractionHelper {

	/**
	 * 
	 * @param attractionDto
	 * @return
	 */
	 Attraction extractModel(AttractionDto attractionDto);

	 /**
	  * 
	  * @param attractionDtoList
	  * @return
	  */
	 List<Attraction> extractModelList(List<AttractionDto> attractionDtoList);

	 /**
	  * 
	  * @param attraction
	  * @return
	  */
	 AttractionDto extractDto(Attraction attraction);

	 /**
	  * 
	  * @param attractionList
	  * @return
	  */
	 List<AttractionDto> extractDtoList(List<Attraction> attractionList);
}
