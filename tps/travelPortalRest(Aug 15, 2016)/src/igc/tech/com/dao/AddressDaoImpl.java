package igc.tech.com.dao;

import igc.tech.com.model.AddressModel;
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
public class AddressDaoImpl extends JdbcTemplate implements AddressDao {

    @Override
    public List procAddress(AddressModel addressModel, String user, String flag) {


        String procName = "proc_address";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_address_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_address_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_parent_address_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_type", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_level", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_address_id", addressModel.getAddressId());
        inp.put("in_address_name", addressModel.getAddressName());
        inp.put("in_parent_address_id", addressModel.getParentAddressId());
        inp.put("in_type", addressModel.getType());
        inp.put("in_level", addressModel.getLevel());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
