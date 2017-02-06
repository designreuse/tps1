package igc.tech.com.dao;

import igc.tech.com.model.PushContentDataModel;
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
public class PushContentDataDaoImpl extends JdbcTemplate implements PushContentDataDao {

    @Override
    public List procPushContentData(PushContentDataModel pushContentDataModel, String user, String flag) {


        String procName = "proc_push_content_data";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_push_content_data_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_status", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_remarks", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_push_content_data_id", pushContentDataModel.getPushContentDataId());
        inp.put("in_hotel_detail_id", pushContentDataModel.getHotelDetailId());
        inp.put("in_status", pushContentDataModel.getStatus());
        inp.put("in_remarks", pushContentDataModel.getRemarks());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
