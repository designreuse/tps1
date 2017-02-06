package igc.tech.com.dao;

import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.HotelReviewTagAccessModel;
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
public class HotelReviewTagAccessDaoImpl extends JdbcTemplate implements HotelReviewTagAccessDao {

    @Override
    public List procHotelReviewTagAccess(HotelReviewTagAccessModel hotelReviewTagAccessModel, String user, String flag) {

        String procName = "proc_hotel_review_tag_access";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_hotel_review_tag_access_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_review_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_review_tag_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("in_hotel_review_tag_access_id", hotelReviewTagAccessModel.getHotelReviewTagAccessId());
        inp.put("in_hotel_review_id", hotelReviewTagAccessModel.getHotelReviewId());
        inp.put("in_hotel_review_tag_id", hotelReviewTagAccessModel.getHotelReviewTagId());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
