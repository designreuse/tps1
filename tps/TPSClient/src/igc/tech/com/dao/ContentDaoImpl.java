package igc.tech.com.dao;

import igc.tech.com.model.ContentModel;
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
public class ContentDaoImpl extends JdbcTemplate implements ContentDao {

    @Override
    public List procContent(ContentModel contentModel, String user, String flag) {


        String procName = "proc_content";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_content_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_content_title", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_content_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_content_page_title", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_content_body", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_meta_description", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_meta_keywords", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_meta_title", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.TINYINT));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_content_id", contentModel.getContentId());
        inp.put("in_content_title", contentModel.getContentTitle());
        inp.put("in_content_url", contentModel.getContentUrl());
        inp.put("in_content_page_title", contentModel.getContentPageTitle());
        inp.put("in_content_body", contentModel.getContentBody());
        inp.put("in_meta_description", contentModel.getMetaDescription());
        inp.put("in_meta_keywords", contentModel.getMetaKeywords());
        inp.put("in_meta_title", contentModel.getMetaTitle());
        inp.put("in_active", contentModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
