/*
package igc.tech.com.resource;

import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.HotelDetailModel;
import igc.tech.com.model.RoomTypeModel;

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
@Path("/roomType")
public class RoomTypeResource {

    @Autowired
    RoomTypeDao roomTypeDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<RoomTypeModel> roomTypeModels = new RoomTypeMapper().mapList(roomTypeDao.
                procRoomType(null, null, null, null, null, null, null, "a"));

        if (roomTypeModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Hotel Detail");

        }


        return Response.status(Status.OK).entity(roomTypeModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/hotelDetail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByHotelType() {

        List<HotelDetailModel> hotelDetailModels = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(null, null, null, null, null, null, null, null, null, null, null, "b"));

        if (hotelDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Hotel Detail");

        }

        for (HotelDetailModel hotelDetailModel : hotelDetailModels) {
            List<RoomTypeModel> roomTypeModels = new RoomTypeMapper().mapList(roomTypeDao.
                    procRoomType(null, null, hotelDetailModel.getHotelDetailId(), null, null, null, null, "s"));
            hotelDetailModel.setRoomTypes(new RoomTypeMapper().mapListSetNull(false, false, true, true, true, true, true, false, false, false, roomTypeModels));

        }

        return Response.status(Status.OK).entity(hotelDetailModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/hotelDetail/{hotelDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByHotelType(@PathParam("hotelDetailId") String hotelDetailId) {

        List<HotelDetailModel> hotelDetailModels = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(hotelDetailId, null, null, null, null, null, null,  null, null, null, null, "s"));

        if (hotelDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Hotel Detail");

        }

        HotelDetailModel hotelDetailModel = hotelDetailModels.get(0);

        List<RoomTypeModel> roomTypeModels = new RoomTypeMapper().mapList(roomTypeDao.
                procRoomType(null, null, hotelDetailModel.getHotelDetailId(), null, null, null, null, "s"));
        hotelDetailModel.setRoomTypes(new RoomTypeMapper().mapListSetNull(false, false, true, true, true, true, true, false, false, false, roomTypeModels));


        return Response.status(Status.OK).entity(hotelDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/{roomTypeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("roomTypeId") String roomTypeId) {

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = roomTypeDao.procRoomType(roomTypeId, null, null, null, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        RoomTypeModel roomTypeModel = new RoomTypeMapper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(roomTypeModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    */
/*@Path("/hotelDetail/{hotelDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByHotelDetailId(@PathParam("hotelDetailId") String hotelDetailId) {


        List<Map> list = roomTypeDao.procRoomType(null, null, hotelDetailId, null, null, null, null, "h");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        RoomTypeModel roomTypeModel = new RoomTypeMapper().mapRow(list.get(0));

        roomTypeModel.setRoomTypes(new RoomTypeMapper().mapList(roomTypeDao.procRoomType(null, null, roomTypeModel.getHotelDetailId(), null, null, null, null, "f")));

        return Response.status(Status.OK).entity(roomTypeModel)
                .type(MediaType.APPLICATION_JSON).build();
    }
*//*

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(RoomTypeModel roomTypeModel) {


        @SuppressWarnings("unchecked")
        Map databaseResponse = (Map) roomTypeDao.procRoomType(null, roomTypeModel.getDescription(), roomTypeModel.getHotelDetailId(), roomTypeModel.getMaxAdult(), roomTypeModel.getMaxChild(), roomTypeModel.getRate(), roomTypeModel.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }


        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();


    }

    //	@Path("/{hotelFacilityID}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(
//			@PathParam("hotelFacilityID") String hotelFacilityID,
            RoomTypeModel roomTypeModel) {

        Response rsp = getById(roomTypeModel.getRoomTypeId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) roomTypeDao.procRoomType(roomTypeModel.getRoomTypeId(), roomTypeModel.getDescription(),
                    roomTypeModel.getHotelDetailId(), roomTypeModel.getMaxAdult(), roomTypeModel.getMaxChild(), roomTypeModel.getRate(), roomTypeModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

    //	@Path("/{hotelFacilityID}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(
//			@PathParam("hotelFacilityID") String hotelFacilityID,
            RoomTypeModel roomTypeModel) {
        */
/*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 *//*


        Response rsp = getById(roomTypeModel.getRoomTypeId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) roomTypeDao.procRoomType(roomTypeModel.getRoomTypeId(), null, null, null, null, null, roomTypeModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }
    }
}
*/
