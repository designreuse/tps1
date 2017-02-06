package igc.tech.com.resource;

import igc.tech.com.dao.CountryDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.CountryMappper;
import igc.tech.com.model.CountryModel;
import igc.tech.com.model.ErrorMessage;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/country")
public class CountryResource {

	@Autowired
	CountryDao countryDao;

	ErrorMessage errorMessage;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {


		List<CountryModel> countryList = new CountryMappper().mapList(countryDao
				.procCountryInfo(null, null, null, "a"));

		if (countryList.isEmpty()) {

			throw new NoContentException("data not found!!!!");

		}

		return Response.status(Status.OK).entity(countryList)
				.type(MediaType.APPLICATION_JSON).build();
	}

	@Path("/{countryId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("countryId") String countryId) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Map> list = countryDao.procCountryInfo(countryId, null, null,
				 "s");

		if (list.isEmpty()) {

			throw new NoContentException("data not found!!!!");

		}

		@SuppressWarnings("rawtypes")
		CountryModel country = new CountryMappper().mapRow((Map) list.get(0));

		return Response.status(Status.OK).entity(country)
				.type(MediaType.APPLICATION_JSON).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertData(CountryModel country) {


		Map databaseResponse =(Map) countryDao.procCountryInfo(
				null, country.getCountryName(), country.getUser(),  "i").get(0);

		if (!databaseResponse.get("STATUS").equals("SUCCESS")){

			throw  new NotImplementedException(databaseResponse.get("MSG").toString());
		}

		return Response.status(Status.OK).entity(databaseResponse)
				.type(MediaType.APPLICATION_JSON).build();

	}

	//update country;
	
//	@Path("/{countryId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateData(/*@PathParam("countryId") String countryId,*/
			CountryModel countryModel) {
		/*
		 * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */
		
		Response rsp = getById(countryModel.getCountryID());

		if (rsp.getStatus() == 200) {
			@SuppressWarnings("unchecked")
			Map databaseResponse =(Map) countryDao
					.procCountryInfo(countryModel.getCountryID(),
							countryModel.getCountryName(), countryModel.getUser(), "u").get(0);

			return Response.status(Status.OK).entity(databaseResponse)
					.type(MediaType.APPLICATION_JSON).build();

		}

		// RETURNING RESPONSE
		else {

			return rsp;
		}

	}
	
//	@Path("/{countryId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteData(
//			@PathParam("countryId") String countryId,
			CountryModel countryModel) {
		/*
		 * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */


		Response rsp = getById(countryModel.getCountryID());

		if (rsp.getStatus() == 200) {
			@SuppressWarnings("unchecked")
			Map databaseResponse =(Map) countryDao
					.procCountryInfo(countryModel.getCountryID(), null, countryModel.getUser(),  "d").get(0);

			return Response.status(Status.OK).entity(databaseResponse)
					.type(MediaType.APPLICATION_JSON).build();

		}

		// RETURNING RESPONSE
		else {

			return rsp;
		}

	}
	
	
	
	
	

}
