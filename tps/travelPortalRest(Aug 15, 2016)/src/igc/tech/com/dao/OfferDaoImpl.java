package igc.tech.com.dao;

import igc.tech.com.model.OfferModel;
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
public class OfferDaoImpl extends JdbcTemplate implements OfferDao {

    @Override
    public List procOffer(OfferModel offerModel, String user, String flag) {


        String procName = "proc_offer";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_offer_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_offer_name", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_effective_from", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_effective_to", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_offer_type", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("in_offer_amount", Types.FLOAT));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_offer_id", offerModel.getOfferId());
        inp.put("in_offer_name", offerModel.getOfferName());
        inp.put("in_room_detail_id", offerModel.getRoomDetailId());
        inp.put("in_effective_from", offerModel.getEffectiveFrom());
        inp.put("in_effective_to", offerModel.getEffectiveTo());
        inp.put("in_offer_type", offerModel.getOfferType());
        inp.put("in_offer_amount", offerModel.getOfferAmount());
        inp.put("in_hotel_detail_id", offerModel.getHotelDetailId());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
