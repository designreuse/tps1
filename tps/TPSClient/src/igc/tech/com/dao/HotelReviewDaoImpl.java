package igc.tech.com.dao;

import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.HotelReviewModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class HotelReviewDaoImpl extends JdbcTemplate implements HotelReviewDao {

    @Override
    public List procHotelReview(HotelReviewModel hotelReviewModel, String user, String flag) {


        String procName = "proc_hotel_review";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_review_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_customer_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_rating_category_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_travel_month", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_expensive", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_approve", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_title", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_positive_review", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_negative_review", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_visit_purpose", Types.VARCHAR));


        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_hotel_review_id", hotelReviewModel.getHotelReviewId());
        inp.put("in_customer_detail_id", hotelReviewModel.getCustomerDetailId());
        inp.put("in_hotel_detail_id", hotelReviewModel.getHotelDetailId());
        inp.put("in_hotel_rating_category_id", hotelReviewModel.getHotelRatingCategoryId());
        inp.put("in_travel_month", hotelReviewModel.getTravelMonth());
        inp.put("in_expensive", hotelReviewModel.getExpensive());

        inp.put("in_approve", hotelReviewModel.getApprove());
        inp.put("in_title", hotelReviewModel.getTitle());
        inp.put("in_positive_review", hotelReviewModel.getPositiveReview());
        inp.put("in_negative_review", hotelReviewModel.getNegativeReview());
        inp.put("in_visit_purpose", hotelReviewModel.getVisitPurpose());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
