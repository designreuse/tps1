package igc.tech.com.dao;

import igc.tech.com.model.AmenityModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class AmenityDaoImpl extends JdbcTemplate implements AmenityDao {

    @Override
    public List procAmenity(AmenityModel amenityModel, String user, String flag) {


        String procName = "proc_amenity";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_amenity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_parent_amenity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_amenity_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_charge_option", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("in_web_prior", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_mob_prior", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_icon", Types.VARCHAR));


        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_amenity_id", amenityModel.getAmenityId());
        inp.put("in_parent_amenity_id", amenityModel.getParentAmenityId());
        inp.put("in_amenity_desc", amenityModel.getAmenityDesc());
        inp.put("in_active", amenityModel.getActive());

        inp.put("in_web_prior", amenityModel.getWebPrior());
        inp.put("in_mob_prior", amenityModel.getMobPrior());
        inp.put("in_icon", amenityModel.getIcon());


        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
