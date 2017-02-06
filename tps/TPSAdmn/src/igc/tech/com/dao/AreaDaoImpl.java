package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 2/9/2016.
 */
public class AreaDaoImpl extends JdbcTemplate implements AreaDao {
    @Override
    public List procArea(String areaId, String areaName, String regionId, String countryId,
                                    String user,
                                   String flag) {

        String procName = "proc_area";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
                call.addDeclaredParameter(new SqlParameter("IN_AREA_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_country_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_REGION_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_AREA_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_area_id",areaId);
        inp.put("in_country_id",countryId);
        inp.put("in_region_id",regionId);
        inp.put("in_area_name",areaName);
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);



    }
}
