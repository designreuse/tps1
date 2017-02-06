package igc.tech.com.mapper;

import igc.tech.com.model.RoomRateModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class RoomRateMapper {


    public List<RoomRateModel> mapList(List<Map> list) {

        List<RoomRateModel> resultList = new ArrayList<>();

        RoomRateModel roomRateModel;

        for (Map m : list) {
            roomRateModel = mapRow(m);
            resultList.add(roomRateModel);
        }



        return resultList;
    }

    public RoomRateModel mapRow(Map map) {

        RoomRateModel roomRateModel = new RoomRateModel();


        roomRateModel.setRoomRateId(map.get("room_rate_id").toString());
        roomRateModel.setRoomDetailId(map.get("room_detail_id")==null?null:map.get("room_detail_id").toString());
        roomRateModel.setCurrencyId(map.get("currency_id").toString());
        roomRateModel.setRate(map.get("rate")==null?null:map.get("rate").toString());
        roomRateModel.setChildRate(map.get("child_rate")==null?null:map.get("child_rate").toString());
        roomRateModel.setAdultRate(map.get("adult_rate")==null?null:map.get("adult_rate").toString());

        System.out.println(roomRateModel);



        return roomRateModel;


    }
}
