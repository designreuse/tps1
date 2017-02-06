package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class PackageAvailableDaoImpl extends JdbcTemplate implements
		PackageAvailableDao {

	@Override
	public List procPackageAvailable(String packageAvailableId,
			String availableDateId, String rate, String user, String flag) {

		String procName = "proc_package_available";

		SimpleJdbcCall call = new SimpleJdbcCall(this);

		call = call.withProcedureName(procName);
		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_AVAILABLE_ID",
				Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_RATE", Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter(
				"IN_PACKAGE_AVAILABLE_DATE_ID", Types.NUMERIC));

		System.out.println("here");

		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);
		inp.put("IN_PACKAGE_AVAILABLE_ID", packageAvailableId);
		inp.put("IN_PACKAGE_AVAILABLE_DATE_ID", availableDateId);
		inp.put("IN_RATE", rate);
		inp.put("IN_USER", user);

		Map<String, Object> resultMap = call.execute(inp);

		System.out.println(resultMap);

		String keyName = resultMap.keySet().toArray()[0].toString();

		return (ArrayList<Map>) resultMap.get(keyName);

	}
}
