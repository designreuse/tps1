package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class AvailableDateRateImpl extends JdbcTemplate implements AvailableDateRateDao{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List procAvailableDateRate(String availableDateId, String availableDate,String packageId,String rate,
			String user,  String flag) {

		String procName = "proc_available_date_rate";
		SimpleJdbcCall call = new SimpleJdbcCall(this);
		
		call = call.withProcedureName(procName);
		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_AVAILABLE_DATE_RATE_ID",Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_AVAILABLE_DATE", Types.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_INFO_ID", Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_RATE", Types.NUMERIC));
				call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);
		inp.put("IN_AVAILABLE_DATE_RATE_ID", availableDateId);
		inp.put("IN_AVAILABLE_DATE", availableDate);
		inp.put("IN_PACKAGE_INFO_ID", packageId);
		inp.put("IN_RATE", rate);
		inp.put("IN_USER", user);

		Map<String, Object> resultMap = call.execute(inp);

		String keyName = resultMap.keySet().toArray()[0].toString();

		return (ArrayList<Map>) resultMap.get(keyName);

	}

}
