package igc.tech.com.dao;

import igc.tech.com.model.NiblConfigModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface NiblConfigDao {

    public List procNiblConfig(NiblConfigModel niblConfigModel,
                                String user,
                                String flag);

}
