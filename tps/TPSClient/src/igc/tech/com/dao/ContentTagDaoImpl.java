package igc.tech.com.dao;

import igc.tech.com.model.ContentTagModel;
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
public class ContentTagDaoImpl extends JdbcTemplate implements ContentTagDao {

    @Override
    public List procContentTag(ContentTagModel contentTagModel, String user, String flag) {


        String procName = "proc_content_tag";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_content_tag_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_content_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_tag_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_content_tag_id", contentTagModel.getContentTagId());
        inp.put("in_content_id", contentTagModel.getContentId());
        inp.put("in_tag_id", contentTagModel.getTagId());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
