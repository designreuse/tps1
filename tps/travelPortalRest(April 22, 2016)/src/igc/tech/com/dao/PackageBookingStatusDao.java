package igc.tech.com.dao;

import java.util.List;

public interface PackageBookingStatusDao {

    public List procPackageBookingStatus(String packageBookingStatusId, String packageBookingId, String packageStatus, String active,String hashCode,
                                         String user, String flag);

}
