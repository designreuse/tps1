package igc.tech.com.dao;

import igc.tech.com.model.NearestAreaModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NearestAreaDaoImpl extends JdbcTemplate implements NearestAreaDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/

    @SuppressWarnings("unchecked")
    @Override
    public List procNearestArea(NearestAreaModel nearestAreaModel, String user, String flag) {


        //		String packageName="UTILITIES";
        String procName = "proc_nearest_area";
        SimpleJdbcCall call = new SimpleJdbcCall(this);


        //		call=call.withCatalogName(packageName);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_nearest_area_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_popular_place_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_distance", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();
        inp.put("in_flag", flag);
        inp.put("in_nearest_area_id", nearestAreaModel.getNearestAreaId());
        inp.put("in_hotel_detail_id", nearestAreaModel.getHotelDetailId());
        inp.put("in_popular_place_id",nearestAreaModel.getPopularPlaceId());
        inp.put("in_distance", nearestAreaModel.getDistance());
        inp.put("in_active", nearestAreaModel.getActive());
        inp.put("in_user", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();


        return (ArrayList<Map>) resultMap.get(keyName);


    }


}
