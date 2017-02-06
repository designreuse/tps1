package igc.tech.com.mapper;

import igc.tech.com.model.ContentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class ContentMapper {


    public List<ContentModel> mapList(List<Map> list) {

        List<ContentModel> resultList = new ArrayList<>();

        ContentModel contentModel;

        for (Map m : list) {
            contentModel = mapRow(m);
            resultList.add(contentModel);
        }



        return resultList;
    }

    public ContentModel mapRow(Map map) {

        ContentModel contentModel = new ContentModel();


        contentModel.setContentId(map.get("content_id").toString());
        contentModel.setContentTitle( map.get("content_title").toString());
        contentModel.setContentUrl(map.get("content_url").toString());
        contentModel.setContentPageTitle(map.get("content_page_title").toString());
        contentModel.setContentBody(map.get("content_body").toString());
        contentModel.setMetaDescription(map.get("meta_description").toString());
        contentModel.setMetaKeywords(map.get("meta_keywords").toString());
        contentModel.setMetaTitle(map.get("meta_title").toString());
        contentModel.setActive(map.get("active").toString());

        return contentModel;


    }
}
