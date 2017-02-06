package igc.tech.com.dao;

import igc.tech.com.model.RoomImportanceModel;
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
    public List procRoomImportance(RoomImportanceModel roomImportanceModel,
                                   String user, String flag) {


        String procName = "proc_room_importance";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_importance_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_rules_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("in_room_importance_id", roomImportanceModel.getRoomImportanceId());
        inp.put("in_rules_id", roomImportanceModel.getRulesId());
        inp.put("in_room_detail_id", roomImportanceModel.getRoomDetailId());
        inp.put("in_active", roomImportanceModel.getActive());
        inp.put("in_hotel_detail_id", roomImportanceModel.getHotelDetailId());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
