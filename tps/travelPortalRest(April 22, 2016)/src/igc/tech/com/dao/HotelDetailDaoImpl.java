package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class HotelDetailDaoImpl extends JdbcTemplate implements HotelDetailDao {

    @Override
    public List procHotelDetail(String hotelDetailId, String hotelName,
                                String hotelPhNo1, String hotelPhNo2, String hotelPhNo3,
                                String hotelAddress, String hotelEmailId, String areaId,
                                String url,String clientDetailId,String user, String flag) {

        String procName = "proc_hotel_detail";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_DETAIL_ID",Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_NAME",Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_PH_NO_1",Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_PH_NO_2",Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_PH_NO_3",Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_ADDRESS",Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_EMAIL_ID",Types.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_AREA_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_URL", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CLIENT_DETAIL_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_HOTEL_DETAIL_ID", hotelDetailId);
        inp.put("IN_HOTEL_NAME", hotelName);
        inp.put("IN_HOTEL_PH_NO_1", hotelPhNo1);
        inp.put("IN_HOTEL_PH_NO_2", hotelPhNo2);
        inp.put("IN_HOTEL_PH_NO_3", hotelPhNo3);
        inp.put("IN_HOTEL_ADDRESS", hotelAddress);
        inp.put("IN_HOTEL_EMAIL_ID", hotelEmailId);
        inp.put("IN_AREA_ID", areaId);
        inp.put("IN_URL", url);
        inp.put("IN_CLIENT_DETAIL_ID", clientDetailId);
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);



    }
}
