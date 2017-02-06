package igc.tech.com.mapper;

import igc.tech.com.model.AvailableDateRateModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AvailableDateRateMappper {

    @SuppressWarnings("rawtypes")
    public List<AvailableDateRateModel> mapList(List<Map> list) {

        List<AvailableDateRateModel> resultList = new ArrayList<>();

        AvailableDateRateModel availableDateModel;

        for (Map m : list) {
            availableDateModel = mapRow(m);
            resultList.add(availableDateModel);
        }

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public AvailableDateRateModel mapRow(Map map) {

        AvailableDateRateModel availableDateModel = new AvailableDateRateModel();

        availableDateModel.setAvailableDateRateId(map.get("AVAILABLE_DATE_RATE_ID").toString());
        availableDateModel.setAvailableDate(map.get("AVAILABLE_DATE").toString());
        availableDateModel.setPackageInfoId(map.get("PACKAGE_INFO_ID").toString());
        availableDateModel.setPackageName(map.get("PACKAGE_NAME").toString());
        availableDateModel.setRate(map.get("RATE").toString());

        return availableDateModel;
    }

}
