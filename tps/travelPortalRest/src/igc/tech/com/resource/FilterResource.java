package igc.tech.com.resource;

import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.validate.ValidData;
import igc.tech.com.validate.ValidType;
import igc.tech.com.validate.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.search.SubjectTerm;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/search")
public class FilterResource {

    @Autowired
    HotelFilterDao hotelFilterDao;

    @Autowired
    RoomFilterDao roomFilterDao;

    @Autowired
    OutOfRoomFilterDao outOfRoomFilterDao;

    @Autowired
    HotelFeatureDao hotelFeatureDao;

    @Autowired
    HotelActivityDao hotelActivityDao;

    @Autowired
    RoomAmenityDao roomAmenityDao;

    @Autowired
    HotelImageDao hotelImageDao;

    @Autowired
    RoomImageDao roomImageDao;

    @Autowired
    OfferDao offerDao;


    @Autowired
    NearPlacesDao nearPlacesDao;

    @Autowired
    AddressResource addressResource;

    @Autowired
    AddressDao addressDao;

    @Autowired
    HotelDetailDao hotelDetailDao;

    @Autowired
    RoomImportanceDao roomImportanceDao;

    @Autowired
    FilterMainHotelAreaDao filterMainHotelAreaDao;

    @Autowired
    FilterMainHotelWiseDao filterMainHotelWiseDao;

    @Autowired
    FilterAdvanceDao  filterAdvanceDao;

    @Autowired
    ConfigModel configModel;

    @Autowired
    EncodeResource encodeResource;

    @Autowired
    HotelRulesDao hotelRulesDao;

    @Autowired
    ActivityHighlightDao activityHighlightDao;

    @Autowired
    AmenityHighlightDao amenityHighlightDao;

    @Autowired
    HotelBookingDao hotelBookingDao;


    @Autowired
    HotelReviewResource hotelReviewResource;

    ErrorMessage errorMessage;

    ResponseModel responseModel;



    @Path("/hotelFilter")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelFilter(HotelFilterModel hotelFilterModel) throws Exception {

        //  normal validation
        List<ValidData> validDatas=new ArrayList<>();
        validDatas.add(new ValidData("searchValue", hotelFilterModel.getSearchValue(), new ValidType(false,false,true,false)));
        validDatas.add(new ValidData("checkInDate", hotelFilterModel.getCheckInDate(), new ValidType(false,false,true,false)));
        validDatas.add(new ValidData("checkOutDate", hotelFilterModel.getCheckOutDate(), new ValidType(false,false,true,false)));
        validDatas.add(new ValidData("noOfRooms", hotelFilterModel.getNoOfRooms(), new ValidType(false,false,true,false)));
        validDatas.add(new ValidData("noOfAdult", hotelFilterModel.getNoOfAdult(), new ValidType(false,false,true,false)));
        validDatas.add(new ValidData("noOfChild", hotelFilterModel.getNoOfChild(), new ValidType(false,false,true,false)));
        validDatas.add(new ValidData("type", hotelFilterModel.getType(), new ValidType(false,false,true,false)));
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



        String searchValue="";
        HotelFilterModel hotelFilterModel1=new HotelFilterModel();

       if ((hotelFilterModel.getSearchValue()==null?"":hotelFilterModel.getSearchValue()).trim().length()!=0){

           //for area
           if (hotelFilterModel.getType().equals("A")){

               /*AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.
                       procAddress(new AddressModel(encodeResource.decrypt(hotelFilterModel.getSearchValue())),null,"s")).get(0);
               List<AddressModel> addressModels=  addressResource.getAreaNodesBySelectedNode(addressModel);
            // capture address id of area type
               for (int i=0; i <(addressModels.size()-1); i ++){
                   addressModel=addressModels.get(i);
                 //  System.out.println(addressModel.toString());
                   searchValue=searchValue+addressModel.getAddressId()+",";

               }
                /*//**
               searchValue=searchValue+addressModels.get(addressModels.size()-1).getAddressId();*/

               searchValue=encodeResource.decrypt(hotelFilterModel.getSearchValue());

               hotelFilterModel.setSearchValue(searchValue);

                hotelFilterModel1 = new HotelFilterMapper().mapRow(filterMainHotelAreaDao.procFilterMainHotelArea(hotelFilterModel));
           }
           // for hotel
           else  if(hotelFilterModel.getType().equals("H")){

               searchValue=encodeResource.decrypt(hotelFilterModel.getSearchValue());

               hotelFilterModel.setSearchValue(searchValue);

               hotelFilterModel1 = new HotelFilterMapper().mapRow(filterMainHotelWiseDao.procFilterMainHotelWise(hotelFilterModel));
           }

       }


        for (RoomDetailModel roomDetailModel : hotelFilterModel1.getRoomDetailList()) {


            // todays total booked room binding

            HotelBookingModel hotelBookingModel21=new HotelBookingModel();
            hotelBookingModel21.setRoomDetailId(roomDetailModel.getRoomDetailId());

            hotelBookingModel21= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel21,null,"todays_total_booking_by_room")).get(0);

            roomDetailModel.setTotalBooked(hotelBookingModel21.getTotalBooked());

            //*************

            // hotel review and rating binding

            HotelReviewModel hotelReviewModel=new HotelReviewModel();
            hotelReviewModel.setHotelDetailId(roomDetailModel.getHotelDetailId());

            HotelReviewModel hotelReviewModel11= (HotelReviewModel) hotelReviewResource.hotelReviewTotalandAvg(hotelReviewModel).getEntity();

            if (hotelReviewModel11.getStatus().equals("SUCCESS")){

                roomDetailModel.setHotelReview(hotelReviewModel11);
            }

            //***************

            // hotelfeature binding
            HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
            hotelFeatureModel.setHotelDetailId(roomDetailModel.getHotelDetailId());
            hotelFeatureModel = (HotelFeatureModel) new HotelFeatureMapper().mapList(hotelFeatureDao.procHotelFeature(hotelFeatureModel, null, "s")).get(0);
            roomDetailModel.setHotelFeature(new HotelFeatureMapper().mapRowSetNull(true, false, false, false, false, true, true, hotelFeatureModel));

            // activity binding
            List<ActivityModel> activityModels=new ActivityMapper().mapList(hotelActivityDao.procHotelActivity(new HotelActivityModel(null,roomDetailModel.getHotelDetailId()),null,"e"));

            for (ActivityModel activityModel:activityModels){

                // binding image url to parent activity
                if (activityModel.getImage()!=null){
                    activityModel.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityModel.getImage());
                }
                //****

                List<ActivityModel> activityModels1=new ActivityMapper().mapList(hotelActivityDao.procHotelActivity(new HotelActivityModel(null,roomDetailModel.getHotelDetailId(),activityModel.getActivityId()),null,"f"));

                for (ActivityModel activityModel1:activityModels1){

                    // binding image url to child activity
                    if (activityModel1.getImage()!=null){
                        activityModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityModel1.getImage());
                    }
                    //****
                }

                activityModel.setActivityList(activityModels1);

            }

            roomDetailModel.setActivityList(activityModels);



            //********************



            // Hotel activity binding
            HotelActivityModel hotelActivityModel = new HotelActivityModel();
            hotelActivityModel.setHotelDetailId(roomDetailModel.getHotelDetailId());
            hotelActivityModel.setActive("Y");
            List<HotelActivityModel> hotelActivityModels = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "s"));

            roomDetailModel.setHotelActivityList(new HotelActivityMapper().mapListSetNull(false, true, false, false, true, true, false, false, false, hotelActivityModels));


            // Hotel Activity Highlights Binding
            ActivityHighlightModel activityHighlightModel=new ActivityHighlightModel();
            activityHighlightModel.setHotelDetailId(roomDetailModel.getHotelDetailId());

            List<ActivityHighlightModel> activityHighlightModels=  new ActivityHighlightMapper().mapList(activityHighlightDao.procActivityHighlight(activityHighlightModel,null,"hightlight_by_hotel"));

            for (ActivityHighlightModel activityHighlightModel1:activityHighlightModels){

                /*if (activityHighlightModel1.getIcon()!=null){
                    activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getIcon());
                }*/
                 if (activityHighlightModel1.getImage()!=null){
                    activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getImage());
                }

            }

            roomDetailModel.setActivityHighlightList(activityHighlightModels);

            // *********

            if (roomDetailModel.getRoomDetailId()!=null){

                // Room Amenity Highlights Binding
                AmenityHighlightModel amenityHighlightModel=new AmenityHighlightModel();
                amenityHighlightModel.setRoomDetailId(roomDetailModel.getRoomDetailId());

                List<AmenityHighlightModel> amenityHighlightModels=  new AmenityHighlightMapper().mapList(amenityHighlightDao
                        .procAmenityHighlight(amenityHighlightModel,null,"hightlight_by_room"));

                for (AmenityHighlightModel amenityHighlightModel1:amenityHighlightModels){

                    /*if (amenityHighlightModel1.getIcon()!=null){
                        amenityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+amenityHighlightModel1.getIcon());
                    }*/
                     if (amenityHighlightModel1.getImage()!=null){
                        amenityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+amenityHighlightModel1.getImage());
                    }

                }

                roomDetailModel.setAmenityHighlightList(amenityHighlightModels);

                // *********

                // room amenity binding
                RoomAmenityModel roomAmenityModel = new RoomAmenityModel();
                roomAmenityModel.setRoomDetailId(roomDetailModel.getRoomDetailId());
                roomAmenityModel.setActive("Y");
                List<RoomAmenityModel> roomAmenityModels = new RoomAmenityMapper().mapList(roomAmenityDao.procRoomAmenity(roomAmenityModel, null, "s"));
                roomDetailModel.setRoomAmenityList(new RoomAmenityMapper().mapListSetNull(false, true, false, true, true, true, false, roomAmenityModels));

            }


            //offer binding
            if (roomDetailModel.getOfferId()!=null){

                roomDetailModel.setOffer((OfferModel) new OfferMapper().mapListSetNull(true, false, true, true, true, false, false,
                        new OfferMapper().mapList(offerDao.procOffer(new OfferModel( roomDetailModel.getOfferId(), roomDetailModel.getRoomDetailId()), null, "s"))).get(0));
            }

            // nearest places binding

            List<NearPlacesModel> nearPlacesModels= new NearPlacesMapper().mapList(nearPlacesDao.procNearPlaces(new NearPlacesModel(roomDetailModel.getHotelDetailId()), null, "s"));

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

            roomDetailModel.setNearPlacesList(new NearPlacesMapper().mapListSetNull(true, true, false, false, false, false, false, nearPlacesModels));


            //address binding
            AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(roomDetailModel.getAddressId()),null,"s")).get(0);
            addressResource.lowerToUpperNode(addressModel);
            addressModel.setAddress(null);
            addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);
            roomDetailModel.setAddress(addressModel);

            // hotel image binding
            HotelImageModel hotelImageModel = new HotelImageModel();
            hotelImageModel.setImageUrl(configModel.getTpsResourceUrl()+"/HotelImages/"+ ((HotelImageModel) new HotelImageMapper().mapList(hotelImageDao.
                    procHotelImage(new HotelImageModel(null, roomDetailModel.getHotelDetailId(), null, null, "Y", null, null, "Y"), null, "s")).get(0)).getImageUrl());

               roomDetailModel.setHotelImage(hotelImageModel);

           roomDetailModel.setHotelDetailId(encodeResource.encrypt(roomDetailModel.getHotelDetailId()));

            /*if (roomDetailModel.getRoomDetailId()!=null){
                roomDetailModel.setRoomDetailId(encodeResource.encrypt(roomDetailModel.getRoomDetailId()));

            }*/

        }

        return Response.status(Response.Status.OK).entity(hotelFilterModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/advanceSearch")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response advanceSearch(HotelFilterModel hotelFilterModel) throws Exception {


        HotelFilterModel hotelFilterModel1 = new HotelFilterMapper().mapRow(filterAdvanceDao.procFilterAdvance(hotelFilterModel));


        for (RoomDetailModel roomDetailModel : hotelFilterModel1.getRoomDetailList()) {

            // todays total booked room binding

            HotelBookingModel hotelBookingModel21=new HotelBookingModel();
            hotelBookingModel21.setRoomDetailId(roomDetailModel.getRoomDetailId());

            hotelBookingModel21= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel21,null,"todays_total_booking_by_room")).get(0);

            roomDetailModel.setTotalBooked(hotelBookingModel21.getTotalBooked());

            //*************


            // hotel review and rating binding

            HotelReviewModel hotelReviewModel=new HotelReviewModel();
            hotelReviewModel.setHotelDetailId(roomDetailModel.getHotelDetailId());

            HotelReviewModel hotelReviewModel11= (HotelReviewModel) hotelReviewResource.hotelReviewTotalandAvg(hotelReviewModel).getEntity();

            if (hotelReviewModel11.getStatus().equals("SUCCESS")){

                roomDetailModel.setHotelReview(hotelReviewModel11);
            }

            //***************



            // hotelfeature binding
            HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
            hotelFeatureModel.setHotelDetailId(roomDetailModel.getHotelDetailId());
            hotelFeatureModel = (HotelFeatureModel) new HotelFeatureMapper().mapList(hotelFeatureDao.procHotelFeature(hotelFeatureModel, null, "s")).get(0);
            roomDetailModel.setHotelFeature(new HotelFeatureMapper().mapRowSetNull(true, false, false, false, false, true, true, hotelFeatureModel));

            // activity binding
            List<ActivityModel> activityModels=new ActivityMapper().mapList(hotelActivityDao.procHotelActivity(new HotelActivityModel(null,roomDetailModel.getHotelDetailId()),null,"e"));

            for (ActivityModel activityModel:activityModels){

                // binding image url to parent activity
                if (activityModel.getImage()!=null){
                    activityModel.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityModel.getImage());
                }
                //****

                List<ActivityModel> activityModels1=new ActivityMapper().mapList(hotelActivityDao.procHotelActivity(new HotelActivityModel(null,roomDetailModel.getHotelDetailId(),activityModel.getActivityId()),null,"f"));

                for (ActivityModel activityModel1:activityModels1){

                    // binding image url to child activity
                    if (activityModel1.getImage()!=null){
                        activityModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityModel1.getImage());
                    }
                    //****
                }

                activityModel.setActivityList(activityModels1);

            }

            roomDetailModel.setActivityList(activityModels);

            //********************

            // Hotel activity binding
            HotelActivityModel hotelActivityModel = new HotelActivityModel();
            hotelActivityModel.setHotelDetailId(roomDetailModel.getHotelDetailId());
            hotelActivityModel.setActive("Y");
            List<HotelActivityModel> hotelActivityModels = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "s"));

            roomDetailModel.setHotelActivityList(new HotelActivityMapper().mapListSetNull(false, true, false, false, true, true, false, false, false, hotelActivityModels));


            // Hotel Activity Highlights Binding
            ActivityHighlightModel activityHighlightModel=new ActivityHighlightModel();
            activityHighlightModel.setHotelDetailId(roomDetailModel.getHotelDetailId());

            List<ActivityHighlightModel> activityHighlightModels=  new ActivityHighlightMapper().mapList(activityHighlightDao.procActivityHighlight(activityHighlightModel,null,"hightlight_by_hotel"));

            for (ActivityHighlightModel activityHighlightModel1:activityHighlightModels){

                /*if (activityHighlightModel1.getIcon()!=null){
                    activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getIcon());
                }*/
                 if (activityHighlightModel1.getImage()!=null){
                    activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getImage());
                }

            }

            roomDetailModel.setActivityHighlightList(activityHighlightModels);

            // *********

            if (roomDetailModel.getRoomDetailId()!=null){

                // Room Amenity Highlights Binding
                AmenityHighlightModel amenityHighlightModel=new AmenityHighlightModel();
                amenityHighlightModel.setRoomDetailId(roomDetailModel.getRoomDetailId());

                List<AmenityHighlightModel> amenityHighlightModels=  new AmenityHighlightMapper().mapList(amenityHighlightDao
                        .procAmenityHighlight(amenityHighlightModel,null,"hightlight_by_room"));

                for (AmenityHighlightModel amenityHighlightModel1:amenityHighlightModels){

                   /* if (amenityHighlightModel1.getIcon()!=null){
                        amenityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+amenityHighlightModel1.getIcon());
                    }*/
                     if (amenityHighlightModel1.getImage()!=null){
                        amenityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+amenityHighlightModel1.getImage());
                    }

                }

                roomDetailModel.setAmenityHighlightList(amenityHighlightModels);

                // *********

                // room amenity binding
                RoomAmenityModel roomAmenityModel = new RoomAmenityModel();
                roomAmenityModel.setRoomDetailId(roomDetailModel.getRoomDetailId());
                roomAmenityModel.setActive("Y");
                List<RoomAmenityModel> roomAmenityModels = new RoomAmenityMapper().mapList(roomAmenityDao.procRoomAmenity(roomAmenityModel, null, "s"));
                roomDetailModel.setRoomAmenityList(new RoomAmenityMapper().mapListSetNull(false, true, false, true, true, true, false, roomAmenityModels));
            }






            //offer binding
            if (roomDetailModel.getOfferId()!=null){
                roomDetailModel.setOffer((OfferModel) new OfferMapper().mapListSetNull(true, false, true, true, true, false, false,
                        new OfferMapper().mapList(offerDao.procOffer(new OfferModel(roomDetailModel.getOfferId(),roomDetailModel.getRoomDetailId()), null, "s"))).get(0));
            }

            // nearest places binding

            List<NearPlacesModel> nearPlacesModels= new NearPlacesMapper().mapList(nearPlacesDao.procNearPlaces(new NearPlacesModel(roomDetailModel.getHotelDetailId()), null, "s"));

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


            roomDetailModel.setNearPlacesList(new NearPlacesMapper().mapListSetNull(true, true, false, false, false, false, false, nearPlacesModels));


            //address binding
            AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(roomDetailModel.getAddressId()),null,"s")).get(0);
            addressResource.lowerToUpperNode(addressModel);
            addressModel.setAddress(null);
            addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);
            roomDetailModel.setAddress(addressModel);

            // hotel image binding
            HotelImageModel hotelImageModel = new HotelImageModel();
            hotelImageModel.setImageUrl(configModel.getTpsResourceUrl()+"/HotelImages/"+ ((HotelImageModel) new HotelImageMapper().mapList(hotelImageDao.
                    procHotelImage(new HotelImageModel(null, roomDetailModel.getHotelDetailId(), null, null, "Y", null, null, "Y"), null, "s")).get(0)).getImageUrl());

            roomDetailModel.setHotelImage(hotelImageModel);
            //   roomDetailModel.setHotelImage( new HotelImageMapper().mapList(hotelImageDao.procHotelImage(new HotelImageModel(null,roomDetailModel.getHotelDetailId(),null,null,null,null,null,"Y"),null,"s")).get(0));



            roomDetailModel.setHotelDetailId(encodeResource.encrypt(roomDetailModel.getHotelDetailId()));


            // roomAmenityModel.setHotelDetailId("12121321321");

        }

        //    System.out.println(roomDetailModels);


        return Response.status(Response.Status.OK).entity(hotelFilterModel1)
                .type(MediaType.APPLICATION_JSON).build();

    }



    @Path("/roomFilter")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response roomFilter(HotelFilterModel hotelFilterModel) throws Exception {

        //   CALL proc_room_filter(1 ,'2016-10-2','2016-10-8',3,2,1,'1' );

        String hotelDetailid=encodeResource.decrypt(hotelFilterModel.getHotelDetailId());

        HotelDetailModel hotelDetailModel= (HotelDetailModel) new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(hotelDetailid,null),null,"s")).get(0);

         /*       new HotelDetailMapper().mapRowSetNull(true,false,false,false,false,false,false,false,false,false,true,true,true,true,
                                                       new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(hotelDetailid,null),null,"s")).get(0)) ;
*/


        // hotel review and rating binding

        HotelReviewModel hotelReviewModel=new HotelReviewModel();
        hotelReviewModel.setHotelDetailId(hotelFilterModel.getHotelDetailId());

        HotelReviewModel hotelReviewModel11= (HotelReviewModel) hotelReviewResource.hotelReviewDetail(hotelReviewModel).getEntity();

        if (hotelReviewModel11.getStatus().equals("SUCCESS")){

            hotelDetailModel.setHotelReview(hotelReviewModel11);
        }

        //***************

        // hotelfeature binding
        HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
        hotelFeatureModel.setHotelDetailId(hotelDetailid);
        hotelFeatureModel = (HotelFeatureModel) new HotelFeatureMapper().mapList(hotelFeatureDao.procHotelFeature(hotelFeatureModel, null, "s")).get(0);
        hotelDetailModel.setHotelFeature(new HotelFeatureMapper().mapRowSetNull(true, false, false, false, false, true, true, hotelFeatureModel));


        // activity binding
        List<ActivityModel> activityModels=new ActivityMapper().mapList(hotelActivityDao.procHotelActivity(new HotelActivityModel(null,hotelDetailModel.getHotelDetailId()),null,"e"));

        for (ActivityModel activityModel:activityModels){

            // binding image url to parent activity
            if (activityModel.getImage()!=null){
                activityModel.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityModel.getImage());
            }
            //****

            List<ActivityModel> activityModels1=new ActivityMapper().mapList(hotelActivityDao.procHotelActivity(new HotelActivityModel(null,hotelDetailModel.getHotelDetailId(),activityModel.getActivityId()),null,"f"));

            for (ActivityModel activityModel1:activityModels1){

                // binding image url to child activity
                if (activityModel1.getImage()!=null){
                    activityModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityModel1.getImage());
                }
                //****
            }

            activityModel.setActivityList(activityModels1);

        }

        hotelDetailModel.setActivityList(activityModels);



        //********************

        // Hotel activity binding
        HotelActivityModel hotelActivityModel = new HotelActivityModel();
        hotelActivityModel.setHotelDetailId(hotelDetailid);
        hotelActivityModel.setActive("Y");
        List<HotelActivityModel> hotelActivityModels = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "s"));
        hotelDetailModel.setHotelActivityList(new HotelActivityMapper().mapListSetNull(false, true, false, false, true, true, false, false, false, hotelActivityModels));



        // Hotel Activity Highlights Binding
        ActivityHighlightModel activityHighlightModel=new ActivityHighlightModel();
        activityHighlightModel.setHotelDetailId(hotelDetailModel.getHotelDetailId());

        List<ActivityHighlightModel> activityHighlightModels=  new ActivityHighlightMapper().mapList(activityHighlightDao.procActivityHighlight(activityHighlightModel,null,"hightlight_by_hotel"));

        for (ActivityHighlightModel activityHighlightModel1:activityHighlightModels){

            /*if (activityHighlightModel1.getIcon()!=null){
                activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getIcon());
            }*/
             if (activityHighlightModel1.getImage()!=null){
                activityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+activityHighlightModel1.getImage());
            }

        }

        hotelDetailModel.setActivityHighlightList(activityHighlightModels);

        // *********

        // *********


        //hotel Image binding
        List<HotelImageModel> hotelImageModels=new HotelImageMapper().mapList(hotelImageDao.
                procHotelImage(new HotelImageModel(null,hotelDetailid,null,null,null,null,null,"Y"),null,"s"));

        for(HotelImageModel hotelImageModel:hotelImageModels){
            hotelImageModel.setFullImageUrl(configModel.getTpsResourceUrl()+"/HotelImages/"+hotelImageModel.getImageUrl());

        }
        hotelDetailModel.setHotelImageList(new HotelImageMapper().mapListSetNull(true,true,false,true,false,true,false,true,false,hotelImageModels));


        // nearest places binding
        List<NearPlacesModel> nearPlacesModels= new NearPlacesMapper().mapList(nearPlacesDao.procNearPlaces(new NearPlacesModel(hotelDetailid), null, "s"));

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




        //address binding
        AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(hotelDetailModel.getAddressId()),null,"s")).get(0);
        addressResource.lowerToUpperNode(addressModel);
        addressModel.setAddress(null);
        addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);
        hotelDetailModel.setAddress(addressModel);

        // hotel rules binding
        List<HotelRulesModel> hotelRulesModels= new HotelRulesMapper().mapList(hotelRulesDao.procHotelRules(new HotelRulesModel(null,null,hotelDetailid,"Y"), null, "s"));
        hotelDetailModel.setHotelRulesList(new HotelRulesMapper().mapListSetNull(true,true,true,true,true,false,hotelRulesModels));


        List<RoomDetailModel> roomDetailModels = new RoomDetailMapper().mapList(roomFilterDao.procRoomFilter(encodeResource.decrypt(hotelFilterModel.getHotelDetailId()),
                hotelFilterModel.getCheckInDate(),hotelFilterModel.getCheckOutDate(),hotelFilterModel.getNoOfRooms(),hotelFilterModel.getNoOfAdult(),
                hotelFilterModel.getNoOfChild(),hotelFilterModel.getChildAges(),hotelFilterModel.getAmenities(),hotelFilterModel.getCurrencyDesc()));


        for (RoomDetailModel roomDetailModel:roomDetailModels){

            // todays total booked room binding

            HotelBookingModel hotelBookingModel21=new HotelBookingModel();
            hotelBookingModel21.setRoomDetailId(roomDetailModel.getRoomDetailId());

            hotelBookingModel21= (HotelBookingModel) new HotelBookingMapper().mapList(hotelBookingDao.procHotelBooking(hotelBookingModel21,null,"todays_total_booking_by_room")).get(0);

            roomDetailModel.setTotalBooked(hotelBookingModel21.getTotalBooked());

            //*************

            // room amenity binding
            List<RoomAmenityModel> roomAmenityModels= new RoomAmenityMapper().mapList(roomAmenityDao.
                    procRoomAmenity(new RoomAmenityModel(null,roomDetailModel.getRoomDetailId(),null,"Y",null,null,null,null,null), null, "s"));
            roomDetailModel.setRoomAmenityList(new RoomAmenityMapper().mapListSetNull(false, true, false, true, true, true, false, roomAmenityModels));

            // bed type binding
          /*  List<RoomAmenityModel> roomAmenityModels= new RoomAmenityMapper().mapList(roomAmenityDao.
                    procRoomAmenity(new RoomAmenityModel(null,roomDetailModel.getRoomDetailId(),null,"Y",null,null,null,null,null), null, "s"));
            roomDetailModel.setRoomAmenityList(new RoomAmenityMapper().mapListSetNull(false, true, false, true, true, true, false, roomAmenityModels));
*/

            //room image binding
            List<RoomImageModel> roomImageModels= new RoomImageMapper().mapList(roomImageDao.
                    procRoomImage(new RoomImageModel(null,roomDetailModel.getRoomDetailId(),null,null,null,null,null,"Y"), null, "s"));

            for (RoomImageModel roomImageModel:roomImageModels){

                roomImageModel.setFullImageUrl(configModel.getTpsResourceUrl()+"/RoomImages/"+roomImageModel.getImageUrl());

             }


            roomDetailModel.setRoomImageList(new RoomImageMapper().mapListSetNull(true,true,false,true,false,true,false,true,false,roomImageModels));


            // Room Amenity Highlights Binding
            AmenityHighlightModel amenityHighlightModel=new AmenityHighlightModel();
            amenityHighlightModel.setRoomDetailId(roomDetailModel.getRoomDetailId());

            List<AmenityHighlightModel> amenityHighlightModels=  new AmenityHighlightMapper().mapList(amenityHighlightDao
                    .procAmenityHighlight(amenityHighlightModel,null,"hightlight_by_room"));

            for (AmenityHighlightModel amenityHighlightModel1:amenityHighlightModels){

                /*if (amenityHighlightModel1.getIcon()!=null){
                    amenityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+amenityHighlightModel1.getIcon());
                }*/
                 if (amenityHighlightModel1.getImage()!=null){
                    amenityHighlightModel1.setImage(configModel.getTpsResourceUrl()+"/icons/"+amenityHighlightModel1.getImage());
                }

            }

            roomDetailModel.setAmenityHighlightList(amenityHighlightModels);

            // *********

            // room importance binding

            List<RoomImportanceModel> roomImportanceModels= new RoomImportanceMapper().mapList(roomImportanceDao.
                    procRoomImportance(new RoomImportanceModel(null,null,roomDetailModel.getRoomDetailId(),"Y",null), null, "s"));
            roomDetailModel.setRoomImportanceList(new RoomImportanceMapper().mapListSetNull(true,true,true,true,false,true,roomImportanceModels));


            //offer binding
            if (roomDetailModel.getOfferId()!=null){
                roomDetailModel.setOffer((OfferModel) new OfferMapper().mapListSetNull(true, false, true, true, true, false, false,
                        new OfferMapper().mapList(offerDao.procOffer(new OfferModel(roomDetailModel.getOfferId(),roomDetailModel.getRoomDetailId()), null, "s"))).get(0));
            }

            roomDetailModel.setRoomDetailId(encodeResource.encrypt(roomDetailModel.getRoomDetailId()));

        }

        hotelDetailModel.setRoomDetailList(roomDetailModels);

        hotelDetailModel =   new HotelDetailMapper().mapRowSetNull(true,false,false,false,false,false,false,false,false,false,true,true,true,true,hotelDetailModel) ;

        // get similar listing

       /* {
            "searchValue":"873741e2179aef4be8cac6ef6fd9fa468c79c5dc",
                "checkInDate":"2016-9-14",
                "checkOutDate":"2016-9-15",
                "noOfRooms":"1",
                "noOfAdult":"1",
                "noOfChild":"0",
                "childAges":"1",
                "type":"H"

        }*/

        HotelFilterModel hotelFilterModel1=new HotelFilterModel();

        hotelFilterModel1.setSearchValue(hotelFilterModel.getHotelDetailId());
        hotelFilterModel1.setCheckInDate(hotelFilterModel.getCheckInDate());
        hotelFilterModel1.setCheckOutDate(hotelFilterModel.getCheckOutDate());
        hotelFilterModel1.setNoOfRooms(hotelFilterModel.getNoOfRooms());
        hotelFilterModel1.setNoOfAdult(hotelFilterModel.getNoOfAdult());
        hotelFilterModel1.setNoOfChild(hotelFilterModel.getNoOfChild());
        hotelFilterModel1.setChildAges(hotelFilterModel.getChildAges());
        hotelFilterModel1.setPageNo("1");
        hotelFilterModel1.setOffSet("7");
        hotelFilterModel1.setType("H");
        hotelFilterModel1.setCurrencyDesc(hotelFilterModel.getCurrencyDesc());



        /*"pageNo":"1",
                "offSet":"5"*/

        Response response=hotelFilter(hotelFilterModel1);

        HotelFilterModel hotelFilterModel2= (HotelFilterModel) response.getEntity();

        List<RoomDetailModel> roomDetailModels1=hotelFilterModel2.getRoomDetailList();

        roomDetailModels1.remove(0);

        hotelDetailModel.setSimilarHotelList(roomDetailModels1);

        //  *************



        return Response.status(Response.Status.OK).entity(hotelDetailModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/outOfRoomFilter")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response outOfRoomFilter() {


        //  CALL proc_out_of_room_filter(1 ,'2016-10-2','2016-10-8',1,1,1,'1',NULL  ,NULL ,NULL );


        List<RoomDetailModel> roomDetailModels = new RoomDetailMapper().mapList(outOfRoomFilterDao.procOoutOfRoomFilter("1", "2016-10-2", "2016-10-8", "1", "1", "1", "1", null, null, null));

        System.out.println(roomDetailModels);


        return Response.status(Response.Status.OK).entity(roomDetailModels)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {

        /*CALL proc_filter_main_hotel_area('113' ,'2017-11-1','2017-11-2',1 ,1,1,'1',NULL ,NULL );





        CALL proc_filter_advance(NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL );*/


        HotelFilterModel hotelFilterModel=new HotelFilterModel();

        hotelFilterModel.setSearchValue("16");
        hotelFilterModel.setCheckInDate("2017-11-1");
        hotelFilterModel.setCheckOutDate("2017-11-2");
        hotelFilterModel.setNoOfRooms("1");
        hotelFilterModel.setNoOfAdult("1");
        hotelFilterModel.setNoOfChild("1");
        hotelFilterModel.setChildAges("1");
        hotelFilterModel.setChildAges("1");


       // System.out.println(filterMainHotelAreaDao.procFilterMainHotelArea(hotelFilterModel));
      //  System.out.println(filterAdvanceDao.procFilterAdvance(hotelFilterModel));

        hotelFilterModel=new HotelFilterModel();

        hotelFilterModel.setSearchKey("8b84bd1cfc34a52b913c760ddfceaefec30c7943");

        System.out.println(filterAdvanceDao.procFilterAdvance(hotelFilterModel));


        return  null;

    }


}
