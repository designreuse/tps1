package igc.tech.com.dao;

import igc.tech.com.model.HotelBookingModel;
import igc.tech.com.model.HotelFilterModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FilterMainHotelAreaDaoImpl extends JdbcTemplate implements FilterMainHotelAreaDao {

    @Override
    public List procFilterMainHotelArea(HotelFilterModel hotelFilterModel) {


        String procName = "proc_filter_main_hotel_area";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_search_value", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_in_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_no_of_rooms", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_adult", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_child", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_ages", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_page_no", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_off_set", Types.NUMERIC));


        Map<String, Object> inp = new HashMap<String, Object>();


        inp.put("in_search_value", hotelFilterModel.getSearchValue());
        inp.put("in_check_in_date", hotelFilterModel.getCheckInDate());
        inp.put("in_check_out_date", hotelFilterModel.getCheckOutDate());
        inp.put("in_no_of_rooms", hotelFilterModel.getNoOfRooms());
        inp.put("in_no_of_adult", hotelFilterModel.getNoOfAdult());
        inp.put("in_no_of_child", hotelFilterModel.getNoOfChild());
        inp.put("in_child_ages", hotelFilterModel.getChildAges());

        inp.put("in_page_no", hotelFilterModel.getPageNo());
        inp.put("in_off_set", hotelFilterModel.getOffSet());

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }
}
