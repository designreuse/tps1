package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FacilityDaoImpl extends JdbcTemplate implements FacilityDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/

    @SuppressWarnings("unchecked")
    @Override
    public List procFacility(String facilityId, String facilityDesc, String type, String icon, String image, String user, String flag) {


        //		String packageName="UTILITIES";
        String procName = "proc_facility";
        SimpleJdbcCall call = new SimpleJdbcCall(this);


        //		call=call.withCatalogName(packageName);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_facility_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_facility_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_icon", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_image", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();
        inp.put("in_flag", flag);
        inp.put("in_facility_id", facilityId);
        inp.put("in_facility_desc", facilityDesc);
        inp.put("in_type", type);
        inp.put("in_icon", icon);
        inp.put("in_image", image);
        inp.put("in_user", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();


        return (ArrayList<Map>) resultMap.get(keyName);


    }


}
