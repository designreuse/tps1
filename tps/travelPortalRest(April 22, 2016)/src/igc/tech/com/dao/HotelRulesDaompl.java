package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelRulesDaompl extends JdbcTemplate implements HotelRulesDao {

    @Override
    public List procHotelRules(String hotelRulesId, String rulesId,
                                String hotelDetailId,String user, String flag) {

        String procName = "proc_hotel_rules";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_RULES_ID",Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_RULES_ID",Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_DETAIL_ID",Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_HOTEL_RULES_ID", hotelRulesId);
        inp.put("IN_RULES_ID", rulesId);
        inp.put("IN_HOTEL_DETAIL_ID", hotelDetailId);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);



    }
}
