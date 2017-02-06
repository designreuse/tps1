package igc.tech.com.dao;

import igc.tech.com.model.NpayConfigModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface NpayConfigDao {

    public List procNpayConfig(NpayConfigModel npayConfigModel,
                               String user,
                               String flag);

}
