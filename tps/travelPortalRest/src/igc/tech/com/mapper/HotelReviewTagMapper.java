package igc.tech.com.mapper;

import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.HotelReviewTagModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelReviewTagMapper {


    public List<HotelReviewTagModel> mapList(List<Map> list) {

        List<HotelReviewTagModel> resultList = new ArrayList<>();

        HotelReviewTagModel hotelReviewTagModel;

        for (Map m : list) {
            hotelReviewTagModel = mapRow(m);
            resultList.add(hotelReviewTagModel);
        }



        return resultList;
    }

    public HotelReviewTagModel mapRow(Map map) {

        HotelReviewTagModel hotelReviewTagModel = new HotelReviewTagModel();

        hotelReviewTagModel.setHotelReviewTagId(map.get("hotel_review_tag_id")==null? null:map.get("hotel_review_tag_id").toString() );
        hotelReviewTagModel.setTagDesc(map.get("tag_desc")==null? null:map.get("tag_desc").toString());

        return hotelReviewTagModel;


    }
}
