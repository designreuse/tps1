package igc.tech.com.dao;

import igc.tech.com.model.HotelDetailModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelDetailDaoImpl extends JdbcTemplate implements HotelDetailDao {


    public List procHotelDetail(HotelDetailModel hotelDetailModel, String user, String flag) {

        String procName = "proc_hotel_detail";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_star_rating", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_ph_no_1", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_ph_no_2", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_ph_no_3", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_street_address", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_zip_code", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_EMAIL_ID", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_address_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_URL", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_total_room", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_token_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user_detail_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("in_lat", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_lng", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_HOTEL_DETAIL_ID", hotelDetailModel.getHotelDetailId());
        inp.put("IN_HOTEL_NAME", hotelDetailModel.getHotelName());
        inp.put("in_star_rating", hotelDetailModel.getStarRating());
        inp.put("IN_HOTEL_PH_NO_1", hotelDetailModel.getHotelPhNo1());
        inp.put("IN_HOTEL_PH_NO_2", hotelDetailModel.getHotelPhNo2());
        inp.put("IN_HOTEL_PH_NO_3", hotelDetailModel.getHotelPhNo3());
        inp.put("in_street_address", hotelDetailModel.getStreetAddress());
        inp.put("in_zip_code", hotelDetailModel.getZipCode());
        inp.put("IN_HOTEL_EMAIL_ID", hotelDetailModel.getHotelEmailId());
        inp.put("in_address_id", hotelDetailModel.getAddressId());
        inp.put("IN_URL", hotelDetailModel.getUrl());

        inp.put("in_total_room", hotelDetailModel.getTotalRoom());
        inp.put("in_active", hotelDetailModel.getActive());
        inp.put("in_token_id", hotelDetailModel.getTokenId());
        inp.put("IN_USER", user);
        inp.put("in_user_detail_id", hotelDetailModel.getUserDetailId());

        inp.put("in_lat", hotelDetailModel.getLat());
        inp.put("in_lng", hotelDetailModel.getLng());


        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
