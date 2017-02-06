/*
package igc.tech.com.resource;

import igc.tech.com.dao.CustomerDetailDao;
import igc.tech.com.dao.HotelBookingDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.CustomerDetailMapper;
import igc.tech.com.mapper.HotelBookingMappper;
import igc.tech.com.model.CustomerDetailModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.HotelBookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Map;

@Component
@Path("/hotelBooking")
public class HotelBookingResource {

    @Autowired
    CustomerDetailDao customerDetailDao;

    @Autowired
    HotelBookingDao hotelBookingDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<HotelBookingModel> hotelBookingModels= new HotelBookingMappper().mapList(hotelBookingDao.
                procHotelBooking(null, null, null, null, null, null, null, null,  null, null, null, null, null, null,null, null,null,null,null, "a"));

        if (hotelBookingModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Hotel Detail");

        }


        return Response.status(Status.OK).entity(hotelBookingModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/customerDetail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCustomerDetail() {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.
                procCustomerDetail(null, null, null, null, null, null, null, null, null, null, null, null, "g"));

        System.out.println(customerDetailModels);

       for (CustomerDetailModel customerDetailModel : customerDetailModels) {

            List<HotelBookingModel> hotelBookingModels= new HotelBookingMappper().mapList(hotelBookingDao.
                    procHotelBooking(null, null, null, null, null, null, null, null, null, null, null, null,
                            customerDetailModel.getCustomerDetailId(), null, null, null,null,null,null, "s"));


            customerDetailModel.setHotelBookingList(hotelBookingModels);

        }


        */
/*if (customerDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Hotel Detail");

        }
*//*


        return Response.status(Status.OK).entity(customerDetailModels)
                .type(MediaType.APPLICATION_JSON).build();

     //   return  null;

    }


    @Path("/{hotelBookingId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("hotelBookingId") String hotelBookingId) {

        List<Map> list = hotelBookingDao.procHotelBooking(hotelBookingId, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null,null,null,null, "s");


        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        HotelBookingModel hotelBookingModel= new HotelBookingMappper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(hotelBookingModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(HotelBookingModel hotelBookingModel) {

        Map databaseResponse = (Map) hotelBookingDao.procHotelBooking(null,hotelBookingModel.getRoomTypeId(),hotelBookingModel.getAdult() ,
                hotelBookingModel.getChild(),hotelBookingModel.getCheckInDate(),hotelBookingModel.getCheckOutDate(),hotelBookingModel.getCountryId(),hotelBookingModel.getCompany(),
                hotelBookingModel.getCity(),hotelBookingModel.getPostalCode(),hotelBookingModel.getLicenseNo(),hotelBookingModel.getAirportPickUp(),
                hotelBookingModel.getCustomerDetailId(),hotelBookingModel.getAmount(),hotelBookingModel.getDiscountAmount(),
                hotelBookingModel.getTotalAmount(),hotelBookingModel.getReferenceNo(),hotelBookingModel.getPayCategory(), hotelBookingModel.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(HotelBookingModel hotelBookingModel) {

        Response rsp = getById(hotelBookingModel.getHotelBookingId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")

            Map databaseResponse = (Map) hotelBookingDao.procHotelBooking(hotelBookingModel.getHotelBookingId(),hotelBookingModel.getRoomTypeId(),hotelBookingModel.getAdult() ,
                    hotelBookingModel.getChild(),hotelBookingModel.getCheckInDate(),hotelBookingModel.getCheckOutDate(),hotelBookingModel.getCountryId(),hotelBookingModel.getCompany(),
                    hotelBookingModel.getCity(),hotelBookingModel.getPostalCode(),hotelBookingModel.getLicenseNo(),hotelBookingModel.getAirportPickUp(),
                    hotelBookingModel.getCustomerDetailId(),hotelBookingModel.getAmount(),hotelBookingModel.getDiscountAmount(),
                    hotelBookingModel.getTotalAmount(),hotelBookingModel.getReferenceNo(),hotelBookingModel.getPayCategory(), hotelBookingModel.getUser(), "u").get(0);

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
    public Response deleteData(HotelBookingModel hotelBookingModel) {
        */
/*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 *//*


        Response rsp = getById(hotelBookingModel.getHotelBookingId());

        if (rsp.getStatus() == 200) {

            Map databaseResponse = (Map) hotelBookingDao.procHotelBooking(hotelBookingModel.getHotelBookingId(), null, null, null, null, null, null, null, null, null,
                    null, null, null, null, null,null,null, null,hotelBookingModel.getUser(), "d");

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
