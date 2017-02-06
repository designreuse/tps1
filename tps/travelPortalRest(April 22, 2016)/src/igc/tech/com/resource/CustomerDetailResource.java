/*
package igc.tech.com.resource;

import igc.tech.com.dao.CountryDao;
import igc.tech.com.dao.CustomerDetailDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.CountryMappper;
import igc.tech.com.mapper.CustomerDetailMapper;
import igc.tech.com.model.CountryModel;
import igc.tech.com.model.CustomerDetailModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Map;

@Component
@Path("/customerDetail")
public class CustomerDetailResource {

    @Autowired
    CustomerDetailDao customerDetailDao;

    Utility utility;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {


        List<CustomerDetailModel> customerDetailModels = new CustomerDetailMapper().mapList(customerDetailDao.
                procCustomerDetail(null, null, null, null, null, null, null, null, null, null, null, null, "a"));

        if (customerDetailModels.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        return Response.status(Status.OK).entity(customerDetailModels)
                .type(MediaType.APPLICATION_JSON).build();
    }

    @Path("/{customerDetailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("customerDetailId") String customerDetailId) {

        List<Map> list = customerDetailDao.procCustomerDetail(customerDetailId, null, null, null, null, null, null, null, null, null, null, null, "s");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        @SuppressWarnings("rawtypes")
        CustomerDetailModel customerDetailModel = new CustomerDetailMapper().mapRow((Map) list.get(0));

        return Response.status(Status.OK).entity(customerDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(CustomerDetailModel customerDetailModel) {



        Map databaseResponse = (Map) customerDetailDao.procCustomerDetail(customerDetailModel.getCustomerDetailId(), customerDetailModel.getEmail(), customerDetailModel.getPassword(),
                customerDetailModel.getCustomerTitle(), customerDetailModel.getFirstName(), customerDetailModel.getMiddleName(), customerDetailModel.getLastName(),
                customerDetailModel.getContactNo(), customerDetailModel.getPassportNo(), customerDetailModel.getCustomerType(), customerDetailModel.getAcitvationCode(),
                customerDetailModel.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }

    //update country;

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(CustomerDetailModel customerDetailModel) {
        */
/*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 *//*


        Response rsp = getById(customerDetailModel.getCustomerDetailId());

        if (rsp.getStatus() == 200) {

            Map databaseResponse = (Map) customerDetailDao.procCustomerDetail(customerDetailModel.getCustomerDetailId(), customerDetailModel.getEmail(), customerDetailModel.getPassword(),
                    customerDetailModel.getCustomerTitle(), customerDetailModel.getFirstName(), customerDetailModel.getMiddleName(), customerDetailModel.getLastName(),
                    customerDetailModel.getContactNo(), customerDetailModel.getPassportNo(), customerDetailModel.getCustomerType(), customerDetailModel.getAcitvationCode(),
                    customerDetailModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

    //	@Path("/{countryId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(CustomerDetailModel customerDetailModel) {
        */
/*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 *//*


        Response rsp = getById(customerDetailModel.getCustomerDetailId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse = (Map) customerDetailDao.procCustomerDetail(customerDetailModel.getCustomerDetailId(), null, null, null, null, null,
                    null, null, null, null, null, null, "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }

    @Path("/authentication")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Authentication(CustomerDetailModel customerDetailModel) {

        CustomerDetailModel customerDetail = new CustomerDetailMapper().mapRow((Map) customerDetailDao.
                procCustomerDetail(null, customerDetailModel.getEmail(), customerDetailModel.getPassword(), null, null, null,
                        null, null, null, null, null, null, "b").get(0));

        if (customerDetail.getStatus().equals("Success")) {

            customerDetail=new CustomerDetailMapper().mapRow((Map) customerDetailDao.
                    procCustomerDetail(customerDetail.getCustomerDetailId(), null, null, null, null, null, null, null, null, null, null, null, "s").get(0));
            customerDetail.setStatus("Login Success");

        }

        return Response.status(Status.OK).entity(customerDetail)
                .type(MediaType.APPLICATION_JSON).build();

    }


}
*/
