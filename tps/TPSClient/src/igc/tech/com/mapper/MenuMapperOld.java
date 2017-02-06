package igc.tech.com.mapper;

import igc.tech.com.model.MenuModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class MenuMapperOld {


    public List<MenuModel> mapList(List<Map> list) {

        List<MenuModel> resultList = new ArrayList<>();

        MenuModel menuModel;

        for (Map m : list) {
            menuModel = mapRow(m);
            resultList.add(menuModel);
        }



        return resultList;
    }

    public MenuModel mapRow(Map map) {

        MenuModel menuModel = new MenuModel();

        menuModel.setMenuId(map.get("menu_id").toString());
        menuModel.setMenuDesc(map.get("menu_desc").toString());
        menuModel.setMenuUrl(map.get("menu_url").toString());
        menuModel.setParentMenuId(map.get("parent_menu").toString());

        return menuModel;


    }
}
