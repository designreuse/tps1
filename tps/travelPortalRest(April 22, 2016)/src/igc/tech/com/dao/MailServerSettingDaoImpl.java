package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailServerSettingDaoImpl extends JdbcTemplate implements
        MailServerSettingDao {

    @Override
    public List procMailServerSetting(String mailServerSettingId, String emailId, String password, String host, String port, String active, String userName,
                                      String user, String flag) {

        String procName = "proc_mail_server_setting";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_MAIL_SERVER_SETTING_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_EMAIL_ID", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_PASSWORD", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_HOST", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_PORT", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ACTIVE", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER_NAME", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_MAIL_SERVER_SETTING_ID", mailServerSettingId);
        inp.put("IN_EMAIL_ID", emailId);
        inp.put("IN_PASSWORD", password);
        inp.put("IN_HOST", host);
        inp.put("IN_PORT", port);
        inp.put("IN_ACTIVE", active);
        inp.put("IN_USER_NAME", userName);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }
}
