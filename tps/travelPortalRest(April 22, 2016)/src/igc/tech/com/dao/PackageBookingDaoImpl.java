package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageBookingDaoImpl extends JdbcTemplate implements PackageBookingDao {

    @Override
    public List procPackageBooking(String packageBookingId, String referenceNo, String amount, String discountAmount,
                                String totalAmount, String arrivalDate, String departDate,String noOfPerson,
                                String adult, String child, String additionalInfo,
                                String referedBy,String payCategory,
                                String customerDetailId, String availableDateRateId,
                                String user, String flag) {

        String procName = "proc_package_booking";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_BOOKING_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_REFERENCE_NO", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_AMOUNT", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_DISCOUNT_AMOUNT", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_TOTAL_AMOUNT", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_AVAILABLE_DATE_RATE_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ARRIVAL_DATE", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CUSTOMER_DETAIL_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_DEPART_DATE", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_NO_OF_PERSON", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_ADULT", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_CHILD", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ADDITIONAL_INFO", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_REFERED_BY", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_PAY_CATEGORY", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_PACKAGE_BOOKING_ID", packageBookingId);
        inp.put("IN_REFERENCE_NO", referenceNo);
        inp.put("IN_AMOUNT", amount);
        inp.put("IN_DISCOUNT_AMOUNT", discountAmount);
        inp.put("IN_TOTAL_AMOUNT", totalAmount);
        inp.put("IN_AVAILABLE_DATE_RATE_ID", availableDateRateId);
        inp.put("IN_ARRIVAL_DATE", arrivalDate);
        inp.put("IN_CUSTOMER_DETAIL_ID", customerDetailId);
        inp.put("IN_DEPART_DATE", departDate);
        inp.put("IN_NO_OF_PERSON", noOfPerson);
        inp.put("IN_ADULT", adult);
        inp.put("IN_CHILD", child);
        inp.put("IN_ADDITIONAL_INFO", additionalInfo);
        inp.put("IN_REFERED_BY", referedBy);
        inp.put("IN_PAY_CATEGORY", payCategory);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
