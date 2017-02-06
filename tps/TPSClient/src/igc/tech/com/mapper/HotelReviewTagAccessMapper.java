package igc.tech.com.mapper;

import igc.tech.com.model.HotelReviewTagAccessModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelReviewTagAccessMapper {


    public List<HotelReviewTagAccessModel> mapList(List<Map> list) {

        List<HotelReviewTagAccessModel> resultList = new ArrayList<>();

        HotelReviewTagAccessModel hotelReviewTagAccessModel;

        for (Map m : list) {
            hotelReviewTagAccessModel = mapRow(m);
            resultList.add(hotelReviewTagAccessModel);
        }



        return resultList;
    }

    public HotelReviewTagAccessModel mapRow(Map map) {

        HotelReviewTagAccessModel hotelReviewTagAccessModel = new HotelReviewTagAccessModel();

        hotelReviewTagAccessModel.setHotelReviewTagAccessId(map.get("hotel_review_tag_access_id")==null? null:map.get("hotel_review_tag_access_id").toString() );
        hotelReviewTagAccessModel.setHotelReviewId(map.get("hotel_review_id")==null? null:map.get("hotel_review_id").toString());
        hotelReviewTagAccessModel.setHotelReviewTagId(map.get("hotel_review_tag_id")==null? null:map.get("hotel_review_tag_id").toString());
        hotelReviewTagAccessModel.setTagDesc(map.get("tag_desc")==null? null:map.get("tag_desc").toString());

        return hotelReviewTagAccessModel;


    }
}
