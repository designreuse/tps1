package igc.tech.com.dao;

import igc.tech.com.model.RoomImageModel;
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
    public List procRoomImage(RoomImageModel roomImageModel,
                               String user, String flag) {


        String procName = "proc_room_image";

		/*
         * creating jdbc call object
		 */

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_image_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_file_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_thumbnail", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_caption", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_image_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("if_file_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_room_image_id", roomImageModel.getRoomImageId());
        inp.put("in_room_detail_id", roomImageModel.getRoomDetailId());
        inp.put("in_file_name", roomImageModel.getFileName());
        inp.put("in_thumbnail",roomImageModel.getThumbnail ());
        inp.put("in_caption", roomImageModel.getCaption());
        inp.put("in_active", roomImageModel.getActive());
        inp.put("in_image_url",roomImageModel.getImageUrl());
        inp.put("in_file_type",roomImageModel.getFileType());
        inp.put("IN_USER", user);


        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);




    }
}
