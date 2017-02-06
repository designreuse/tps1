package igc.tech.com.dao;

import igc.tech.com.model.UserDetailModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface UserDetailDao {

    public List procUserDetail(UserDetailModel tokenModel,
                               String user,
                               String flag);

}
