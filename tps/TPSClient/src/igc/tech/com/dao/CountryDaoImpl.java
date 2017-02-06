package igc.tech.com.dao;

import igc.tech.com.model.CountryModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryDaoImpl extends JdbcTemplate implements CountryDao {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List procCountry(CountryModel countryModel,
                            String user, String flag) {

        String procName = "proc_country";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_COUNTRY_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_COUNTRY_NAME", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_COUNTRY_ID", countryModel.getCountryId());
        inp.put("IN_COUNTRY_NAME", countryModel.getCountryName());
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
