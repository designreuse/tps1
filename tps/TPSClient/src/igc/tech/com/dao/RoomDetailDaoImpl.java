package igc.tech.com.dao;

import igc.tech.com.model.RoomDetailModel;
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
public class RoomDetailDaoImpl extends JdbcTemplate implements RoomDetailDao {

    @Override
    public List procRoomDetail(RoomDetailModel roomDetailModel, String user, String flag) {


        String procName = "proc_room_detail";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_bed_type_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_custom_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_rooms_provided", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_bed", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_no_of_guest", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_rate", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_min_no_of_guest", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_discount_percent", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_discount_flat", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_room_dimension", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_extra_child", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_extra_adult", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_age_max", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_child_rate", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_adult_rate", Types.FLOAT));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_room_detail_id", roomDetailModel.getRoomDetailId());
        inp.put("in_room_type_id", roomDetailModel.getRoomTypeId());
        inp.put("in_bed_type_id", roomDetailModel.getBedTypeId());
        inp.put("in_hotel_detail_id", roomDetailModel.getHotelDetailId());
        inp.put("in_custom_name", roomDetailModel.getCustomName());
        inp.put("in_rooms_provided", roomDetailModel.getRoomsProvided());
        inp.put("in_no_of_bed", roomDetailModel.getNoOfBed());
        inp.put("in_no_of_guest", roomDetailModel.getNoOfGuest());
        inp.put("in_rate", roomDetailModel.getRate());
        inp.put("in_min_no_of_guest", roomDetailModel.getMinNoOfGuest());
        inp.put("in_discount", roomDetailModel.getDiscount());
        inp.put("in_discount_type", roomDetailModel.getDicountType());
        inp.put("in_room_dimension", roomDetailModel.getRoomDimension());
        inp.put("in_active", roomDetailModel.getActive());
        inp.put("in_extra_child", roomDetailModel.getExtraChild());
        inp.put("in_extra_adult", roomDetailModel.getExtraAdult());
        inp.put("in_child_age_max", roomDetailModel.getChildAgeMax());
        inp.put("in_child_rate", roomDetailModel.getChildRate());
        inp.put("in_adult_rate", roomDetailModel.getAdultRate());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
