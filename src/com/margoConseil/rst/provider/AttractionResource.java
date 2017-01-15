package com.margoConseil.rst.provider;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.margoConseil.rst.business.AttractionBusiness;
import com.margoConseil.rst.dto.AttractionDto;

@Path("/attraction")
public class AttractionResource {

	@Autowired
	AttractionBusiness attractionBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllAttraction() throws Exception {
		List<AttractionDto> attractionsDto = attractionBusiness.findAllAttraction();
		return Response.status(200).entity(attractionsDto).build();

	}

}
