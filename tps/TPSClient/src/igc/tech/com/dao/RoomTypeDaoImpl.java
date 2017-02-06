package igc.tech.com.dao;

import igc.tech.com.model.RoomTypeModel;
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
public class RoomTypeDaoImpl extends JdbcTemplate implements RoomTypeDao {

    @Override
    public List procRoomType(RoomTypeModel roomTypeModel, String user, String flag) {


        String procName = "proc_room_type";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_parent_room_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_type_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_room_type_id", roomTypeModel.getRoomTypeId());
        inp.put("in_parent_room_type_id", roomTypeModel.getParentRoomTypeId());
        inp.put("in_room_type_desc", roomTypeModel.getRoomTypeDesc());
        inp.put("in_active", roomTypeModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
