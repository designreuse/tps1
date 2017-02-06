package igc.tech.com.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Component
@Path("/test")
public class TestResource {


    public TestResource() {

        System.out.println("testing   const....");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(/*@Context HttpHeaders httpHeaders*/ /*,@Context Request req*/) {



        return  "hello World";

    }



}
