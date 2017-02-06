package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageBookingStatusDaoImpl extends JdbcTemplate implements PackageBookingStatusDao {

    @Override
    public List procPackageBookingStatus(String packageBookingStatusId, String packageBookingId, String packageStatus, String active,String hashCode,
                                String user, String flag) {

        String procName = "proc_package_booking_status";
        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_BOOKING_STATUS_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_BOOKING_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_STATUS", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_ACTIVE", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_HASH_CODE", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_PACKAGE_BOOKING_STATUS_ID", packageBookingStatusId);
        inp.put("IN_PACKAGE_BOOKING_ID", packageBookingId);
        inp.put("IN_PACKAGE_STATUS", packageStatus);
        inp.put("IN_ACTIVE", active);
        inp.put("IN_HASH_CODE", hashCode);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

    }

}
