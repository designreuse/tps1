package igc.tech.com.dao;

import igc.tech.com.model.HotelFeatureModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelFeatureDaoImpl extends JdbcTemplate implements HotelFeatureDao {


    public List procHotelFeature(HotelFeatureModel hotelFeatureModel, String user, String flag) {

        String procName = "proc_hotel_feature";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("in_hotel_feature_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_check_in_from", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_in_to", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_from", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_to", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_HOTEL_DETAIL_ID", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_hotel_feature_id", hotelFeatureModel.getHotelFeatureId());
        inp.put("IN_check_in_from", hotelFeatureModel.getCheckInFrom());
        inp.put("in_check_in_to", hotelFeatureModel.getCheckInTo());
        inp.put("IN_check_out_from", hotelFeatureModel.getCheckOutFrom());
        inp.put("IN_check_out_to", hotelFeatureModel.getCheckOutTo());
        inp.put("in_hotel_detail_id", hotelFeatureModel.getHotelDetailId());

        inp.put("in_active", hotelFeatureModel.getActive());
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
