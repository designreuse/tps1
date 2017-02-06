package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class BedTypeDaoImpl extends JdbcTemplate implements
		BedTypeDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List procBedType(String bedTypeId,String description,
								String hotelDetailId,  String user, String flag) {

		String procName = "proc_bed_type";

		SimpleJdbcCall call = new SimpleJdbcCall(this);

		call = call.withProcedureName(procName);
		
		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_BED_TYPE_ID",Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_DESCRIPTION",Types.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_HOTEL_DETAIL_ID",Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));
		

		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);
		inp.put("IN_BED_TYPE_ID", bedTypeId);
		inp.put("IN_DESCRIPTION", description);
		inp.put("IN_HOTEL_DETAIL_ID", hotelDetailId);
		inp.put("IN_USER", user);

		Map<String, Object> resultMap = call.execute(inp);

		String keyName = resultMap.keySet().toArray()[0].toString();

		return (ArrayList<Map>) resultMap.get(keyName);

		// return (ArrayList<Map>) resultMap.get("OUT_DATA");

	}

}
