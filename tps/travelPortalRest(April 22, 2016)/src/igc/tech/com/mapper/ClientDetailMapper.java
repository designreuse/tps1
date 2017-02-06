package igc.tech.com.mapper;

import igc.tech.com.model.ClientDetailModel;
import igc.tech.com.model.RegionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientDetailMapper {

    public List<ClientDetailModel> mapList(List<Map> list) {

        List<ClientDetailModel> resultList = new ArrayList<>();

        ClientDetailModel clientDetailModel;

        for (Map m : list) {
            clientDetailModel = mapRow(m);
            resultList.add(clientDetailModel);
        }

        // System.out.println("ffasdf");

        return resultList;
    }

    public ClientDetailModel mapRow(Map map) {

        ClientDetailModel clientDetailModel = new ClientDetailModel();

        if (map.get("CLIENT_DETAIL_ID") != null) {
            clientDetailModel.setClientDetailId(map.get("CLIENT_DETAIL_ID").toString());

        }

        if (map.get("CLIENT_NAME") != null) {
            clientDetailModel.setClientName(map.get("CLIENT_NAME").toString());

        }

        if (map.get("ADDRESS") != null) {
            clientDetailModel.setAddress(map.get("ADDRESS").toString());

        }

        if (map.get("PHONE_NUMBER") != null) {
            clientDetailModel.setPhoneNumber(map.get("PHONE_NUMBER").toString());

        }


        if (map.get("EMAIL_ID") != null) {
            clientDetailModel.setEmailId(map.get("EMAIL_ID").toString());

        }

        if (map.get("COMPANY_NAME") != null) {
            clientDetailModel.setCompanyName(map.get("COMPANY_NAME").toString());

        }

        if (map.get("COMPANY_ADDRESS") != null) {
            clientDetailModel.setCompanyAddress(map.get("COMPANY_ADDRESS").toString());

        }

        if (map.get("COMPANY_PHONE_NUMBER") != null) {
            clientDetailModel.setCompanyPhoneNumber(map.get("COMPANY_PHONE_NUMBER").toString());

        }


        if (map.get("COMPANY_EMAIL_ID") != null) {
            clientDetailModel.setCompanyEmailId(map.get("COMPANY_EMAIL_ID").toString());

        }

        if (map.get("ACTIVE") != null) {
            clientDetailModel.setActive(map.get("ACTIVE").toString());

        }


        return clientDetailModel;
    }

}
