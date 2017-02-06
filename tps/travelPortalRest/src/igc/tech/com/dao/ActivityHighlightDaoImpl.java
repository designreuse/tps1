package igc.tech.com.dao;

import igc.tech.com.model.ActivityHighlightModel;
import igc.tech.com.model.ActivityModel;
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
public class ActivityHighlightDaoImpl extends JdbcTemplate implements ActivityHighlightDao {

    @Override
    public List procActivityHighlight(ActivityHighlightModel activityHighlightModel, String user, String flag) {


        String procName = "proc_activity_highlight";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_activity_highlight_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_activity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_priority", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("in_flag", flag);
        inp.put("in_activity_highlight_id", activityHighlightModel.getActivityHighlightId());
        inp.put("in_activity_id", activityHighlightModel.getActivityId());
        inp.put("in_priority", activityHighlightModel.getPriority());
        inp.put("in_hotel_detail_id", activityHighlightModel.getHotelDetailId());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
