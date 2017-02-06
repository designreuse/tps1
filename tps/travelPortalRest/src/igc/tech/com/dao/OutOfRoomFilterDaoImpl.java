package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutOfRoomFilterDaoImpl extends JdbcTemplate implements
        OutOfRoomFilterDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procOoutOfRoomFilter(String roomDetailId, String checkInDate, String checkOutDate,
                                   String noOfRooms, String noOfAdult,
                                  String noOfChild, String childAges, String amenities,
                                   String fromPrice, String toPrice) {

        String procName = "proc_out_of_room_filter";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_check_in_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_no_of_rooms", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_adult", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_child", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_ages", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_amenities", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_from_price", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_to_price", Types.FLOAT));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("in_room_detail_id", roomDetailId);
        inp.put("in_check_in_date", checkInDate);
        inp.put("in_check_out_date", checkOutDate);
        inp.put("in_no_of_rooms", noOfRooms);
        inp.put("in_no_of_adult", noOfAdult);
        inp.put("in_no_of_child", noOfChild);
        inp.put("in_child_ages", childAges);
        inp.put("in_amenities", amenities);
        inp.put("in_from_price", fromPrice);
        inp.put("in_to_price", toPrice);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
