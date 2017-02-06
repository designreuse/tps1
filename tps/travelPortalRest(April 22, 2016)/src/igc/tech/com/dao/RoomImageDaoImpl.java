package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/14/2016.
 */
public class RoomImageDaoImpl extends JdbcTemplate implements RoomImageDao {


    @Override
    public List procRoomImage(String roomImageId, String roomTypeId,
                               String fileName, String caption, String ImageUrl,
                               String fileType, String thumbnail, String active,
                               String user, String flag) {


        String procName = "proc_room_image";

		/*
         * creating jdbc call object
		 */

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_image_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_file_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_thumbnail", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_caption", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_image_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("if_file_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_room_image_id", roomImageId);
        inp.put("in_room_type_id", roomTypeId);
        inp.put("in_file_name", fileName);
        inp.put("in_thumbnail",thumbnail );
        inp.put("in_caption", caption);
        inp.put("in_active", active);
        inp.put("in_image_url",ImageUrl);
        inp.put("in_file_type",fileType);
        inp.put("IN_USER", user);


        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);




    }
}
