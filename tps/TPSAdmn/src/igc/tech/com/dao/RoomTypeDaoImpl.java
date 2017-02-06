package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomTypeDaoImpl extends JdbcTemplate implements RoomTypeDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procRoomType(String roomTypeId, String hotelDetailId, String roomCatetoryId, String bedTypeId, String roomDesc, String initialRate,
                             String maxAdult, String maxChild, String extraBedCharge, String push, String user, String flag) {


        String procName = "proc_room_type";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_ROOM_TYPE_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_DETAIL_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ROOM_CATEGORY_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_BED_TYPE_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ROOM_DESC", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_INITIAL_RATE", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_MAX_ADULT", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_MAX_CHILD", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_EXTRA_BED_CHARGE", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_PUSH", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_ROOM_TYPE_ID", roomTypeId);
        inp.put("IN_HOTEL_DETAIL_ID", hotelDetailId);
        inp.put("IN_ROOM_CATEGORY_ID", roomCatetoryId);
        inp.put("IN_BED_TYPE_ID", bedTypeId);
        inp.put("IN_ROOM_DESC", roomDesc);
        inp.put("IN_INITIAL_RATE", initialRate);
        inp.put("IN_MAX_ADULT", maxAdult);
        inp.put("IN_MAX_CHILD", maxChild);
        inp.put("IN_EXTRA_BED_CHARGE", extraBedCharge);
        inp.put("IN_PUSH", push);
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);
        System.out.println("resultMap "+resultMap);
        String keyName = resultMap.keySet().toArray()[0].toString();
        System.out.println("key Name "+keyName);

        return (ArrayList<Map>) resultMap.get(keyName);



    }

}
