package igc.tech.com.resource;

import igc.tech.com.dao.AddressDao;
import igc.tech.com.dao.HotelActivityDao;
import igc.tech.com.dao.HotelDetailDao;
import igc.tech.com.mapper.AddressMapper;
import igc.tech.com.mapper.HotelDetailMapper;
import igc.tech.com.model.AddressModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.HotelDetailModel;
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
import java.util.List;

@Component
@Path("/hotelDetail")
public class HotelDetailResource {

  @Autowired
  HotelDetailDao hotelDetailDao;

  @Autowired
  AddressDao addressDao;

  @Autowired
  AddressResource addressResource;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    @Path("/search/{value}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam("value") String value) throws Exception {

        List<HotelDetailModel> hotelDetailModels= new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(null,value),null,"c"));

      for(HotelDetailModel hotelDetailModel:hotelDetailModels){
        AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelDetailModel.getAddressId()),null,"s")).get(0);
        addressResource.lowerToUpperNode(addressModel);
        addressModel.setAddress(null);
        addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);
        hotelDetailModel.setAddress(addressModel);

        hotelDetailModel.setHotelDetailId(new Encryption().encrypt(hotelDetailModel.getHotelDetailId()));

        hotelDetailModel=new HotelDetailMapper().mapRowSetNull(false,false,false,true,true, true,true,true,true,true,true,true,true,true,hotelDetailModel);

      }

        return Response.status(Response.Status.OK).entity(hotelDetailModels)
                .type(MediaType.APPLICATION_JSON).build();
    }



}
