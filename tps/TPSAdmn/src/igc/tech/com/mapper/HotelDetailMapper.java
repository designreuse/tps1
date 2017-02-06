package igc.tech.com.mapper;

import igc.tech.com.model.HotelDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelDetailMapper {

    public List<HotelDetailModel> mapList(List<Map> list) {

        List<HotelDetailModel> resultList = new ArrayList<>();

        HotelDetailModel hotelDetailModel;

        for (Map m : list) {
            hotelDetailModel = mapRow(m);
            resultList.add(hotelDetailModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    public HotelDetailModel mapRow(Map map) {


      //  System.out.println("test:" + map);

        HotelDetailModel hotelDetailModel = new HotelDetailModel();

        hotelDetailModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID").toString());
        hotelDetailModel.setHotelName(map.get("HOTEL_NAME").toString());
        hotelDetailModel.setHotelPhNo1(map.get("HOTEL_PH_NO_1").toString());
        hotelDetailModel.setHotelPhNo2(map.get("HOTEL_PH_NO_1").toString());
        hotelDetailModel.setHotelPhNo3(map.get("HOTEL_PH_NO_1").toString());
        hotelDetailModel.setHotelAddress(map.get("HOTEL_ADDRESS").toString());
        hotelDetailModel.setHotelEmailId(map.get("HOTEL_EMAIL_ID").toString());
      /*  hotelDetailModel.setPersonalDetail(map.get("PERSONAL_DETAIL").toString());
        hotelDetailModel.setPersonalPhNo(map.get("PERSONAL_PH_NO").toString());*/
      /*  hotelDetailModel.setPersonalEmailId(map.get("PERSONAL_EMAIL_ID").toString());*/
       /* hotelDetailModel.setRegionId(map.get("REGION_ID").toString());*/
        hotelDetailModel.setUrl(map.get("URL").toString());
        hotelDetailModel.setRegionName(map.get("REGION_NAME").toString());
      /*  hotelDetailModel.setCountryId(map.get("COUNTRY_ID").toString());*/
        hotelDetailModel.setAreaId(map.get("AREA_ID").toString());
        hotelDetailModel.setClientDetailId(map.get("CLIENT_DETAIL_ID").toString());
        hotelDetailModel.setCountryName(map.get("COUNTRY_NAME").toString());
        hotelDetailModel.setAreaName(map.get("area_name").toString());


        return hotelDetailModel;
    }

}
