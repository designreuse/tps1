package igc.tech.com.dao;

import igc.tech.com.model.ActivityModel;
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
public class EsewaTxnDaoImpl extends JdbcTemplate implements EsewaTxnDao {

    @Override
    public List procEsewaTxn(String esewaTxnId,String esewaConfigId,String amount,String taxAmt,String serviceCharge,String deliveryCharge, String totalAmt, String productId,
            String refId, String verifyStatus, String hotelBookingId, String user, String flag) {


        String procName = "proc_esewa_txn";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);


        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_esewa_txn_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_esewa_config_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_amount", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_tax_amt", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_service_charge", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_delivery_charge", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_total_amt", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_product_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_ref_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_verify_status", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_booking_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("in_esewa_txn_id",esewaTxnId);
        inp.put("in_esewa_config_id", esewaConfigId);
        inp.put("in_amount", amount);
        inp.put("in_tax_amt", taxAmt);
        inp.put("in_service_charge", serviceCharge);
        inp.put("in_delivery_charge", deliveryCharge);
        inp.put("in_total_amt",totalAmt);
        inp.put("in_product_id", productId);
        inp.put("in_ref_id", refId);
        inp.put("in_verify_status", verifyStatus);
        inp.put("in_hotel_booking_id", hotelBookingId);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
