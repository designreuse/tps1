package igc.tech.com.dao;

import igc.tech.com.model.OfferModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface NpayTxnDao {

    public List procNpayTxn(String npayTxnId, String npayConfigId, String merchantTxnId, String amount, String purchaseDesc, String reqStatusCode, String reqMessage,
                            String processId, String gatewayRefNo, String verifyStatusCode, String verifyMessage, String txnStatus, String remarks, String cardNo, String merchantDecs,
                            String txnDateTime, String concernedBank, String hotelBookingId, String user, String flag) ;

}
