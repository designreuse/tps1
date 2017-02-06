package igc.tech.com.resource;

import igc.tech.com.dao.*;
import igc.tech.com.mapper.*;
import igc.tech.com.model.*;
import igc.tech.com.utility.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.transform.Source;
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
    FilterAdvanceDao  filterAdvanceDao;



    @Autowired
    HotelRulesDao hotelRulesDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;


    @Path("/search/{value}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam("value")String value) throws Exception {

        List<HotelFilterModel> hotelFilterModels=new ArrayList<>();

        HotelFilterModel hotelFilterModel=new HotelFilterModel();

        // for area
        List<AddressModel> addressModels=new AddressMapper().mapList(addressDao.procAddress(new AddressModel(null,value,null,null,null),null,"c"));

        if (!addressModels.isEmpty()){
            for (AddressModel addressModel:addressModels){
                addressResource.lowerToUpperNode(addressModel);
                addressModel.setAddress(null);
                addressModel.setAddressId(new Encryption().encrypt(addressModel.getAddressId()));
            }

            hotelFilterModel.setType("Area");
            hotelFilterModel.setAddressList(addressModels);
        }

        hotelFilterModels.add(hotelFilterModel);
        //**

        //for hotel


        hotelFilterModel=new HotelFilterModel();

        List<HotelDetailModel> hotelDetailModels= new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(null,value),null,"c"));

        if (!hotelDetailModels.isEmpty()){

            hotelFilterModel=new HotelFilterModel();
            hotelFilterModel.setType("Hotel");
            hotelFilterModel.setHotelDetailList(hotelDetailModels);

        }
        hotelFilterModels.add(hotelFilterModel);

        //**


       // return null;

        return Response.status(Response.Status.OK).entity(hotelFilterModels)
                .type(MediaType.APPLICATION_JSON).build();
    }


    @Path("/hotelFilter")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hotelFilter(HotelFilterModel hotelFilterModel) throws Exception {

         String searchValue="";

       if ((hotelFilterModel.getSearchValue()==null?"":hotelFilterModel.getSearchValue()).trim().length()!=0){

           //for area
           if (hotelFilterModel.getType().equals("A")){
               AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.
                       procAddress(new AddressModel(new Encryption().decrypt(hotelFilterModel.getSearchValue())),null,"s")).get(0);
               List<AddressModel> addressModels=  addressResource.getAreaNodesBySelectedNode(addressModel);
            // capture address id of area type
               for (int i=0; i <(addressModels.size()-1); i ++){
                   addressModel=addressModels.get(i);
                   System.out.println(addressModel.toString());
                   searchValue=searchValue+addressModel.getAddressId()+",";

               }
                //**
               searchValue=searchValue+addressModels.get(addressModels.size()-1).getAddressId();
           }
           // for hotel
           else  if(hotelFilterModel.getType().equals("H")){

               searchValue=new Encryption().decrypt(hotelFilterModel.getSearchValue());
           }

       }

     /*   List<RoomDetailModel> roomDetailModels = new RoomDetailMapper().mapList(hotelFilterDao.
                procHotelFilter(searchValue, hotelFilterModel.getCheckInDate(), hotelFilterModel.getCheckOutDate(),hotelFilterModel.getNoOfRooms(),
                       hotelFilterModel.getNoOfAdult(),hotelFilterModel.getNoOfChild(),hotelFilterModel.getChildAges(),hotelFilterModel.getActivities(),hotelFilterModel.getAmenities(),
                        hotelFilterModel.getFromPrice(),hotelFilterModel.getToPrice(),hotelFilterModel.getType(),hotelFilterModel.getSortingType(),hotelFilterModel.getStarRange(),hotelFilterModel.getPageNo(),hotelFilterModel.getOffSet()));
*/
        HotelFilterModel hotelFilterModel1 = new HotelFilterMapper().mapRow(hotelFilterDao.
                procHotelFilter(searchValue, hotelFilterModel.getCheckInDate(), hotelFilterModel.getCheckOutDate(),hotelFilterModel.getNoOfRooms(),
                        hotelFilterModel.getNoOfAdult(),hotelFilterModel.getNoOfChild(),hotelFilterModel.getChildAges(),hotelFilterModel.getActivities(),hotelFilterModel.getAmenities(),
                        hotelFilterModel.getFromPrice(),hotelFilterModel.getToPrice(),hotelFilterModel.getType(),hotelFilterModel.getSortingType(),hotelFilterModel.getStarRange(),hotelFilterModel.getPageNo(),
                        hotelFilterModel.getOffSet(),hotelFilterModel.getPlatform()));



        for (RoomDetailModel roomDetailModel : hotelFilterModel1.getRoomDetailList()) {
            // hotelfeature binding
            HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
            hotelFeatureModel.setHotelDetailId(roomDetailModel.getHotelDetailId());
            hotelFeatureModel = (HotelFeatureModel) new HotelFeatureMapper().mapList(hotelFeatureDao.procHotelFeature(hotelFeatureModel, null, "s")).get(0);
            roomDetailModel.setHotelFeature(new HotelFeatureMapper().mapRowSetNull(true, false, false, false, false, true, true, hotelFeatureModel));

            // Hotel activity binding
            HotelActivityModel hotelActivityModel = new HotelActivityModel();
            hotelActivityModel.setHotelDetailId(roomDetailModel.getHotelDetailId());
            hotelActivityModel.setActive("Y");
            List<HotelActivityModel> hotelActivityModels = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "s"));

            roomDetailModel.setHotelActivityList(new HotelActivityMapper().mapListSetNull(false, true, false, false, true, true, false, false, false, hotelActivityModels));

            // room amenity binding
            RoomAmenityModel roomAmenityModel = new RoomAmenityModel();
            roomAmenityModel.setRoomDetailId(roomDetailModel.getRoomDetailId());
            roomAmenityModel.setActive("Y");
            List<RoomAmenityModel> roomAmenityModels = new RoomAmenityMapper().mapList(roomAmenityDao.procRoomAmenity(roomAmenityModel, null, "s"));
            roomDetailModel.setRoomAmenityList(new RoomAmenityMapper().mapListSetNull(false, true, false, true, true, true, false, roomAmenityModels));

            //offer binding
            if (roomDetailModel.getOfferId()!=null){
                roomDetailModel.setOffer((OfferModel) new OfferMapper().mapListSetNull(true, false, true, true, true, false, false,
                        new OfferMapper().mapList(offerDao.procOffer(new OfferModel(roomDetailModel.getRoomDetailId()), null, "s"))).get(0));
            }

            // nearest places binding

            List<NearPlacesModel> nearPlacesModels= new NearPlacesMapper().mapList(nearPlacesDao.procNearPlaces(new NearPlacesModel(roomDetailModel.getHotelDetailId()), null, "s"));
            roomDetailModel.setNearPlacesList(new NearPlacesMapper().mapListSetNull(true, true, false, false, false, false, false, nearPlacesModels));


            //address binding
            AddressModel addressModel= (AddressModel) new AddressMapper().mapList(addressDao.procAddress(new AddressModel(roomDetailModel.getAddressId()),null,"s")).get(0);
            addressResource.lowerToUpperNode(addressModel);
            addressModel.setAddress(null);
            addressModel=new AddressMapper().mapRowSetNull(false,false,true,true,true,addressModel);
            roomDetailModel.setAddress(addressModel);

            // hotel image binding
            HotelImageModel hotelImageModel = new HotelImageModel();
            hotelImageModel.setImageUrl("http://192.168.8.4:8080/TPSResources/HotelImages/"+ ((HotelImageModel) new HotelImageMapper().mapList(hotelImageDao.
                    procHotelImage(new HotelImageModel(null, roomDetailModel.getHotelDetailId(), null, null, "Y", null, null, "Y"), null, "s")).get(0)).getImageUrl());

               roomDetailModel.setHotelImage(hotelImageModel);
         //   roomDetailModel.setHotelImage( new HotelImageMapper().mapList(hotelImageDao.procHotelImage(new HotelImageModel(null,roomDetailModel.getHotelDetailId(),null,null,null,null,null,"Y"),null,"s")).get(0));

            System.out.println(roomDetailModel.getHotelDetailId()+roomDetailModel.getRoomDetailId());

           roomDetailModel.setHotelDetailId(new Encryption().encrypt(roomDetailModel.getHotelDetailId()));
           roomDetailModel.setRoomDetailId(new Encryption().encrypt(roomDetailModel.getRoomDetailId()));

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

        String hotelDetailid=new Encryption().decrypt(hotelFilterModel.getHotelDetailId());

        HotelDetailModel hotelDetailModel= (HotelDetailModel) new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(hotelDetailid,null),null,"s")).get(0);

         /*       new HotelDetailMapper().mapRowSetNull(true,false,false,false,false,false,false,false,false,false,true,true,true,true,
                                                       new HotelDetailMapper().mapList(hotelDetailDao.procHotelDetail(new HotelDetailModel(hotelDetailid,null),null,"s")).get(0)) ;
*/
       System.out.println(hotelDetailModel.toString());

        // hotelfeature binding
        HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();
        hotelFeatureModel.setHotelDetailId(hotelDetailid);
        hotelFeatureModel = (HotelFeatureModel) new HotelFeatureMapper().mapList(hotelFeatureDao.procHotelFeature(hotelFeatureModel, null, "s")).get(0);
        hotelDetailModel.setHotelFeature(new HotelFeatureMapper().mapRowSetNull(true, false, false, false, false, true, true, hotelFeatureModel));

        // Hotel activity binding
        HotelActivityModel hotelActivityModel = new HotelActivityModel();
        hotelActivityModel.setHotelDetailId(hotelDetailid);
        hotelActivityModel.setActive("Y");
        List<HotelActivityModel> hotelActivityModels = new HotelActivityMapper().mapList(hotelActivityDao.procHotelActivity(hotelActivityModel, null, "s"));
        hotelDetailModel.setHotelActivityList(new HotelActivityMapper().mapListSetNull(false, true, false, false, true, true, false, false, false, hotelActivityModels));

        //hotel Image binding
        List<HotelImageModel> hotelImageModels=new HotelImageMapper().mapList(hotelImageDao.
                procHotelImage(new HotelImageModel(null,hotelDetailid,null,null,null,null,null,"Y"),null,"s"));
        hotelDetailModel.setHotelImageList(new HotelImageMapper().mapListSetNull(true,true,false,true,false,true,false,true,false,hotelImageModels));


        // nearest places binding
        List<NearPlacesModel> nearPlacesModels= new NearPlacesMapper().mapList(nearPlacesDao.procNearPlaces(new NearPlacesModel(hotelDetailid), null, "s"));
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


        List<RoomDetailModel> roomDetailModels = new RoomDetailMapper().mapList(roomFilterDao.procRoomFilter(new Encryption().decrypt(hotelFilterModel.getHotelDetailId()),
                hotelFilterModel.getCheckInDate(),hotelFilterModel.getCheckOutDate(),hotelFilterModel.getNoOfRooms(),hotelFilterModel.getNoOfAdult(),
                hotelFilterModel.getNoOfChild(),hotelFilterModel.getChildAges(),hotelFilterModel.getAmenities()));


        for (RoomDetailModel roomDetailModel:roomDetailModels){
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
            roomDetailModel.setRoomImageList(new RoomImageMapper().mapListSetNull(true,true,false,true,false,true,false,true,false,roomImageModels));

            // room importance binding

            List<RoomImportanceModel> roomImportanceModels= new RoomImportanceMapper().mapList(roomImportanceDao.
                    procRoomImportance(new RoomImportanceModel(null,null,roomDetailModel.getRoomDetailId(),"Y",null), null, "s"));
            roomDetailModel.setRoomImportanceList(new RoomImportanceMapper().mapListSetNull(true,true,true,true,false,true,roomImportanceModels));


            //offer binding
            if (roomDetailModel.getOfferId()!=null){
                roomDetailModel.setOffer((OfferModel) new OfferMapper().mapListSetNull(true, false, true, true, true, false, false,
                        new OfferMapper().mapList(offerDao.procOffer(new OfferModel(roomDetailModel.getRoomDetailId()), null, "s"))).get(0));
            }

            roomDetailModel.setRoomDetailId(new Encryption().encrypt(roomDetailModel.getRoomDetailId()));

        }

        hotelDetailModel.setRoomDetailList(roomDetailModels);

        hotelDetailModel =   new HotelDetailMapper().mapRowSetNull(true,false,false,false,false,false,false,false,false,false,true,true,true,true,hotelDetailModel) ;


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

        hotelFilterModel.setSearchValue("113");
        hotelFilterModel.setCheckInDate("2017-11-1");
        hotelFilterModel.setCheckOutDate("2017-11-2");
        hotelFilterModel.setNoOfRooms("1");
        hotelFilterModel.setNoOfAdult("1");
        hotelFilterModel.setNoOfChild("1");
        hotelFilterModel.setChildAges("1");


        System.out.println(filterMainHotelAreaDao.procFilterMainHotelArea(hotelFilterModel));

        hotelFilterModel=new HotelFilterModel();

        System.out.println(filterAdvanceDao.procFilterAdvance(hotelFilterModel));


        return  null;

    }


}
