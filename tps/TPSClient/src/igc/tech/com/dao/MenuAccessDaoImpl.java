package igc.tech.com.dao;

import igc.tech.com.model.MenuAccessModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuAccessDaoImpl extends JdbcTemplate implements MenuAccessDao {

	
	@Override
	public List procMenuAccess(MenuAccessModel menuAccessModel, String user, String flag) {
		
		
	//		String packageName="UTILITIES";
			
			String procName = "proc_menu_access";
			SimpleJdbcCall call = new SimpleJdbcCall(this);
			
	//		call=call.withCatalogName(packageName);
			call = call.withProcedureName(procName);
			
			call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
			
			call.addDeclaredParameter(new SqlParameter("in_menu_access_id", Types.NUMERIC));
			call.addDeclaredParameter(new SqlParameter("in_role_id", Types.NUMERIC));
			call.addDeclaredParameter(new SqlParameter("in_menu_id", Types.NUMERIC));
			
			
			call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));
			
			
			Map<String, Object> inp = new HashMap<String, Object>();
			inp.put("in_flag", flag);
			
			inp.put("in_menu_access_id", menuAccessModel.getMenuAccessId());
			inp.put("in_role_id", menuAccessModel.getRoleId());
			inp.put("in_menu_id", menuAccessModel.getMenuId());
			
			inp.put("in_user", user);
			
			Map<String, Object> resultMap = call.execute(inp);
		System.out.println(resultMap);
			/*System.out.println(resultMap);
			System.out.println("Inside dao Impl: "+resultMap.get("OUT_DATA"));*/
			
			String  keyName=resultMap.keySet().toArray()[0].toString();
			return (ArrayList<Map>) resultMap.get(keyName);
		
	
	}
	
	

	
}
