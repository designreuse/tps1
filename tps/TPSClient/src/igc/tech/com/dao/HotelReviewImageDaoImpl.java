package igc.tech.com.dao;

import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.HotelReviewImageModel;
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
public class HotelReviewImageDaoImpl extends JdbcTemplate implements HotelReviewImageDao {

    @Override
    public List procHotelReviewImage(HotelReviewImageModel hotelReviewImageModel, String user, String flag) {


        String procName = "proc_hotel_review_image";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_review_image_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_review_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_image", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_hotel_review_image_id", hotelReviewImageModel.getHotelReviewImageId());
        inp.put("in_hotel_review_id", hotelReviewImageModel.getHotelReviewId());
        inp.put("in_image", hotelReviewImageModel.getImage());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
