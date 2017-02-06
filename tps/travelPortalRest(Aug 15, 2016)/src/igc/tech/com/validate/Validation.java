package igc.tech.com.validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Validation {

	public List<ValidData> test(List<ValidData> validDatas){

		List<ValidData> validDatas1=new ArrayList<>();

		for(ValidData validData:validDatas ){

		ValidType validType=validData.getValidType();

			if (requiredField(validData.getValue())){

				if (validType.isEmail()){
					if (!emailValidation(validData.getValue())){
						validData.getErrorMessageList().add("Invalid Email Format");
					}
				}

				if (validType.isNumber()){
					if (!numberValidation(validData.getValue())){
						validData.getErrorMessageList().add("Invalid Number Format");
					}
				}

				if (validType.isUrl()){
					if (!urlValidation(validData.getValue())){
						validData.getErrorMessageList().add("Invalid Url Format");
					}
				}
			}

			else {
				validData.getErrorMessageList().add("Field Required");
			}

			if(!validData.getErrorMessageList().isEmpty()){
				validData.setValidType(null);
				validDatas1.add(validData);
			}

		}

		return validDatas1;
	}


	public Map Validation(HashMap<String, HashMap<String, Object>> map){
		String msg;
//		List<String> message = new ArrayList<>();
		HashMap<Object, String> message=new HashMap<Object, String>();
		for(Map.Entry m:map.entrySet()){
			if(m.getKey()=="email"){
				HashMap<String,Object> mailMap= new HashMap<String,Object>(); 
				mailMap=map.get("email");
//				System.out.println("check1 inside mail"+mailMap);
//				System.out.println("check2 inside mail"+m.getValue());
				for(Map.Entry m1:mailMap.entrySet()){
					if(requiredField(m1.getValue().toString())){
//						System.out.println("check email");
						if(!emailValidation(m1.getValue().toString()))
//							message.add(m1.getKey()+" is wrong email address");
							message.put(m1.getKey(),"Incorrect Email Address");
					}
//						msg=emailValidation(m1.getValue().toString());
						
					}
				
			}else if(m.getKey()=="number"){
				HashMap<String,Object> mailMap= new HashMap<String,Object>(); 
				mailMap=map.get("number");
				for(Map.Entry m1:mailMap.entrySet()){
					if(requiredField(m1.getValue().toString())){
						if(!numberValidation(m1.getValue().toString()))
//							message.add(m1.getKey()+" must be integer");
							message.put(m1.getKey(), "Must Be Integer");
					}
//						msg=emailValidation(m1.getValue().toString());
						
					}
				
			}else if(m.getKey()=="url"){
				HashMap<String,Object> mailMap= new HashMap<String,Object>(); 
				mailMap=map.get("url");
				for(Map.Entry m1:mailMap.entrySet()){
					if(requiredField(m1.getValue().toString())){
						if(!urlValidation(m1.getValue().toString()))
//							message.add(m1.getKey()+" must be integer");
							message.put(m1.getKey(), "Not In Proper Format");
					}
//						msg=emailValidation(m1.getValue().toString());
						
					}
				
			}else if(m.getKey()=="required"){
				HashMap<String,Object> requiredMap= new HashMap<String,Object>(); 
				requiredMap=map.get("required");
				for(Map.Entry m1:requiredMap.entrySet()){
					if(!requiredField(m1.getValue().toString()))
//						message.add(m1.getKey()+" is required field");
						message.put(m1.getKey(), "Required Field");
					
				}
			}else{
				continue;
			}
				
		}  
		return message;
	}
	
	public Boolean requiredField(String param){
		if(param==null || param=="" || param.trim().isEmpty())
			return false;
		
		/*if(requiredField==null||requiredField==""){
			return false;
		}else
			return true;*/
		return true;
	}
	
	public Boolean emailValidation(String email){
//		String regex="^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$";
		String regx="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
//		Pattern pattern = pattern.compile("^[\w_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$")
		if(email.matches(regx))
			return true;
		else
			return false;
		
	}
	
	public Boolean numberValidation(String number){
//		String regex="^[0-9]*$";
		String regex="^[0-9]+(\\.[0-9][0-9]?)?$";
		if(number.matches(regex))
			return true;
		else 
			return false;
	}
	
	public Boolean urlValidation(String url){
//		^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$
//		String regex="^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
		
		String regex="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		if(url.matches(regex))
			return true;
		else
			return false;
	}
/*return true;
}*/
}