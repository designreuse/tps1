package igc.tech.com.dao;

import igc.tech.com.model.UserDetailModel;
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
public class UserDetailDaoImpl extends JdbcTemplate implements UserDetailDao {

    @Override
    public List procUserDetail(UserDetailModel userDetailModel, String user, String flag) {


        String procName = "proc_user_detail";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_user_detail_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_address", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_phone_no", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_EMAIL_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_username", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_password", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_role_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_user_detail_ID", userDetailModel.getUserDetailId());
        inp.put("IN_NAME", userDetailModel.getName());
        inp.put("in_address", userDetailModel.getAddress());
        inp.put("in_phone_no", userDetailModel.getPhoneNo());
        inp.put("IN_EMAIL_id", userDetailModel.getEmailId());
        inp.put("in_username", userDetailModel.getUserName());
        inp.put("in_password", userDetailModel.getPassword());
        inp.put("in_active", userDetailModel.getActive());
        inp.put("in_role_id", userDetailModel.getRoleId());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
