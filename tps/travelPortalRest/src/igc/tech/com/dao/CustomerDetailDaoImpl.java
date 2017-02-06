package igc.tech.com.dao;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDetailDaoImpl extends JdbcTemplate implements
        CustomerDetailDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procCustomerDetail(String customerDetailId, String email, String password, String customerTitle, String name,
                                  String contactNo, String customerType, String appVersion, String deviceEmail,
                                   String deviceId, String regKey, String platform, String activationCode,String otpCode, String active,
                                   String user, String flag) {

        System.out.println(customerDetailId);
        System.out.println(email);
        System.out.println(password);
        System.out.println(customerDetailId);

        String procName = "proc_customer_detail";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_CUSTOMER_DETAIL_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_EMAIL", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_PASSWORD", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CUSTOMER_TITLE", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CONTACT_NO", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CUSTOMER_TYPE", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_APP_VERSION", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_DEVICE_EMAIL", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_DEVICE_ID", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_REG_KEY", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_PLATFORM", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_ACTIVATION_CODE", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_OTP_CODE", Types.VARCHAR));


        call.addDeclaredParameter(new SqlParameter("IN_ACTIVE", Types.VARCHAR));


        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_CUSTOMER_DETAIL_ID", customerDetailId);
        inp.put("IN_EMAIL", email);
        inp.put("IN_PASSWORD", password);
        inp.put("IN_CUSTOMER_TITLE", customerTitle);
        inp.put("IN_NAME", name);
        inp.put("IN_CONTACT_NO", contactNo);
        inp.put("IN_CUSTOMER_TYPE", customerType);
        inp.put("IN_APP_VERSION", appVersion);
        inp.put("IN_DEVICE_EMAIL", deviceEmail);
        inp.put("IN_DEVICE_ID", deviceId);
        inp.put("IN_REG_KEY", regKey);
        inp.put("IN_PLATFORM", platform);
        inp.put("IN_ACTIVATION_CODE", activationCode);
        inp.put("IN_OTP_CODE", otpCode);
        inp.put("IN_ACTIVE", active);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
