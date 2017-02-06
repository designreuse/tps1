package igc.tech.com.mapper;

import igc.tech.com.model.ImageModel;
import igc.tech.com.model.RegionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImageMapper {

    public List<ImageModel> mapList(List<Map> list) {

        List<ImageModel> resultList = new ArrayList<>();

        ImageModel imageModel;

        for (Map m : list) {
            imageModel = mapRow(m);
            resultList.add(imageModel);
        }


        return resultList;
    }

    public ImageModel mapRow(Map map) {

        ImageModel imageModel = new ImageModel();

        if (map.get("IMAGE_ID") != null) {
            imageModel.setImageId(map.get("IMAGE_ID").toString());

        }

        if (map.get("IMAGE_CAPTION") != null) {
            imageModel.setImageCaption(map.get("IMAGE_CAPTION").toString());

        }

        if (map.get("FILE_NAME") != null) {
            imageModel.setFileName(map.get("FILE_NAME").toString());

        }

        if (map.get("ALBUM_ID") != null) {
            imageModel.setAlbumId(map.get("ALBUM_ID").toString());

        }
        if (map.get("ALBUM_CAPTION") != null) {
            imageModel.setAlbumCaption(map.get("ALBUM_CAPTION").toString());

        }
        if (map.get("DETAIL") != null) {
            imageModel.setDetail(map.get("DETAIL").toString());

        }
        if (map.get("COMMON_ID") != null) {
            imageModel.setCommonId(map.get("COMMON_ID").toString());

        }


        return imageModel;
    }

    public ImageModel mapRowSetNull(boolean imageId,
                                    boolean imageCaption,
                                    boolean fileName,
                                    boolean albumId,
                                    boolean albumCaption,
                                    boolean detail,
                                    boolean commonId,
                                    ImageModel imageModel) {

        if (imageId==true) {
            imageModel.setImageId(null);

        }

        if (imageCaption==true) {
            imageModel.setImageCaption(null);

        }

        if (fileName==true) {
            imageModel.setFileName(null);

        }

        if (albumId==true) {
            imageModel.setAlbumId(null);

        }
        if (albumCaption==true) {
            imageModel.setAlbumCaption(null);

        }
        if (detail==true) {
            imageModel.setDetail(null);

        }
        if (commonId==true) {
            imageModel.setCommonId(null);

        }

        return imageModel;
    }

    public List<ImageModel> mapListSetNull(boolean imageId,
                                           boolean imageCaption,
                                           boolean fileName,
                                           boolean albumId,
                                           boolean albumCaption,
                                           boolean detail,
                                           boolean commonId,
                                           List<ImageModel> imageModels) {

        for (ImageModel imageModel: imageModels) {

            imageModel = mapRowSetNull(imageId, imageCaption, fileName, albumId, albumCaption, detail, commonId, imageModel);

        }

        return imageModels;
    }


}
