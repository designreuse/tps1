package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class HotelFacilityDaoImpl extends JdbcTemplate implements HotelFacilityDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procHotelFacility(String hotelFacilityId, String facilityId, String hotelDetailId, String active,
                                  String user, String flag) {

        String procName = "proc_hotel_facility";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("in_hotel_facility_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_facility_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("in_hotel_facility_id", hotelFacilityId);
        inp.put("in_facility_id", facilityId);
        inp.put("in_hotel_detail_id", hotelDetailId);
        inp.put("in_active", active);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
