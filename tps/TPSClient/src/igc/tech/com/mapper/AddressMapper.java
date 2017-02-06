package igc.tech.com.mapper;

import igc.tech.com.model.AddressModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class AddressMapper {


    public List<AddressModel> mapList(List<Map> list) {

        List<AddressModel> resultList = new ArrayList<>();

        AddressModel addressModel;

        for (Map m : list) {
            addressModel = mapRow(m);
            resultList.add(addressModel);
        }



        return resultList;
    }

    public AddressModel mapRow(Map map) {

        AddressModel addressModel = new AddressModel();

        addressModel.setAddressId(map.get("address_id").toString());
        addressModel.setAddressName(map.get("address_name").toString());
        addressModel.setParentAddressId(map.get("parent_address_id")==null?null:map.get("parent_address_id").toString());
        addressModel.setType(map.get("type").toString());
        addressModel.setLevel(map.get("level").toString());

        return addressModel;


    }
}
