package igc.tech.com.dao;

import igc.tech.com.model.PayGateAccessModel;
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
public class PayGateAccessDaoImpl extends JdbcTemplate implements PayGateAccessDao {

    @Override
    public List procPayGateAccess(PayGateAccessModel payGateAccessModel, String user, String flag) {


        String procName = "proc_pay_gate_access";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_pay_gate_access_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_pay_gate_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_pay_gate_access_id", payGateAccessModel.getPayGateAccessId());
        inp.put("in_pay_gate_desc", payGateAccessModel.getPayGateDesc());
        inp.put("in_type", payGateAccessModel.getType());
        inp.put("in_active", payGateAccessModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
