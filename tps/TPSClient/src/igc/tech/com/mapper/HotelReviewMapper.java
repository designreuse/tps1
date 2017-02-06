package igc.tech.com.mapper;

import igc.tech.com.model.HotelReviewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HotelReviewMapper {


    public List<HotelReviewModel> mapList(List<Map> list) {

        List<HotelReviewModel> resultList = new ArrayList<>();

        HotelReviewModel  hotelReviewModel;

        for (Map m : list) {
            hotelReviewModel = mapRow(m);
            resultList.add(hotelReviewModel);
        }



        return resultList;
    }

    public HotelReviewModel mapRow(Map map) {

        HotelReviewModel hotelReviewModel= new HotelReviewModel();

        hotelReviewModel.setHotelReviewId(map.get("hotel_review_id")==null? null:map.get("hotel_review_id").toString());
        hotelReviewModel.setCustomerDetailId(map.get("customer_detail_id")==null? null:map.get("customer_detail_id").toString());
        hotelReviewModel.setHotelDetailId(map.get("hotel_detail_id")==null? null:map.get("hotel_detail_id").toString());
        hotelReviewModel.setHotelRatingCategoryId(map.get("hotel_rating_category_id")==null? null:map.get("hotel_rating_category_id").toString());
        hotelReviewModel.setTravelMonth(map.get("travel_month")==null? null:map.get("travel_month").toString());
        hotelReviewModel.setExpensive(map.get("expensive")==null? null:map.get("expensive").toString());
        hotelReviewModel.setImage(map.get("image")==null? null:map.get("image").toString());
      /*  hotelReviewModel.setStatus(map.get("status")==null? null:map.get("status").toString());
        hotelReviewModel.setMessage(map.get("msg")==null? null:map.get("msg").toString());
        hotelReviewModel.setId(map.get("id")==null? null:map.get("id").toString());*/
        hotelReviewModel.setApprove(map.get("approve")==null? null:map.get("approve").toString());
        hotelReviewModel.setTitle(map.get("title")==null? null:map.get("title").toString());
        hotelReviewModel.setReview(map.get("review")==null? null:map.get("review").toString());
        hotelReviewModel.setPositiveReview(map.get("positive_review")==null? null:map.get("positive_review").toString());
        hotelReviewModel.setNegativeReview(map.get("negative_review")==null? null:map.get("negative_review").toString());
        hotelReviewModel.setVisitPurpose(map.get("visit_purpose")==null? null:map.get("visit_purpose").toString());
        hotelReviewModel.setRating(map.get("rating")==null? null:map.get("rating").toString());
        hotelReviewModel.setRatingType(map.get("rating_type")==null? null:map.get("rating_type").toString());
        hotelReviewModel.setAverageRating(map.get("average_rating")==null? null:map.get("average_rating").toString());
        hotelReviewModel.setTotalReview(map.get("total_review")==null? null:map.get("total_review").toString());
        hotelReviewModel.setCreatedDate(map.get("created_date")==null? null:map.get("created_date").toString());
        hotelReviewModel.setName(map.get("name")==null? null:map.get("name").toString());

        return hotelReviewModel;


    }
}
