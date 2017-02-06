package igc.tech.com.dao;

import igc.tech.com.model.RoomRateModel;
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
public class RoomRateDaoImpl extends JdbcTemplate implements RoomRateDao {

    @Override
    public List procRoomRate(RoomRateModel roomRateModel, String user, String flag) {


        String procName = "proc_room_rate";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_rate_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_currency_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_rate", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_child_rate", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_adult_rate", Types.FLOAT));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_room_rate_id", roomRateModel.getRoomRateId());
        inp.put("in_room_detail_id", roomRateModel.getRoomDetailId());
        inp.put("in_currency_id", roomRateModel.getCurrencyId());
        inp.put("in_rate", roomRateModel.getRate());
        inp.put("in_child_rate", roomRateModel.getChildRate());
        inp.put("in_adult_rate", roomRateModel.getAdultRate());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
