/*
package igc.tech.com.resource;

import igc.tech.com.dao.CustomerDetailDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.dao.PackageBookingDao;
import igc.tech.com.dao.RoomTypeDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.CustomerDetailMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.mapper.PackageBookingMapper;
import igc.tech.com.mapper.RoomTypeMapper;
import igc.tech.com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.lang.invoke.CallSite;
import java.util.List;
import java.util.Map;

@Component
@Path("/packageBooking")
public class PackageBookingResource {

    @Autowired
    PackageBookingDao packageBookingDao;

    @Autowired
    CustomerDetailDao customerDetailDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<PackageBookingModel> packageBookingModels = new PackageBookingMapper().mapList(packageBookingDao.
                procPackageBooking(null, null, null, null, null, null, null,  null, null, null, null, null, null, null, null, null, "a"));

        if (packageBookingModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Hotel Detail");

        }


        return Response.status(Status.OK).entity(packageBookingModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/customerDetail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCustomerDetail() {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.
                procCustomerDetail(null, null, null, null, null, null, null, null, null, null, null, null, "h"));

        for (CustomerDetailModel customerDetailModel : customerDetailModels) {

            List<PackageBookingModel> packageBookingModels = new PackageBookingMapper().mapList(packageBookingDao.
                    procPackageBooking(null, null, null, null, null,  null, null, null, null, null,  null,
                            null,null, customerDetailModel.getCustomerDetailId(), null, null, "s"));

            customerDetailModel.setPackageBookingList(packageBookingModels);

        }


        if (customerDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!: Hotel Detail");

        }


        return Response.status(Status.OK).entity(customerDetailModels)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/{packageBookingId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("packageBookingId") String packageBookingId) {

        List<Map> list = packageBookingDao.procPackageBooking(packageBookingId, null, null, null,null, null, null, null,  null, null, null, null, null, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        PackageBookingModel packageBookingModel = new PackageBookingMapper()
                .mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(packageBookingModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(PackageBookingModel packageBookingModel) {

        Map databaseResponse = (Map) packageBookingDao.procPackageBooking(null, packageBookingModel.getReferenceNo(), packageBookingModel.getAmount(), packageBookingModel.getDiscountAmount(),
                packageBookingModel.getTotalAmount(), packageBookingModel.getArrivalDate(), packageBookingModel.getDepartDate(), packageBookingModel.getNoOfPerson(), packageBookingModel.getAdult(),
                packageBookingModel.getChild(), packageBookingModel.getAdditionalInfo(), packageBookingModel.getReferedBy(),packageBookingModel.getPayCategory(),
                packageBookingModel.getCustomerDetailId(), packageBookingModel.getAvailableDateRateId(), packageBookingModel.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }


        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();


    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(PackageBookingModel packageBookingModel) {

        Response rsp = getById(packageBookingModel.getPackageBookingId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) packageBookingDao.procPackageBooking(packageBookingModel.getPackageBookingId(), packageBookingModel.getReferenceNo(), packageBookingModel.getAmount(), packageBookingModel.getDiscountAmount(),
                    packageBookingModel.getTotalAmount(), packageBookingModel.getArrivalDate(), packageBookingModel.getDepartDate(), packageBookingModel.getNoOfPerson(), packageBookingModel.getAdult(),
                    packageBookingModel.getChild(), packageBookingModel.getAdditionalInfo(), packageBookingModel.getReferedBy(),packageBookingModel.getPayCategory(),
                    packageBookingModel.getCustomerDetailId(), packageBookingModel.getAvailableDateRateId(), packageBookingModel.getUser(), "u").get(0);

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
    public Response deleteData(PackageBookingModel packageBookingModel) {
        */
/*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 *//*


        Response rsp = getById(packageBookingModel.getPackageBookingId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) packageBookingDao.procPackageBooking(packageBookingModel.getPackageBookingId(), null, null,null, null, null, null, null, null, null, null, null, null, null, null, null, "d").get(0);

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
