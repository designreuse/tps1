package igc.tech.com.dao;

import java.util.List;

public interface AlbumDao {

	public List procAlbum(String albumId, String albumCaption,
						   String detail, String type, String commonId, String imageId, String user, String flag);

}
