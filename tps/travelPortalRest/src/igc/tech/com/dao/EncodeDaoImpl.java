package igc.tech.com.dao;

import igc.tech.com.model.EncodeModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EncodeDaoImpl extends JdbcTemplate implements EncodeDao {

    @Override
    public List procEncode(EncodeModel encodeModel, String flag) {

        String procName = "proc_encode";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_encode_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_encoded_hash", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_encode_id", encodeModel.getEncodeId());
        inp.put("in_id", encodeModel.getId());
        inp.put("in_encoded_hash", encodeModel.getEncodedHash());

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
