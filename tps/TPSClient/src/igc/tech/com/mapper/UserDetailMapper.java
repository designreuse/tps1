package igc.tech.com.mapper;

import igc.tech.com.model.UserDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class UserDetailMapper {


    public List<UserDetailModel> mapList(List<Map> list) {

        List<UserDetailModel> resultList = new ArrayList<>();

        UserDetailModel userDetailModel;

        for (Map m : list) {
            userDetailModel = mapRow(m);
            resultList.add(userDetailModel);
        }



        return resultList;
    }

    public UserDetailModel mapRow(Map map) {

        UserDetailModel userDetailModel = new UserDetailModel();

        userDetailModel.setUserDetailId(map.get("user_detail_id").toString());
        userDetailModel.setName(map.get("name").toString());
        userDetailModel.setAddress(map.get("address")==null?null:map.get("address").toString());
        userDetailModel.setPhoneNo(map.get("phone_no")==null?null:map.get("phone_no").toString());
        userDetailModel.setEmailId(map.get("email_id").toString());
//        userDetailModel.setUserName(map.get("username").toString());
        userDetailModel.setPassword(map.get("password")==null?null:map.get("password").toString());
        userDetailModel.setActive(map.get("active")==null?null:map.get("active").toString());
        userDetailModel.setRoleId(map.get("role_id")==null?null:map.get("role_id").toString());
        userDetailModel.setRoleDesc(map.get("role_desc")==null?null:map.get("role_desc").toString());

        return userDetailModel;


    }
}
