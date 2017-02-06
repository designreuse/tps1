package igc.tech.com.resource;

import igc.tech.com.dao.ActivityDao;
import igc.tech.com.mapper.ActivityMapper;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/activity")
public class ActivityResource {

   @Autowired
    ActivityDao activityDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    @Path("/mobNav")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response mobNav( ) throws Exception {


        System.out.println(activityDao.procActivity(new ActivityModel(),null,"a"));
       List<ActivityModel>  activityModels=  new ActivityMapper().mapList(activityDao.procActivity(new ActivityModel(),null,"nav_mob")) ;


        return Response.status(Response.Status.OK).entity(activityModels)
                .type(MediaType.APPLICATION_JSON).build();


    }


    @Path("/webNav")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response webNav( ) throws Exception {

        List<ActivityModel>  activityModels=  new ActivityMapper().mapList(activityDao.procActivity(new ActivityModel(),null,"nav_web")) ;


        return Response.status(Response.Status.OK).entity(activityModels)
                .type(MediaType.APPLICATION_JSON).build();


    }





}
