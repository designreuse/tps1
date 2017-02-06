package igc.tech.com.dao;

import igc.tech.com.model.TokenModel;
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
public class TokenDaoImpl extends JdbcTemplate implements TokenDao {

    @Override
    public List procToken(TokenModel tokenModel, String user, String flag) {


        String procName = "proc_token";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_token_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_status", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_token", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_step", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_token_ID", tokenModel.getTokenId());
        inp.put("in_status", tokenModel.getStatus());
        inp.put("in_token", tokenModel.getToken());
        inp.put("in_user_detail_id", tokenModel.getUserDetailId());
        inp.put("in_step", tokenModel.getStep());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
