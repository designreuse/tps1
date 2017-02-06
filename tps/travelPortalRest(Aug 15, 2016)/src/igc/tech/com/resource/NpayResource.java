package igc.tech.com.resource;

import igc.tech.com.dao.NpayConfigDao;
import igc.tech.com.mapper.NpayConfigMapper;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.NpayConfigModel;
import igc.tech.com.model.NpayDataModel;
import igc.tech.com.model.ResponseModel;
import igc.tech.com.utility.Encryption;
import npay.AuthenticateMerchant;
import npay.Service;
import npay.ServiceSoap;
import npay.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/nPay")
public class NpayResource {


    @Autowired
    NpayConfigDao npayConfigDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;




    @Path("/validateMerchant")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public AuthenticateMerchant validateMerchant(NpayDataModel npayDataModel) throws Exception {


      NpayConfigModel npayConfigModel= (NpayConfigModel) new NpayConfigMapper().mapList(npayConfigDao.procNpayConfig(new NpayConfigModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);


      String merchantPwd= new Encryption().generateHashSha256(npayConfigModel.getMerchantUserName()+npayConfigModel.getMerchantPassword()) ;


      String signature=new Encryption().generateHashSha256(npayConfigModel.getSignature()+ npayConfigModel.getMerchantUserName()+npayDataModel.getInvoice()) ;

        Service service=new Service();
        ServiceSoap serviceSoap=service.getServiceSoap();



        AuthenticateMerchant authenticateMerchant= serviceSoap.validateMerchant(npayConfigModel.getMerchantId(),npayDataModel.getInvoice(),npayConfigModel.getMerchantUserName(),
                merchantPwd,signature,npayDataModel.getAmount(),npayDataModel.getDescription());


        return  authenticateMerchant;

    }


    @Path("/verifyTransaction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public TransactionStatus verifyTransaction(NpayDataModel   npayDataModel) throws Exception {

        NpayConfigModel npayConfigModel= (NpayConfigModel) new NpayConfigMapper().mapList(npayConfigDao.procNpayConfig(new NpayConfigModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        String merchantPwd= new Encryption().generateHashSha256(npayConfigModel.getMerchantUserName()+npayConfigModel.getMerchantPassword()) ;
        String signature=new Encryption().generateHashSha256(npayConfigModel.getSignature()+ npayConfigModel.getMerchantUserName()+npayDataModel.getInvoice()) ;


        Service service=new Service();
        ServiceSoap serviceSoap=service.getServiceSoap();


        TransactionStatus transactionStatus= serviceSoap.checkTransactionStatus(npayConfigModel.getMerchantId(),npayDataModel.getInvoice(),
                npayConfigModel.getMerchantUserName(),merchantPwd,signature,npayDataModel.getGatewayRefNo());

        return  transactionStatus;

    }

}
