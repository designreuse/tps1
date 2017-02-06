package igc.tech.com.mapper;

import igc.tech.com.model.DatabaseResponse;

import java.util.Map;

public class DatabaseResponseMapper {


    public DatabaseResponse mapRow(Map map) {

        DatabaseResponse databaseResponse = new DatabaseResponse();

        databaseResponse.setStatus(map.get("STATUS").toString());
        databaseResponse.setMessage(map.get("MSG").toString());
//		databaseResponse.setId(map.get(2).toString());

        return databaseResponse;
    }

}
