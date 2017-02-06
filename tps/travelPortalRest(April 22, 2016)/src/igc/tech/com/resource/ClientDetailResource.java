package igc.tech.com.resource;

import igc.tech.com.dao.ClientDetailDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.ClientDetailMapper;
import igc.tech.com.model.ClientDetailModel;
import igc.tech.com.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Map;

@Component
@Path("/clientDetail")
public class ClientDetailResource {

    @Autowired
    ClientDetailDao clientDetailDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        System.out.println(clientDetailDao.
                procClientDetail(null, null, null, null, null, null, null, null, null, null, null, "a"));

        List<ClientDetailModel> clientDetailModels = new ClientDetailMapper().mapList(clientDetailDao.
                procClientDetail(null, null, null, null, null, null, null, null, null, null, null, "a"));

        if (clientDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        return Response.status(Status.OK).entity(clientDetailModels)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/{clientDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("clientDetailId") String clientDetailId) {

        List<ClientDetailModel> clientDetailModels = new ClientDetailMapper().mapList(clientDetailDao.
                procClientDetail(clientDetailId, null, null, null, null, null, null, null, null, null, null, "s"));

        if (clientDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        ClientDetailModel clientDetailModel = clientDetailModels.get(0);

        return Response.status(Status.OK).entity(clientDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(ClientDetailModel clientDetailModel) {


        Map databaseResponse = (Map) clientDetailDao.procClientDetail(
                clientDetailModel.getClientDetailId(), clientDetailModel.getClientName(), clientDetailModel.getAddress(), clientDetailModel.getPhoneNumber(),
                clientDetailModel.getEmailId(), clientDetailModel.getCompanyName(), clientDetailModel.getCompanyAddress(), clientDetailModel.getCompanyPhoneNumber(),
                clientDetailModel.getCompanyEmailId(), clientDetailModel.getActive(), clientDetailModel.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(ClientDetailModel clientDetailModel) {

        Response rsp = getById(clientDetailModel.getClientDetailId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")

            Map databaseResponse = (Map) clientDetailDao.procClientDetail(
                    clientDetailModel.getClientDetailId(), clientDetailModel.getClientName(), clientDetailModel.getAddress(), clientDetailModel.getPhoneNumber(),
                    clientDetailModel.getEmailId(), clientDetailModel.getCompanyName(), clientDetailModel.getCompanyAddress(), clientDetailModel.getCompanyPhoneNumber(),
                    clientDetailModel.getCompanyEmailId(), clientDetailModel.getActive(), clientDetailModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(
            ClientDetailModel clientDetailModel) {
        /*
		 * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */


        Response rsp = getById(clientDetailModel.getClientDetailId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) clientDetailDao.
                    procClientDetail(clientDetailModel.getClientDetailId(), null, null, null, null, null, null, null, null, null, null, "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }


}
