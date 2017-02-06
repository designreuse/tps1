package igc.tech.com.resource;

import igc.tech.com.dao.ActivityDetailDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.mapper.ActivityDetailMapper;
import igc.tech.com.model.ActivityDetailModel;
import igc.tech.com.model.DatabaseResponseModel;
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
@Path("/activityDetail")
public class ActivityDetailResource {

	@Autowired
	ActivityDetailDao activityDetailDao;

	ErrorMessage errorMessage;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {


		@SuppressWarnings("unchecked")
		List<ActivityDetailModel> activityDetailModels = new ActivityDetailMapper()
				.mapList(activityDetailDao.procActivityDetail(null, null, 
						null, "a"));

		if (activityDetailModels.isEmpty()) {

			throw new NoContentException("data not found!!!!");

		}

		return Response.status(Status.OK).entity(activityDetailModels)
				.type(MediaType.APPLICATION_JSON).build();
	}

	@Path("/{activityDetailId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(
			@PathParam("activityDetailId") String activityDetailId) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Map> list = activityDetailDao.procActivityDetail(activityDetailId,
				null, null,  "s");

		if (list.isEmpty()) {

			throw new NoContentException("data not found!!!!");

		}

		@SuppressWarnings("rawtypes")
		ActivityDetailModel activityDetailModels = new ActivityDetailMapper()
				.mapRow((Map) list.get(0));

		return Response.status(Status.OK).entity(activityDetailModels)
				.type(MediaType.APPLICATION_JSON).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertData(ActivityDetailModel activityDetailModel) {

		@SuppressWarnings("unchecked")
		List<DatabaseResponseModel> databaseResponses = activityDetailDao
				.procActivityDetail(null,
						activityDetailModel.getDescription(),
						activityDetailModel.getUser(), "i");

		return Response.status(Status.OK).entity(databaseResponses)
				.type(MediaType.APPLICATION_JSON).build();

	}

//	@Path("/{activityDetailId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateData(

//	@PathParam("activityDetailId") String activityDetailId,
			ActivityDetailModel activityDetailModel) {

		Response rsp = getById( activityDetailModel.getActivityDetailId() );

		if (rsp.getStatus() == 200) {

			@SuppressWarnings("unchecked")
			List<DatabaseResponseModel> databaseResponses = activityDetailDao
					.procActivityDetail(activityDetailModel.getActivityDetailId(),
							activityDetailModel.getDescription(),
							activityDetailModel.getUser(), "u");
			return Response.status(Status.OK).entity(databaseResponses)
					.type(MediaType.APPLICATION_JSON).build();

		}

		// RETURNING RESPONSE else {

		return rsp;
	}

//	@Path("/{activityDetailId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteData(
//			@PathParam("activityDetailId") String activityDetailId,
			ActivityDetailModel activityDetailModel) {

		Response rsp = getById(activityDetailModel.getActivityDetailId());

		if (rsp.getStatus() == 200) {

			@SuppressWarnings("unchecked")
			List<DatabaseResponseModel> databaseResponses = activityDetailDao
					.procActivityDetail(activityDetailModel.getActivityDetailId(),
							null,
							activityDetailModel.getUser(), "d");
			return Response.status(Status.OK).entity(databaseResponses)
					.type(MediaType.APPLICATION_JSON).build();

		}

		// RETURNING RESPONSE else {

		return rsp;
	}

}
