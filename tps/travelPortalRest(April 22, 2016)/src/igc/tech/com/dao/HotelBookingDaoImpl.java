package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelBookingDaoImpl extends JdbcTemplate implements HotelBookingDao {

    @Override
    public List procHotelBooking(String hotelBookingId, String roomTypeId, String adult, String child, String checkInDate,
                              String checkOutDate, String countryId, String company, String city,
                              String postalCode, String licenseNo, String airportPickUp,String customerDetailId,
                                 String amount, String discountAmount, String totalAmount, String referenceNo, String payCategory,
                              String user, String flag) {


        String procName = "proc_hotel_booking";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_HOTEL_BOOKING_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ROOM_TYPE_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ADULT", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_CHILD", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_CHECK_IN_DATE", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CHECK_OUT_DATE", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_COUNTRY_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_COMPANY", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CITY", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_POSTAL_CODE", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_LICENSE_NO", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_AIRPORT_PICK_UP", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_CUSTOMER_DETAIL_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_AMOUNT", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_DISCOUNT_AMOUNT", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_TOTAL_AMOUNT", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("IN_REFERENCE_NO", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_PAY_CATEGORY", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_HOTEL_BOOKING_ID", hotelBookingId);
        inp.put("IN_ROOM_TYPE_ID", roomTypeId);
        inp.put("IN_ADULT", adult);
        inp.put("IN_CHILD", child);
        inp.put("IN_CHECK_IN_DATE", checkInDate);
        inp.put("IN_CHECK_OUT_DATE", checkOutDate);
        inp.put("IN_COUNTRY_ID", countryId);
        inp.put("IN_COMPANY", company);
        inp.put("IN_CITY", city);
        inp.put("IN_POSTAL_CODE", postalCode);
        inp.put("IN_LICENSE_NO", licenseNo);
        inp.put("IN_AIRPORT_PICK_UP", airportPickUp);
        inp.put("IN_CUSTOMER_DETAIL_ID", customerDetailId);
        inp.put("IN_AMOUNT", amount);
        inp.put("IN_DISCOUNT_AMOUNT", discountAmount);
        inp.put("IN_TOTAL_AMOUNT", totalAmount);
        inp.put("IN_REFERENCE_NO", referenceNo);
        inp.put("IN_PAY_CATEGORY", payCategory);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
