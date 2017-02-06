package igc.tech.com.mapper;

import igc.tech.com.model.HotelReviewCategoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HotelReviewCategoryMapper {


    public List<HotelReviewCategoryModel> mapList(List<Map> list) {

        List<HotelReviewCategoryModel> resultList = new ArrayList<>();

        HotelReviewCategoryModel  hotelReviewCategoryModel;

        for (Map m : list) {
            hotelReviewCategoryModel = mapRow(m);
            resultList.add(hotelReviewCategoryModel);
        }



        return resultList;
    }

    public HotelReviewCategoryModel mapRow(Map map) {

        HotelReviewCategoryModel hotelReviewCategoryModel= new HotelReviewCategoryModel();

        hotelReviewCategoryModel.setHotelReviewCategoryId(map.get("hotel_review_category_id")==null? null:map.get("hotel_review_category_id").toString());
        hotelReviewCategoryModel.setCategoryDesc(map.get("category_desc")==null? null:map.get("category_desc").toString());
        hotelReviewCategoryModel.setActive(map.get("active")==null? null:map.get("active").toString());
        hotelReviewCategoryModel.setAvgRating(map.get("avg_rating")==null? null:map.get("avg_rating").toString());
        hotelReviewCategoryModel.setRatingType(map.get("rating_type")==null? null:map.get("rating_type").toString());

        return hotelReviewCategoryModel;


    }
}
