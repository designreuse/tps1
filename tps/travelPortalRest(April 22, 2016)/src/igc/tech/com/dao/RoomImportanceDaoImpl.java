package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomImportanceDaoImpl extends JdbcTemplate implements RoomImportanceDao {

    @Override
    public List procRoomImportance(String roomImportanceId, String rulesId, String roomTypeId,
                                 String user, String flag) {


        String procName = "proc_room_importance";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_importance_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_rules_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_type_id", Types.NUMERIC));


        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("in_room_importance_id", roomImportanceId);
        inp.put("in_rules_id", rulesId);
        inp.put("in_room_type_id", roomTypeId);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
