package igc.tech.com.dao;

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
public class HotelReviewSortingDaoImpl extends JdbcTemplate implements HotelReviewSortingDao {

    @Override
    public List procHotelReviewSorting(HotelReviewModel hotelReviewModel, String flag) {


        String procName = "proc_hotel_review_sorting";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_tag_sorting", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_page_no", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_off_set", Types.NUMERIC));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_hotel_detail_id", hotelReviewModel.getHotelDetailId());
        inp.put("in_tag_sorting", hotelReviewModel.getTagSorting());
        inp.put("in_page_no", hotelReviewModel.getPageNo());
        inp.put("in_off_set", hotelReviewModel.getOffSet());

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
