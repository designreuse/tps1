package igc.tech.com.mapper;

import igc.tech.com.model.ExtraBedModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class ExtraBedMapper {


    public List<ExtraBedModel> mapList(List<Map> list) {

        List<ExtraBedModel> resultList = new ArrayList<>();

        ExtraBedModel extraBedModel;

        for (Map m : list) {
            extraBedModel = mapRow(m);
            resultList.add(extraBedModel);
        }



        return resultList;
    }

    public ExtraBedModel mapRow(Map map) {

        ExtraBedModel extraBedModel = new ExtraBedModel();


        extraBedModel.setExtraBedId(map.get("extra_bed_id").toString());
        extraBedModel.setHotelDetailId(map.get("hotel_detail_id").toString());
        extraBedModel.setNoOfExtraBed(map.get("no_of_extra_bed")==null?null:map.get("no_of_extra_bed").toString());
        extraBedModel.setInfantRate(map.get("infant_rate")==null?null:map.get("infant_rate").toString());
        extraBedModel.setChildAgeMax(map.get("child_age_max")==null?null:map.get("child_age_max").toString());
        extraBedModel.setChildRate(map.get("child_rate")==null?null:map.get("child_rate").toString());
        extraBedModel.setAdultRate(map.get("adult_rate")==null?null:map.get("adult_rate").toString());
        extraBedModel.setActive(map.get("active")==null?null:map.get("active").toString());



        return extraBedModel;


    }
}
