package igc.tech.com.dao;

import java.util.List;

public interface PackageBookingDao {

    public List procPackageBooking(String packageBookingId, String referenceNo, String amount, String discountAmount,
                                   String totalAmount, String arrivalDate, String departDate,String noOfPerson,
                                   String adult, String child, String additionalInfo,
                                   String referedBy,String payCategory,
                                   String customerDetailId, String availableDateRateId,
                                   String user, String flag);

}
