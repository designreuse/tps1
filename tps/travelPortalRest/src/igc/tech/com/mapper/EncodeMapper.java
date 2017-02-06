package igc.tech.com.mapper;

import igc.tech.com.model.EncodeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncodeMapper {


    public List<EncodeModel> mapList(List<Map> list) {

        List<EncodeModel> resultList = new ArrayList<>();

        EncodeModel encodeModel;

        for (Map m : list) {
            encodeModel = mapRow(m);
            resultList.add(encodeModel);
        }



        return resultList;
    }

    public EncodeModel mapRow(Map map) {

        EncodeModel encodeModel= new EncodeModel();

        encodeModel.setEncodeId(map.get("encode_id")==null? null:map.get("encode_id").toString() );
        encodeModel.setId(map.get("id")==null? null:map.get("id").toString());
        encodeModel.setEncodedHash(map.get("encoded_hash")==null? null:map.get("encoded_hash").toString());

        return encodeModel;


    }
}
