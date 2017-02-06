package igc.tech.com.dao;

import igc.tech.com.model.AmenityHighlightModel;
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
public class AmenityHighlightDaoImpl extends JdbcTemplate implements AmenityHighlightDao {

    @Override
    public List procAmenityHighlight(AmenityHighlightModel amenityHighlightModel, String user, String flag) {


        String procName = "proc_amenity_highlight";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_amenity_highlight_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_amenity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_priority", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_amenity_highlight_id", amenityHighlightModel.getAmenityHighlightId());
        inp.put("in_amenity_id", amenityHighlightModel.getAmenityId());
        inp.put("in_room_detail_id", amenityHighlightModel.getRoomDetailId());
        inp.put("in_priority", amenityHighlightModel.getPriority());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
