package igc.tech.com.resource;

import igc.tech.com.dao.EncodeDao;
import igc.tech.com.mapper.EncodeMapper;
import igc.tech.com.model.EncodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Component
@Path("/encode")
public class EncodeResource {

   @Autowired
   EncodeDao  encodeDao;

    @Path("/id/{value}")
    @GET
    public String encrypt(@PathParam("value") String value) throws Exception {

    EncodeModel encodeModel= (EncodeModel) new EncodeMapper().mapList(encodeDao.procEncode(new EncodeModel(null,value,null),"i")).get(0);

        return encodeModel.getEncodedHash();
    }


    @Path("/decode/{value}")
    @GET
    public String decrypt(@PathParam("value") String value ) throws Exception {


        EncodeModel encodeModel= (EncodeModel) new EncodeMapper().mapList(encodeDao.procEncode(new EncodeModel(null,null,value),"s")).get(0);

        return encodeModel.getId();

    }





}
