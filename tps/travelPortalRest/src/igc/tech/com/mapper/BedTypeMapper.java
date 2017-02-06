package igc.tech.com.mapper;

import igc.tech.com.model.BedTypeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class BedTypeMapper {


    public List<BedTypeModel> mapList(List<Map> list) {

        List<BedTypeModel> resultList = new ArrayList<>();

        BedTypeModel bedTypeModel;

        for (Map m : list) {
            bedTypeModel = mapRow(m);
            resultList.add(bedTypeModel);
        }



        return resultList;
    }

    public BedTypeModel mapRow(Map map) {

        BedTypeModel bedTypeModel = new BedTypeModel();


        bedTypeModel.setBedTypeId(map.get("bed_type_id").toString());
        bedTypeModel.setBedTypeDesc(map.get("bed_type_desc").toString());
        bedTypeModel.setCapacity(map.get("capacity").toString());
        bedTypeModel.setBedDimension(map.get("bed_dimension").toString());
        bedTypeModel.setActive(map.get("active")==null? null:map.get("active").toString());



        return bedTypeModel;


    }
}
