package igc.tech.com.dao;

import igc.tech.com.model.HotelBookingModel;
import igc.tech.com.model.OfferModel;
import npay.AuthenticateMerchant;
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
public class NpayTxnDaoImpl extends JdbcTemplate implements NpayTxnDao {

    @Override
    public List procNpayTxn(String npayTxnId, String npayConfigId, String merchantTxnId, String amount, String purchaseDesc, String reqStatusCode, String reqMessage,
            String processId, String gatewayRefNo, String verifyStatusCode, String verifyMessage, String txnStatus, String remarks, String cardNo, String merchantDecs,
            String txnDateTime, String concernedBank, String hotelBookingId, String user, String flag) {


        String procName = "proc_npay_txn";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);


        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("in_npay_txn_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_npay_config_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_merchant_txn_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_amount", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_purchase_desc", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_req_status_code", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_req_message", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_process_id", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_gateway_ref_no", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_verify_status_code", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_verify_message", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_txn_status", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_remarks", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_card_no", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_merchant_decs", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_txn_date_time", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_concerned_bank", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_booking_id", Types.NUMERIC));


        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("in_npay_txn_id", npayTxnId);
        inp.put("in_npay_config_id", npayConfigId);
        inp.put("in_merchant_txn_id", merchantTxnId);
        inp.put("in_amount", amount);
        inp.put("in_purchase_desc", purchaseDesc);
        inp.put("in_req_status_code", reqStatusCode);
        inp.put("in_req_message", reqMessage);
        inp.put("in_process_id", processId);

        inp.put("in_gateway_ref_no", gatewayRefNo);
        inp.put("in_verify_status_code", verifyStatusCode);
        inp.put("in_verify_message", verifyMessage);
        inp.put("in_txn_status", txnStatus);
        inp.put("in_remarks", remarks);
        inp.put("in_card_no", cardNo);
        inp.put("in_merchant_decs", merchantDecs);
        inp.put("in_txn_date_time", txnDateTime);

        inp.put("in_concerned_bank", concernedBank);
        inp.put("in_hotel_booking_id", hotelBookingId);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
