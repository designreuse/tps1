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

    public AddressModel mapRowSetNull(boolean addressId,
                                    boolean addressName,
                                    boolean parentAddressId,
                                    boolean type,
                                    boolean level,

                                    AddressModel addressModel) {


        if (addressId == true) {

            addressModel.setAddressId(null);
        }
        if (addressName == true) {

            addressModel.setAddressName(null);
        }
        if (parentAddressId == true) {

            addressModel.setParentAddressId(null);
        }
        if (type == true) {

            addressModel.setType(null);
        }
        if (level == true) {

            addressModel.setLevel(null);
        }


        return addressModel;
    }

    public List<AddressModel> mapListSetNull(boolean addressId,
                                             boolean addressName,
                                             boolean parentAddressId,
                                             boolean type,
                                             boolean level,
                                           List<AddressModel> addressModels) {

        for (AddressModel addressModel: addressModels) {

            addressModel = mapRowSetNull(addressId,addressName,parentAddressId,type,level, addressModel);

        }



        return addressModels;
    }
}