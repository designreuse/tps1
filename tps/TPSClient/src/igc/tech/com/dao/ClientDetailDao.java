package igc.tech.com.dao;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface ClientDetailDao {

    public List procClientDetail(String clientDetailId, String clientName,
                                 String address,
                                 String phoneNumber,
                                 String email,
                                 String companyName,
                                 String companyAddress,
                                 String companyPhone,
                                 String companyEmail,
                                 String active,
                                 String user,
                                 String flag);

}
