package igc.tech.com.dao;

import igc.tech.com.model.ActivityModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface EsewaTxnDao {

    public List procEsewaTxn(String esewaTxnId,String esewaConfigId,String amount,String taxAmt,String serviceCharge,String deliveryCharge, String totalAmt, String productId,
                             String refId, String verifyStatus, String hotelBookingId, String user, String flag);

}
