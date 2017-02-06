package igc.tech.com.dao;

import igc.tech.com.model.AddressModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface AddressDao {

    public List procAddress(AddressModel addressModel,
                             String user,
                             String flag);

}
