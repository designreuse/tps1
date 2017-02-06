package igc.tech.com.resource;

import igc.tech.com.dao.*;
import igc.tech.com.exception.DataNotFoundException;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.utility.AESencrp;
import igc.tech.com.utility.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Map;

@Component
@Path("/transaction")
public class TransactionResource {


    @Autowired
    CustomerDetailDao customerDetailDao;

    @Autowired
    PackageBookingDao packageBookingDao;

    @Autowired
    HotelBookingDao hotelBookingDao;

    @Autowired
    MailServerSettingResource mailServerSettingResource;

    @Autowired
    PackageBookingStatusDao packageBookingStatusDao;

    @Autowired
    HotelBookingStatusDao hotelBookingStatusDao;

    ResponseModel responseModel;


    ErrorMessage errorMessage;

    SendEmail sendEmail;

    HotelEmailModel hotelEmailModel;

    DatabaseResponseModel databaseResponse;

    @Path("/packageBooking")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response packageBookOrPay(PackageBookingModel packageBookingModel) throws Exception {

        String bookingType = null;

        if (packageBookingModel.getBookingStatus().equals("book")) {

            bookingType = "book";
            packageBookingModel.setPayCategory("BP");
        } else if (packageBookingModel.getBookingStatus().equals("pay")) {

            bookingType = "pay";
            packageBookingModel.setPayCategory("DP");

        } else {

            System.out.println("throw expception");
        }

        String redirectLink = "https://tps.com";

        databaseResponse = new DatabaseResponseMapper().mapRow((Map) packageBookingDao.procPackageBooking(null, null, packageBookingModel.getAmount(),
                packageBookingModel.getDiscountAmount(), packageBookingModel.getTotalAmount(), packageBookingModel.getArrivalDate(),
                packageBookingModel.getDepartDate(), packageBookingModel.getNoOfPerson(), packageBookingModel.getAdult(),
                packageBookingModel.getChild(), packageBookingModel.getAdditionalInfo(), packageBookingModel.getReferedBy(), packageBookingModel.getPayCategory(),
                packageBookingModel.getCustomerDetailId(), packageBookingModel.getAvailableDateRateId(), packageBookingModel.getUser(), "i").get(0));

        packageBookingModel = new PackageBookingMapper().mapRow((Map) packageBookingDao.
                procPackageBooking(databaseResponse.getId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "s").get(0));


        String response = null;


        databaseResponse = new DatabaseResponseMapper().mapRow((Map) packageBookingStatusDao.procPackageBookingStatus(null, databaseResponse.getId(), "B", null, null, "tilak", "i").get(0));


        PackageBookingStatusModel packageBookingStatusModel = new PackageBookingStatusMapper().mapRow((Map) packageBookingStatusDao.
                procPackageBookingStatus(databaseResponse.getId(), null, null, null, null, null, "s").get(0));


        PackageEmailModel packageEmailModel= new PackageEmailModel();

        packageEmailModel.setPackageBookingModel(packageBookingModel);
        packageEmailModel.setPaymentStatus("PENDING");
        packageEmailModel.setPaymentType("-");
        packageEmailModel.setRedirectLink("https://tps.com/" + bookingType + "/" + packageBookingStatusModel.getHashCode());
        packageEmailModel.setBookingStatus("Pending");

        packageEmailModel.setBookingReq(true);

        sendEmail = new SendEmail();

        sendEmail.setMailServerSettingModel(mailServerSettingResource.getByActive("Y"));
        sendEmail.setSubject("Package Booking test");
        sendEmail.setEmailTo(packageBookingModel.getEmail());
        sendEmail.setEmailValue(packageEmailModel.getEmailBody());
        sendEmail.access();

        responseModel = new ResponseModel();

        responseModel.setStatus("SUCCESS");
        responseModel.setMessage("Request for booking confirmation has been sent to customer Email");

        return Response.status(Status.OK).entity(responseModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/package/book")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookPackage(PackageBookingModel packageBookingModel) throws Exception {


        List<PackageBookingStatusModel> packageBookingStatusModels = new PackageBookingStatusMapper().mapList(packageBookingStatusDao.
                procPackageBookingStatus(null, null, null, null, packageBookingModel.getHashCode(), null, "s"));

        if (packageBookingStatusModels.isEmpty()) {
            throw new DataNotFoundException("Key doesn't match for Booking Confirmation");
        }


        PackageBookingStatusModel packageBookingStatusModel = packageBookingStatusModels.get(0);

        databaseResponse = new DatabaseResponseMapper().mapRow((Map) packageBookingStatusDao.
                procPackageBookingStatus(packageBookingStatusModel.getPackageBookingStatusId(), null, null, "Y", null, null, "u").get(0));

        PackageEmailModel packageEmailModel = new PackageEmailModel();

        packageBookingModel = new PackageBookingMapper().mapRow((Map) packageBookingDao.procPackageBooking(packageBookingStatusModel.getPackageBookingId(), null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, "s").get(0));

        databaseResponse = new DatabaseResponseMapper().mapRow((Map) packageBookingStatusDao.
                procPackageBookingStatus(null, packageBookingModel.getPackageBookingId(), "P", null, null, "tilak", "i").get(0));

        packageBookingStatusModel = new PackageBookingStatusMapper().mapRow((Map) packageBookingStatusDao.
                procPackageBookingStatus(databaseResponse.getId(), null, null, null, null, null, "s").get(0));


        packageEmailModel.setPackageBookingModel(packageBookingModel);

        packageEmailModel.setPaymentStatus("PENDING");
        packageEmailModel.setPaymentType("-");
        packageEmailModel.setRedirectLink("https://tps.com/pay/" + packageBookingStatusModel.getHashCode());
        packageEmailModel.setBookingStatus("Booked");
        packageEmailModel.setBookingReqConf(true);

        sendEmail = new SendEmail();

        sendEmail.setMailServerSettingModel(mailServerSettingResource.getByActive("Y"));
        sendEmail.setSubject("Package Booking Accepted");
        sendEmail.setEmailTo(packageBookingModel.getEmail());
        sendEmail.setEmailValue(packageEmailModel.getEmailBody());
        sendEmail.access();

        responseModel = new ResponseModel();

        responseModel.setStatus("SUCCESS");
        responseModel.setMessage("Booking Accepted!! Booking Detail and Payment Request has been sent to customer Email");

        return Response.status(Status.OK).entity(responseModel)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/hotelBooking")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelBookOrPay(HotelBookingModel hotelBookingModel) throws Exception {


        String bookingType = null;

        if (hotelBookingModel.getBookingStatus().equals("book")) {

            bookingType = "book";
            hotelBookingModel.setPayCategory("BP");
        } else if (hotelBookingModel.getBookingStatus().equals("pay")) {

            bookingType = "pay";
            hotelBookingModel.setPayCategory("DP");

        } else {

            System.out.println("throw expception");
        }

        String redirectLink = "https://tps.com";

        databaseResponse = new DatabaseResponseMapper().mapRow((Map) hotelBookingDao.procHotelBooking(null, hotelBookingModel.getRoomTypeId(), hotelBookingModel.getAdult(),
                hotelBookingModel.getChild(), hotelBookingModel.getCheckInDate(), hotelBookingModel.getCheckOutDate(), hotelBookingModel.getCountryId(), hotelBookingModel.getCompany(),
                hotelBookingModel.getCity(), hotelBookingModel.getPostalCode(), hotelBookingModel.getLicenseNo(), hotelBookingModel.getAirportPickUp(),
                hotelBookingModel.getCustomerDetailId(), hotelBookingModel.getAmount(), hotelBookingModel.getDiscountAmount(),
                hotelBookingModel.getTotalAmount(), null, hotelBookingModel.getPayCategory(), hotelBookingModel.getUser(), "i").get(0));

        hotelBookingModel = new HotelBookingMappper().mapRow((Map) hotelBookingDao.
                procHotelBooking(databaseResponse.getId(), null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null, "s").get(0));


        String response = null;


        databaseResponse = new DatabaseResponseMapper().mapRow((Map) hotelBookingStatusDao.procHotelBookingStatus(null, databaseResponse.getId(), "B", null, null, "tilak", "i").get(0));


        HotelBookingStatusModel hotelBookingStatusModel= new HotelBookingStatusMapper().mapRow((Map) hotelBookingStatusDao.
                procHotelBookingStatus(databaseResponse.getId(), null, null, null, null, null, "s").get(0));


        hotelEmailModel=new HotelEmailModel();


        hotelEmailModel.setHotelBookingModel(hotelBookingModel);
        hotelEmailModel.setPaymentStatus("PENDING");
        hotelEmailModel.setPaymentType("-");
        hotelEmailModel.setRedirectLink("https://tps.com/" + bookingType + "/" + hotelBookingStatusModel.getHashCode());
        hotelEmailModel.setBookingStatus("Pending");
        hotelEmailModel.setBookingReq(true);

        sendEmail = new SendEmail();

        sendEmail.setMailServerSettingModel(mailServerSettingResource.getByActive("Y"));
        sendEmail.setSubject("Hotel Booking test");
        sendEmail.setEmailTo(hotelBookingModel.getEmail());
        sendEmail.setEmailValue(hotelEmailModel.getEmailBody());
        sendEmail.access();

        responseModel = new ResponseModel();

        responseModel.setStatus("SUCCESS");
        responseModel.setMessage("Request for hotel booking confirmation has been sent to customer Email");

        return Response.status(Status.OK).entity(responseModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/hotel/book")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookHotel(HotelBookingModel hotelBookingModel) throws Exception {


        List<HotelBookingStatusModel> hotelBookingStatusModels= new HotelBookingStatusMapper().mapList(hotelBookingStatusDao.
                procHotelBookingStatus(null, null, null, null, hotelBookingModel.getHashCode(), null, "s"));

        if (hotelBookingStatusModels.isEmpty()) {
            throw new DataNotFoundException("Key doesn't match for Booking Confirmation");
        }


        HotelBookingStatusModel hotelBookingStatusModel = hotelBookingStatusModels.get(0);

        databaseResponse = new DatabaseResponseMapper().mapRow((Map) hotelBookingStatusDao.
                procHotelBookingStatus(hotelBookingStatusModel.getHotelBookingStatusId(), null, null, "Y", null, null, "u").get(0));



        hotelBookingModel = new HotelBookingMappper().mapRow((Map) hotelBookingDao.
                procHotelBooking(hotelBookingStatusModel.getHotelBookingId(), null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null,null,null,null, "s").get(0));


        databaseResponse = new DatabaseResponseMapper().mapRow((Map) hotelBookingStatusDao.
                procHotelBookingStatus(null, hotelBookingModel.getHotelBookingId(), "P", null, null, "tilak", "i").get(0));

        hotelBookingStatusModel = new HotelBookingStatusMapper().mapRow((Map) hotelBookingStatusDao.
                procHotelBookingStatus(databaseResponse.getId(), null, null, null, null, null, "s").get(0));

        hotelEmailModel= new HotelEmailModel();
        hotelEmailModel.setHotelBookingModel(hotelBookingModel);

        hotelEmailModel.setPaymentStatus("PENDING");
        hotelEmailModel.setPaymentType("-");
        hotelEmailModel.setRedirectLink("https://tps.com/pay/" + hotelBookingStatusModel.getHashCode());
        hotelEmailModel.setBookingStatus("Booked");
        hotelEmailModel.setBookingReqConf(true);

        sendEmail = new SendEmail();

        sendEmail.setMailServerSettingModel(mailServerSettingResource.getByActive("Y"));
        sendEmail.setSubject("Hotel Booking Accepted");
        sendEmail.setEmailTo(hotelBookingModel.getEmail());
        sendEmail.setEmailValue(hotelEmailModel.getEmailBody());
        sendEmail.access();

        responseModel = new ResponseModel();

        responseModel.setStatus("SUCCESS");
        responseModel.setMessage("Booking Accepted!! Booking Detail and Payment Request has been sent to customer Email");

        return Response.status(Status.OK).entity(responseModel)
                .type(MediaType.APPLICATION_JSON).build();
    }

/*

    @Path("/hotelBooking/request")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelBookingRequest(HotelBookingModel hotelBookingModel,
                                        @PathParam("bookingStatus")boolean bookingStatus) throws Exception {

        if (bookingStatus==true){

            databaseResponse = (Map) hotelBookingDao.procHotelBooking(hotelBookingModel.getHotelBookingId(), null, null, null, null, null, null, null, null, null, null, null,
                    null, "BOOKED", null, null, null,null,null,"tilak", "u").get(0);


            if (databaseResponse.get("status").equals("SUCCESS")){

                hotelBookingModel =  new HotelBookingMappper().mapRow((Map) hotelBookingDao.procHotelBooking(hotelBookingModel.getHotelBookingId(), null, null, null, null,
                        null, null, null, null, null, null, null,
                        null, null, null, null, null,null,null,null, "s").get(0));

                sendEmail=new SendEmail();

                hotelEmailModel=new HotelEmailModel();
                hotelEmailModel.setHotelBookingModel(hotelBookingModel);
                hotelEmailModel.setPaymentStatus("Pending");
                hotelEmailModel.setPaymentType("-");

                sendEmail.setMailServerSettingModel(mailServerSettingResource.getByActive("Y"));
                sendEmail.setSubject("test");
                sendEmail.setEmailTo("tilakpeace0000@gmail.com");
                sendEmail.setEmailValue(hotelEmailModel.getEmailBody());

                String status=sendEmail.access();

                if(status.equals("done")){

                    responseModel=new ResponseModel();
                    responseModel.setStatus("Success");
                    responseModel.setMessage("Hotel Booking Done.Hotel Booking Details have been send to Email");

                    return Response.status(Status.OK).entity(responseModel)
                            .type(MediaType.APPLICATION_JSON).build();

                }

            }
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();


    }

*/

/*

    @Path("/hotelBooking/bookingStatus/{bookingStatus}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelBookingConfirm(HotelBookingModel hotelBookingModel,
                                 @PathParam("bookingStatus")boolean bookingStatus) throws Exception {

        if (bookingStatus==true){

            databaseResponse = (Map) hotelBookingDao.procHotelBooking(hotelBookingModel.getHotelBookingId(), null, null, null, null, null, null, null, null, null, null, null,
                            null, "BOOKED", null, null, null,null,null,"tilak", "u").get(0);


            if (databaseResponse.get("status").equals("SUCCESS")){

                hotelBookingModel =  new HotelBookingMappper().mapRow((Map) hotelBookingDao.procHotelBooking(hotelBookingModel.getHotelBookingId(), null, null, null, null,
                        null, null, null, null, null, null, null,
                        null, null, null, null, null,null,null,null, "s").get(0));

                sendEmail=new SendEmail();

                hotelEmailModel=new HotelEmailModel();
                hotelEmailModel.setHotelBookingModel(hotelBookingModel);
                hotelEmailModel.setPaymentStatus("Pending");
                hotelEmailModel.setPaymentType("-");

                sendEmail.setMailServerSettingModel(mailServerSettingResource.getByActive("Y"));
                sendEmail.setSubject("test");
                sendEmail.setEmailTo("tilakpeace0000@gmail.com");
                sendEmail.setEmailValue(hotelEmailModel.getEmailBody());

                String status=sendEmail.access();

                 if(status.equals("done")){

                     responseModel=new ResponseModel();
                     responseModel.setStatus("Success");
                     responseModel.setMessage("Hotel Booking Done.Hotel Booking Details have been send to Email");

                     return Response.status(Status.OK).entity(responseModel)
                             .type(MediaType.APPLICATION_JSON).build();

                 }

            }
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();


    }

*/


}
