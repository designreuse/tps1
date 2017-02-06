package igc.tech.com.dao;

import igc.tech.com.model.EmailTpsModel;
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
public class EmailTpsDaoImpl extends JdbcTemplate implements EmailTpsDao {

    @Override
    public List procEmailTps(EmailTpsModel emailTpsModel, String user, String flag) {


        String procName = "proc_email_tps";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_email_tps_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_email_address", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_email_tps_id", emailTpsModel.getEmailTpsId());
        inp.put("in_email_address", emailTpsModel.getEmailAddress());
        inp.put("in_active", emailTpsModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
