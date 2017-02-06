package igc.tech.com.mapper;

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

        if (map.get("NAME") != null) {
            customerDetailModel.setName(map.get("NAME").toString());

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

    public CustomerDetailModel mapRowSetNull(boolean customerDetailId,
                                             boolean email,
                                             boolean password,
                                             boolean customerTitle,
                                             boolean name,
                                             boolean contactNo,
                                             boolean customerType,
                                             boolean appVersion,
                                             boolean deviceEmail,
                                             boolean deviceId,
                                             boolean regKey,
                                             boolean platform,
                                             boolean activationCode,
                                             boolean otpCode,
                                             boolean active,
                                             CustomerDetailModel customerDetailModel) {


        if (customerDetailId == true) {

            customerDetailModel.setCustomerDetailId(null);
        }
        if (email == true) {

            customerDetailModel.setEmail(null);
        }
        if (password == true) {

            customerDetailModel.setPassword(null);
        }
        if (customerTitle == true) {

            customerDetailModel.setCustomerTitle(null);
        }
        if (name == true) {

            customerDetailModel.setName(null);
        }
        if (contactNo == true) {

            customerDetailModel.setContactNo(null);
        }
        if (customerType == true) {

            customerDetailModel.setCustomerType(null);
        }

        if (appVersion == true) {

            customerDetailModel.setAppVersion(null);
        }
        if (deviceEmail == true) {

            customerDetailModel.setDeviceEmail(null);
        }
        if (deviceId == true) {

            customerDetailModel.setDeviceId(null);
        }

        if (regKey == true) {

            customerDetailModel.setRegKey(null);
        }

        if (platform == true) {

            customerDetailModel.setPlatform(null);
        }


        if (activationCode == true) {

            customerDetailModel.setActivationCode(null);
        }


        if (otpCode == true) {

            customerDetailModel.setOtpCode(null);
        }

        if (active == true) {

            customerDetailModel.setActive(null);
        }


        return customerDetailModel;
    }

    public List<CustomerDetailModel> mapListSetNull(boolean customerDetailId,
                                                    boolean email,
                                                    boolean password,
                                                    boolean customerTitle,
                                                    boolean name,
                                                    boolean contactNo,
                                                    boolean customerType,
                                                    boolean appVersion,
                                                    boolean deviceEmail,
                                                    boolean deviceId,
                                                    boolean regKey,
                                                    boolean platform,
                                                    boolean activationCode,
                                                    boolean otpCode,
                                                    boolean active,
                                                 List<CustomerDetailModel> customerDetailModels) {

        for (CustomerDetailModel customerDetailModel: customerDetailModels) {

            customerDetailModel = mapRowSetNull(customerDetailId,email,password,customerTitle,name,contactNo,customerType,appVersion,deviceEmail,deviceId,regKey,platform,activationCode,otpCode,active, customerDetailModel);

        }



        return customerDetailModels;
    }


}
