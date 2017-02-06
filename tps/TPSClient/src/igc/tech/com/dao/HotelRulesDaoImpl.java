package igc.tech.com.dao;

import igc.tech.com.model.HotelRulesModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelRulesDaoImpl extends JdbcTemplate implements HotelRulesDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procHotelRules(HotelRulesModel hotelRulesModel,
                                  String user, String flag) {

        String procName = "proc_hotel_rules";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("in_hotel_rules_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_rules_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("in_hotel_rules_id", hotelRulesModel.getHotelRulesId());
        inp.put("in_rules_id", hotelRulesModel.getRulesId());
        inp.put("in_hotel_detail_id", hotelRulesModel.getHotelDetailId());
        inp.put("in_active", hotelRulesModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
