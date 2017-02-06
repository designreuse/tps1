package igc.tech.com.resource;

import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
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
import javax.ws.rs.*;
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

    @Autowired
    HotelActivityDao hotelActivityDao;

    @Autowired
    PayGateAccessDao payGateAccessDao;
    
    @Autowired
    EncodeResource encodeResource;

    @Autowired
    RoomImageDao roomImageDao;

    @Autowired
    ConfigModel configModel;

    @Autowired
    MailServerSettingDao mailServerSettingDao;

    @Autowired
    EmailTpsDaoImpl emailTpsDao;

    @Autowired
    CustomerDetailDao customerDetailDao;

    @Autowired
    EmailResource emailResource;

    @Autowired
    AddressDao addressDao;

    @Autowired
    AddressResource addressResource;

    @Autowired
    HotelFeatureDao hotelFeatureDao;

    @Autowired
    ActivityHighlightDao activityHighlightDao;

    @Autowired
    HotelImageDao hotelImageDao;

    @Autowired
    NearPlacesDao nearPlacesDao;

    @Autowired
    HotelRulesDao hotelDetailid;

    @Autowired
    RoomAmenityDao roomAmenityDao;

    @Autowired
    RoomImportanceDao roomImportanceDao;

    @Autowired
    HotelRulesDao hotelRulesDao;

    @Autowired
    OfferDao offerDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    NpayDataModel npayDataModel;

    @Path("/request")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public HotelBookingModel request(HotelBookingModel hotelBookingModel) throws Exception {

        hotelBookingModel.setRoomDetailId(encodeResource.decrypt(hotelBookingModel.getRoomDetailId()));

        HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"booking_request")).get(0);

        System.out.println(hotelBookingModel1.toString());

        String currencyType=null;
        if (hotelBookingModel.getCurrencyDesc().equals("NPR")){

            currencyType="NPL";
        }
        else {
            currencyType="OTHER";
        }

        // payment gateway access
        List<PayGateAccessModel> payGateAccessModels=new PayGateAccessMapper().mapList(payGateAccessDao.procPayGateAccess(new PayGateAccessModel(null,null,null,"Y",null,currencyType),null,"s"));

        for (PayGateAccessModel payGateAccessModel:payGateAccessModels){
            payGateAccessModel.setImage(configModel.getTpsResourceUrl()+"/icons/"+payGateAccessModel.getImage());
            payGateAccessModel.setCurrencyType(null);
        }

        payGateAccessModels=new PayGateAccessMapper().mapListSetNull(true,false,false,true,payGateAccessModels);
        hotelBookingModel1.setPayGateAccessList(payGateAccessModels);
        // **

        /// ****************

        HotelDetailModel hotelDetailModel=new HotelDetailModel();

        hotelDetailModel.setHotelDetailId(hotelBookingModel1.getHotelDetailId());
        hotelDetailModel= (HotelDetailModel) new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(hotelDetailModel,null,"s")).get(0);

        // hotelfeature binding
        HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
        hotelFeatureModel.setHotelDetailId(hotelBookingModel1.getHotelDetailId());
        hotelFeatureModel = (HotelFeatureModel) new HotelFeatureMapper().mapList(hotelFeatureDao.procHotelFeature(hotelFeatureModel, null, "s")).get(0);

        hotelFeatureModel.setCheckInFrom(new Utility().formatTime(hotelFeatureModel.getCheckInFrom()));
        hotelFeatureModel.setCheckInTo(new Utility().formatTime(hotelFeatureModel.getCheckInTo()));
        hotelFeatureModel.setCheckOutFrom(new Utility().formatTime(hotelFeatureModel.getCheckOutFrom()));
        hotelFeatureModel.setCheckOutTo(new Utility().formatTime(hotelFeatureModel.getCheckOutTo()));

        hotelDetailModel.setHotelFeature(new HotelFeatureMapper().mapRowSetNull(true, false, false, false, false, true, true, hotelFeatureModel));

        // Hotel activity binding
        HotelActivityModel hotelActivityModel = new HotelActivityModel();
        hotelActivityModel.setHotelDetailId(hotelBookingModel1.getHotelDetailId());
        hotelActivityModel.setActive("Y");
        List<HotelActivityModel> hotelActivityModels = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "s"));
        hotelDetailModel.setHotelActivityList(new HotelActivityMapper().mapListSetNull(false, true, false, false, true, true, false, false, false, hotelActivityModels));



        // Hotel Activity Highlights Binding
        ActivityHighlightModel activityHighlightModel=new ActivityHighlightModel();
        activityHighlightModel.setHotelDetailId(hotelBookingModel1.getHotelDetailId());

        List<ActivityHighlightModel> activityHighlightModels=  new ActivityHighlightMapper().mapList(activityHighlightDao.procActivityHighlight(activityHighlightModel,null,"hightlight_by_hotel"));

        for (ActivityHighlightModel activityHighlightModel1:activityHighlightModels){

            if (activityHighlightModel1.getIcon()!=null){
                activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getIcon());
            }
            else if (activityHighlightModel1.getImage()!=null){
                activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getImage());
            }

        }

        hotelDetailModel.setActivityHighlightList(activityHighlightModels);

        // *********

        // *********


        //hotel Image binding
        List<HotelImageModel> hotelImageModels=new HotelImageMapper().mapList(hotelImageDao.
                procHotelImage(new HotelImageModel(null,hotelBookingModel1.getHotelDetailId(),null,null,null,null,null,"Y"),null,"s"));

        for(HotelImageModel hotelImageModel:hotelImageModels){
            hotelImageModel.setFullImageUrl(configModel.getTpsResourceUrl()+"/HotelImages/"+hotelImageModel.getImageUrl());

        }
        hotelDetailModel.setHotelImageList(new HotelImageMapper().mapListSetNull(true,true,false,true,false,true,false,true,false,hotelImageModels));


        // nearest places binding
        List<NearPlacesModel> nearPlacesModels= new NearPlacesMapper().mapList(nearPlacesDao.procNearPlaces(new NearPlacesModel(hotelBookingModel1.getHotelDetailId()), null, "s"));

        for (NearPlacesModel nearPlacesModel:nearPlacesModels){

            if (nearPlacesModel.getType().equals("food")){

                nearPlacesModel.setIconUrl(configModel.getTpsResourceUrl()+"/icons/restaurantsm.png");
            }

            else  if (nearPlacesModel.getType().equals("store")){
                nearPlacesModel.setIconUrl(configModel.getTpsResourceUrl()+"/icons/supermarketsm.png");

            }

            else  if (nearPlacesModel.getType().equals("taxi_stand")){
                nearPlacesModel.setIconUrl(configModel.getTpsResourceUrl()+"/icons/taxism.png");

            }

            else  if (nearPlacesModel.getType().equals("bus_station")){
                nearPlacesModel.setIconUrl(configModel.getTpsResourceUrl()+"/icons/bussm.png");

            }

        }

        hotelDetailModel.setNearPlacesList(new NearPlacesMapper().mapListSetNull(true, true, false, false, false, false, false, nearPlacesModels));


        System.out.println(hotelBookingModel1.getAddressId());
        //address binding
        AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelBookingModel1.getAddressId()),null,"s")).get(0);
        addressResource.lowerToUpperNode(addressModel);
        addressModel.setAddress(null);
        addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);
        hotelDetailModel.setAddress(addressModel);

        // hotel rules binding
        List<HotelRulesModel> hotelRulesModels= new HotelRulesMapper().mapList(hotelRulesDao.procHotelRules(new HotelRulesModel(null,null,hotelBookingModel1.getHotelDetailId(),"Y"), null, "s"));
        hotelDetailModel.setHotelRulesList(new HotelRulesMapper().mapListSetNull(true,true,true,true,true,false,hotelRulesModels));


        RoomDetailModel roomDetailModel=new RoomDetailModel();

            // room amenity binding
            List<RoomAmenityModel> roomAmenityModels= new RoomAmenityMapper().mapList(roomAmenityDao.
                    procRoomAmenity(new RoomAmenityModel(null,hotelBookingModel1.getRoomDetailId(),null,"Y",null,null,null,null,null), null, "s"));
            roomDetailModel.setRoomAmenityList(new RoomAmenityMapper().mapListSetNull(false, true, false, true, true, true, false, roomAmenityModels));

            // bed type binding
          /*  List<RoomAmenityModel> roomAmenityModels= new RoomAmenityMapper().mapList(roomAmenityDao.
                    procRoomAmenity(new RoomAmenityModel(null,roomDetailModel.getRoomDetailId(),null,"Y",null,null,null,null,null), null, "s"));
            roomDetailModel.setRoomAmenityList(new RoomAmenityMapper().mapListSetNull(false, true, false, true, true, true, false, roomAmenityModels));
*/

            //room image binding
            List<RoomImageModel> roomImageModels= new RoomImageMapper().mapList(roomImageDao.
                    procRoomImage(new RoomImageModel(null,hotelBookingModel1.getRoomDetailId(),null,null,null,null,null,"Y"), null, "s"));

            for (RoomImageModel roomImageModel:roomImageModels){

                roomImageModel.setFullImageUrl(configModel.getTpsResourceUrl()+"/RoomImages/"+roomImageModel.getImageUrl());

            }


            roomDetailModel.setRoomImageList(new RoomImageMapper().mapListSetNull(true,true,false,true,false,true,false,true,false,roomImageModels));

            // room importance binding

            List<RoomImportanceModel> roomImportanceModels= new RoomImportanceMapper().mapList(roomImportanceDao.
                    procRoomImportance(new RoomImportanceModel(null,null,hotelBookingModel1.getRoomDetailId(),"Y",null), null, "s"));
            roomDetailModel.setRoomImportanceList(new RoomImportanceMapper().mapListSetNull(true,true,true,true,false,true,roomImportanceModels));


            //offer binding
            if (roomDetailModel.getOfferId()!=null){
                roomDetailModel.setOffer((OfferModel) new OfferMapper().mapListSetNull(true, false, true, true, true, false, false,
                        new OfferMapper().mapList(offerDao.procOffer(new OfferModel(roomDetailModel.getOfferId(),hotelBookingModel1.getRoomDetailId()), null, "s"))).get(0));
            }



        hotelDetailModel.setRoomDetail(roomDetailModel);

        hotelDetailModel =   new HotelDetailMapper().mapRowSetNull(true,false,false,false,false,false,false,false,false,false,true,true,true,true,hotelDetailModel) ;


        hotelBookingModel1.setHotelDetail(hotelDetailModel);
        /////  *************



        return hotelBookingModel1;

    }


    @Path("/requestConfirmWithPayAtHotel")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public HotelBookingModel requestConfirmWithPayAtHotel(HotelBookingModel hotelBookingModel) throws Exception {

        if (hotelBookingModel.getCustomerDetailId()!=null){
            hotelBookingModel.setCustomerDetailId(encodeResource.decrypt(hotelBookingModel.getCustomerDetailId()));

        }


        HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"pay_at_hotel")).get(0);

        // email part handling
        if(hotelBookingModel1.getStatus().equals("SUCCESS")){

            final HotelBookingModel hotelBookingModel3=hotelBookingModel;

            // thread handling
            new Thread(new Runnable() {
                @Override
                public void run() {

                    HotelBookingModel hotelBookingModel2=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel3,null,"search_pay_at_hotel")).get(0);

                    hotelBookingModel2.setPaymentStatus("Pending");
                    try {
                        emailResource.bookingConfirm(hotelBookingModel2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();

            // ** ending of thread handling

       }
        //**

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
       /* List<ValidData> validDatas=new ArrayList<>();
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

        }*/
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

      /*  HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().
                mapList( hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s_hash_code")).get(0);*/

        HotelBookingModel hotelBookingModel1= hotelBookingModels.get(0);


        if (!hotelBookingModel1.getPayAtHotel().equals("Y")){

            // update guest detail   only if   pay now directly clicked (doesnt update if pay done after pay at hotel selected)

            HotelBookingModel hotelBookingModel2=new HotelBookingModel();

            hotelBookingModel2.setHashCode(npayDataModel.getHashCode());

            if (npayDataModel.getCustomerDetailId()!=null){
                hotelBookingModel2.setCustomerDetailId(encodeResource.decrypt(npayDataModel.getCustomerDetailId()));
            }

            hotelBookingModel2.setGuestName(npayDataModel.getGuestName());
            hotelBookingModel2.setGuestEmailId(npayDataModel.getGuestEmailId());
            hotelBookingModel2.setGuestPhNo(npayDataModel.getGuestPhNo());

            hotelBookingModel2.setAirportShuttle(npayDataModel.getAirportShuttle());
            hotelBookingModel2.setIdentificationNo(npayDataModel.getIdentificationNo());
            hotelBookingModel2.setArrivalDateTime(npayDataModel.getArrivalDateTime());
            hotelBookingModel2.setCountry(npayDataModel.getCountry());
            hotelBookingModel2.setSpecialRequest(npayDataModel.getSpecialRequest());

            hotelBookingDao.procHotelBooking(hotelBookingModel2,null,"update_guest_detail");
            // ***
        }

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
       Map map= (Map) npayTxnDao.procNpayTxn(null,npayConfigModel.getNpayConfigId(),hotelBookingModel1.getInvoice(),npayDataModel.getAmount(),
               npayDataModel.getDescription(),authenticateMerchant.getSTATUSCODE(),
                authenticateMerchant.getMESSAGE(),authenticateMerchant.getPROCESSID(),null,null,null,null,null,null,null,
                null,null,hotelBookingModel1.getHotelBookingId(),null,"validate_mer").get(0);

        // **

       NpayDataModel  npayDataModel1 =new NpayDataModel();

        if (authenticateMerchant.getSTATUSCODE().equals("0")){
            npayDataModel1.setProcessId(authenticateMerchant.getPROCESSID());
            npayDataModel1.setStatus("SUCCESS");
            npayDataModel1.setMessage("System can proceed for Transaction");
            npayDataModel1.setNpayTxnId( encodeResource.encrypt(map.get("id").toString())  );
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


    @Path("/npayVerifyTransaction1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String npayVerifyTransaction1(@QueryParam("MERCHANTTXNID") String merchantTxnId,
                                          @QueryParam("GTWREFNO") String gatewayRefNo) throws Exception {

   // **npay service handling for verification of transaction
        NpayConfigModel npayConfigModel= (NpayConfigModel) new NpayConfigMapper().mapList(npayConfigDao.procNpayConfig(new NpayConfigModel(null,null,null,null,null,null,"Y"),null,"s")).get(0);

        String merchantPwd= new Encryption().generateHashSha256(npayConfigModel.getMerchantUserName()+npayConfigModel.getMerchantPassword()) ;
        String signature=new Encryption().generateHashSha256(npayConfigModel.getSignature()+ npayConfigModel.getMerchantUserName()+merchantTxnId) ;

        Service service=new Service();
        ServiceSoap serviceSoap=service.getServiceSoap();

        TransactionStatus transactionStatus= serviceSoap.checkTransactionStatus(npayConfigModel.getMerchantId(),merchantTxnId,
                npayConfigModel.getMerchantUserName(),merchantPwd,signature,gatewayRefNo);

        // **

             Map map= (Map) npayTxnDao.procNpayTxn( null ,null,merchantTxnId,null,
                        null,null,null,null,transactionStatus.getGTWREFNO(),transactionStatus.getSTATUSCODE(),transactionStatus.getMESSAGE(),
                        transactionStatus.getTRANSACTIONSTATUS(),transactionStatus.getREMARKS(),transactionStatus.getCARDNO(),transactionStatus.getMERCHANTDECS(),
                        transactionStatus.getTXNDATETIME(),transactionStatus.getCONCERNEDBANK(),null,null,"verify_txn").get(0);

        System.out.println(transactionStatus.toString());
             if (transactionStatus.getSTATUSCODE().equals("0") && transactionStatus.getTRANSACTIONSTATUS().equals("SUCCESS")){

                 HotelBookingModel hotelBookingModel=new HotelBookingModel();
                 hotelBookingModel.setInvoice(merchantTxnId);

                  HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s")).get(0);

                 HotelBookingModel hotelBookingModel3=new HotelBookingModel();
                 hotelBookingModel3.setHashCode(hotelBookingModel1.getHashCode());
                 hotelBookingModel3.setPayType("npay");


                 HotelBookingModel hotelBookingModel4= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel3,null,"online_pay")).get(0);

                // email handling

                 if (hotelBookingModel4.getStatus().equals("SUCCESS")){

                     final HotelBookingModel hotelBookingModel5=hotelBookingModel1;

                     // thread handling
                     new Thread(new Runnable() {
                         @Override
                         public void run() {

                             HotelBookingModel hotelBookingModel2=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel5,null,"search_paid")).get(0);

                             hotelBookingModel2.setPaymentStatus("Paid by npay ");
                             try {
                                 emailResource.bookingConfirm(hotelBookingModel2);
                             } catch (Exception e) {
                                 e.printStackTrace();
                             }
                         }

                     }).start();

                     // ** ending of thread handling

                     // **

                 }


               //  return "0";
             }

                /*else {

                 return  "UNSUCCESS";

             }*/

             return "0";



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

        Map map= (Map) npayTxnDao.procNpayTxn( encodeResource.decrypt(npayDataModel.getNpayTxnId()) ,null,null,null,
                null,null,null,null,transactionStatus.getGTWREFNO(),transactionStatus.getSTATUSCODE(),transactionStatus.getMESSAGE(),
                transactionStatus.getTRANSACTIONSTATUS(),transactionStatus.getREMARKS(),transactionStatus.getCARDNO(),transactionStatus.getMERCHANTDECS(),
                transactionStatus.getTXNDATETIME(),transactionStatus.getCONCERNEDBANK(),hotelBookingModel1.getHotelBookingId(),null,"verify_txn").get(0);

        if (transactionStatus.getSTATUSCODE().equals("0")){

            System.out.println(npayDataModel.getHashCode());

            HotelBookingModel hotelBookingModel3=new HotelBookingModel();
            hotelBookingModel3.setHashCode(npayDataModel.getHashCode());
            hotelBookingModel3.setPayType("npay");
                /* hotelBookingModel3.setCustomerDetailId(npayDataModel.getCustomerDetailId());
                 hotelBookingModel3.setGuestName(npayDataModel.getGuestName());
                 hotelBookingModel3.setGuestPhNo(npayDataModel.getGuestPhNo());
                 hotelBookingModel3.setGuestEmailId(npayDataModel.getGuestEmailId());*/

            HotelBookingModel hotelBookingModel4= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel3,null,"online_pay")).get(0);



            /*if (hotelBookingModel4.getStatus().equals("SUCCESS")){
                HotelBookingModel hotelBookingModel2=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"search_paid")).get(0);

                hotelBookingModel2.setPaymentStatus("Paid by npay ");
                emailResource.bookingConfirm(hotelBookingModel2);


            }*/
            // set medium whether  it is from web or mob
            hotelBookingModel4.setMedium(hotelBookingModel1.getMedium());
            // **

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
     //   validDatas.add(new ValidData("guestName", esewaDataModel.getGuestName(), new ValidType()));
     //   validDatas.add(new ValidData("guestPhNo", esewaDataModel.getGuestPhNo(), new ValidType(false,true, false)));
      //  validDatas.add(new ValidData("guestEmailId", esewaDataModel.getGuestEmailId(), new ValidType(true, false,  false)));
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

        if (!hotelBookingModel1.getPayAtHotel().equals("Y")){

            // update guest detail
            HotelBookingModel hotelBookingModel2=new HotelBookingModel();

            hotelBookingModel2.setHashCode(esewaDataModel.getHashCode());

            if (esewaDataModel.getCustomerDetailId()!=null){
                hotelBookingModel2.setCustomerDetailId(encodeResource.decrypt(esewaDataModel.getCustomerDetailId()) );
            }


            hotelBookingModel2.setGuestName(esewaDataModel.getGuestName());
            hotelBookingModel2.setGuestEmailId(esewaDataModel.getGuestEmailId());
            hotelBookingModel2.setGuestPhNo(esewaDataModel.getGuestPhNo());

            hotelBookingModel2.setAirportShuttle(esewaDataModel.getAirportShuttle());
            hotelBookingModel2.setIdentificationNo(esewaDataModel.getIdentificationNo());
            hotelBookingModel2.setArrivalDateTime(esewaDataModel.getArrivalDateTime());
            hotelBookingModel2.setCountry(esewaDataModel.getCountry());
            hotelBookingModel2.setSpecialRequest(esewaDataModel.getSpecialRequest());


            hotelBookingDao.procHotelBooking(hotelBookingModel2,null,"update_guest_detail");
            // ***
        }



        //**esewa config data
         EsewaConfigModel esewaConfigModel= (EsewaConfigModel) new EsewaConfigMapper().mapList(esewaConfigDao.procEsewaConfig(new EsewaConfigModel(null,null,null,null,null,null,null,"Y"),null,"s")).get(0);
        // **

        // insert esewa records into esewa_txn
       Map map=  (Map) esewaTxnDao.procEsewaTxn(null,esewaConfigModel.getEsewaConfigId(),hotelBookingModel1.getFinalRate(),"0","0","0",hotelBookingModel1.getFinalRate(),
               hotelBookingModel1.getInvoice(),hotelBookingModel1.getInvoice(),null,hotelBookingModel1.getHotelBookingId(),null,"payment_request").get(0);
        // **

        EsewaDataModel esewaDataModel1=new EsewaDataModel();

      //  esewaDataModel1.setEsewaConfig(esewaConfigModel);

        esewaDataModel1.setInterfaceUrl(esewaConfigModel.getInterfaceUrl());
        esewaDataModel1.setServiceCode(esewaConfigModel.getServiceCode());
        esewaDataModel1.setSuccessUrl(esewaConfigModel.getSuccessUrl());
        esewaDataModel1.setFailUrl(esewaConfigModel.getFailUrl());

        esewaDataModel1.setAmount(hotelBookingModel1.getFinalRate());
        esewaDataModel1.setTaxAmount("0");
        esewaDataModel1.setServiceCharge("0");
        esewaDataModel1.setDeliveryCharge("0");
        esewaDataModel1.setTotalAmount(hotelBookingModel1.getFinalRate());
        esewaDataModel1.setProductId(hotelBookingModel1.getInvoice());
        esewaDataModel1.setEsewaTxnId(encodeResource.encrypt(map.get("ID").toString()) );
        esewaDataModel1.setStatus("SUCCESS");

        return Response.status(Response.Status.OK).entity(esewaDataModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/esewaConfirm")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response esewaConfirm(EsewaDataModel esewaDataModel) throws Exception {

        HotelBookingModel hotelBookingModel=new HotelBookingModel();

        hotelBookingModel.setInvoice(esewaDataModel.getProductId());

        HotelBookingModel hotelBookingModel1= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"s")).get(0);


        //**esewa config data
        EsewaConfigModel esewaConfigModel= (EsewaConfigModel) new EsewaConfigMapper().mapList(esewaConfigDao.procEsewaConfig(new EsewaConfigModel(null,null,null,null,null,null,null,"Y"),null,"s")).get(0);
        // **


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
                hotelBookingModel3.setHashCode(hotelBookingModel1.getHashCode());
                hotelBookingModel3.setPayType("esewa");
           //     hotelBookingModel3.setCustomerDetailId(esewaDataModel.getCustomerDetailId());
            //    hotelBookingModel3.setGuestName(esewaDataModel.getGuestName());
            //    hotelBookingModel3.setGuestPhNo(esewaDataModel.getGuestPhNo());
             //   hotelBookingModel3.setGuestEmailId(esewaDataModel.getGuestEmailId());

                Map map=  (Map)  esewaTxnDao.procEsewaTxn(null ,null,null,null,null,null,null,esewaDataModel.getProductId(),esewaDataModel.getRefId(),null,hotelBookingModel1.getHotelBookingId(),null,"confirm_txn").get(0);

                System.out.println(map);

                HotelBookingModel hotelBookingModel4= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel3,null,"online_pay")).get(0);


                if (hotelBookingModel4.getStatus().equals("SUCCESS")){

                    final HotelBookingModel hotelBookingModel6=hotelBookingModel1;
                    // thread handling
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            HotelBookingModel hotelBookingModel2=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel6,null,"search_paid")).get(0);

                            hotelBookingModel2.setPaymentStatus("Paid by esewa ");

                            try {
                                emailResource.bookingConfirm(hotelBookingModel2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }).start();

                    // ** ending of thread handling


                }

                hotelBookingModel4.setInvoice(esewaDataModel.getProductId());

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

    @Path("/invoiceNo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookingDetailByInvoiceNo(HotelBookingModel hotelBookingModel) throws Exception {

            hotelBookingModel=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"search_by_invoice")).get(0);

        //    System.out.println(hotelBookingModel.getStatus());

         //   String x= hotelBookingModel.getStatus()==null? "":hotelBookingModel.getStatus();

            if ((hotelBookingModel.getStatus()==null?"":hotelBookingModel.getStatus()).equals("UNSUCCESS")){
                errorMessage =new ErrorMessage();
                errorMessage.setStatus("UNSUCCESS");
                errorMessage.setErrormessage(hotelBookingModel.getMessage());

                return Response.status(Response.Status.OK).entity(errorMessage)
                        .type(MediaType.APPLICATION_JSON).build();

            }

            int perRate = (int) Double.parseDouble(hotelBookingModel.getFinalRate()) / (int) Double.parseDouble(hotelBookingModel.getTotalDays());

            hotelBookingModel.setPerRate(Integer.toString(perRate));

         //   System.out.println(hotelBookingModel.toString());

         //   System.out.println(hotelBookingModel.getRoomDetailId());

         //   System.out.println(roomImageDao.procRoomImage(new RoomImageModel(null, hotelBookingModel.getRoomDetailId(), null, null, "Y", null, null, null), null, "s"));

            RoomImageModel roomImageModel = (RoomImageModel) new RoomImageMapper().
                    mapList(roomImageDao.procRoomImage(new RoomImageModel(null, hotelBookingModel.getRoomDetailId(), null, null, "Y", null, null, null), null, "s")).get(0);

            hotelBookingModel.setRoomImageUrl(configModel.getTpsResourceUrl() + "/RoomImages/" + roomImageModel.getImageUrl());

            hotelBookingModel.setCheckInTo(new Utility().formatTime(hotelBookingModel.getCheckInTo()));
            hotelBookingModel.setCheckOutTo(new Utility().formatTime(hotelBookingModel.getCheckOutTo()));

            //address binding
            AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelBookingModel.getAddressId()),null,"s")).get(0);
            addressResource.lowerToUpperNode(addressModel);
            addressModel.setAddress(null);
            addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);

            hotelBookingModel.setHotelAddress(addressModel.getAddressNameEdited());
              hotelBookingModel.setStatus("SUCCESS");

        // payment gateway access

            if (hotelBookingModel.getPayOptionFlag().equals("Y")){

                String currencyType=null;
                if (hotelBookingModel.getCurrencyDesc().equals("NPR")){

                    currencyType="NPL";
                }
                else {
                    currencyType="OTHER";
                }

                List<PayGateAccessModel> payGateAccessModels=new PayGateAccessMapper().mapList(payGateAccessDao.procPayGateAccess(new PayGateAccessModel(null,null,null,"Y",null,currencyType),null,"s"));

                for (PayGateAccessModel payGateAccessModel:payGateAccessModels){
                    payGateAccessModel.setImage(configModel.getTpsResourceUrl()+"/icons/"+payGateAccessModel.getImage());
                }

                payGateAccessModels=new PayGateAccessMapper().mapListSetNull(true,false,false,true,payGateAccessModels);
                hotelBookingModel.setPayGateAccessList(payGateAccessModels);


            }

        // **

        return Response.status(Response.Status.OK).entity(hotelBookingModel)
                    .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/bookingDetail")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookingDetailByCustomerDetail(HotelBookingModel hotelBookingModel) throws Exception {

       hotelBookingModel.setCustomerDetailId(encodeResource.decrypt(hotelBookingModel.getCustomerDetailId()));

       List<HotelBookingModel> hotelBookingModels= new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"booking_by_customer_detail"));


        for(HotelBookingModel hotelBookingModel1:hotelBookingModels){

            int perRate = (int) Double.parseDouble(hotelBookingModel1.getFinalRate()) / (int) Double.parseDouble(hotelBookingModel1.getTotalDays());

            hotelBookingModel1.setPerRate(Integer.toString(perRate));


            RoomImageModel roomImageModel = (RoomImageModel) new RoomImageMapper().
                    mapList(roomImageDao.procRoomImage(new RoomImageModel(null, hotelBookingModel1.getRoomDetailId(), null, null, "Y", null, null, null), null, "s")).get(0);

            hotelBookingModel1.setRoomImageUrl(configModel.getTpsResourceUrl() + "/RoomImages/" + roomImageModel.getImageUrl());

            hotelBookingModel1.setCheckInTo(new Utility().formatTime(hotelBookingModel1.getCheckInTo()));
            hotelBookingModel1.setCheckOutTo(new Utility().formatTime(hotelBookingModel1.getCheckOutTo()));

            //address binding
            AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelBookingModel1.getAddressId()),null,"s")).get(0);
            addressResource.lowerToUpperNode(addressModel);
            addressModel.setAddress(null);
            addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);

            hotelBookingModel1.setHotelAddress(addressModel.getAddressNameEdited());


        }

        return Response.status(Response.Status.OK).entity(hotelBookingModels)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/unbooked/invoiceNo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookingDetailUnbookedByInvoiceNo(HotelBookingModel hotelBookingModel) throws Exception {

        hotelBookingModel=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"search_unbooked_by_invoice")).get(0);


        //   String x= hotelBookingModel.getStatus()==null? "":hotelBookingModel.getStatus();

        if ((hotelBookingModel.getStatus()==null?"":hotelBookingModel.getStatus()).equals("UNSUCCESS")){
            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage(hotelBookingModel.getMessage());

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        int perRate = (int) Double.parseDouble(hotelBookingModel.getFinalRate()) / (int) Double.parseDouble(hotelBookingModel.getTotalDays());

        hotelBookingModel.setPerRate(Integer.toString(perRate));

        System.out.println(hotelBookingModel.toString());

        System.out.println(hotelBookingModel.getRoomDetailId());

        System.out.println(roomImageDao.procRoomImage(new RoomImageModel(null, hotelBookingModel.getRoomDetailId(), null, null, "Y", null, null, null), null, "s"));

        RoomImageModel roomImageModel = (RoomImageModel) new RoomImageMapper().
                mapList(roomImageDao.procRoomImage(new RoomImageModel(null, hotelBookingModel.getRoomDetailId(), null, null, "Y", null, null, null), null, "s")).get(0);

        hotelBookingModel.setRoomImageUrl(configModel.getTpsResourceUrl() + "/RoomImages/" + roomImageModel.getImageUrl());

        hotelBookingModel.setCheckInTo(new Utility().formatTime(hotelBookingModel.getCheckInTo()));
        hotelBookingModel.setCheckOutTo(new Utility().formatTime(hotelBookingModel.getCheckOutTo()));

        //address binding
        AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelBookingModel.getAddressId()),null,"s")).get(0);
        addressResource.lowerToUpperNode(addressModel);
        addressModel.setAddress(null);
        addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);

        hotelBookingModel.setHotelAddress(addressModel.getAddressNameEdited());
        hotelBookingModel.setStatus("SUCCESS");

        hotelBookingModel.setRoomDetailId(encodeResource.encrypt(hotelBookingModel.getRoomDetailId()));

        return Response.status(Response.Status.OK).entity(hotelBookingModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/unbooked/hash")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookingDetailUnbookedByHash(HotelBookingModel hotelBookingModel) throws Exception {

        hotelBookingModel=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"search_unbooked_by_hash")).get(0);


        //   String x= hotelBookingModel.getStatus()==null? "":hotelBookingModel.getStatus();

        if ((hotelBookingModel.getStatus()==null?"":hotelBookingModel.getStatus()).equals("UNSUCCESS")){
            errorMessage =new ErrorMessage();
            errorMessage.setStatus("UNSUCCESS");
            errorMessage.setErrormessage(hotelBookingModel.getMessage());

            return Response.status(Response.Status.OK).entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        int perRate = (int) Double.parseDouble(hotelBookingModel.getFinalRate()) / (int) Double.parseDouble(hotelBookingModel.getTotalDays());

        hotelBookingModel.setPerRate(Integer.toString(perRate));

        RoomImageModel roomImageModel = (RoomImageModel) new RoomImageMapper().
                mapList(roomImageDao.procRoomImage(new RoomImageModel(null, hotelBookingModel.getRoomDetailId(), null, null, "Y", null, null, null), null, "s")).get(0);

        hotelBookingModel.setRoomImageUrl(configModel.getTpsResourceUrl() + "/RoomImages/" + roomImageModel.getImageUrl());

        hotelBookingModel.setCheckInTo(new Utility().formatTime(hotelBookingModel.getCheckInTo()));
        hotelBookingModel.setCheckOutTo(new Utility().formatTime(hotelBookingModel.getCheckOutTo()));

        //address binding
        AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelBookingModel.getAddressId()),null,"s")).get(0);
        addressResource.lowerToUpperNode(addressModel);
        addressModel.setAddress(null);
        addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);

        hotelBookingModel.setHotelAddress(addressModel.getAddressNameEdited());
        hotelBookingModel.setStatus("SUCCESS");

        hotelBookingModel.setRoomDetailId(encodeResource.encrypt(hotelBookingModel.getRoomDetailId()));

        return Response.status(Response.Status.OK).entity(hotelBookingModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/cancelBooking")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelBooking(HotelBookingModel hotelBookingModel) throws Exception {

       HotelBookingModel hotelBookingModel1=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel,null,"cancellation")).get(0);

        if (hotelBookingModel1.getStatus().equals("SUCCESS")){

            ///////
/*
            int perRate = (int) Double.parseDouble(hotelBookingModel1.getFinalRate()) / (int) Double.parseDouble(hotelBookingModel1.getTotalDays());

            hotelBookingModel1.setPerRate(Integer.toString(perRate));

            RoomImageModel roomImageModel = (RoomImageModel) new RoomImageMapper().
                    mapList(roomImageDao.procRoomImage(new RoomImageModel(null, hotelBookingModel1.getRoomDetailId(), null, null, "Y", null, null, null), null, "s")).get(0);

            hotelBookingModel1.setRoomImageUrl(configModel.getTpsResourceUrl() + "/RoomImages/" + roomImageModel.getImageUrl());

            hotelBookingModel1.setCheckInTo(new Utility().formatTime(hotelBookingModel1.getCheckInTo()));
            hotelBookingModel1.setCheckOutTo(new Utility().formatTime(hotelBookingModel1.getCheckOutTo()));

            //address binding
            AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelBookingModel1.getAddressId()),null,"s")).get(0);
            addressResource.lowerToUpperNode(addressModel);
            addressModel.setAddress(null);
            addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);

            hotelBookingModel1.setHotelAddress(addressModel.getAddressNameEdited());

*/

            //////

            final HotelBookingModel hotelBookingModel3=new HotelBookingModel();
            hotelBookingModel3.setInvoice(hotelBookingModel.getInvoice());

            // thread handling
            new Thread(new Runnable() {
                @Override
                public void run() {

                    HotelBookingModel hotelBookingModel2=(HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel3,null,"s")).get(0);

                    if (hotelBookingModel2.getPaid().equals("Y")){

                        if (hotelBookingModel2.getPayType().equals("esewa")){
                            hotelBookingModel2.setPaymentStatus("Paid by esewa");
                        }

                        else if (hotelBookingModel2.getPayType().equals("npay")){

                            hotelBookingModel2.setPaymentStatus("Paid by esewa");
                        }

                        else if (hotelBookingModel2.getPayType().equals("nibl")){

                            hotelBookingModel2.setPaymentStatus("Paid by nibl");
                        }


                    }

                    else {

                        hotelBookingModel2.setPaymentStatus("Pending");
                    }


                    try {
                        emailResource.cancelBooking(hotelBookingModel2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();

            // ** ending of thread handling

        }


        return Response.status(Response.Status.OK).entity(hotelBookingModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }


}
