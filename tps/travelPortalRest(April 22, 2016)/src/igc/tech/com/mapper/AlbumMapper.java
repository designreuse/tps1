package igc.tech.com.mapper;

import igc.tech.com.model.AlbumModel;
import igc.tech.com.model.RegionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlbumMapper {

    public List<AlbumModel> mapList(List<Map> list) {

        List<AlbumModel> resultList = new ArrayList<>();

        AlbumModel albumModel;

        for (Map m : list) {
            albumModel = mapRow(m);
            resultList.add(albumModel);
        }


        return resultList;
    }

    public AlbumModel mapRow(Map map) {

        AlbumModel albumModel = new AlbumModel();

        if (map.get("ALBUM_ID") != null) {
            albumModel.setAlbumId(map.get("ALBUM_ID").toString());

        }

        if (map.get("ALBUM_CAPTION") != null) {
            albumModel.setAlbumCaption(map.get("ALBUM_CAPTION").toString());

        }

        if (map.get("DETAIL") != null) {
            albumModel.setDetail(map.get("DETAIL").toString());

        }

        if (map.get("TYPE") != null) {
            albumModel.setType(map.get("TYPE").toString());

        }


        if (map.get("COMMON_ID") != null) {
            albumModel.setCommonId(map.get("COMMON_ID").toString());

        }

        if (map.get("IMAGE_ID") != null) {
            albumModel.setImageId(map.get("IMAGE_ID").toString());

        }
        if (map.get("IMAGE_CAPTION") != null) {
            albumModel.setImageCaption(map.get("IMAGE_CAPTION").toString());

        }
        if (map.get("FILE_NAME") != null) {
            albumModel.setFileName(map.get("FILE_NAME").toString());

        }

        return albumModel;
    }

    public AlbumModel mapRowSetNull(boolean albumId,
                                    boolean albumCaption,
                                    boolean detail,
                                    boolean type,
                                    boolean commonId,
                                    boolean imageId,
                                    boolean imageCaption,
                                    boolean fileName,
                                    AlbumModel albumModel) {

        if (albumId == true) {
            albumModel.setAlbumId(null);

        }

        if (albumCaption == true) {
            albumModel.setAlbumCaption(null);

        }

        if (detail == true) {
            albumModel.setDetail(null);

        }

        if (type == true) {
            albumModel.setType(null);

        }


        if (commonId == true) {
            albumModel.setCommonId(null);

        }

        if (imageId == true) {
            albumModel.setImageId(null);

        }
        if (imageCaption == true) {
            albumModel.setImageCaption(null);

        }
        if (fileName == true) {
            albumModel.setFileName(null);

        }


        return albumModel;
    }

    public List<AlbumModel> mapListSetNull(boolean albumId,
                                              boolean albumCaption,
                                              boolean detail,
                                              boolean type,
                                              boolean commonId,
                                              boolean imageId,
                                              boolean imageCaption,
                                              boolean fileName,
                                              List<AlbumModel> albumModels) {

        for (AlbumModel albumModel: albumModels) {

            albumModel = mapRowSetNull(albumId, albumCaption, detail, type, commonId, imageId, imageCaption, fileName, albumModel);

        }

        return albumModels;
    }


}
