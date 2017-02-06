package igc.tech.com.client;


import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;


public class DetailClient {
  public static void main(String[] args) throws JSONException {

	  ClientConfig config = new DefaultClientConfig();
	  Client client = Client.create(config);
	  client.addFilter(new LoggingFilter());
	  WebResource service = client.resource(getBaseURI());
	  
	  JSONObject jObject=new JSONObject();
	  JSONArray jarray=new JSONArray();
	  JSONObject json=new JSONObject();
	  
	 /* json.put("merchantKey", "dgdfgdgdgdgdgdg");
	  json.put("type", "HOTEL");
	  JSONObject json1=service.path("rest").path("merchantAuth").path("check").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
	  System.out.println(json1);
	 */ 
	  
	  //** for product**
	/*  jObject.put("id", "1");
	  jObject.put("itemName", "mob");
	  jObject.put("detailDesc", "mob");
	  jObject.put("price", "1");
	  jObject.put("refItemNo", "432");
	  
	  jarray.put(jObject);
	  
	  jObject=new JSONObject();
	  
	  jObject.put("id", "2");
	  jObject.put("itemName", "cam");
	  jObject.put("detailDesc", "camera");
	  jObject.put("price", "1");
	  jObject.put("refItemNo", "324432");
	  
	  jarray.put(jObject);
	  
	  json.put("merchantKey", "test1");
	  json.put("refOrder", "432423423");
	  
	  json.put("customerName", "Tilak Nakarmi");
	  json.put("email", "tilakpeace0000@gmail.com");
	  json.put("phoneNo", "432423423");
	  
	  json.put("shipToName", "ram sharma");
	  json.put("shipToStreet", "ktm");
	  json.put("shipToCity", "ktm");
	  json.put("shipToState", "ktm");
	  json.put("shipToCountryCode", "npl");
	  json.put("shipToZip", "2342432");
	  json.put("shipToPhoneNo", "42342342");
	  json.put("item", jarray);
	  
	  JSONObject json1=service.path("rest").path("order").path("product").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
	  System.out.println(json1);*/
	  
	//** for product**
	  
	//** for hotel**
	  json.put("merchantKey", "05e34009c66863bbff02dbb5f7a1a27b9e98981d259db10d872244096807d18d");
	  json.put("refOrder", "432423423");
	  
	  json.put("roomType", "delux");
	  json.put("adults", "0");
	  json.put("childs", "0");
	  json.put("bedType", "double");
	  json.put("checkInDate", "sdfsdf");
	  
	  json.put("checkOutDate", "asdasd");
	  json.put("fullName", "tilak");
	  json.put("company", "igc");
	  
	  json.put("address", "ktm");
	  json.put("country", "nepal");
	  json.put("city", "ktm");
	  json.put("postalCode", "234234");
	  json.put("emailAddress", "tilakpeace0000@gmail.com");
	  
	  json.put("telephone", "23423");
	  json.put("airportPickUp", "");
	  json.put("cost", "1");
	  json.put("priceToPay", "1");
	  
	  JSONObject json1=service.path("rest").path("order").path("hotel").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
	  
	  System.out.println(json1);
  }

  private static URI getBaseURI() {
//    return UriBuilder.fromUri("http://192.168.8.2:8081/PaymentGatewayRest").build();
//	  return UriBuilder.fromUri("http://192.168.8.4:8081/PaymentGatewayRest").build();
	  return UriBuilder.fromUri("http://192.168.6.3:8080/PaymentGatewayRest").build();
//	  return UriBuilder.fromUri("http://192.168.6.12:8081/PaymentGatewayRest").build();
  }
} 
