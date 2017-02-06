package igc.tech.com.mapper;

import igc.tech.com.model.HotelReviewReplyModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelReviewReplyMapper {


    public List<HotelReviewReplyModel> mapList(List<Map> list) {

        List<HotelReviewReplyModel> resultList = new ArrayList<>();

        HotelReviewReplyModel hotelReviewReplyModel;

        for (Map m : list) {
            hotelReviewReplyModel = mapRow(m);
            resultList.add(hotelReviewReplyModel);
        }



        return resultList;
    }

    public HotelReviewReplyModel mapRow(Map map) {

        HotelReviewReplyModel hotelReviewReplyModel = new HotelReviewReplyModel();

        hotelReviewReplyModel.setHotelReviewReplyId(map.get("hotel_review_reply_id")==null? null:map.get("hotel_review_reply_id").toString() );
        hotelReviewReplyModel.setHotelReviewId(map.get("hotel_review_id")==null? null:map.get("hotel_review_id").toString());
        hotelReviewReplyModel.setReply(map.get("reply")==null? null:map.get("reply").toString());
        hotelReviewReplyModel.setReplyBy(map.get("reply_by")==null? null:map.get("reply_by").toString());
        hotelReviewReplyModel.setReplyDate(map.get("reply_date")==null? null:map.get("reply_date").toString());

        return hotelReviewReplyModel;


    }
}
