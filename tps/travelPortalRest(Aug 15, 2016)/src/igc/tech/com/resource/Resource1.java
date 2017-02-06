package igc.tech.com.resource;

import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.ResponseModel;
import igc.tech.com.utility.ScheduleTask;
import igc.tech.com.utility.ThreadLoop;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.transform.Source;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

@Component
@Path("/testing1")
public class Resource1 {


    ErrorMessage errorMessage;

    ResponseModel responseModel;

    Timer timer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response mobNav() throws Exception {


        errorMessage = new ErrorMessage();
        errorMessage.setErrormessage("testing1");
        Thread thread = new Thread(new ThreadLoop("task1"));


        //the Date and time at which you want to execute
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter.parse("2016-07-12 12:46:30");

        //Now create the time and schedule it
        timer = new Timer();

        //Use this if you want to execute it once
        timer.schedule(new ScheduleTask(thread), date);

        System.out.println(timer.hashCode());

        //Use this if you want to execute it repeatedly
        //int period = 10000;//10secs
        //timer.schedule(new MyTimeTask(), date, period );


        return Response.status(Response.Status.OK).entity(errorMessage)
                .type(MediaType.APPLICATION_JSON).build();


    }

    @Path("cancel")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancel() throws Exception {

        this.timer.cancel();

        errorMessage = new ErrorMessage();
        errorMessage.setErrormessage("testing1 timer cancelled");

        return Response.status(Response.Status.OK).entity(errorMessage)
                .type(MediaType.APPLICATION_JSON).build();


    }

}
