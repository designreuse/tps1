package igc.tech.com.mapper;

import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.HotelReviewImageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelReviewImageMapper {


    public List<HotelReviewImageModel> mapList(List<Map> list) {

        List<HotelReviewImageModel> resultList = new ArrayList<>();

        HotelReviewImageModel activityReviewImageModel;

        for (Map m : list) {
            activityReviewImageModel = mapRow(m);
            resultList.add(activityReviewImageModel);
        }



        return resultList;
    }

    public HotelReviewImageModel mapRow(Map map) {

        HotelReviewImageModel hotelReviewImageModel = new HotelReviewImageModel();


        hotelReviewImageModel.setHotelReviewImageId(map.get("hotel_review_image_id")==null? null:map.get("hotel_review_image_id").toString() );
        hotelReviewImageModel.setHotelReviewId(map.get("hotel_review_id")==null? null:map.get("hotel_review_id").toString());
        hotelReviewImageModel.setImage(map.get("image")==null? null:map.get("image").toString());

        return hotelReviewImageModel;


    }
}
