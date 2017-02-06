package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class BedTypeDaoImpl extends JdbcTemplate implements
        BedTypeDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procBedType(String bedTypeId, String bedTypeDesc, String size, String user, String flag) {

        String procName = "proc_bed_type";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_BED_TYPE_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_bed_type_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_size", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_BED_TYPE_ID", bedTypeId);
        inp.put("in_bed_type_desc", bedTypeDesc);
        inp.put("in_size", size);
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

        // return (ArrayList<Map>) resultMap.get("OUT_DATA");

    }

}
