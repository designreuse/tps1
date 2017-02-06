package igc.tech.com.dao;

import igc.tech.com.model.RegionModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionDaoImpl extends JdbcTemplate implements RegionDao {

    @Override
    public List procRegion(RegionModel regionModel, String user, String flag) {

        String procName = "proc_region";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_REGION_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_COUNTRY_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_REGION_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_REGION_ID", regionModel.getRegionId());
        inp.put("IN_COUNTRY_ID", regionModel.getCountryId());
        inp.put("IN_REGION_NAME", regionModel.getRegionName());
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
