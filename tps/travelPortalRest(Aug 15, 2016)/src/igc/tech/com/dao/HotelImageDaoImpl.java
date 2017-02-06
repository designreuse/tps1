package igc.tech.com.dao;

import igc.tech.com.model.HotelImageModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelImageDaoImpl extends JdbcTemplate implements HotelImageDao {


    @Override
    public List procHotelImage(HotelImageModel hotelImageModel, String user, String flag) {


        String procName = "proc_hotel_image";

		/*
         * creating jdbc call object
		 */

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_image_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_file_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_thumbnail", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_caption", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_image_url", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("if_file_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_hotel_image_id", hotelImageModel.getHotelImageId());
        inp.put("in_hotel_detail_id", hotelImageModel.getHotelDetailId());
        inp.put("in_file_name", hotelImageModel.getFileName());
        inp.put("in_thumbnail",hotelImageModel.getThumbnail() );
        inp.put("in_caption", hotelImageModel.getCaption());
        inp.put("in_active", hotelImageModel.getActive());
        inp.put("in_image_url",hotelImageModel.getImageUrl());
        inp.put("in_file_type",hotelImageModel.getFileType());
        inp.put("IN_USER", user);


        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

        // return (ArrayList<Map>) resultMap.get("OUT_DATA");



    }
}