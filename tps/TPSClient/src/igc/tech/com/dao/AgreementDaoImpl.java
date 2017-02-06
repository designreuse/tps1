package igc.tech.com.dao;

import igc.tech.com.model.AgreementModel;
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
public class AgreementDaoImpl extends JdbcTemplate implements AgreementDao {

    @Override
    public List procAgreement(AgreementModel agreementModel, String user, String flag) {


        String procName = "proc_agreement";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_agreement_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_title", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_content", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_agreement_id", agreementModel.getAgreementId());
        inp.put("in_title", agreementModel.getTitle());
        inp.put("in_content", agreementModel.getContent());
        inp.put("in_active", agreementModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
