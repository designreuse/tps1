package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomFilterDaoImpl extends JdbcTemplate implements
        RoomFilterDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procRoomFilter(String hotelDetailId, String checkInDate, String checkOutDate,
                                   String noOfRooms, String noOfAdult,
                                  String noOfChild, String childAges, String amenities) {

        String procName = "proc_room_filter";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);



        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_check_in_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_no_of_rooms", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_adult", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_child", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_ages", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_amenities", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("in_hotel_detail_id", hotelDetailId);
        inp.put("in_check_in_date", checkInDate);
        inp.put("in_check_out_date", checkOutDate);
        inp.put("in_no_of_rooms", noOfRooms);
        inp.put("in_no_of_adult", noOfAdult);
        inp.put("in_no_of_child", noOfChild);
        inp.put("in_child_ages", childAges);
        inp.put("in_amenities", amenities);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
