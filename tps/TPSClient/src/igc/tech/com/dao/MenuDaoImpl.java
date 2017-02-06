package igc.tech.com.dao;

import igc.tech.com.model.MenuModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuDaoImpl extends JdbcTemplate implements MenuDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/
	
	@Override
	public List procMenu(MenuModel menuModel, String user, String flag) {
		
		
	//		String packageName="UTILITIES";
			String procName = "proc_menu";
			SimpleJdbcCall call = new SimpleJdbcCall(this);
	
			
			
			
			
	//		call=call.withCatalogName(packageName);
			call = call.withProcedureName(procName);
			
			call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
			
			call.addDeclaredParameter(new SqlParameter("in_menu_id", Types.NUMERIC));
			call.addDeclaredParameter(new SqlParameter("in_menu_desc", Types.VARCHAR));
			call.addDeclaredParameter(new SqlParameter("in_menu_url", Types.VARCHAR));
			call.addDeclaredParameter(new SqlParameter("in_parent_menu", Types.NUMERIC));
			
			call.addDeclaredParameter(new SqlParameter("in_user", Types.VARCHAR));
			
			
			
			Map<String, Object> inp = new HashMap<String, Object>();
			inp.put("in_flag", flag);
			
			inp.put("in_menu_id", menuModel.getMenuId());
			inp.put("in_menu_desc", menuModel.getMenuDesc());
			inp.put("in_menu_url", menuModel.getMenuUrl());
			inp.put("in_parent_menu", menuModel.getParentMenuId());
			
			inp.put("in_user", user);
			
			Map<String, Object> resultMap = call.execute(inp);
			
			String  keyName=resultMap.keySet().toArray()[0].toString();
			return (ArrayList<Map>) resultMap.get(keyName);
		
	
	}
	
	

	
}
