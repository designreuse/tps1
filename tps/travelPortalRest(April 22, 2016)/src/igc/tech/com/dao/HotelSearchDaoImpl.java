package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelSearchDaoImpl extends JdbcTemplate implements
		HotelSearchDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List procHotelSearch(String location,String flag) {

		String procName = "proc_hotel_search";

		SimpleJdbcCall call = new SimpleJdbcCall(this);

		call = call.withProcedureName(procName);

		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_LOCATION",Types.VARCHAR));



		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);
		inp.put("IN_LOCATION", location);


		Map<String, Object> resultMap = call.execute(inp);

		String keyName = resultMap.keySet().toArray()[0].toString();

		return (ArrayList<Map>) resultMap.get(keyName);

		// return (ArrayList<Map>) resultMap.get("OUT_DATA");

	}

}
