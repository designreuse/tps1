package igc.tech.com.mapper;

import igc.tech.com.model.HotelActivityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelActivityMapper {


    public List<HotelActivityModel> mapList(List<Map> list) {

        List<HotelActivityModel> resultList = new ArrayList<>();

        HotelActivityModel hotelActivityModel;

        for (Map m : list) {
            hotelActivityModel = mapRow(m);
            resultList.add(hotelActivityModel);
        }



        return resultList;
    }

    public HotelActivityModel mapRow(Map map) {

        HotelActivityModel hotelActivityModel = new HotelActivityModel();


        hotelActivityModel.setHotelActivityId(map.get("hotel_activity_id")==null? null : map.get("hotel_activity_id").toString());
        hotelActivityModel.setHotelDetailId(map.get("hotel_detail_id")==null? null : map.get("hotel_detail_id").toString());
        hotelActivityModel.setActivityId(map.get("activity_id")==null? null : map.get("activity_id").toString());
        hotelActivityModel.setType(map.get("type")==null? null : map.get("type").toString());
        hotelActivityModel.setActive(map.get("active")==null? null : map.get("active").toString());
        hotelActivityModel.setParentActivityId(map.get("parent_activity_id")==null? null : map.get("parent_activity_id").toString());
        hotelActivityModel.setActivityDesc(map.get("activity_desc")==null? null: map.get("activity_desc").toString());
        hotelActivityModel.setChargeOption(map.get("charge_option")==null? null: map.get("charge_option").toString());
        hotelActivityModel.setParentActivityDesc(map.get("parent_activity_desc")==null? null: map.get("parent_activity_desc").toString());
        hotelActivityModel.setActivityList(map.get("activity_list")==null? null: map.get("activity_list").toString());



        return hotelActivityModel;


    }
}
