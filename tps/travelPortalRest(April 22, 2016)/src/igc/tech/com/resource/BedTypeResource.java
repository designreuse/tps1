package igc.tech.com.resource;

import igc.tech.com.dao.BedTypeDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.BedTypeMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.model.BedTypeModel;
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

import igc.tech.com.model.HotelDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/bedType")
public class BedTypeResource {

    @Autowired
    BedTypeDao bedTypeDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<BedTypeModel> bedTypeModels = new BedTypeMapper().mapList(bedTypeDao.
                procBedType(null, null, null, null, "a"));

        if (bedTypeModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        return Response.status(Status.OK).entity(bedTypeModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/hotelDetail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByHotelDetail() {

        List<HotelDetailModel> hotelDetailModels = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(null, null, null, null, null, null, null, null,  null, null, null, "f"));

        System.out.println(hotelDetailModels);

        if (hotelDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }


        for (HotelDetailModel hotelDetailModel : hotelDetailModels) {
            List<BedTypeModel> bedTypeModels = new BedTypeMapper().mapList(bedTypeDao.
                    procBedType(null, null, hotelDetailModel.getHotelDetailId(), null, "s"));
            hotelDetailModel.setBedTypes(new BedTypeMapper().mapListSetNull(false, false, true, true, true, true, true, bedTypeModels));

        }

        return Response.status(Status.OK).entity(hotelDetailModels)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/hotelDetail/{hotelDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("hotelDetailId") String hotelDetailId) {

        List<HotelDetailModel> hotelDetailModels = new HotelDetailMapper().mapList(hotelDetailDao.
                procHotelDetail(hotelDetailId, null, null, null, null, null, null, null, null, null, null, "s"));

        if (hotelDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        HotelDetailModel hotelDetailModel = hotelDetailModels.get(0);


        List<BedTypeModel> bedTypeModels = new BedTypeMapper().mapList(bedTypeDao.
                procBedType(null, null, hotelDetailModel.getHotelDetailId(), null, "s"));
        hotelDetailModel.setBedTypes(new BedTypeMapper().mapListSetNull(false, false, true, true, true, true, true, bedTypeModels));

        return Response.status(Status.OK).entity(hotelDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/{bedTypeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("bedTypeId") String bedTypeId) {

        @SuppressWarnings({"rawtypes", "unchecked"})
        List<Map> list = bedTypeDao.procBedType(bedTypeId, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        BedTypeModel bedTypeModel = new BedTypeMapper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(bedTypeModel)
                .type(MediaType.APPLICATION_JSON).build();

    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(BedTypeModel bedTypeModel) {


        Map databaseResponse = (Map) bedTypeDao.procBedType(null, bedTypeModel.getDescription(), bedTypeModel.getHotelDetailId(), bedTypeModel.getUser(), "i").get(0);

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
            BedTypeModel bedTypeModel) {

        Response rsp = getById(bedTypeModel.getBedTypeId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) bedTypeDao.procBedType(bedTypeModel.getBedTypeId(), bedTypeModel.getDescription(),
                    bedTypeModel.getHotelDetailId(), bedTypeModel.getUser(), "u").get(0);

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
            BedTypeModel bedTypeModel) {
        /*
		 * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 */

        Response rsp = getById(bedTypeModel.getBedTypeId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) bedTypeDao.procBedType(bedTypeModel.getBedTypeId(), null, null, bedTypeModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }
    }
}
