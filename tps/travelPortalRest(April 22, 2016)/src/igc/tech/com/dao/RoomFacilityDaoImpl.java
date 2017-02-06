package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class RoomFacilityDaoImpl extends JdbcTemplate implements RoomFacilityDao {

    @Override
    public List procRoomFacility(String roomFacilityId, String roomTypeId, String facilityId, String active,
                                 String user, String flag) {


        String procName = "proc_room_facility";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_room_facility_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_facility_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_room_facility_ID", roomFacilityId);
        inp.put("in_room_type_id", roomTypeId);
        inp.put("in_facility_id", facilityId);
        inp.put("in_active", active);
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
