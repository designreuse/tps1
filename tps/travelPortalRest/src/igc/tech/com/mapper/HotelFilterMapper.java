package igc.tech.com.mapper;

import igc.tech.com.model.AddressModel;
import igc.tech.com.model.HotelFilterModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelFilterMapper {


  /*  public List<HotelFilterModel> mapList(List<Map> list) {

        List<HotelFilterModel> resultList = new ArrayList<>();

        HotelFilterModel hotelFilterModel;

        for (Map m : list) {
            hotelFilterModel = mapRow(m);
            resultList.add(hotelFilterModel);
        }
,


        return resultList;
    }*/

    public HotelFilterModel mapRow(Map<String, Object> map) {

        HotelFilterModel hotelFilterModel=new HotelFilterModel();

      // for room detail
       //   String keyName2 = map.keySet().toArray()[0].toString();
        List<Map> mapList1=  (ArrayList<Map>) map.get("#result-set-1");
        hotelFilterModel.setRoomDetailList(new RoomDetailMapper().mapList(mapList1));  ;
       // **

        //  for total count of hotel
        //   String keyName1 = map.keySet().toArray()[1].toString();
        List<Map> mapList2=   (ArrayList<Map>) map.get("#result-set-2");
        Map map1=mapList2.get(0);
        hotelFilterModel.setTotalHotels(map1.get("total_hotels")==null?null:map1.get("total_hotels").toString());
        hotelFilterModel.setOverPage(map1.get("over_page")==null?null:map1.get("over_page").toString());
        hotelFilterModel.setSearchKey(map1.get("search_key")==null?null:map1.get("search_key").toString());
        hotelFilterModel.setCurrencyDesc(map1.get("currency_desc")==null?null:map1.get("currency_desc").toString());

        // **

     /*   // for hotel activity
        //   String keyName2 = map.keySet().toArray()[0].toString();
        List<Map> mapList3=  (ArrayList<Map>) map.get("#result-set-3");
        hotelFilterModel.setActivityList(new ActivityMapper().mapList(mapList3));  ;
        // **

        // for room amenity
        //   String keyName2 = map.keySet().toArray()[0].toString();
        List<Map> mapList4=  (ArrayList<Map>) map.get("#result-set-4");
        hotelFilterModel.setAmenityList(new AmenityMapper().mapList(mapList4));  ;
        // **
*/
        // for star rating
        //   String keyName2 = map.keySet().toArray()[0].toString();
        List<Map> mapList5=  (ArrayList<Map>) map.get("#result-set-3");
        hotelFilterModel.setStarList(new HotelDetailMapper().mapList(mapList5));  ;
        // **

        return hotelFilterModel;


    }

  /*  public AddressModel mapRowSetNull(boolean addressId,
                                    boolean addressName,
                                    boolean parentAddressId,
                                    boolean type,
                                    boolean level,

                                    AddressModel addressModel) {


        if (addressId == true) {

            addressModel.setAddressId(null);
        }
        if (addressName == true) {

            addressModel.setAddressName(null);
        }
        if (parentAddressId == true) {

            addressModel.setParentAddressId(null);
        }
        if (type == true) {

            addressModel.setType(null);
        }
        if (level == true) {

            addressModel.setLevel(null);
        }


        return addressModel;
    }

    public List<AddressModel> mapListSetNull(boolean addressId,
                                             boolean addressName,
                                             boolean parentAddressId,
                                             boolean type,
                                             boolean level,
                                           List<AddressModel> addressModels) {

        for (AddressModel addressModel: addressModels) {

            addressModel = mapRowSetNull(addressId,addressName,parentAddressId,type,level, addressModel);

        }



        return addressModels;
    }*/
}