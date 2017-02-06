package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class RegionDaoImpl extends JdbcTemplate implements RegionDao {

    @Override
    public List procRegion(String regionId, String regionName,
                           String countryId, String user, String flag) {

        String procName = "proc_region";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_REGION_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_COUNTRY_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_REGION_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        System.out.println("here");

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_REGION_ID", regionId);
        inp.put("IN_COUNTRY_ID", countryId);
        inp.put("IN_REGION_NAME", regionName);
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
