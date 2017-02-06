package igc.tech.com.dao;

import igc.tech.com.model.HotelFilterModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilterAdvanceDaoImpl extends JdbcTemplate implements
        FilterAdvanceDao {


    @Override
    public Map<String, Object> procFilterAdvance(HotelFilterModel hotelFilterModel) {

      //  String procName = "proc_hotel_filter1";
        String procName = "proc_filter_advance";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);


        call.addDeclaredParameter(new SqlParameter("in_activities", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_amenities", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_from_price", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_to_price", Types.FLOAT));

        call.addDeclaredParameter(new SqlParameter("in_sorting_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_star_range", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_page_no", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_off_set", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_search_key", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();


        inp.put("in_activities", hotelFilterModel.getActivities());
        inp.put("in_amenities", hotelFilterModel.getAmenities());
        inp.put("in_from_price", hotelFilterModel.getFromPrice());
        inp.put("in_to_price", hotelFilterModel.getToPrice());

        inp.put("in_sorting_type", hotelFilterModel.getSortingType());
        inp.put("in_star_range", hotelFilterModel.getStarRange());
        inp.put("in_page_no", hotelFilterModel.getPageNo());
        inp.put("in_off_set", hotelFilterModel.getOffSet());
        inp.put("in_search_key", hotelFilterModel.getSearchKey());


         Map<String, Object> resultMap = call.execute(inp);

       /* System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        System.out.println(keyName);
*/
        return resultMap;



    }

}
