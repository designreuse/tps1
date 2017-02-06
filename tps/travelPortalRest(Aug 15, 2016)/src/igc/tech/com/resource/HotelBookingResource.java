package igc.tech.com.resource;

import igc.tech.com.dao.*;
import igc.tech.com.mapper.EsewaConfigMapper;
import igc.tech.com.mapper.HotelBookingMapper;
import igc.tech.com.mapper.NpayConfigMapper;
import igc.tech.com.model.*;
import igc.tech.com.utility.Encryption;
import igc.tech.com.utility.Utility;
import igc.tech.com.validate.ValidData;
import igc.tech.com.validate.ValidType;
import igc.tech.com.validate.Validation;
import npay.AuthenticateMerchant;
import npay.Service;
import npay.ServiceSoap;
import npay.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Path("/hotelBooking")
public class HotelBookingResource {


    @Autowired
    NpayConfigDao npayConfigDao;


    @Autowired
    HotelBookingDao hotelBookingDao;

    @Autowired
    NpayResource npayResource;

    @Autowired
    NpayTxnDao npayTxnDao;

    @Autowired
    EsewaConfigDao esewaConfigDao;

    @Autowired
    EsewaTxnDao esewaTxnDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    NpayDataModel npayDataModel;

    @Path("/request")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public HotelBookingModel request(HotelBookingModel hotelBookingModel) throws Exception {

        hotelBookingModel.setRoomDetailId(new Encryption().decrypt(hotelBookingModel.getRoomDetailId()));

        HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"booking_request")).get(0);

        return hotelBookingModel1;

    }


    @Path("/requestConfirmWithPayAtHotel")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public HotelBookingModel requestConfirmWithPayAtHotel(HotelBookingModel hotelBookingModel) throws Exception {

        HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"pay_at_hotel")).get(0);

        return hotelBookingModel1;

    }


    @Path("/npayValidateMerchant")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response npayValidateMerchant(NpayDataModel npayDataModel) throws Exception {

/*  // compulsary

              {
             "hashCode": "ebe1d7e548393e22ed68a8123890986ff7e6d15d",
             "customerDetailId":"1",
             "guestName":"ram",
             "guestPhNo":"242342",
             "guestEmailId":"abc@gmail.com"
         }

     *************
*/
      //  normal validation
        List<ValidData> validDatas=new ArrayList<>();
        validDatas.add(new ValidData("hashCode", npayDataModel.getHashCode(), new ValidType()));
        validDatas.add(new ValidData("guestName", npayDataModel.getGuestName(), new ValidType()));
        validDatas.add(new ValidData("guestPhNo", npayDataModel.getGuestPhNo(), new ValidType(false,true, false)));
        validDatas.add(new ValidData("guestEmailId", npayDataModel.getGuestEmailId(), new ValidType(true, false,  false)));
        validDatas=  new Validation().test(validDatas);

        if (!validDatas.isEmpty()){

            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Validation Failed");
            errorMessage.setValidDataList(validDatas);

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();

        }
       // **

        String description="test";

        // retrieve hotel_booking_id  using hash_code
        HotelBookingModel hotelBookingModel=new HotelBookingModel();
        hotelBookingModel.setHashCode(npayDataModel.getHashCode());
        // **

        List<HotelBookingModel> hotelBookingModels=new HotelBookingMapper().
                mapList( hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s_hash_code"));

        if (hotelBookingModels.isEmpty()){
            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Hash code doesnot exists for transaction");

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();
        }

        HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().
                mapList( hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s_hash_code")).get(0);

        // update guest detail
        HotelBookingModel hotelBookingModel2=new HotelBookingModel();

        hotelBookingModel2.setHashCode(npayDataModel.getHashCode());
        hotelBookingModel2.setCustomerDetailId(npayDataModel.getCustomerDetailId());
        hotelBookingModel2.setGuestName(npayDataModel.getGuestName());
        hotelBookingModel2.setGuestEmailId(npayDataModel.getGuestEmailId());
        hotelBookingModel2.setGuestPhNo(npayDataModel.getGuestPhNo());

        hotelBookingDao.procHotelBooking(hotelBookingModel2,null,"update_guest_detail");
        // ***

// **npay service handling for validate merchant
        NpayConfigModel npayConfigModel= (NpayConfigModel) new NpayConfigMapper().mapList(npayConfigDao.procNpayConfig(new NpayConfigModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        String merchantPwd= new Encryption().generateHashSha256(npayConfigModel.getMerchantUserName()+npayConfigModel.getMerchantPassword()) ;

        String signature=new Encryption().generateHashSha256(npayConfigModel.getSignature()+ npayConfigModel.getMerchantUserName()+hotelBookingModel1.getInvoice()) ;

        Service service=new Service(new URL(npayConfigModel.getApiUrl()) );

        ServiceSoap serviceSoap=service.getServiceSoap();

        AuthenticateMerchant authenticateMerchant= serviceSoap.validateMerchant(npayConfigModel.getMerchantId(),hotelBookingModel1.getInvoice(),npayConfigModel.getMerchantUserName(),
                merchantPwd,signature,hotelBookingModel1.getFinalRate(),description);
// **

        // insert npay records into npay_txn
       Map map= (Map) npayTxnDao.procNpayTxn(null,npayConfigModel.getNpayConfigId(),npayDataModel.getInvoice(),npayDataModel.getAmount(),
               npayDataModel.getDescription(),authenticateMerchant.getSTATUSCODE(),
                authenticateMerchant.getMESSAGE(),authenticateMerchant.getPROCESSID(),null,null,null,null,null,null,null,
                null,null,hotelBookingModel1.getHotelBookingId(),null,"validate_mer").get(0);

        // **

       NpayDataModel  npayDataModel1 =new NpayDataModel();

        if (authenticateMerchant.getSTATUSCODE().equals("0")){
            npayDataModel1.setProcessId(authenticateMerchant.getPROCESSID());
            npayDataModel1.setStatus("SUCCESS");
            npayDataModel1.setMessage("System can proceed for Transaction");
            npayDataModel1.setNpayTxnId( new Encryption().encrypt(map.get("id").toString())  );
            npayDataModel1.setMerchantId(npayConfigModel.getMerchantId());
            npayDataModel1.setMerchantTxnId(hotelBookingModel1.getInvoice());
            npayDataModel1.setAmount(hotelBookingModel1.getFinalRate());
            npayDataModel1.setMerchantUserName(npayConfigModel.getMerchantUserName());
            npayDataModel1.setDescription(description);
            npayDataModel1.setInterfaceUrl(npayConfigModel.getInterfaceUrl());

            return Response.status(Response.Status.OK).entity(npayDataModel1)
                    .type(MediaType.APPLICATION_JSON).build();

        }
        else {

            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage(authenticateMerchant.getMESSAGE());

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();


        }

    }

    @Path("/npayVerifyTransaction")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response npayVerifyTransaction(NpayDataModel npayDataModel) throws Exception {

        /*  // compulsary

                {
                  "npayTxnId": "TAhE67s/gEDoBH3FKJPDRw==",
                  "hashCode": "ebe1d7e548393e22ed68a8123890986ff7e6d15d",
                  "gatewayRefNo":"103472138926"
               }


     *************
*/

        //  normal validation
        List<ValidData> validDatas=new ArrayList<>();
        validDatas.add(new ValidData("npayTxnId", npayDataModel.getNpayTxnId(), new ValidType()));
        validDatas.add(new ValidData("hashCode", npayDataModel.getHashCode(), new ValidType()));
        validDatas.add(new ValidData("gatewayRefNo", npayDataModel.getGatewayRefNo(), new ValidType()));
        validDatas=  new Validation().test(validDatas);

        if (!validDatas.isEmpty()){

            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Validation Failed");
            errorMessage.setValidDataList(validDatas);

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();

        }
        // **

        // retrieve hotel_booking_id  using hash_code
        HotelBookingModel hotelBookingModel=new HotelBookingModel();
        hotelBookingModel.setHashCode(npayDataModel.getHashCode());

        HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().
                mapList( hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s_hash_code")).get(0);

        // **

        // **npay service handling for verification of transaction
        NpayConfigModel npayConfigModel= (NpayConfigModel) new NpayConfigMapper().mapList(npayConfigDao.procNpayConfig(new NpayConfigModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        String merchantPwd= new Encryption().generateHashSha256(npayConfigModel.getMerchantUserName()+npayConfigModel.getMerchantPassword()) ;
        String signature=new Encryption().generateHashSha256(npayConfigModel.getSignature()+ npayConfigModel.getMerchantUserName()+hotelBookingModel1.getInvoice()) ;

        Service service=new Service();
        ServiceSoap serviceSoap=service.getServiceSoap();

        TransactionStatus transactionStatus= serviceSoap.checkTransactionStatus(npayConfigModel.getMerchantId(),hotelBookingModel1.getInvoice(),
                npayConfigModel.getMerchantUserName(),merchantPwd,signature,npayDataModel.getGatewayRefNo());

        // **

             Map map= (Map) npayTxnDao.procNpayTxn( new Encryption().decrypt(npayDataModel.getNpayTxnId()) ,null,null,null,
                        null,null,null,null,transactionStatus.getGTWREFNO(),transactionStatus.getSTATUSCODE(),transactionStatus.getMESSAGE(),
                        transactionStatus.getTRANSACTIONSTATUS(),transactionStatus.getREMARKS(),transactionStatus.getCARDNO(),transactionStatus.getMERCHANTDECS(),
                        transactionStatus.getTXNDATETIME(),transactionStatus.getCONCERNEDBANK(),hotelBookingModel1.getHotelBookingId(),null,"verify_txn").get(0);

             if (transactionStatus.getSTATUSCODE().equals("0")){

                 System.out.println(npayDataModel.getHashCode());

                 HotelBookingModel hotelBookingModel3=new HotelBookingModel();
                 hotelBookingModel3.setHashCode(npayDataModel.getHashCode());
                 hotelBookingModel3.setPayType("npay");
                 hotelBookingModel3.setCustomerDetailId(npayDataModel.getCustomerDetailId());
                 hotelBookingModel3.setGuestName(npayDataModel.getGuestName());
                 hotelBookingModel3.setGuestPhNo(npayDataModel.getGuestPhNo());
                 hotelBookingModel3.setGuestEmailId(npayDataModel.getGuestEmailId());

                 HotelBookingModel hotelBookingModel4= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel3,null,"online_pay")).get(0);

                 return Response.status(Response.Status.OK).entity(hotelBookingModel4)
                         .type(MediaType.APPLICATION_JSON).build();
             }

                else {

                 errorMessage =new ErrorMessage();
                 errorMessage.setStatus("UNSUCCESS");
                 errorMessage.setErrormessage(transactionStatus.getMESSAGE());

                 return Response.status(Response.Status.OK).entity(errorMessage)
                         .type(MediaType.APPLICATION_JSON).build();

             }
    }


    @Path("/esewaConfig")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response esewaConfig(EsewaDataModel esewaDataModel) throws Exception {
/*        {
            "hashCode": "87d2ceaba32137223d1c4df076ab9876ed1e645f",
                "customerDetailId":"1",
                "guestName":"ram",
                "guestPhNo":"4234324",
                "guestEmailId":"abc@gmail.com"
        }
*/
        //  normal validation
        List<ValidData> validDatas=new ArrayList<>();
        validDatas.add(new ValidData("hashCode", esewaDataModel.getHashCode(), new ValidType()));
        validDatas.add(new ValidData("guestName", esewaDataModel.getGuestName(), new ValidType()));
        validDatas.add(new ValidData("guestPhNo", esewaDataModel.getGuestPhNo(), new ValidType(false,true, false)));
        validDatas.add(new ValidData("guestEmailId", esewaDataModel.getGuestEmailId(), new ValidType(true, false,  false)));
        validDatas=  new Validation().test(validDatas);

        if (!validDatas.isEmpty()){

            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Validation Failed");
            errorMessage.setValidDataList(validDatas);

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();

        }
        // **

        // retrieve hotel_booking_id  using hash_code
        HotelBookingModel hotelBookingModel=new HotelBookingModel();
        hotelBookingModel.setHashCode(esewaDataModel.getHashCode());

        List<HotelBookingModel> hotelBookingModels=new HotelBookingMapper(). mapList( hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s_hash_code"));

        if (hotelBookingModels.isEmpty()){
            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Hash code doesnot exists for transaction");

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();
        }

        HotelBookingModel hotelBookingModel1= hotelBookingModels.get(0);

        // **

        // update guest detail
        HotelBookingModel hotelBookingModel2=new HotelBookingModel();

        hotelBookingModel2.setHashCode(esewaDataModel.getHashCode());
        hotelBookingModel2.setCustomerDetailId(esewaDataModel.getCustomerDetailId());
        hotelBookingModel2.setGuestName(esewaDataModel.getGuestName());
        hotelBookingModel2.setGuestEmailId(esewaDataModel.getGuestEmailId());
        hotelBookingModel2.setGuestPhNo(esewaDataModel.getGuestPhNo());

        hotelBookingDao.procHotelBooking(hotelBookingModel2,null,"update_guest_detail");
        // ***

        //**esewa config data
         EsewaConfigModel esewaConfigModel= (EsewaConfigModel) new EsewaConfigMapper().mapList(esewaConfigDao.procEsewaConfig(new EsewaConfigModel(null,null,null,null,null,null,null,"Y"),null,"s")).get(0);
        // **

        // insert esewa records into esewa_txn
       Map map=  (Map) esewaTxnDao.procEsewaTxn(null,esewaConfigModel.getEsewaConfigId(),hotelBookingModel1.getFinalRate(),"0","0","0",hotelBookingModel1.getFinalRate(),
               hotelBookingModel1.getInvoice(),hotelBookingModel1.getInvoice(),null,hotelBookingModel1.getHotelBookingId(),null,"payment_request").get(0);
        // **

        EsewaDataModel esewaDataModel1=new EsewaDataModel();

        esewaDataModel1.setEsewaConfig(esewaConfigModel);

        esewaDataModel1.setAmount(hotelBookingModel1.getFinalRate());
        esewaDataModel1.setTaxAmount("0");
        esewaDataModel1.setServiceCharge("0");
        esewaDataModel1.setDeliveryCharge("0");
        esewaDataModel1.setTotalAmount(hotelBookingModel1.getFinalRate());
        esewaDataModel1.setProductId(hotelBookingModel1.getInvoice());
        esewaDataModel1.setEsewaTxnId(new Encryption().encrypt(map.get("ID").toString()) );

        return Response.status(Response.Status.OK).entity(esewaDataModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/esewaConfirm")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response esewaConfirm(EsewaDataModel esewaDataModel) throws Exception {

        /*{
            "hashCode": "87d2ceaba32137223d1c4df076ab9876ed1e645f",
                "refId":"0007CC2",
                "esewaTxnId": "13"
        }
*/
        //  normal validation
        List<ValidData> validDatas=new ArrayList<>();
        validDatas.add(new ValidData("esewaTxnId", esewaDataModel.getEsewaTxnId(), new ValidType()));
        validDatas.add(new ValidData("refId", esewaDataModel.getRefId(), new ValidType()));
        validDatas.add(new ValidData("hashCode", esewaDataModel.getHashCode(), new ValidType()));
        validDatas=  new Validation().test(validDatas);

        if (!validDatas.isEmpty()){

            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Validation Failed");
            errorMessage.setValidDataList(validDatas);

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();

        }
        // **

         // retrieve hotel_booking_id  using hash_code
        HotelBookingModel hotelBookingModel=new HotelBookingModel();
        hotelBookingModel.setHashCode(esewaDataModel.getHashCode());

        List<HotelBookingModel> hotelBookingModels=new HotelBookingMapper(). mapList( hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s_hash_code"));

        if (hotelBookingModels.isEmpty()){
            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Hash code doesnot exists for transaction");

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();
        }

        HotelBookingModel hotelBookingModel1= hotelBookingModels.get(0);
        // **

        //**esewa config data
        EsewaConfigModel esewaConfigModel= (EsewaConfigModel) new EsewaConfigMapper().mapList(esewaConfigDao.procEsewaConfig(new EsewaConfigModel(null,null,null,null,null,null,null,"Y"),null,"s")).get(0);
        // **

        System.out.println(esewaConfigModel.toString());

      //  amt=100&scd=eSewa_IGC&pid=11111&rid=0007C8B
      //  String encodedData = "amt="+hotelBookingModel1.getFinalRate()+"&scd="+esewaConfigModel.getServiceCode()+"&pid="+hotelBookingModel1.getInvoice()+"&rid="+esewaDataModel.getRefId();


        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};

// Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ;
        }

        URL obj = new URL(esewaConfigModel.getVerifyApiUrl());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        //  con.setRequestProperty("User-Agent", USER_AGENT);

       // String encodedData = "amt=100&scd=eSewa_IGC&pid=11111&rid=0007C8B";
        String encodedData = "amt="+hotelBookingModel1.getFinalRate()+"&scd="+esewaConfigModel.getServiceCode()+"&pid="+hotelBookingModel1.getInvoice()+"&rid="+esewaDataModel.getRefId();


        System.out.println(encodedData);

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(encodedData.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());

            String xx=response.toString();

            EsewaResponse esewaResponse = (EsewaResponse) new Utility().convertXmlToObject(xx, EsewaResponse.class);
            System.out.println(esewaResponse.toString());

            if (esewaResponse.getResponseCode().equals("Success")){

                HotelBookingModel hotelBookingModel3=new HotelBookingModel();
                hotelBookingModel3.setHashCode(esewaDataModel.getHashCode());
                hotelBookingModel3.setPayType("esewa");
           //     hotelBookingModel3.setCustomerDetailId(esewaDataModel.getCustomerDetailId());
            //    hotelBookingModel3.setGuestName(esewaDataModel.getGuestName());
            //    hotelBookingModel3.setGuestPhNo(esewaDataModel.getGuestPhNo());
             //   hotelBookingModel3.setGuestEmailId(esewaDataModel.getGuestEmailId());

                Map map=  (Map)  esewaTxnDao.procEsewaTxn(new Encryption().decrypt(esewaDataModel.getEsewaTxnId()) ,null,null,null,null,null,null,null,esewaDataModel.getRefId(),null,hotelBookingModel1.getHotelBookingId(),null,"confirm_txn").get(0);

                HotelBookingModel hotelBookingModel4= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel3,null,"online_pay")).get(0);

                return Response.status(Response.Status.OK).entity(hotelBookingModel4)
                        .type(MediaType.APPLICATION_JSON).build();

            }

        }

        else {

            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage("Failed to connect Esewa");

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();
        }

        return  null;

    }




    }
