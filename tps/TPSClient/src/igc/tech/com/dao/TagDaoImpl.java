package igc.tech.com.dao;

import igc.tech.com.model.TagModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TagDaoImpl extends JdbcTemplate implements TagDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/

    @SuppressWarnings("unchecked")
    @Override
    public List procTag(TagModel tagModel, String user, String flag) {


        //		String packageName="UTILITIES";
        String procName = "proc_tag";
        SimpleJdbcCall call = new SimpleJdbcCall(this);


        //		call=call.withCatalogName(packageName);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_tag_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_tag_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();
        inp.put("in_flag", flag);
        inp.put("in_tag_id", tagModel.getTagId());
        inp.put("in_description", tagModel.getDescription());
        inp.put("in_active", tagModel.getActive());
        inp.put("in_user", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);    /*get("#result-set-1");*/


    }


}
