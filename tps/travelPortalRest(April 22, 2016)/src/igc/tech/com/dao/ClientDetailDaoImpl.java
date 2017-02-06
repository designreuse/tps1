package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.awt.*;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDetailDaoImpl extends JdbcTemplate implements ClientDetailDao {

    @Override
    public List procClientDetail(String clientDetailId, String clientName, String address, String phoneNumber, String emailId, String companyName, String companyAddress,
                                 String companyPhoneNumber, String companyEmailId, String active,
                                 String user, String flag) {


        String procName = "proc_client_detail";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_CLIENT_DETAIL_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_CLIENT_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_ADDRESS", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_PHONE_NUMBER", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_EMAIL_ID", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_COMPANY_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_COMPANY_ADDRESS", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_COMPANY_PHONE_NUMBER", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_COMPANY_EMAIL_ID", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_ACTIVE", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_CLIENT_DETAIL_ID", clientDetailId);
        inp.put("IN_CLIENT_NAME", clientName);
        inp.put("IN_ADDRESS", address);
        inp.put("IN_PHONE_NUMBER", phoneNumber);
        inp.put("IN_EMAIL_ID", emailId);
        inp.put("IN_COMPANY_NAME", companyName);
        inp.put("IN_COMPANY_ADDRESS", companyAddress);
        inp.put("IN_COMPANY_PHONE_NUMBER", companyPhoneNumber);
        inp.put("IN_COMPANY_EMAIL_ID", companyEmailId);
        inp.put("IN_ACTIVE", active);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
