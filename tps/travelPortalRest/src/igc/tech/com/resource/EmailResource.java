package igc.tech.com.resource;

import igc.tech.com.dao.CustomerDetailDao;
import igc.tech.com.dao.EmailTpsDaoImpl;
import igc.tech.com.dao.MailServerSettingDao;
import igc.tech.com.dao.RoomImageDao;
import igc.tech.com.mapper.CustomerDetailMapper;
import igc.tech.com.mapper.EmailTpsMapper;
import igc.tech.com.mapper.MailServerSettingMapper;
import igc.tech.com.mapper.RoomImageMapper;
import igc.tech.com.model.*;
import igc.tech.com.utility.EmailContent;
import igc.tech.com.utility.SendEmail;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/email")
public class EmailResource {


    @Autowired
    MailServerSettingDao mailServerSettingDao;

    @Autowired
    EmailTpsDaoImpl emailTpsDao;

    @Autowired
    RoomImageDao roomImageDao;

    @Autowired
    CustomerDetailDao customerDetailDao;

    @Autowired
    ConfigModel configModel;

    ErrorMessage errorMessage;

    ResponseModel responseModel;



    @Path("/bookingConfirm")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel bookingConfirm(HotelBookingModel hotelBookingModel) throws Exception {


        int perRate=(int) Double.parseDouble(hotelBookingModel.getFinalRate())/(int) Double.parseDouble(hotelBookingModel.getTotalDays());

        hotelBookingModel.setPerRate(Integer.toString(perRate));

   //     System.out.println(hotelBookingModel.toString());

    //    System.out.println(hotelBookingModel.getRoomDetailId());

   //     System.out.println(roomImageDao.procRoomImage(new RoomImageModel(null,hotelBookingModel.getRoomDetailId(),null,null,"Y",null,null,null),null,"s"));

        RoomImageModel roomImageModel= (RoomImageModel) new RoomImageMapper().
                mapList(roomImageDao.procRoomImage(new RoomImageModel(null,hotelBookingModel.getRoomDetailId(),null,null,"Y",null,null,null),null,"s")).get(0);

        hotelBookingModel.setRoomImageUrl(configModel.getTpsResourceUrl()+"/RoomImages/"+roomImageModel.getImageUrl());

        hotelBookingModel.setCheckInTo(new Utility().formatTime(hotelBookingModel.getCheckInTo()));
        hotelBookingModel.setCheckOutTo(new Utility().formatTime(hotelBookingModel.getCheckOutTo()));

        String emailContent=   new EmailContent().confirmationEmail(hotelBookingModel);

        MailServerSettingModel mailServerSettingModel= (MailServerSettingModel) new MailServerSettingMapper().mapList(mailServerSettingDao.procMailServerSetting(new MailServerSettingModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        List<EmailTpsModel> emailTpsModels=  new EmailTpsMapper().mapList(emailTpsDao.procEmailTps(new EmailTpsModel(null,null,"Y"),null,"s"));

        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        for (EmailTpsModel emailTpsModel:emailTpsModels){
            map.put("EMAIL_ID", emailTpsModel.getEmailAddress());
        }

        list.add(map);

        String emailId=null;
        if (hotelBookingModel.getCustomerDetailId()!=null){

            CustomerDetailModel customerDetailModel=  (CustomerDetailModel) new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(hotelBookingModel.getCustomerDetailId(),null,null,null,null,null,null,null,null,null,null,null,null,null,"Y",null,"s")).get(0);

            emailId=customerDetailModel.getEmail();
        }
        else {
            emailId=hotelBookingModel.getGuestEmailId();

        }

    //    System.out.println(emailId);


      String status= new SendEmail().access(mailServerSettingModel.getDisplayName(),mailServerSettingModel.getEmailId(),mailServerSettingModel.getPassword(),
                mailServerSettingModel.getHost(),mailServerSettingModel.getPort(),emailId, "Booking Confirmed", emailContent, list);

        responseModel=new ResponseModel();

        if (status.equals("done")){

            responseModel.setStatus("SUCCESS");
            responseModel.setMessage("Email sent for :Register Your Hotel");

        }

        else {

            responseModel.setStatus("UNSUCCESS");

        }

        return responseModel;
    }



    @Path("/cancelBooking")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel cancelBooking(HotelBookingModel hotelBookingModel) throws Exception {


        int perRate=(int) Double.parseDouble(hotelBookingModel.getFinalRate())/(int) Double.parseDouble(hotelBookingModel.getTotalDays());

        hotelBookingModel.setPerRate(Integer.toString(perRate));

        //     System.out.println(hotelBookingModel.toString());

        //    System.out.println(hotelBookingModel.getRoomDetailId());

        //     System.out.println(roomImageDao.procRoomImage(new RoomImageModel(null,hotelBookingModel.getRoomDetailId(),null,null,"Y",null,null,null),null,"s"));

        RoomImageModel roomImageModel= (RoomImageModel) new RoomImageMapper().
                mapList(roomImageDao.procRoomImage(new RoomImageModel(null,hotelBookingModel.getRoomDetailId(),null,null,"Y",null,null,null),null,"s")).get(0);

        hotelBookingModel.setRoomImageUrl(configModel.getTpsResourceUrl()+"/RoomImages/"+roomImageModel.getImageUrl());

        hotelBookingModel.setCheckInTo(new Utility().formatTime(hotelBookingModel.getCheckInTo()));
        hotelBookingModel.setCheckOutTo(new Utility().formatTime(hotelBookingModel.getCheckOutTo()));

        String emailContent=   new EmailContent().cancelBooking(hotelBookingModel);

        MailServerSettingModel mailServerSettingModel= (MailServerSettingModel) new MailServerSettingMapper().mapList(mailServerSettingDao.procMailServerSetting(new MailServerSettingModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        List<EmailTpsModel> emailTpsModels=  new EmailTpsMapper().mapList(emailTpsDao.procEmailTps(new EmailTpsModel(null,null,"Y"),null,"s"));

        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        for (EmailTpsModel emailTpsModel:emailTpsModels){
            map.put("EMAIL_ID", emailTpsModel.getEmailAddress());
        }

        list.add(map);

        String emailId=null;
        if (hotelBookingModel.getCustomerDetailId()!=null){

            CustomerDetailModel customerDetailModel=  (CustomerDetailModel) new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(hotelBookingModel.getCustomerDetailId(),null,null,null,null,null,null,null,null,null,null,null,null,null,"Y",null,"s")).get(0);

            emailId=customerDetailModel.getEmail();
        }
        else {
            emailId=hotelBookingModel.getGuestEmailId();

        }

        //    System.out.println(emailId);


        String status= new SendEmail().access(mailServerSettingModel.getDisplayName(),mailServerSettingModel.getEmailId(),mailServerSettingModel.getPassword(),
                mailServerSettingModel.getHost(),mailServerSettingModel.getPort(),emailId, "Booking Cancelled", emailContent, list);

        responseModel=new ResponseModel();

        if (status.equals("done")){

            responseModel.setStatus("SUCCESS");
            responseModel.setMessage("Email sent for :Booking Cancelled");

        }

        else {

            responseModel.setStatus("UNSUCCESS");

        }

        return responseModel;
    }





    @Path("/registrationStartUp")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrationStartUp(HotelDetailModel hotelDetailModel) throws Exception {

        MailServerSettingModel mailServerSettingModel= (MailServerSettingModel) new MailServerSettingMapper().mapList(mailServerSettingDao.procMailServerSetting(new MailServerSettingModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        List<EmailTpsModel> emailTpsModels=  new EmailTpsMapper().mapList(emailTpsDao.procEmailTps(new EmailTpsModel(null,null,"Y"),null,"s"));

        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        for (EmailTpsModel emailTpsModel:emailTpsModels){
            map.put("EMAIL_ID", emailTpsModel.getEmailAddress());
        }

        list.add(map);

        hotelDetailModel.setTpsClientUrl(configModel.getTpsClientUrl());

        System.out.println(configModel.getTpsClientUrl());

        String emailContent=   new EmailContent().registrationStartUp(hotelDetailModel);

          String status=   new SendEmail().access(mailServerSettingModel.getDisplayName(),mailServerSettingModel.getEmailId(),mailServerSettingModel.getPassword(),
                mailServerSettingModel.getHost(),mailServerSettingModel.getPort(),hotelDetailModel.getEmailId(), "Register Your Hotel", emailContent, list);

        if (status.equals("done")){

            responseModel=new ResponseModel();
            responseModel.setStatus("SUCCESS");
            responseModel.setMessage("Email sent for :Register Your Hotel");
            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        else {

            errorMessage=new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();
        }



    }




    @Path("/clientAccess")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response clientAccess(HotelDetailModel  hotelDetailModel) throws Exception {

        MailServerSettingModel mailServerSettingModel= (MailServerSettingModel) new MailServerSettingMapper().mapList(mailServerSettingDao.procMailServerSetting(new MailServerSettingModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        List<EmailTpsModel> emailTpsModels=  new EmailTpsMapper().mapList(emailTpsDao.procEmailTps(new EmailTpsModel(null,null,"Y"),null,"s"));

        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        for (EmailTpsModel emailTpsModel:emailTpsModels){
            map.put("EMAIL_ID", emailTpsModel.getEmailAddress());
        }

        list.add(map);

        hotelDetailModel.setTpsClientUrl(configModel.getTpsClientUrl());

        String emailContent=   new EmailContent().clientAccess(hotelDetailModel);

        String status=   new SendEmail().access(mailServerSettingModel.getDisplayName(),mailServerSettingModel.getEmailId(),mailServerSettingModel.getPassword(),
                mailServerSettingModel.getHost(),mailServerSettingModel.getPort(),hotelDetailModel.getEmailId(), "Login Detail", emailContent, list);

        if (status.equals("done")){

            responseModel=new ResponseModel();
            responseModel.setStatus("SUCCESS");
            responseModel.setMessage("Email sent for :Login Detail");
            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        else {

            errorMessage=new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();
        }

    }


    @Path("/registrationComplete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrationComplete(HotelDetailModel  hotelDetailModel) throws Exception {

        MailServerSettingModel mailServerSettingModel= (MailServerSettingModel) new MailServerSettingMapper().mapList(mailServerSettingDao.procMailServerSetting(new MailServerSettingModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        List<EmailTpsModel> emailTpsModels=  new EmailTpsMapper().mapList(emailTpsDao.procEmailTps(new EmailTpsModel(null,null,"Y"),null,"s"));

        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        for (EmailTpsModel emailTpsModel:emailTpsModels){
            map.put("EMAIL_ID", emailTpsModel.getEmailAddress());
        }

        list.add(map);

      //  hotelDetailModel.setTpsClientUrl(configModel.getTpsClientUrl());

        String emailContent=   new EmailContent().registrationComplete(hotelDetailModel);

        String status=   new SendEmail().access(mailServerSettingModel.getDisplayName(),mailServerSettingModel.getEmailId(),mailServerSettingModel.getPassword(),
                mailServerSettingModel.getHost(),mailServerSettingModel.getPort(),hotelDetailModel.getEmailId(), "Registration Complete", emailContent, list);

        if (status.equals("done")){

            responseModel=new ResponseModel();
            responseModel.setStatus("SUCCESS");
            responseModel.setMessage("Email sent for :Registration Complete");
            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        else {

            errorMessage=new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();
        }

    }


}
