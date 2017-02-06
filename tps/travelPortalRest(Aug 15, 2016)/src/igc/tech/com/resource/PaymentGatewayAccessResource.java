package igc.tech.com.resource;

import igc.tech.com.dao.PayGateAccessDao;
import igc.tech.com.mapper.PayGateAccessMapper;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.PayGateAccessModel;
import igc.tech.com.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/paymentGatewayAccess")
public class PaymentGatewayAccessResource {


    @Autowired
    PayGateAccessDao payGateAccessDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    @Path("/active")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<PayGateAccessModel> getActivePayGateway() {

        List<PayGateAccessModel> payGateAccessModels=new PayGateAccessMapper().mapList(payGateAccessDao.procPayGateAccess(new PayGateAccessModel(null,null,null,"Y"),null,"s"));

        return  payGateAccessModels;
    }


}
