package igc.tech.com.mapper;

import igc.tech.com.model.DayDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DayDetailMapper {

    @SuppressWarnings("rawtypes")
    public List<DayDetailModel> mapList(List<Map> list) {

        List<DayDetailModel> resultList = new ArrayList<>();

        DayDetailModel dayModel;

        for (Map m : list) {
            dayModel = mapRow(m);
            resultList.add(dayModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public DayDetailModel mapRow(Map map) {

        DayDetailModel dayDetailModel = new DayDetailModel();

        dayDetailModel.setDayDetailId(map.get("DAY_DETAIL_ID").toString());
        dayDetailModel.setPackageName(map.get("PACKAGE_NAME").toString());
        dayDetailModel.setPackageItineraryId(map.get("PACKAGE_ITINERARY_ID").toString());
        dayDetailModel.setDay(map.get("DAY").toString());
        dayDetailModel.setActivityDetailId(map.get("ACTIVITY_DETAIL_ID").toString());
        dayDetailModel.setActivityName(map.get("ACTIVITY_NAME").toString());

        return dayDetailModel;
    }

}
