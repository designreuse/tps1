package igc.tech.com.dao;

import igc.tech.com.model.PaymentTypeModel;
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
public class PaymentTypeDaoImpl extends JdbcTemplate implements PaymentTypeDao {

    @Override
    public List procPaymentType(PaymentTypeModel paymentTypeModel, String user, String flag) {


        String procName = "proc_payment_type";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_payment_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_payment_type_desc", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_payment_type_id", paymentTypeModel.getPaymentTypeId());
        inp.put("in_payment_type_desc", paymentTypeModel.getPaymentTypeDesc());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
