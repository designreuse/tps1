package igc.tech.com.dao;

import igc.tech.com.model.NearPlacesModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NearPlacesDaoImpl extends JdbcTemplate implements NearPlacesDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/

    @SuppressWarnings("unchecked")
    @Override
    public List procNearPlaces(NearPlacesModel nearPlacesModel, String user, String flag) {


        //		String packageName="UTILITIES";
        String procName = "proc_near_places";
        SimpleJdbcCall call = new SimpleJdbcCall(this);


        //		call=call.withCatalogName(packageName);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_near_places_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_place_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_lat", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_lng", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_distance", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();
        inp.put("in_flag", flag);
        inp.put("in_near_places_id", nearPlacesModel.getNearPlaceId());
        inp.put("in_hotel_detail_id", nearPlacesModel.getHotelDetailId());
        inp.put("in_place_name",nearPlacesModel.getPlaceName());
        inp.put("in_type",nearPlacesModel.getType());
        inp.put("in_lat",nearPlacesModel.getLat());
        inp.put("in_lng",nearPlacesModel.getLng());
        inp.put("in_distance", nearPlacesModel.getDistance());
        inp.put("in_user", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();


        return (ArrayList<Map>) resultMap.get(keyName);


    }


}
