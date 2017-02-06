package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageDaoImpl extends JdbcTemplate implements ImageDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procImage(String imageId, String imageCaption, String fileName, String albumId, String user,
                             String flag) {


        String procName = "proc_image";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_IMAGE_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_IMAGE_CAPTION", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_FILE_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_ALBUM_ID", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_IMAGE_ID", imageId);
        inp.put("IN_IMAGE_CAPTION", imageCaption);
        inp.put("IN_FILE_NAME", fileName);
        inp.put("IN_ALBUM_ID", albumId);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return ((ArrayList<Map>) resultMap.get(keyName));


    }

}
