package igc.tech.com.dao;

import igc.tech.com.model.CancellationModel;
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
public class CancellationDaoImpl extends JdbcTemplate implements CancellationDao {

    @Override
    public List procCancellation(CancellationModel cancellationModel, String user, String flag) {


        String procName = "proc_cancellation";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_cancellation_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_free_cancellation_before", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_charge_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_charge_amount", Types.FLOAT));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_cancellation_id", cancellationModel.getCancellationId());
        inp.put("in_hotel_detail_id", cancellationModel.getHotelDetailId());
        inp.put("in_free_cancellation_before", cancellationModel.getFreeCancellationBefore());
        inp.put("in_charge_type", cancellationModel.getChargeType());
        inp.put("in_charge_amount", cancellationModel.getChargeAmount());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
