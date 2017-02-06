package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class PackageLocationDaoImpl extends JdbcTemplate implements PackageLocationDao{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List procPackageLocation(String packageLocationId, String packageItineraryId,String areaId,
			String user,  String flag) {

		String procName = "proc_package_location";
		SimpleJdbcCall call = new SimpleJdbcCall(this);
		
		call = call.withProcedureName(procName);
		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_LOCATION_ID",Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_ITINERARY_ID", Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_AREA_ID", Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);
		
		inp.put("IN_PACKAGE_LOCATION_ID", packageLocationId);
		inp.put("IN_PACKAGE_ITINERARY_ID", packageItineraryId);
		inp.put("IN_AREA_ID", areaId);
		
		inp.put("IN_USER", user);

		Map<String, Object> resultMap = call.execute(inp);

		System.out.println(resultMap);

		String keyName = resultMap.keySet().toArray()[0].toString();

		return (ArrayList<Map>) resultMap.get(keyName);

	}

}
