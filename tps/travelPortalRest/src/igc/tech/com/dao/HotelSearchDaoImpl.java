package igc.tech.com.dao;

import igc.tech.com.model.HotelSearchModel;
import igc.tech.com.model.RoomDetailModel;
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
public class HotelSearchDaoImpl extends JdbcTemplate implements HotelSearchDao {

    @Override
    public List procHotelSearch(HotelSearchModel hotelSearchModel, String user, String flag) {


        String procName = "proc_hotel_search";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);


        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_search_value", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_in_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_date", Types.VARCHAR));



        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_search_value", hotelSearchModel.getSearchValue());
        inp.put("in_check_in_date", hotelSearchModel.getCheckInDate());
        inp.put("in_check_out_date", hotelSearchModel.getCheckOutDate());


        Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
