package igc.tech.com.mapper;

import igc.tech.com.model.HotelFeatureModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelFeatureMapper {

    public List<HotelFeatureModel> mapList(List<Map> list) {

        List<HotelFeatureModel> resultList = new ArrayList<>();

        HotelFeatureModel hotelFeatureModel;

        for (Map m : list) {
            hotelFeatureModel = mapRow(m);
            resultList.add(hotelFeatureModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    public HotelFeatureModel mapRow(Map map) {


      //  System.out.println("test:" + map);

        HotelFeatureModel hotelFeatureModel = new HotelFeatureModel();


        hotelFeatureModel.setHotelFeatureId(map.get("hotel_feature_id")==null?null:map.get("hotel_feature_id").toString());
        hotelFeatureModel.setCheckInFrom(map.get("check_in_from")==null?null:map.get("check_in_from").toString());
        hotelFeatureModel.setCheckInTo(map.get("check_in_to")==null?null:map.get("check_in_to").toString());
        hotelFeatureModel.setCheckOutFrom(map.get("check_out_from")==null?null:map.get("check_out_from").toString());
        hotelFeatureModel.setCheckOutTo(map.get("check_out_to")==null?null:map.get("check_out_to").toString());
        hotelFeatureModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID")==null?null:map.get("HOTEL_DETAIL_ID").toString());
        hotelFeatureModel.setActive(map.get("active")==null?null:map.get("active").toString());


        return hotelFeatureModel;
    }


    public HotelFeatureModel mapRowSetNull(boolean hotelFeaureId,
                                             boolean checkInFrom,
                                             boolean checkInTo,
                                             boolean checkOutFrom,
                                             boolean checkOutTo,
                                           boolean hotelDetailId,
                                             boolean active,
                                             HotelFeatureModel hotelFeatureModel) {


        if (hotelFeaureId == true) {

            hotelFeatureModel.setHotelFeatureId(null);
        }
        if (checkInFrom == true) {

            hotelFeatureModel.setCheckInFrom(null);
        }
        if (checkInTo == true) {

            hotelFeatureModel.setCheckInTo(null);
        }
        if (checkOutFrom == true) {

            hotelFeatureModel.setCheckOutFrom(null);
        }
        if (checkOutTo == true) {

            hotelFeatureModel.setCheckOutTo(null);
        }

        if (hotelDetailId == true) {

            hotelFeatureModel.setHotelDetailId(null);
        }

        if (active == true) {

            hotelFeatureModel.setActive(null);
        }
        return hotelFeatureModel;
    }

    public List<HotelFeatureModel> mapListSetNull(boolean hotelFeaureId,
                                                  boolean checkInFrom,
                                                  boolean checkInTo,
                                                  boolean checkOutFrom,
                                                  boolean checkOutTo,
                                                  boolean hotelDetailId,
                                                  boolean active,
                                                    List<HotelFeatureModel> hotelFeatureModels) {

        for (HotelFeatureModel hotelFeatureModel: hotelFeatureModels) {

            hotelFeatureModel = mapRowSetNull(hotelFeaureId,checkInFrom,checkInTo,checkOutFrom,checkOutTo,hotelDetailId, active, hotelFeatureModel);

        }

        return hotelFeatureModels;
    }

}