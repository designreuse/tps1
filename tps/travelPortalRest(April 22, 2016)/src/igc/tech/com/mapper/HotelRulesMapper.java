package igc.tech.com.mapper;

import igc.tech.com.model.HotelRulesModel;
import igc.tech.com.model.ImageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelRulesMapper {

    public List<HotelRulesModel> mapList(List<Map> list) {

        List<HotelRulesModel> resultList = new ArrayList<>();

        HotelRulesModel hotelRulesModel;

        for (Map m : list) {
            hotelRulesModel = mapRow(m);
            resultList.add(hotelRulesModel);
        }


        return resultList;
    }

    public HotelRulesModel mapRow(Map map) {

        HotelRulesModel hotelRulesModel= new HotelRulesModel();

        if (map.get("HOTEL_RULES_ID") != null) {
            hotelRulesModel.setHotelRulesId(map.get("HOTEL_RULES_ID").toString());

        }

        if (map.get("HOTEL_DETAIL_ID") != null) {
            hotelRulesModel.setHotelDetailid(map.get("HOTEL_DETAIL_ID").toString());

        }

        if (map.get("HOTEL_NAME") != null) {
            hotelRulesModel.setHotelName(map.get("HOTEL_NAME").toString());

        }

        if (map.get("RULES_ID") != null) {
            hotelRulesModel.setRulesId(map.get("RULES_ID").toString());

        }
        if (map.get("RULES_DESC") != null) {
            hotelRulesModel.setRulesDesc(map.get("RULES_DESC").toString());

        }
        return hotelRulesModel;
    }





}
