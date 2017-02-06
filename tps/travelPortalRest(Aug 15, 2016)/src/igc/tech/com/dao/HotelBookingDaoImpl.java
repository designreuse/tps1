package igc.tech.com.dao;

import igc.tech.com.model.HotelBookingModel;
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
    public List procHotelBooking(HotelBookingModel hotelBookingModel, String user, String flag) {


        String procName = "proc_hotel_booking";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_check_in_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_check_out_date", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_no_of_rooms", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_adult", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_child", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_ages", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_hash_code", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_customer_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_guest_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_guest_ph_no", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_guest_email_id", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_pay_type", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_room_detail_id", hotelBookingModel.getRoomDetailId());
        inp.put("in_check_in_date", hotelBookingModel.getCheckInDate());
        inp.put("in_check_out_date", hotelBookingModel.getCheckOutDate());
        inp.put("in_no_of_rooms", hotelBookingModel.getNoOfRooms());
        inp.put("in_no_of_adult", hotelBookingModel.getNoOfAdult());
        inp.put("in_no_of_child", hotelBookingModel.getNoOfChild());
        inp.put("in_child_ages", hotelBookingModel.getChildAges());
        inp.put("in_hash_code", hotelBookingModel.getHashCode());
        inp.put("in_customer_detail_id", hotelBookingModel.getCustomerDetailId());
        inp.put("in_guest_name", hotelBookingModel.getGuestName());
        inp.put("in_guest_ph_no", hotelBookingModel.getGuestPhNo());
        inp.put("in_guest_email_id", hotelBookingModel.getGuestEmailId());
        inp.put("in_pay_type", hotelBookingModel.getPayType());

        Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);
        System.out.println( hotelBookingModel.getHashCode());

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }
}
