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

        AvailableDateRateModel availableDateRateModel = new AvailableDateRateModel();

        availableDateRateModel.setAvailableDateRateId(map.get("AVAILABLE_DATE_RATE_ID").toString());
        availableDateRateModel.setAvailableDate(map.get("AVAILABLE_DATE").toString());
        availableDateRateModel.setPackageInfoId(map.get("PACKAGE_INFO_ID").toString());
        availableDateRateModel.setPackageName(map.get("PACKAGE_NAME").toString());
        availableDateRateModel.setRate(map.get("RATE").toString());

        return availableDateRateModel;
    }

    public AvailableDateRateModel mapRowSetNull(boolean availableDateRateId,
                                                boolean availableDate,
                                                boolean packageInfoId,
                                                boolean packageName,
                                                boolean rate,
                                                AvailableDateRateModel availableDateRateModel) {

        if (availableDateRateId==true){
            availableDateRateModel.setAvailableDateRateId(null);

        }
        if (availableDate==true){
            availableDateRateModel.setAvailableDate(null);

        }
        if (packageInfoId==true){

            availableDateRateModel.setPackageInfoId(null);
        }
        if (packageName==true){

            availableDateRateModel.setPackageName(null);
        }
        if (rate==true){

            availableDateRateModel.setRate(null);
        }

        return availableDateRateModel;
    }


    public List<AvailableDateRateModel> mapListSetNull(boolean availableDateRateId,
                                                boolean availableDate,
                                                boolean packageInfoId,
                                                boolean packageName,
                                                boolean rate,
                                                List<AvailableDateRateModel> availableDateRateModels) {

        for (AvailableDateRateModel availableDateRateModel:availableDateRateModels){

            availableDateRateModel=  mapRowSetNull(availableDateRateId,availableDate,packageInfoId,packageName,rate,availableDateRateModel);

        }

       return  availableDateRateModels;
    }


}
