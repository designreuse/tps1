package igc.tech.com.utility;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;


public class DetailClient {
	
	
	public JSONObject getProductPassKey(String amount) throws JSONException {
		
		ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  client.addFilter(new LoggingFilter());
		  WebResource service = client.resource(getBaseURI());
		  
		  
		  
		  
		  JSONObject jObject=new JSONObject();
		  JSONArray jarray=new JSONArray();
		  
		  String amt = new BigDecimal(amount).divide(new BigDecimal(2)).toString();
		  System.out.println("amount: "+amt);
		  //** for product**
//		  jObject.put("id", "1");
		  jObject.put("itemName", "mob");
		  jObject.put("detailDesc", "mob");
//		  jObject.put("price", "1.10");
		  jObject.put("price", amt);
		  jObject.put("refItemNo", "432");
		  
		  jarray.put(jObject);
		  
		  jObject=new JSONObject();
		  
//		  jObject.put("id", "2");
		  jObject.put("itemName", "cam");
		  jObject.put("detailDesc", "camera");
//		  jObject.put("price", "1.15");
		  jObject.put("price", amt);
		  jObject.put("refItemNo", "324432");
		  
		  jarray.put(jObject);


		  JSONObject json=new JSONObject();
		  json.put("merchantKey", "a689c301a98462f067cda24a5c571c9377025b78c94d870e47ce7bcc955d04e6");
		  json.put("refOrder", "432423423");
		  
		  json.put("title", "Ms.");
		  json.put("firstName", "Ganga");
		  json.put("middleName", "");
		  json.put("lastName", "Maharjan");
		  json.put("email", "mailbox.ganga@gmail.com");
		  json.put("phoneNo", "432423423");
		  
		  /*json.put("shipToName", "ram sharma");
		  json.put("shipToStreet", "ktm");
		  json.put("shipToCity", "ktm");
		  json.put("shipToState", "ktm");
		  json.put("shipToCountryCode", "npl");
		  json.put("shipToZip", "2342432");
		  json.put("shipToPhoneNo", "42342342");*/
		  json.put("itemDetails", jarray);
		  
		  try{
			 JSONObject json1=service.path("rest").path("product").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
			  System.out.println(json);
			 return json;
		  }catch(Exception e){
			  JSONObject json1=new JSONObject();
			  json1.put("passKey", "error");
			  return json1;
		  }
		
	}
	
	
public JSONObject getHotelPassKey(String amount) throws JSONException {
		
		ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  client.addFilter(new LoggingFilter());
		  WebResource service = client.resource(getBaseURI());
		  
		  JSONObject json=new JSONObject();
		  json.put("merchantKey", "c97beea7a4d946cfe813aa5b6e55b8287347f7efed4b62105b5da5ac93e883c8");
		  json.put("refOrder", "432423423");
		  
		  json.put("roomType", "delux");
		  json.put("adults", "0");
		  json.put("childs", "0");
		  json.put("bedType", "double");
		  json.put("checkInDate", "sdfsdf");
		  
		  json.put("checkOutDate", "asdasd");
		  json.put("title", "Ms.");
		  json.put("firstName", "Ganga");
		  json.put("middleName", "");
		  json.put("lastName", "Maharjan");
		  json.put("company", "igc");
		  
		  json.put("address", "ktm");
		  json.put("country", "nepal");
		  json.put("city", "ktm");
		  json.put("postalCode", "234234");
		  json.put("emailAddress", "mailbox.ganga@gmail.com");
		  
		  json.put("telephone", "23423");
		  json.put("airportPickUp", "");
		  /*json.put("cost", "1");
		  json.put("priceToPay", "1.20");*/
		  json.put("cost", amount);
		  json.put("priceToPay", amount);
		  
		  
		  try{
		  JSONObject json1=service.path("rest").path("hotel").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
		  
		  System.out.println("test: "+json1);
		  
			 return json1;
		  }catch(Exception e){
			  /*System.out.println(e.hashCode());
			  ClientResponse response = service.get(ClientResponse.class);
			  System.out.println(response.getStatus());
			  System.out.println(response.getHeaders());
			  System.out.println(response.getEntityInputStream());
			  try{
			  BufferedReader is = new BufferedReader(new InputStreamReader( response.getEntityInputStream()));
				String _line = null;
				while(((_line = is.readLine()) !=null))
				{
//					respText = respText + _line;
					System.out.println(_line);
				}	
			  }catch(Exception ex){
				  System.out.println("error"+ex.getMessage());
			  }*/
			  JSONObject json1=new JSONObject();
			  json1.put("passKey", "error");
			  return json1;
		  }
		  
		  
		
	}

public JSONObject getTrekKey(String amount) throws JSONException {
	
	ClientConfig config = new DefaultClientConfig();
	  Client client = Client.create(config);
	  client.addFilter(new LoggingFilter());
	  WebResource service = client.resource(getBaseURI());
	  
//	  9fe494356ee9c347800a799436d4b99e320ff012049bd8f91566df301cd58779
	  
	  JSONObject json=new JSONObject();
	  json.put("merchantKey", "038d7a61b64a1418f73aedd55cf752a64c1c834dabe2dd9049d6dee86ac8e2c0");
	  json.put("refOrder", "432423423");
	  
	  json.put("packageName", "testPackage");
	  json.put("accomodation", "testAcc");
//	  json.put("price", "44");
	  json.put("price", amount);
	  json.put("tripType", "test");
	  json.put("checkInDate", "sdfsdf");
	  json.put("checkOutDate", "asdasd");
	  json.put("noOfPax", "2");
	  json.put("title", "Ms.");
	  json.put("firstName", "ganga");
	  json.put("middleName", "");
	  json.put("lastName", "maharjan");
	  json.put("country", "america");
	  json.put("city", "new york");
	  json.put("postalCode", "234234");
	  json.put("emailAddress", "mailbox.ganga@gmail.com");
	  json.put("passportNo", "4355435");
	  
	  try{
		  JSONObject json1=service.path("rest").path("trek").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
		  
	//	  ClientResponse response=service.path("rest").path("trek").accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, json);
		  
	//	  System.out.println(response.getEntity(String.class));
		  
	//	  JSONObject jj=new JSONObject(response.getEntity(String.class)) ;
		  System.out.println(json1);
		  
		 return json1;
	  }catch(Exception e){
		  JSONObject json1=new JSONObject();
		  json1.put("passKey", "error");
		  return json1;
	  }
	
}

	
	
  public static void main(String[] args) throws JSONException {

	  
	  System.out.println(new DetailClient().getProductPassKey("255"));
//	  System.out.println(new DetailClient().getHotelPassKey("255"));
	  
//	     System.out.println(new DetailClient().getTrekKey());  
  
  }

  private static URI getBaseURI() {
//    return UriBuilder.fromUri("http://192.168.8.4/PaymentGatewayRest").build();
   // return UriBuilder.fromUri("http://localhost:8080/PaymentGatewayRest").build();
//    return UriBuilder.fromUri("http://demo.igcpay.com:8080/PaymentGatewayRest").build();
    return UriBuilder.fromUri("http://192.168.8.13:8080/PaymentGatewayRest").build();
  }
} 
