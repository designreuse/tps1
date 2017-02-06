package igc.tech.com.dao;

import igc.tech.com.model.ContentCommentModel;
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
public class ContentCommentDaoImpl extends JdbcTemplate implements ContentCommentDao {

    @Override
    public List procContentComment(ContentCommentModel contentCommentModel, String user, String flag) {


        String procName = "proc_contentComment";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_content_comment_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_content_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_sender_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_sender_email", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_message", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_comment_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_approve", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_content_comment_id", contentCommentModel.getContentCommentId());
        inp.put("in_content_id", contentCommentModel.getContentId());
        inp.put("in_sender_name", contentCommentModel.getSenderName());
        inp.put("in_sender_email", contentCommentModel.getSenderEmail());
        inp.put("in_message", contentCommentModel.getMessage());
        inp.put("in_comment_date", contentCommentModel.getCommentDate());
        inp.put("in_approve", contentCommentModel.getApprove());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
