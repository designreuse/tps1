package igc.tech.com.mapper;

import igc.tech.com.model.DatabaseResponseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseResponseMapper {

    public List<DatabaseResponseModel> mapList(List<Map> list) {
        List<DatabaseResponseModel> resultList = new ArrayList<>();

        DatabaseResponseModel databaseResponseModel;

        for (Map m : list) {
            databaseResponseModel = mapRow(m);
            resultList.add(databaseResponseModel);
        }

        return resultList;
    }

    public DatabaseResponseModel mapRow(Map map) {

        DatabaseResponseModel databaseResponseModel = new DatabaseResponseModel();

        databaseResponseModel.setId(map.get("ID").toString());
        databaseResponseModel.setMessage(map.get("MSG").toString());
        databaseResponseModel.setStatus(map.get("STATUS").toString());

        return databaseResponseModel;
    }


}
