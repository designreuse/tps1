package igc.tech.com.resource;

import igc.tech.com.dao.MailServerSettingDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.mapper.MailServerSettingMapper;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.MailServerSettingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/mailServerSetting")
public class MailServerSettingResource {

    @Autowired
    MailServerSettingDao mailServerSettingDao;

    ErrorMessage errorMessage;

	/*@GET
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
	}*/

    /*@Path("/{mailServerSettingId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("activityDetailId") String activityDetailId) {

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = activityDetailDao.procActivityDetail(activityDetailId,
                null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        ActivityDetailModel activityDetailModels = new ActivityDetailMapper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(activityDetailModels)
                .type(MediaType.APPLICATION_JSON).build();

    }*/

    @Path("/active/{active}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MailServerSettingModel getByActive(@PathParam("active") String active) {

        List<MailServerSettingModel> mailServerSettingModels = new MailServerSettingMapper().mapList(mailServerSettingDao.
                procMailServerSetting(null, null, null, null, null, active, null, null, "s"));

        if (mailServerSettingModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        return mailServerSettingModels.get(0);

    }

	/*@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertData(ActivityDetailModel activityDetailModel) {

		@SuppressWarnings("unchecked")
		List<DatabaseResponse> databaseResponses = activityDetailDao
				.procActivityDetail(null,
						activityDetailModel.getDescription(),
						activityDetailModel.getUser(), "i");

		return Response.status(Status.OK).entity(databaseResponses)
				.type(MediaType.APPLICATION_JSON).build();

	}*/

	/*@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateData(

			ActivityDetailModel activityDetailModel) {

		Response rsp = getById( activityDetailModel.getActivityDetailId() );

		if (rsp.getStatus() == 200) {

			@SuppressWarnings("unchecked")
			List<DatabaseResponse> databaseResponses = activityDetailDao
					.procActivityDetail(activityDetailModel.getActivityDetailId(),
							activityDetailModel.getDescription(),
							activityDetailModel.getUser(), "u");
			return Response.status(Status.OK).entity(databaseResponses)
					.type(MediaType.APPLICATION_JSON).build();

		}

		// RETURNING RESPONSE else {

		return rsp;
	}
*/

	/*@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteData(
			ActivityDetailModel activityDetailModel) {

		Response rsp = getById(activityDetailModel.getActivityDetailId());

		if (rsp.getStatus() == 200) {

			@SuppressWarnings("unchecked")
			List<DatabaseResponse> databaseResponses = activityDetailDao
					.procActivityDetail(activityDetailModel.getActivityDetailId(),
							null,
							activityDetailModel.getUser(), "d");
			return Response.status(Status.OK).entity(databaseResponses)
					.type(MediaType.APPLICATION_JSON).build();

		}

		// RETURNING RESPONSE else {

		return rsp;
	}*/

}
