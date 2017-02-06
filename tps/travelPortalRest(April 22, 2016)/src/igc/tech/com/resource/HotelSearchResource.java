package igc.tech.com.resource;

import igc.tech.com.dao.*;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/hotelSearch")
public class HotelSearchResource {


    @Autowired
    RoomTypeDao roomTypeDao;

    @Autowired
    RoomImageDao roomImageDao;

    @Autowired
    HotelImageDao hotelImageDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    HotelFacilityDao hotelFacilityDao;

    @Autowired
    HotelRulesDao hotelRulesDao;

    @Autowired
    RoomFacilityDao roomFacilityDao;

    @Autowired
    RoomImportanceDao roomImportanceDao;


    ErrorMessage errorMessage;


    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search() {

        List<RoomTypeModel> roomTypeModels = new RoomTypeMapper().mapList(roomTypeDao.
                procRoomType(null, null, null, null, null, null, null, null, null, null, null, "a"));

        for (RoomTypeModel roomTypeModel : roomTypeModels) {
            roomTypeModel.setThumbnailImage("http://192.168.8.4/TPSResources/RoomImages/" + new RoomImageMapper().mapRow((Map) roomImageDao.
                    procRoomImage(null, roomTypeModel.getRoomTypeId(), null, null, null, null, "Y", null, null, "s").get(0)).getImageUrl());
        }

        return Response.status(Status.OK).entity(roomTypeModels)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/roomType/{roomTypeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam(("roomTypeId")) String roomTypeId) {

        RoomTypeModel roomTypeModel = new RoomTypeMapper().mapRow((Map) roomTypeDao.
                procRoomType(roomTypeId, null, null, null, null, null, null, null, null, null, null, "s").get(0));

        List<HotelFacilityModel> hotelFacilityModels = new HotelFacilityMapper().mapList(hotelFacilityDao.
                procHotelFacility(null, null, roomTypeModel.getHotelDetailId(), "Y", null, "s"));


        roomTypeModel.setHotelFacilityModels(hotelFacilityModels);


        List<HotelRulesModel> hotelRulesModels = new HotelRulesMapper().mapList(hotelRulesDao.
                procHotelRules(null, null, roomTypeModel.getHotelDetailId(), null, "s"));

        roomTypeModel.setHotelRulesModels(hotelRulesModels);


        List<RoomFacilityModel> roomFacilityModels = new RoomFacilityMapper().mapList(roomFacilityDao.
                procRoomFacility(null, roomTypeId, null, null, null, "s"));

        roomTypeModel.setRoomFacilityModels(roomFacilityModels);

        List<RoomImportanceModel> roomImportanceModels = new RoomImportanceMapper().mapList(roomImportanceDao.
                procRoomImportance(null, null, roomTypeId, null,"s"));

        roomTypeModel.setRoomImportanceModels(roomImportanceModels);


        List<RoomImageModel> roomImageModels = new RoomImageMapper().mapList(roomImageDao.
                procRoomImage(null, roomTypeId, null, null, null, null, null, null, null, "s"));

        roomTypeModel.setRoomImageModels(roomImageModels);


        return Response.status(Status.OK).entity(roomTypeModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/hotelDetail/{hotelDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByHotelDetailId(@PathParam("hotelDetailId") String hotelDetailId) {

        HotelDetailModel hotelDetailModel = new HotelDetailMapper().mapRow((Map) hotelDetailDao.
                procHotelDetail(hotelDetailId, null, null, null, null, null, null, null, null, null, null, "s").get(0));
        List<HotelFacilityModel> hotelFacilityModels = new HotelFacilityMapper().mapList(hotelFacilityDao.
                procHotelFacility(null, null, hotelDetailId, "Y", null, "s"));
        hotelDetailModel.setHotelFacilityModels(hotelFacilityModels);


        List<HotelRulesModel> hotelRulesModels = new HotelRulesMapper().mapList(hotelRulesDao.
                procHotelRules(null, null, hotelDetailId, null, "s"));
        hotelDetailModel.setHotelRulesModels(hotelRulesModels);

        List<RoomTypeModel> roomTypeModels = new RoomTypeMapper().mapList(roomTypeDao.
                procRoomType(null, hotelDetailId, null, null, null, null, null, null, null, null, null, "s"));
        hotelDetailModel.setRoomTypeModels(roomTypeModels);


        for (RoomTypeModel roomTypeModel : roomTypeModels) {


            List<RoomFacilityModel> roomFacilityModels = new RoomFacilityMapper().mapList(roomFacilityDao.
                    procRoomFacility(null, roomTypeModel.getRoomTypeId(), null, null, null, "s"));

            roomTypeModel.setRoomFacilityModels(roomFacilityModels);

            List<RoomImageModel> roomImageModels = new RoomImageMapper().mapList(roomImageDao.
                    procRoomImage(null, roomTypeModel.getRoomTypeId(), null, null, null, null, null, null, null, "s"));

            roomTypeModel.setRoomImageModels(roomImageModels);

        }


        return Response.status(Status.OK).entity(hotelDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


}
