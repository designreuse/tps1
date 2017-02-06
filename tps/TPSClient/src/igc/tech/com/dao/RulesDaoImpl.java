package igc.tech.com.dao;

import igc.tech.com.model.RulesModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RulesDaoImpl extends JdbcTemplate implements RulesDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/

    @SuppressWarnings("unchecked")
    @Override
    public List procRules(RulesModel rulesModel, String user, String flag) {


        //		String packageName="UTILITIES";
        String procName = "proc_rules";
        SimpleJdbcCall call = new SimpleJdbcCall(this);


        //		call=call.withCatalogName(packageName);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_rules_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_rules_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();
        inp.put("in_flag", flag);
        inp.put("in_rules_id", rulesModel.getRulesId());
        inp.put("in_rules_desc", rulesModel.getRulesDesc());
        inp.put("in_type", rulesModel.getType());
        inp.put("in_hotel_detail_id", rulesModel.getHotelDetailId());
        inp.put("in_user", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();


        return (ArrayList<Map>) resultMap.get(keyName);


    }


}
