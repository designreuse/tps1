package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class CountryDaoImpl extends JdbcTemplate implements CountryDao{

	@Override
	public List procCountryInfo(String country_id, String country_name,
			String user,  String flag) {
		

		String procName = "proc_country";

		/*
		 * creating jdbc call object
		 */
		
		
		/*
		 * in_flag char,
	in_country_id   int(11),
	in_user varchar(20),
	in_deleted_flag char
		 * 
		*/
				
		SimpleJdbcCall call = new SimpleJdbcCall(this);

		call = call.withProcedureName(procName);
		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

		call.addDeclaredParameter(new SqlParameter("IN_COUNTRY_ID",Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_COUNTRY_NAME", Types.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

		
		
		System.out.println("here");
		
		System.out.println(country_id+" "+country_name);

		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);
		inp.put("IN_COUNTRY_ID", country_id);
		inp.put("IN_COUNTRY_NAME", country_name);
		inp.put("IN_USER", user);

		Map<String, Object> resultMap = call.execute(inp);

		System.out.println(resultMap);

		String keyName = resultMap.keySet().toArray()[0].toString();

		return (ArrayList<Map>) resultMap.get(keyName);

		// return (ArrayList<Map>) resultMap.get("OUT_DATA");

	}

}
