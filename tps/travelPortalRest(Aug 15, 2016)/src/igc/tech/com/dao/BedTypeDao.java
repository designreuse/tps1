package igc.tech.com.dao;

import igc.tech.com.model.BedTypeModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface BedTypeDao {

    public List procBedType(BedTypeModel tokenModel,
                            String user,
                            String flag);

}
