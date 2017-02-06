package igc.tech.com.mapper;

import igc.tech.com.model.ClientDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class ClientDetailMapper {


    public List<ClientDetailModel> mapList(List<Map> list) {

        List<ClientDetailModel> resultList = new ArrayList<>();

        ClientDetailModel clientDetailModel;

        for (Map m : list) {
            clientDetailModel = mapRow(m);
            resultList.add(clientDetailModel);
        }



        return resultList;
    }

    public ClientDetailModel mapRow(Map map) {

        ClientDetailModel clientDetailModel = new ClientDetailModel();


        clientDetailModel.setClientDetailId(map.get("client_detail_id").toString());
        clientDetailModel.setClientName(map.get("client_name").toString());
        clientDetailModel.setAddress(map.get("address").toString());
        clientDetailModel.setPhoneNumber(map.get("phone_number").toString());
        clientDetailModel.setEmailId(map.get("email_id").toString());
        clientDetailModel.setCompanyName(map.get("company_name").toString());
        clientDetailModel.setCompanyAddress(map.get("company_address").toString());
        clientDetailModel.setCompanyPhone(map.get("company_phone_number").toString());
        clientDetailModel.setCompanyEmail(map.get("company_email_id").toString());
        clientDetailModel.setActive(map.get("active").toString());


        return clientDetailModel;


    }
}
