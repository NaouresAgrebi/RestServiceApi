package com.margoConseil.rst.provider;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.margoConseil.rst.business.CountryBusiness;
import com.margoConseil.rst.dto.CountryDto;

@Path("/country")
public class CountryResource {

	@Autowired
	private CountryBusiness countryBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllCountry() throws Exception {
		List<CountryDto> countryDto = countryBusiness.findAllCountry();
		return Response.status(200).entity(countryDto).build();

	}
}
