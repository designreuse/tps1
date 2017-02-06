package igc.tech.com.resource;

import igc.tech.com.dao.ClientDetailDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.ClientDetailMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.model.ClientDetailModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.HotelDetailModel;

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
@Path("/hotelDetail")
public class HotelDetailResource {

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    ClientDetailDao clientDetailDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<HotelDetailModel> hotelDetails = new HotelDetailMapper()
                .mapList(hotelDetailDao.procHotelDetail(null, null, null, null,
                        null, null, null, null, null, null, null, "a"));

        if (hotelDetails.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        return Response.status(Status.OK).entity(hotelDetails)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/clientDetail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByClientDetail() {

        List<ClientDetailModel> clientDetailModels = new ClientDetailMapper().mapList(clientDetailDao.
                procClientDetail(null, null, null, null, null, null, null, null, null, null, null, "b"));

        if (clientDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        for (ClientDetailModel clientDetailModel : clientDetailModels) {

            List<HotelDetailModel> hotelDetailModels = new HotelDetailMapper().mapList(hotelDetailDao.
                    procHotelDetail(null, null, null, null, null, null, null, null, null, clientDetailModel.getClientDetailId(), null, "s"));

            clientDetailModel.setHotelDetails(new HotelDetailMapper().
                    mapListSetNull(false, false, false, false, false, false, false, false, false, false, false, false, true, true, hotelDetailModels));
        }


        return Response.status(Status.OK).entity(clientDetailModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/clientDetail/{clientDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByClientDetailId(@PathParam("clientDetailId") String clientDetailId) {

        List<ClientDetailModel> clientDetailModels = new ClientDetailMapper().mapList(clientDetailDao.
                procClientDetail(clientDetailId, null, null, null, null, null, null, null, null, null, null, "s"));

        if (clientDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        ClientDetailModel clientDetailModel = clientDetailModels.get(0);

        List<HotelDetailModel> hotelDetailModels = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(null, null, null, null, null, null, null, null, null, clientDetailModel.getClientDetailId(), null, "s"));

        clientDetailModel.setHotelDetails(new HotelDetailMapper().
                mapListSetNull(false, false, false, false, false, false, false, false, false, false, false, false, true, true, hotelDetailModels));

        return Response.status(Status.OK).entity(clientDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/{hotelDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("hotelDetailId") String hotelDetailId) {


        List<Map> list = hotelDetailDao.procHotelDetail(hotelDetailId, null,
                null, null, null, null, null, null, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }


        HotelDetailModel hotelDetail = new HotelDetailMapper().mapRow((Map) list
                .get(0));

        return Response.status(Status.OK).entity(hotelDetail)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(HotelDetailModel hotel) {

        Map databaseResponse = (Map) hotelDetailDao
                .procHotelDetail(null, hotel.getHotelName(),
                        hotel.getHotelPhNo1(), hotel.getHotelPhNo2(),
                        hotel.getHotelPhNo3(), hotel.getHotelAddress(),
                        hotel.getHotelEmailId(), hotel.getAreaId(),
                        hotel.getUrl(), hotel.getClientDetailId(), hotel.getUser(),
                        "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

    //	@Path("/{hotelDetailId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(HotelDetailModel hotelModel) {
        /*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */
        // System.out.println("this is the first cid "+countryId);

        Response rsp = getById(hotelModel.getHotelDetailId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) hotelDetailDao
                    .procHotelDetail(hotelModel.getHotelDetailId(), hotelModel.getHotelName(),
                            hotelModel.getHotelPhNo1(), hotelModel.getHotelPhNo2(),
                            hotelModel.getHotelPhNo3(), hotelModel.getHotelAddress(),
                            hotelModel.getHotelEmailId(), hotelModel.getAreaId(),
                            hotelModel.getUrl(), hotelModel.getClientDetailId(), hotelModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

    //	@Path("/{hotelDetailId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(
//			@PathParam("hotelDetailId") String hotelDetailId, 
            HotelDetailModel hotelModel) {
        /*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */

        Response rsp = getById(hotelModel.getHotelDetailId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) hotelDetailDao
                    .procHotelDetail(hotelModel.getHotelDetailId(), null, null, null, null,
                            null, null, null, null, null, hotelModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }
}
