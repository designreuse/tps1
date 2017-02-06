package igc.tech.com.mapper;

import igc.tech.com.model.BedTypeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BedTypeMapper {


    @SuppressWarnings("rawtypes")
    public List<BedTypeModel> mapList(List<Map> list) {

        List<BedTypeModel> resultList = new ArrayList<>();

        BedTypeModel bedTypeModel;

        for (Map m : list) {
            bedTypeModel = mapRow(m);
            resultList.add(bedTypeModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    @SuppressWarnings("rawtypes")
    public BedTypeModel mapRow(Map map) {

        BedTypeModel bedTypeModel = new BedTypeModel();

        bedTypeModel.setBedTypeId(map.get("BED_TYPE_ID").toString());
        bedTypeModel.setBedTypeDesc(map.get("bed_type_desc").toString());
        bedTypeModel.setSize(map.get("size").toString());

        return bedTypeModel;
    }

}
