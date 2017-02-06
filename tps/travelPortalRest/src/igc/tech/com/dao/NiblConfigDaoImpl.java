package igc.tech.com.dao;

import igc.tech.com.model.NiblConfigModel;
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
public class NiblConfigDaoImpl extends JdbcTemplate implements NiblConfigDao {

    @Override
    public List procNiblConfig(NiblConfigModel niblConfigModel, String user, String flag) {


        String procName = "proc_nibl_config";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_nibl_config_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_band_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_mode", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_payee_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_currency", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_return_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_cg", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user_lang_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_app_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_nibl_config_id", niblConfigModel.getNiblConfigId());
        inp.put("in_band_id", niblConfigModel.getBandId());
        inp.put("in_mode", niblConfigModel.getMode());
        inp.put("in_payee_id", niblConfigModel.getPayeeId());
        inp.put("in_currency", niblConfigModel.getCurrency());
        inp.put("in_return_url", niblConfigModel.getReturnUrl());
        inp.put("in_cg", niblConfigModel.getCg());
        inp.put("in_user_lang_id", niblConfigModel.getUserLangId());
        inp.put("in_user_type", niblConfigModel.getUserType());
        inp.put("in_app_type", niblConfigModel.getAppType());
        inp.put("in_type", niblConfigModel.getType());
        inp.put("in_active", niblConfigModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
