package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomFacilityAccessDaoImpl extends JdbcTemplate implements RoomFacilityAccessDao {



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List procRoomFacilityAccess(String roomFacilityAccessId, String roomTypeId, String roomFacilityId, String user,
			String flag) {
		
		
		String procName = "proc_room_facility_access";
		SimpleJdbcCall call = new SimpleJdbcCall(this);

		call = call.withProcedureName(procName);
		call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
		call.addDeclaredParameter(new SqlParameter("IN_ROOM_FACILITY_ACCESS_ID",Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_ROOM_TYPE_ID", Types.VARCHAR));
		call.addDeclaredParameter(new SqlParameter("IN_ROOM_FACILITY_ID", Types.NUMERIC));
		call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

		Map<String, Object> inp = new HashMap<String, Object>();

		inp.put("IN_FLAG", flag);

		inp.put("IN_ROOM_FACILITY_ACCESS_ID", roomFacilityAccessId);
		inp.put("IN_ROOM_TYPE_ID", roomTypeId);
		inp.put("IN_ROOM_FACILITY_ID",roomFacilityId);

		inp.put("IN_USER", user);

		Map<String, Object> resultMap = call.execute(inp);


		String keyName = resultMap.keySet().toArray()[0].toString();

		return ((ArrayList<Map>) resultMap.get(keyName));

		
	}

}
