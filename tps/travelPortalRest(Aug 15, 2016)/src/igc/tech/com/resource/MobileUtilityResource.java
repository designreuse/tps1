package igc.tech.com.resource;

import igc.tech.com.dao.CustomerDetailDao;
import igc.tech.com.mapper.CustomerDetailMapper;
import igc.tech.com.model.CustomerDetailModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Component
@Path("/mobileUtility")
public class MobileUtilityResource {

    @Autowired
    CustomerDetailDao customerDetailDao;

   


    ErrorMessage errorMessage;

    ResponseModel responseModel;

    @Path("/registerUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(CustomerDetailModel customerDetailModel) {

        Map map = (Map) customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null, null, customerDetailModel.getName(),
                customerDetailModel.getContactNo(), null, customerDetailModel.getAppVersion(),
                customerDetailModel.getDeviceEmail(), customerDetailModel.getDeviceId(), customerDetailModel.getRegKey(),
                customerDetailModel.getPlatform(), null, null, null, null, "i").get(0);

        //    System.out.println(customerDetailDao.procCustomerDetail(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "a"));



        return Response.status(Response.Status.OK).entity(map)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/checkRegisteredUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkNumberRegistered(CustomerDetailModel customerDetailModel) {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(null, null, null,
                null, null, customerDetailModel.getContactNo(), null, null, null, null, null, null, null, null, null, null, "s"));


        if (customerDetailModels.isEmpty()) {

            responseModel = new ResponseModel();

            responseModel.setMessage("User/Guest is not Registered");

            return Response.status(Response.Status.OK).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }


        customerDetailModel = customerDetailModels.get(0);
        customerDetailModel.setStatus("SUCCESS");
        customerDetailModel.setMessage("User/Guest is Registered");


        return Response.status(Response.Status.OK).entity(customerDetailModel)
                .type(MediaType.APPLICATION_JSON).build();
    }


    @Path("/otpRequest")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response otpRequest(CustomerDetailModel customerDetailModel) {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null,  null, null, customerDetailModel.getContactNo(), null, null, null, null, null, null, null, null, null, null, "s"));

        responseModel = new ResponseModel();


        if (customerDetailModels.isEmpty()) {
            responseModel.setStatus("UNSUCCESS");
            responseModel.setMessage("Request failed!!!. Invalid user");
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
    public Response confirmOtpRequest(CustomerDetailModel customerDetailModel) {

        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.procCustomerDetail(null, customerDetailModel.getEmail(), null,  null, null,
                customerDetailModel.getContactNo(), null, null, null, null, null, null, null, customerDetailModel.getOtpCode(), null, null, "s"));

        if (customerDetailModels.isEmpty()) {
            responseModel = new ResponseModel();
            responseModel.setStatus("UNSUCCESS");
            responseModel.setMessage("Request failed!!!.OTP Validation Failed");
            return Response.status(403).entity(responseModel)
                    .type(MediaType.APPLICATION_JSON).build();
        }

        customerDetailModel = customerDetailModels.get(0);
        customerDetailModel.setStatus("SUCCESS");
        customerDetailModel.setMessage("OTP Validation confirmed!!");


        return Response.status(Response.Status.OK).entity(customerDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/hotelSearchByRoom")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {






       /* return Response.status(Response.Status.OK).entity(customerDetailModel)
                .type(MediaType.APPLICATION_JSON).build();*/

        return  null;

    }








}
