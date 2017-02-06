package igc.tech.com.mapper;

import igc.tech.com.model.HotelRulesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelRulesMapper {

    @SuppressWarnings("rawtypes")
    public List<HotelRulesModel> mapList(List<Map> list) {

        List<HotelRulesModel> resultList = new ArrayList<>();

        HotelRulesModel hotelRulesModel;

        for (Map m : list) {
            hotelRulesModel = mapRow(m);
            resultList.add(hotelRulesModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public HotelRulesModel mapRow(Map map) {

        HotelRulesModel hotelRulesModel = new HotelRulesModel();

        hotelRulesModel.setHotelRulesId(map.get("hotel_rules_id")==null? null : map.get("hotel_rules_id").toString());
        hotelRulesModel.setRulesId(map.get("rules_id")==null? null : map.get("rules_id").toString());
        hotelRulesModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID")==null ? null :map.get("HOTEL_DETAIL_ID").toString());
        hotelRulesModel.setHotelName(map.get("HOTEL_NAME")==null ? null :map.get("HOTEL_NAME").toString());
        hotelRulesModel.setActive(map.get("active")==null ? null :map.get("active").toString());
        hotelRulesModel.setRulesDesc(map.get("rules_desc")==null? null:map.get("rules_desc").toString());

        return hotelRulesModel;
    }

}
