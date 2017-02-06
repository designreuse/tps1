package igc.tech.com.mapper;

import igc.tech.com.model.OfferModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class OfferMapper {


    public List<OfferModel> mapList(List<Map> list) {

        List<OfferModel> resultList = new ArrayList<>();

        OfferModel offerModel;

        for (Map m : list) {
            offerModel = mapRow(m);
            resultList.add(offerModel);
        }



        return resultList;
    }

    public OfferModel mapRow(Map map) {

        OfferModel offerModel = new OfferModel();


        offerModel.setOfferId(map.get("offer_id").toString());
        offerModel.setOfferName(map.get("offer_name")==null?null:map.get("offer_name").toString());
        offerModel.setRoomDetailId(map.get("room_detail_id").toString());
        offerModel.setEffectiveFrom(map.get("effective_from").toString());
        offerModel.setEffectiveTo(map.get("effective_to").toString());
        offerModel.setBookingFrom(map.get("booking_from")==null?null:map.get("booking_from").toString());
        offerModel.setBookingTo(map.get("booking_to")==null?null:map.get("booking_to").toString());
        offerModel.setOfferType(map.get("offer_type").toString());
        offerModel.setOfferAmount(map.get("offer_amount").toString());
        offerModel.setRoomName(map.get("custom_name")==null?null:map.get("custom_name").toString());



        return offerModel;


    }
}
