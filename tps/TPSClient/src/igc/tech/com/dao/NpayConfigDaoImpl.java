package igc.tech.com.dao;

import igc.tech.com.model.NpayConfigModel;
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
public class NpayConfigDaoImpl extends JdbcTemplate implements NpayConfigDao {

    @Override
    public List procNpayConfig(NpayConfigModel npayConfigModel, String user, String flag) {


        String procName = "proc_npay_config";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_npay_config_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_merchant_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_merchant_user_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_merchant_password", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_signature", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_interface_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_api_url", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_npay_config_id", npayConfigModel.getNpayConfigId());
        inp.put("in_merchant_id", npayConfigModel.getMerchantId());
        inp.put("in_merchant_user_name", npayConfigModel.getMerchantUserName());
        inp.put("in_merchant_password", npayConfigModel.getMerchantPassword());
        inp.put("in_signature", npayConfigModel.getSignature());
        inp.put("in_type", npayConfigModel.getType());
        inp.put("in_active", npayConfigModel.getActive());
        inp.put("in_interface_url", npayConfigModel.getInterfaceUrl());
        inp.put("in_api_url", npayConfigModel.getApiUrl());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
