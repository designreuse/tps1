package igc.tech.com.resource;

import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.HotelSearchModel;
import igc.tech.com.model.ResponseModel;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/hotelSearch")
public class HotelSearchResource {


    ErrorMessage errorMessage;

    ResponseModel responseModel;

    @Path("/test")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser() {


        return null;
    }


}
