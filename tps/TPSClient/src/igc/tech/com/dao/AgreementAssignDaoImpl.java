package igc.tech.com.dao;

import igc.tech.com.model.AgreementAssignModel;
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
public class AgreementAssignDaoImpl extends JdbcTemplate implements AgreementAssignDao {

    @Override
    public List procAgreementAssign(AgreementAssignModel agreementAssignModel, String user, String flag) {


        String procName = "proc_agreement_assign";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_agreement_assign_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_agreement_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_agreement_assign_id", agreementAssignModel.getAgreementAssignId());
        inp.put("in_agreement_id", agreementAssignModel.getAgreementId());
        inp.put("in_type", agreementAssignModel.getType());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
