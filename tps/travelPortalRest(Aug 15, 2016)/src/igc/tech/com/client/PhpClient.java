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


public class PhpClient {
  public static void main(String[] args) throws JSONException {

	  ClientConfig config = new DefaultClientConfig();
	  Client client = Client.create(config);
	  client.addFilter(new LoggingFilter());
	  WebResource service = client.resource(getBaseURI());
	  
	  JSONObject jObject=new JSONObject();
	  JSONArray jarray=new JSONArray();
	  JSONObject json=new JSONObject();
	
	  json.put("output","this is testing ");
	  JSONObject json1=service.accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
	  
	  System.out.println(json1);
  }

  private static URI getBaseURI() {
//    return UriBuilder.fromUri("http://192.168.8.2:8081/PaymentGatewayRest").build();
//	  return UriBuilder.fromUri("http://192.168.8.4:8081/PaymentGatewayRest").build();
	  return UriBuilder.fromUri("http://192.168.6.9/ashok/IGC-webservice/service_test.php").build();
//	  return UriBuilder.fromUri("http://192.168.6.12:8081/PaymentGatewayRest").build();
  }
} 
