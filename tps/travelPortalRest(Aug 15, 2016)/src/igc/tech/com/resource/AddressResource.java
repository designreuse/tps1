package igc.tech.com.resource;

import igc.tech.com.dao.AddressDao;
import igc.tech.com.mapper.AddressMapper;
import igc.tech.com.model.AddressModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.ResponseModel;
import igc.tech.com.utility.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/address")
public class AddressResource {

    @Autowired
    AddressDao addressDao;


    ErrorMessage errorMessage;

    ResponseModel responseModel;

    String address="";

    List<AddressModel> addressModels;


    @Path("/testing")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test1( ) throws Exception {

       List<AddressModel>  addressModels=  new AddressMapper().mapList(addressDao.procAddress(new AddressModel(),null,"a")) ;


        return Response.status(Response.Status.OK).entity(addressModels)
                .type(MediaType.APPLICATION_JSON).build();


    }


    @Path("/search/{value}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam("value")String value) throws Exception {


        // for area
        List<AddressModel> addressModels=new AddressMapper().mapList(addressDao.procAddress(new AddressModel(null,value,null,null,null),null,"c"));

        if (!addressModels.isEmpty()){
            for (AddressModel addressModel:addressModels){
                lowerToUpperNode(addressModel);
                addressModel.setAddress(null);
                addressModel.setAddressId(new Encryption().encrypt(addressModel.getAddressId()));
            }

        }


        return Response.status(Response.Status.OK).entity(addressModels)
                .type(MediaType.APPLICATION_JSON).build();
    }


    @Path("/area/{value}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response areaListing(@PathParam("value")String value ) throws Exception {

       List<AddressModel> addressModels=new AddressMapper().mapList(addressDao.procAddress(new AddressModel(null,value,null,null,null),null,"c"));

        for (AddressModel addressModel:addressModels){
            lowerToUpperNode(addressModel);
             addressModel.setAddress(null);
            addressModel.setAddressId(new Encryption().encrypt(addressModel.getAddressId()));
        }

        return Response.status(Response.Status.OK).entity(addressModels)
               .type(MediaType.APPLICATION_JSON).build();
    }






    public void lowerToUpperNode(AddressModel addressModel){

        System.out.println(addressModel.toString());

    // applying recursive function
       if (addressModel.getParentAddressId()!=null/* !addressModel.getParentAddressId().equals("0")*/ ){
            AddressModel addressModel1= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(addressModel.getParentAddressId()),null,"s")).get(0);
            addressModel.setAddress(addressModel1);
           lowerToUpperNode(addressModel1);
        }
    //******

        //getting back position from recursive function
        if (addressModel.getLevel().equals("1")){
            this.address=addressModel.getAddressName();
        }
        else {
            this.address=addressModel.getAddressName()+","+this.address;
        }

        addressModel.setAddressName(address);
        //********

    }


    @Path("/test1/{value}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test1(@PathParam("value")String value ) throws Exception {

        List<AddressModel> addressModels=new AddressMapper().mapList(addressDao.procAddress(new AddressModel("1",null,null,null,null),null,"s"));

        AddressModel addressModel=addressModels.get(0);

       getAreaNodesBySelectedNode(addressModel);

       // upperTolowerNode(addressModel);

        return Response.status(Response.Status.OK).entity(getAreaNodesBySelectedNode(addressModel))
                .type(MediaType.APPLICATION_JSON).build();
    }



    public void upperTolowerNode(AddressModel addressModel){

      List<AddressModel> addressModels=new AddressMapper().mapList(addressDao.procAddress(new AddressModel(null,null,addressModel.getAddressId(),null,null),null,"s"));

        if (!addressModels.isEmpty()){

            for (AddressModel addressModel1:addressModels){
                addressModel.setAddressList(addressModels);
                upperTolowerNode(addressModel1);
            }

        }

        else /*if (addressModel.getLevel().equals("5"))*/
        {

            System.out.println(addressModel.toString());
            this.addressModels.add(addressModel);
        }

    }


    public  List<AddressModel> getAreaNodesBySelectedNode(AddressModel addressModel){

        this.addressModels=new ArrayList<>();

        upperTolowerNode(addressModel);

        return this.addressModels;
    }




}
