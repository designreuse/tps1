package igc.tech.com.dao;

import igc.tech.com.model.ExtraBedModel;
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
public class ExtraBedDaoImpl extends JdbcTemplate implements ExtraBedDao {

    @Override
    public List procExtraBed(ExtraBedModel extraBedModel, String user, String flag) {


        String procName = "proc_extra_bed";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_extra_bed_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_extra_bed", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_infant_rate", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_child_age_max", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_rate", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_adult_rate", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_extra_bed_id", extraBedModel.getExtraBedId());
        inp.put("in_hotel_detail_id", extraBedModel.getHotelDetailId());
        inp.put("in_no_of_extra_bed", extraBedModel.getNoOfExtraBed());
        inp.put("in_infant_rate", extraBedModel.getInfantRate());
        inp.put("in_child_age_max", extraBedModel.getChildAgeMax());
        inp.put("in_child_rate", extraBedModel.getChildRate());
        inp.put("in_adult_rate", extraBedModel.getAdultRate());
        inp.put("in_active", extraBedModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
