package igc.tech.com.mapper;

import igc.tech.com.model.RoleModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class RoleMapper {


    public List<RoleModel> mapList(List<Map> list) {

        List<RoleModel> resultList = new ArrayList<>();

        RoleModel roleModel;

        for (Map m : list) {
            roleModel = mapRow(m);
            resultList.add(roleModel);
        }



        return resultList;
    }

    public RoleModel mapRow(Map map) {

        RoleModel roleModel = new RoleModel();

        roleModel.setRoleId(map.get("role_id").toString());
        roleModel.setRoleDesc(map.get("role_desc").toString());

        return roleModel;


    }
}
