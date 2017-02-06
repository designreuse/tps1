package igc.tech.com.mapper;

import igc.tech.com.model.HotelRatingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HotelRatingMapper {


    public List<HotelRatingModel> mapList(List<Map> list) {

        List<HotelRatingModel> resultList = new ArrayList<>();

        HotelRatingModel  hotelRatingModel;

        for (Map m : list) {
            hotelRatingModel = mapRow(m);
            resultList.add(hotelRatingModel);
        }



        return resultList;
    }

    public HotelRatingModel mapRow(Map map) {

        HotelRatingModel hotelRatingModel= new HotelRatingModel();

        hotelRatingModel.setHotelRatingId(map.get("hotel_rating_id")==null? null:map.get("hotel_rating_id").toString());
        hotelRatingModel.setHotelReviewId(map.get("hotel_review_id")==null? null:map.get("hotel_review_id").toString());
        hotelRatingModel.setHotelReviewCategoryId(map.get("hotel_review_category_id")==null? null:map.get("hotel_review_category_id").toString());
        hotelRatingModel.setHotelRatingCategoryId(map.get("hotel_rating_category_id")==null? null:map.get("hotel_rating_category_id").toString());
        hotelRatingModel.setCategoryDesc(map.get("category_desc")==null? null:map.get("category_desc").toString());
        hotelRatingModel.setRating(map.get("rating")==null? null:map.get("rating").toString());
        hotelRatingModel.setRatingType(map.get("rating_type")==null? null:map.get("rating_type").toString());
        hotelRatingModel.setTotalCount(map.get("total_count")==null? null:map.get("total_count").toString());


        return hotelRatingModel;


    }
}
