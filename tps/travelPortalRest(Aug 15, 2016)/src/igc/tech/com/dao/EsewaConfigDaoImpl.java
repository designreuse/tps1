package igc.tech.com.dao;

import igc.tech.com.model.EsewaConfigModel;
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
public class EsewaConfigDaoImpl extends JdbcTemplate implements EsewaConfigDao {

    @Override
    public List procEsewaConfig(EsewaConfigModel esewaConfigModel, String user, String flag) {


        String procName = "proc_esewa_config";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_esewa_config_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_service_code", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_success_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_fail_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_interface_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_verify_api_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_esewa_config_id", esewaConfigModel.getEsewaConfigId());
        inp.put("in_service_code", esewaConfigModel.getServiceCode());
        inp.put("in_success_url", esewaConfigModel.getSuccessUrl());
        inp.put("in_fail_url", esewaConfigModel.getFailUrl());
        inp.put("in_interface_url", esewaConfigModel.getInterfaceUrl());
        inp.put("in_verify_api_url", esewaConfigModel.getVerifyApiUrl());
        inp.put("in_type", esewaConfigModel.getType());
        inp.put("in_active", esewaConfigModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
