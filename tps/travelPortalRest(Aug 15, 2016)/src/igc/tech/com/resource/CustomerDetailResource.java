package igc.tech.com.resource;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import igc.tech.com.dao.CustomerDetailDao;
import igc.tech.com.mapper.CustomerDetailMapper;
import igc.tech.com.model.CustomerDetailModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.ResponseModel;
import igc.tech.com.utility.Encryption;
import igc.tech.com.utility.GenerateHash;
import igc.tech.com.utility.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Path("/customerDetail")
public class CustomerDetailResource {

    @Autowired
    CustomerDetailDao customerDetailDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    /*@Path("/registerUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(CustomerDetailModel customerDetailModel) {

        Map map = (Map) customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, customerDetailModel.getFirstName(),
                customerDetailModel.getMiddleName(), customerDetailModel.getLastName(),
                customerDetailModel.getContactNo(), null, customerDetailModel.getAppVersion(),
                customerDetailModel.getDeviceEmail(), customerDetailModel.getDeviceId(), customerDetailModel.getRegKey(),
                customerDetailModel.getPlatform(), null, null, null, null, "i").get(0);

        //    System.out.println(customerDetailDao.procCustomerDetail(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "a"));


        return Response.status(Response.Status.OK).entity(map)
                .type(MediaType.APPLICATION_JSON).build();

    }*/


    @Path("/registerUserReqWeb")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUserReqWeb(CustomerDetailModel customerDetailModel) throws Exception {


        if (!customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, null, null,
                null, null, null, null, null, null, null, null, "Y", null, "s").isEmpty()){

            responseModel = new ResponseModel();
            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("Email Address Already exists");

            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }


        Map map = (Map) customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(),
                new GenerateHash().generateHash(customerDetailModel.getEmail() + customerDetailModel.getPassword()), null, customerDetailModel.getName(),
                customerDetailModel.getContactNo(), null, null,
                null, null, null, null, null, null, null, null, "i").get(0);

        CustomerDetailModel customerDetailModel1 = (CustomerDetailModel) new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(map.get("id").toString(), null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, "s")).get(0);





        //SendEmail sendEmail = new SendEmail();
        String emailContent = "Dear " + customerDetailModel.getName() + ",<br>" +
                "Welcome to  TPS.<br>" +
                "To continue signup, please click the below url.<br>" +
                "<a href='http://192.168.6.100:8080/TPS/Register/verify-email?token=" + customerDetailModel1.getActivationCode() + "&email="+customerDetailModel1.getEmail()+"'>Complete Sign up process.</a><br>" +
                "Registration is completely free. Plus, you can manage your property and bookings with our easy-to-use Extranet. Our dedicated support team is available around the clock – just in case.<br>" +
                "The sooner you complete your registration, the sooner your property can work for you!<br>" +
                "Kind regards,<br>" +
                "The TPS Team";

      new SendEmail().access("TPS", "igctesting123@gmail.com", "igctesting@123", "smtp.gmail.com",
                "587", customerDetailModel.getEmail(), "Sign Up in TPS", emailContent, new ArrayList<Map>());


      //  responseModel = new ResponseModel();
        customerDetailModel1=new CustomerDetailMapper().mapRowSetNull(false,false,true,false,false,false,true,true,true,true,true,true,true,true,true,customerDetailModel1);

        customerDetailModel1.setCustomerDetailId(new Encryption().encrypt(customerDetailModel1.getCustomerDetailId()));
        customerDetailModel1.setStatus("Success");
        customerDetailModel1.setMessage("Confirmation for sign up has been sent via email ");


        return Response.status(Response.Status.OK).entity(customerDetailModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }



    @Path("/proceedToRegister")   // by sajan update
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkValidEmail(CustomerDetailModel customerDetailModel) throws Exception {


        if (customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, null, null,
                null, null, null, null, null, null, null, null, "Y", null, "s").isEmpty()){

            responseModel = new ResponseModel();
            responseModel.setStatus("true");
            responseModel.setMessage("Email Address does not Exists");
            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }


        responseModel = new ResponseModel();
        responseModel.setStatus("false");
        responseModel.setMessage("Email Address Exists");


        return Response.status(Response.Status.OK).entity(responseModel)
                .type(MediaType.APPLICATION_JSON).build();

    }



    @Path("/registerUserReqSendEmailWeb")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUserReqSendEmailWeb(CustomerDetailModel customerDetailModel) throws Exception {

        System.out.println("tilak");

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().
                mapList(customerDetailDao.procCustomerDetail(new Encryption().decrypt(customerDetailModel.getCustomerDetailId()), null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, "s"));

        if (customerDetailModels.isEmpty()){
            responseModel = new ResponseModel();
            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("Invalid customer Detail id");

            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }

       if (customerDetailModels.get(0).getActive().equals("Y")){

           CustomerDetailModel  customerDetailModel1=new CustomerDetailMapper().mapRowSetNull(false,false,true,false,false,false,true,true,true,
                   true,true,true,true,true,true,customerDetailModels.get(0));

           customerDetailModel1.setCustomerDetailId(new Encryption().encrypt(customerDetailModel1.getCustomerDetailId()));
           customerDetailModel1.setStatus("Active");
           customerDetailModel1.setMessage("Guest is already active");

           return Response.status(Response.Status.OK).entity(customerDetailModel1)
                   .type(MediaType.APPLICATION_JSON).build();



       }

        System.out.println(customerDetailModels.get(0).toString());



        //SendEmail sendEmail = new SendEmail();
        String emailContent = "Dear " + customerDetailModels.get(0).getName() + ",<br>" +
                "Welcome to  TPS.<br>" +
                "To continue signup, please click the below url.<br>" +
                "<a href='http://192.168.6.100:8080/TPS/Register/verify-email?token=" + customerDetailModels.get(0).getActivationCode() + "&email="+customerDetailModels.get(0).getEmail()+"'>Complete Sign up process.</a><br>" +
                "Registration is completely free. Plus, you can manage your property and bookings with our easy-to-use Extranet. Our dedicated support team is available around the clock – just in case.<br>" +
                "The sooner you complete your registration, the sooner your property can work for you!<br>" +
                "Kind regards,<br>" +
                "The TPS Team";

        System.out.println(customerDetailModels.get(0).getEmail());

        new SendEmail().access("TPS", "igctesting123@gmail.com", "igctesting@123", "smtp.gmail.com",
                "587", customerDetailModels.get(0).getEmail(), "Sign Up in TPS", emailContent, new ArrayList<Map>());


        CustomerDetailModel  customerDetailModel1=new CustomerDetailMapper().mapRowSetNull(false,false,true,false,false,false,true,true,true,
                true,true,true,true,true,true,customerDetailModels.get(0));

        customerDetailModel1.setCustomerDetailId(new Encryption().encrypt(customerDetailModel1.getCustomerDetailId()));
        customerDetailModel1.setStatus("Success");
        customerDetailModel1.setMessage("Confirmation for sign up has been sent via email ");

        return Response.status(Response.Status.OK).entity(customerDetailModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/registerUserConfirmWeb")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUserConfirmWeb(CustomerDetailModel customerDetailModel) {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(null, null, null, null, null, null,
                null, null, null, null, null, null, customerDetailModel.getActivationCode(), null, null, null, "s"));

        responseModel = new ResponseModel();
        if (customerDetailModels.isEmpty()) {
            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("Wrong Activation Code");

            return Response.status(200).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        //  System.out.println(customerDetailModels.get(0));

        customerDetailDao.procCustomerDetail(customerDetailModels.get(0).getCustomerDetailId(), null, null, null, null, null,
                null, null, null, null, null, null, null, null, "Y", null, "u");


        responseModel = new ResponseModel();
        responseModel.setStatus("Success");
        responseModel.setMessage("Sign up Confirmation completed");


        return Response.status(Response.Status.OK).entity(responseModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/checkRegisteredUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkRegisteredUser(CustomerDetailModel customerDetailModel) throws Exception {

        System.out.println("test");

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().
                mapList(customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null,
                        null, null, customerDetailModel.getContactNo(), null, null, null, null,
                        null, null, null, null, null, null, "c"));

        if (customerDetailModels.isEmpty()) {

            responseModel = new ResponseModel();

            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("User/Guest is not Registered");

            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();
        } else if (!customerDetailModels.get(0).getPassword().equals(  new GenerateHash().generateHash(customerDetailModels.get(0).getEmail() + customerDetailModel.getPassword())  )){

            responseModel = new ResponseModel();

            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("Password Incorrect");

            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }

         //   customerDetailModel = customerDetailModels.get(0);

        customerDetailModel =new CustomerDetailMapper().mapRowSetNull(false,false,true,true,false,false,true,true,true,true,true,true,true,true,true,customerDetailModels.get(0)) ;
        customerDetailModel.setCustomerDetailId(new Encryption().encrypt(customerDetailModel.getCustomerDetailId()));
        customerDetailModel.setStatus("Success");
        customerDetailModel.setMessage("User/Guest is Registered");

        return Response.status(Response.Status.OK).entity(customerDetailModel)
                .type(MediaType.APPLICATION_JSON).build();
    }



    /***********mobile***************/


    @Path("/registerUserReqMob")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUserReqMob(CustomerDetailModel customerDetailModel) throws Exception {


        if (!customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, null, customerDetailModel.getContactNo(),
                null, null, null, null, null, null, null, null, "Y", null, "s").isEmpty()){

            responseModel = new ResponseModel();
            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("User Already exists");

            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        Map map = (Map) customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(),null, null, customerDetailModel.getName(),
                customerDetailModel.getContactNo(), null, customerDetailModel.getAppVersion(),
                customerDetailModel.getDeviceEmail(), customerDetailModel.getDeviceId(), customerDetailModel.getRegKey(), customerDetailModel.getPlatform(),
                null, "1234ttttt", null, null, "i").get(0);

        CustomerDetailModel customerDetailModel1 = (CustomerDetailModel) new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(map.get("id").toString(), null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, "s")).get(0);


        //***otp message sender handling

        ///**** end otp


        customerDetailModel1=new CustomerDetailMapper().mapRowSetNull(false,false,true,false,false,false,true,false,false,false,false,false,true,true,true,customerDetailModel1);

        customerDetailModel1.setCustomerDetailId(new Encryption().encrypt(customerDetailModel1.getCustomerDetailId()));
        customerDetailModel1.setStatus("Success");
        customerDetailModel1.setMessage("Confirmation for sign up has been sent via OTP message ");


        return Response.status(Response.Status.OK).entity(customerDetailModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/confirmRegisterUserReqMob")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmRegisterUserReqMob(CustomerDetailModel customerDetailModel) throws Exception {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, null,
                customerDetailModel.getContactNo(), null, null, null, null, null, null, null, customerDetailModel.getOtpCode(), null, null, "s"));

        if (customerDetailModels.isEmpty()) {
            responseModel = new ResponseModel();
            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("Request failed!!!. Invalid OTP Code");
            return Response.status(403).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }



        if (customerDetailModels.get(0).getActive().equals("Y")){

            CustomerDetailModel  customerDetailModel1=new CustomerDetailMapper().mapRowSetNull(false,false,true,false,false,false,true,true,true,
                    true,true,true,true,true,true,customerDetailModels.get(0));

            customerDetailModel1.setCustomerDetailId(new Encryption().encrypt(customerDetailModel1.getCustomerDetailId()));
            customerDetailModel1.setStatus("Active");
            customerDetailModel1.setMessage("User is already active");

            return Response.status(Response.Status.OK).entity(customerDetailModel1)
                    .type(MediaType.APPLICATION_JSON).build();



        }


        customerDetailDao.procCustomerDetail(customerDetailModels.get(0).getCustomerDetailId(), null, null, null, null, null,
                null, null, null, null, null, null, null, null, "Y", null, "u");


        customerDetailModel=new CustomerDetailMapper().mapRowSetNull(false,false,true,false,false,false,true,false,false,false,false,false,true,true,true,customerDetailModels.get(0));
        customerDetailModel.setCustomerDetailId(new Encryption().encrypt(customerDetailModel.getCustomerDetailId()));

        // customerDetailModel = customerDetailModels.get(0);
        customerDetailModel.setStatus("Success");
        customerDetailModel.setMessage("User Registration confirmed!!");


        return Response.status(Response.Status.OK).entity(customerDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }





    @Path("/otpRequest")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response otpRequest(CustomerDetailModel customerDetailModel) {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().
                mapList(customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, null,
                        customerDetailModel.getContactNo(), null, null, null, null, null, null, null, null, null, null, "c"));

        responseModel = new ResponseModel();


        if (customerDetailModels.isEmpty()) {
            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("User is not registered");
            return Response.status(403).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }

        System.out.println(customerDetailModels.get(0).toString());

        customerDetailDao.procCustomerDetail(customerDetailModels.get(0).getCustomerDetailId(), null, null, null, null,
                    null, null, null, null, null, null, null, null, "1234ttttt", null, null, "u");


        responseModel.setStatus("SUCCESS");
        responseModel.setMessage("OTP Code Sent Via SMS");


        return Response.status(Response.Status.OK).entity(responseModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/confirmOtpRequest")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmOtpRequest(CustomerDetailModel customerDetailModel) throws Exception {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, null,
                customerDetailModel.getContactNo(), null, null, null, null, null, null, null, customerDetailModel.getOtpCode(), null, null, "s"));

        if (customerDetailModels.isEmpty()) {
            responseModel = new ResponseModel();
            responseModel.setStatus("Unsuccess");
            responseModel.setMessage("Request failed!!!.OTP Validation Failed");
            return Response.status(403).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }



        customerDetailModel=new CustomerDetailMapper().mapRowSetNull(false,false,true,false,false,false,true,false,false,false,false,false,true,true,true,customerDetailModels.get(0));
        customerDetailModel.setCustomerDetailId(new Encryption().encrypt(customerDetailModel.getCustomerDetailId()));

       // customerDetailModel = customerDetailModels.get(0);
        customerDetailModel.setStatus("Success");
        customerDetailModel.setMessage("OTP Validation confirmed!!");


        return Response.status(Response.Status.OK).entity(customerDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


}
