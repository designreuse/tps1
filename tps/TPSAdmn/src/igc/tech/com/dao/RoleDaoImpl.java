package igc.tech.com.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import java.util.Map;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;




public class RoleDaoImpl extends JdbcTemplate implements RoleDao {

	/*SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List procRole(String roleId, String roleDesc,String user, String flag) {

		
	//		String packageName="UTILITIES";
			String procName = "proc_role";
			SimpleJdbcCall call = new SimpleJdbcCall(this);



			
	//		call=call.withCatalogName(packageName);
			call = call.withProcedureName(procName);
			
			call.addDeclaredParameter(new SqlParameter("in_flag", Types.CHAR));
			call.addDeclaredParameter(new SqlParameter("in_role_id", Types.NUMERIC));
			call.addDeclaredParameter(new SqlParameter("in_role_desc", Types.VARCHAR));
			call.addDeclaredParameter(new SqlParameter("in_user",Types.VARCHAR));
			
			
			
			Map<String, Object> inp = new HashMap<String, Object>();
			inp.put("in_flag", flag);
			inp.put("in_role_id", roleId);
			inp.put("in_role_desc", roleDesc);
			inp.put("in_user", user);
			
			Map<String, Object> resultMap = call.execute(inp);

			
			System.out.println(resultMap.keySet().toArray()[0]);
			
			String  keyName=resultMap.keySet().toArray()[0].toString();


			return (ArrayList<Map>) resultMap.get(keyName);


	}
	
	

	
}
