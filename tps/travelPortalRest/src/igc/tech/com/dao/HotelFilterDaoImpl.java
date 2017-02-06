package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.swing.text.Keymap;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelFilterDaoImpl extends JdbcTemplate implements
        HotelFilterDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Map<String, Object> procHotelFilter(String searchValue, String checkInDate, String checkOutDate,
                                   String noOfRooms, String noOfAdult,
                                  String noOfChild, String childAges, String activites, String amenities,
                                   String fromPrice, String toPrice, String type, String sortingType,String starRange, String pageNo, String offSet,String platform) {

      //  String procName = "proc_hotel_filter1";
        String procName = "proc_hotel_filter4";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_search_value", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_in_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_no_of_rooms", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_adult", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_child", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_ages", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_activities", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_amenities", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_from_price", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_to_price", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_sorting_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_star_range", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_page_no", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_off_set", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_platform", Types.VARCHAR));



        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("in_search_value", searchValue);
        inp.put("in_check_in_date", checkInDate);
        inp.put("in_check_out_date", checkOutDate);
        inp.put("in_no_of_rooms", noOfRooms);
        inp.put("in_no_of_adult", noOfAdult);
        inp.put("in_no_of_child", noOfChild);
        inp.put("in_child_ages", childAges);
        inp.put("in_activities", activites);
        inp.put("in_amenities", amenities);
        inp.put("in_from_price", fromPrice);
        inp.put("in_to_price", toPrice);

        inp.put("in_type", type);
        inp.put("in_sorting_type", sortingType);
        inp.put("in_star_range", starRange);
        inp.put("in_page_no", pageNo);
        inp.put("in_off_set", offSet);
        inp.put("in_platform", platform);

         Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        System.out.println(keyName);

        return resultMap;

        /* String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);*/


    }

}
