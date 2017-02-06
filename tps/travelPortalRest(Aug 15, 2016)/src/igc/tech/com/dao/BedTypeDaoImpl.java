package igc.tech.com.dao;

import igc.tech.com.model.BedTypeModel;
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
public class BedTypeDaoImpl extends JdbcTemplate implements BedTypeDao {

    @Override
    public List procBedType(BedTypeModel bedTypeModel, String user, String flag) {


        String procName = "proc_bed_type";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_bed_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_bed_type_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_bed_dimension", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_capacity", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_bed_type_id", bedTypeModel.getBedTypeId());
        inp.put("in_bed_type_desc", bedTypeModel.getBedTypeDesc());
        inp.put("in_bed_dimension", bedTypeModel.getBedDimension());
        inp.put("in_capacity", bedTypeModel.getCapacity());
        inp.put("in_active", bedTypeModel.getActive());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
