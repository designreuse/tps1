package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageSearchDaoImpl extends JdbcTemplate implements
		PackageSearchDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List procPackageSearch(String location,String availableMonth,String flag) {

		String procName = "proc_package_search";

		SimpleJdbcCall call = new SimpleJdbcCall(this);

		call = call.withProcedureName(procName);

		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_LOCATION",Types.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_AVAILABLE_MONTH",Types.VARCHAR));


		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);
		inp.put("IN_LOCATION", location);
		inp.put("IN_AVAILABLE_MONTH", availableMonth);

		Map<String, Object> resultMap = call.execute(inp);

		String keyName = resultMap.keySet().toArray()[0].toString();

		return (ArrayList<Map>) resultMap.get(keyName);

		// return (ArrayList<Map>) resultMap.get("OUT_DATA");

	}

}
