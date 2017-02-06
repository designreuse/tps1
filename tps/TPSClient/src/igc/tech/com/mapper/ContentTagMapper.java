package igc.tech.com.mapper;

import igc.tech.com.model.ContentTagModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 10/24/2016.
 */
public class ContentTagMapper {
    public List<ContentTagModel> mapList(List<Map> list) {

        List<ContentTagModel> resultList = new ArrayList<>();

        ContentTagModel contentTagModel;

        for (Map m : list) {
            contentTagModel = mapRow(m);
            resultList.add(contentTagModel);
        }



        return resultList;
    }

    public ContentTagModel mapRow(Map map) {

        ContentTagModel contentTagModel = new ContentTagModel();

        contentTagModel.setContentTagId(map.get("content_tag_id").toString());
        contentTagModel.setContentId(map.get("content_id").toString());
        contentTagModel.setTagId(map.get("tag_id").toString());

        return contentTagModel;


    }
}
