package igc.tech.com.dao;

import igc.tech.com.model.HotelActivityModel;
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
public class HotelActivityDaoImpl extends JdbcTemplate implements HotelActivityDao {

    @Override
    public List procHotelActivity(HotelActivityModel hotelActivityModel, String user, String flag) {


        String procName = "proc_hotel_activity";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_activity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_activity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_hotel_activity_id", hotelActivityModel.getHotelActivityId());
        inp.put("in_hotel_detail_id", hotelActivityModel.getHotelDetailId());
        inp.put("in_activity_id", hotelActivityModel.getActivityId());
        inp.put("in_type", hotelActivityModel.getType());
        inp.put("in_active", hotelActivityModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
