package igc.tech.com.mapper;

import igc.tech.com.model.HotelFacilityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelFacilityMapper {

    @SuppressWarnings("rawtypes")
    public List<HotelFacilityModel> mapList(List<Map> list) {

        List<HotelFacilityModel> resultList = new ArrayList<>();

        HotelFacilityModel hotelFacilityModel;

        for (Map m : list) {
            hotelFacilityModel = mapRow(m);
            resultList.add(hotelFacilityModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public HotelFacilityModel mapRow(Map map) {

        HotelFacilityModel hotelFacilityModel = new HotelFacilityModel();

        hotelFacilityModel.setHotelFacilityId(map.get("HOTEL_FACILITY_ID")==null?null : map.get("HOTEL_FACILITY_ID").toString());
        hotelFacilityModel.setFacilityId(map.get("facility_id")==null?null : map.get("facility_id").toString());
        hotelFacilityModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID")==null ? null :map.get("HOTEL_DETAIL_ID").toString());
        hotelFacilityModel.setHotelName(map.get("HOTEL_NAME")==null ?null :map.get("HOTEL_NAME").toString());
        hotelFacilityModel.setActive(map.get("active")==null ?null :map.get("active").toString());
        hotelFacilityModel.setFacilityDesc(map.get("facility_desc")==null? null:map.get("facility_desc").toString());
        hotelFacilityModel.setType(map.get("type")==null?null:map.get("type").toString());

        return hotelFacilityModel;
    }

}
