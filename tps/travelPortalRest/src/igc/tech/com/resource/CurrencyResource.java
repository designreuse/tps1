package igc.tech.com.resource;

import igc.tech.com.dao.CurrencyDao;
import igc.tech.com.mapper.CurrencyMapper;
import igc.tech.com.model.CurrencyModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/currency")
public class CurrencyResource {

   @Autowired
   CurrencyDao currencyDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    @Path("/activeCurrency")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActiveCurrency( ) throws Exception {

       List<CurrencyModel>  currencyModels=  new CurrencyMapper().mapList(currencyDao.procCurrency(new CurrencyModel(),null,"get_active_currency")) ;

        return Response.status(Response.Status.OK).entity(currencyModels)
                .type(MediaType.APPLICATION_JSON).build();


    }




}
