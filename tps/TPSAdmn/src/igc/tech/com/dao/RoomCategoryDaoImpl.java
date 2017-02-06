package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RoomCategoryDaoImpl extends JdbcTemplate implements RoomCategoryDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/

    @SuppressWarnings("unchecked")
    @Override
    public List procRoomCategory(String roomCategoryId, String roomCategoryDesc, String user, String flag) {


        //		String packageName="UTILITIES";
        String procName = "proc_room_category";
        SimpleJdbcCall call = new SimpleJdbcCall(this);


        //		call=call.withCatalogName(packageName);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_category_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_category_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();
        inp.put("in_flag", flag);
        inp.put("in_room_category_id", roomCategoryId);
        inp.put("in_room_category_desc", roomCategoryDesc);
        inp.put("in_user", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();


        return (ArrayList<Map>) resultMap.get(keyName);


    }


}
