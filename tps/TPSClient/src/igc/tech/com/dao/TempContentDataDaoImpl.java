package igc.tech.com.dao;

import igc.tech.com.model.TempContentDataModel;
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
public class TempContentDataDaoImpl extends JdbcTemplate implements TempContentDataDao {

    @Override
    public List procTempContentData(TempContentDataModel tempContentDataModel, String user, String flag) {


        String procName = "proc_temp_content_data";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_temp_content_data_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_push_content_data_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_field", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_content_data", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_ref_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_update_field", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_temp_content_data_id", tempContentDataModel.getTempContentDataId());
        inp.put("in_push_content_data_id", tempContentDataModel.getPushContentDataId());
        inp.put("in_field", tempContentDataModel.getField());
        inp.put("in_content_data", tempContentDataModel.getContentData());
        inp.put("in_type", tempContentDataModel.getType());
        inp.put("in_ref_id", tempContentDataModel.getRefId());
        inp.put("in_update_field", tempContentDataModel.getUpdateField());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);
        System.out.println(resultMap);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
