package igc.tech.com.dao;

import igc.tech.com.model.MailServerSettingModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MailServerSettingDaoImpl extends JdbcTemplate implements MailServerSettingDao {

	
	@Override
	public List procMailServerSetting(MailServerSettingModel mailServerSettingModel, String user, String flag){
		try{
	//		String packageName="UTILITIES";
			String procName = "PROC_MAIL_SERVER_SETTING";
			SimpleJdbcCall call = new SimpleJdbcCall(this);
			
	//		call=call.withCatalogName(packageName);
			call = call.withProcedureName(procName);
			
			call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
			
			call.addDeclaredParameter(new SqlParameter("IN_MAIL_SERVER_SETTING_ID", Types.NUMERIC));
			call.addDeclaredParameter(new SqlParameter("in_display_name", Types.VARCHAR));
			call.addDeclaredParameter(new SqlParameter("IN_EMAIL_ID", Types.VARCHAR));
			call.addDeclaredParameter(new SqlParameter("IN_PASSWORD", Types.VARCHAR));
			call.addDeclaredParameter(new SqlParameter("IN_HOST", Types.VARCHAR));
			call.addDeclaredParameter(new SqlParameter("IN_PORT", Types.NUMERIC));
			call.addDeclaredParameter(new SqlParameter("IN_ACTIVE", Types.CHAR));

			call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

			Map<String, Object> inp = new HashMap<String, Object>();
			inp.put("IN_FLAG", flag);
			
			inp.put("IN_MAIL_SERVER_SETTING_ID", mailServerSettingModel.getMailServerSettingId());
			inp.put("in_display_name", mailServerSettingModel.getDisplayName());
			inp.put("IN_EMAIL_ID", mailServerSettingModel.getEmailId());
			inp.put("IN_PASSWORD", mailServerSettingModel.getPassword());
			inp.put("IN_HOST", mailServerSettingModel.getHost());
			inp.put("IN_PORT", mailServerSettingModel.getPort());
			inp.put("IN_ACTIVE", mailServerSettingModel.getActive());

			inp.put("IN_USER", user);
			
			Map<String, Object> resultMap = call.execute(inp);
			System.out.println("resultMap: "+resultMap);
			/*System.out.println(resultMap);
			System.out.println("Inside dao Impl: "+resultMap.get("OUT_DATA"));*/
			
			String  keyName=resultMap.keySet().toArray()[0].toString();
			return (ArrayList<Map>) resultMap.get(keyName);
		}catch(Exception e){
			e.printStackTrace();
			Map map=new HashMap<>();
			map.put("STATUS", "UnSuccess");
			map.put("MSG", e.getMessage());
			List<Map> list = new ArrayList<>();
			list.add(map);
			return list;
		}
	
	}

}
