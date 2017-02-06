package igc.tech.com.mapper;

import igc.tech.com.model.BedTypeModel;
import igc.tech.com.model.CustomerDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDetailMapper {

    public List<CustomerDetailModel> mapList(List<Map> list) {

        List<CustomerDetailModel> resultList = new ArrayList<>();

        CustomerDetailModel customerDetailModel;

        for (Map m : list) {
            customerDetailModel = mapRow(m);
            resultList.add(customerDetailModel);
        }

        return resultList;
    }

    public CustomerDetailModel mapRow(Map map) {

        CustomerDetailModel customerDetailModel = new CustomerDetailModel();



        if (map.get("CUSTOMER_DETAIL_ID") != null) {
            customerDetailModel.setCustomerDetailId(map.get("CUSTOMER_DETAIL_ID").toString());

        }
        if (map.get("EMAIL") != null) {
            customerDetailModel.setEmail(map.get("EMAIL").toString());


        }
        if (map.get("PASSWORD") != null) {
            customerDetailModel.setPassword(map.get("PASSWORD").toString());


        }
        if (map.get("CUSTOMER_TITLE") != null) {
            customerDetailModel.setCustomerTitle(map.get("CUSTOMER_TITLE").toString());


        }

        if (map.get("FIRST_NAME") != null) {
            customerDetailModel.setFirstName(map.get("FIRST_NAME").toString());

        }

        if (map.get("MIDDLE_NAME") != null) {
            customerDetailModel.setMiddleName(map.get("MIDDLE_NAME").toString());


        }
        if (map.get("LAST_NAME") != null) {
            customerDetailModel.setLastName(map.get("LAST_NAME").toString());

        }


        if (map.get("CONTACT_NO") != null) {
            customerDetailModel.setContactNo(map.get("CONTACT_NO").toString());


        }


        if (map.get("CUSTOMER_TYPE") != null) {
            customerDetailModel.setCustomerType(map.get("CUSTOMER_TYPE").toString());


        }

        if (map.get("APP_VERSION") != null) {
            customerDetailModel.setAppVersion(map.get("APP_VERSION").toString());


        }
        if (map.get("DEVICE_EMAIL") != null) {
            customerDetailModel.setDeviceEmail(map.get("DEVICE_EMAIL").toString());


        }
        if (map.get("DEVICE_ID") != null) {
            customerDetailModel.setDeviceId(map.get("DEVICE_ID").toString());


        }
        if (map.get("REG_KEY") != null) {
            customerDetailModel.setRegKey(map.get("REG_KEY").toString());


        }

        if (map.get("PLATFORM") != null) {
            customerDetailModel.setPlatform(map.get("PLATFORM").toString());


        }


        if (map.get("ACTIVATION_CODE") != null) {

            customerDetailModel.setActivationCode(map.get("ACTIVATION_CODE").toString());
        }

        if (map.get("OTP_CODE") != null) {

            customerDetailModel.setOtpCode(map.get("OTP_CODE").toString());
        }

        if (map.get("ACTIVE") != null) {
            customerDetailModel.setActive(map.get("ACTIVE").toString());

        }


        return customerDetailModel;
    }


}
