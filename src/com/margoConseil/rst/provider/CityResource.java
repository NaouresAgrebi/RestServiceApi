package com.margoConseil.rst.provider;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.margoConseil.rst.business.CitiesBusiness;
import com.margoConseil.rst.dto.CityDto;
import com.margoConseil.rst.dto.CountersDto;
import com.margoConseil.rst.dto.InsertCityDto;

@Path("/city")
public class CityResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityResource.class);

	@Autowired
	private CitiesBusiness citiesBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllCity() throws Exception {
		LOGGER.info("Recuperer les cities a partir de la base .");
		List<CityDto> citiesDto = citiesBusiness.findAllCity();
		return Response.status(200).entity(citiesDto).build();

	}

	@POST
	@Path("/insertBulk")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insertCities(@RequestBody List<InsertCityDto> insertCityDtoList) throws Exception {
		LOGGER.info("Insertion en masse des cities dans la base de donnee ");
		if (insertCityDtoList == null) {
			throw new Exception();
		}
		citiesBusiness.insertCities(insertCityDtoList);
		return Response.ok().build();
	}

	@GET
	@Path("/{cityName}")
	@Produces(MediaType.APPLICATION_JSON)
	public CityDto findCityByName(@PathParam("cityName") String cityName) {
		return citiesBusiness.findCityByName(cityName);
	}

	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addCity(@RequestBody CityDto cityDto) throws Exception {

		citiesBusiness.addCity(cityDto);
		return Response.ok().build();
	}

	@GET
	@Path("/counters")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCounters() {
		CountersDto counterDto = citiesBusiness.getCounters();
		return Response.status(200).entity(counterDto).build();
	}

}
