package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class PackageInfoDaoImpl extends JdbcTemplate implements PackageInfoDao {

	/*
     *
	 * package_info_id description no_of_days no_of_nights total_days
	 * package_details
	 */

    @Override
    public List procPackageInfo(String package_info_id,String clientDetailId, String description,
                                String no_of_days, String no_of_nights, String total_days,
                                String package_details, String user, String flag) {


        String procName = "proc_package_info";

		/*
		 * creating jdbc call object
		 */

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_CLIENT_DETAIL_ID",
                Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_INFO_ID",
                Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_DESCRIPTION",
                Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_NO_OF_DAYS",
                Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_NO_OF_NIGHTS",
                Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_TOTAL_DAYS",
                Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_PACKAGE_DETAILS",
                Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));


        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_PACKAGE_INFO_ID", package_info_id);
        inp.put("IN_CLIENT_DETAIL_ID", clientDetailId);
        inp.put("IN_DESCRIPTION", description);
        inp.put("IN_NO_OF_DAYS", no_of_days);
        inp.put("IN_NO_OF_NIGHTS", no_of_nights);
        inp.put("IN_TOTAL_DAYS", total_days);
        inp.put("IN_PACKAGE_DETAILS", package_details);
        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);


        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

        // return (ArrayList<Map>) resultMap.get("OUT_DATA");

    }

}
