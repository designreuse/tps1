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


    @Override
    public List procPackageInfo(String packageInfoId, String description,
                                String noOfDays, String noOfNights, String totalDays,
                                String packageDetails,String clientDetailId, String user,
                                String flag) {


        String procName = "proc_package_info";

		/*
         * creating jdbc call object
		 */

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

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
        call.addDeclaredParameter(new SqlParameter("IN_CLIENT_DETAIL_ID",
                Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));


        System.out.println("here");

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("IN_PACKAGE_INFO_ID", packageInfoId);
        inp.put("IN_DESCRIPTION", description);
        inp.put("IN_NO_OF_DAYS", noOfDays);
        inp.put("IN_NO_OF_NIGHTS", noOfNights);
        inp.put("IN_TOTAL_DAYS", totalDays);
        inp.put("IN_PACKAGE_DETAILS", packageDetails);
        inp.put("IN_CLIENT_DETAIL_ID", clientDetailId);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        System.out.println(resultMap);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);

        // return (ArrayList<Map>) resultMap.get("OUT_DATA");

    }

}
