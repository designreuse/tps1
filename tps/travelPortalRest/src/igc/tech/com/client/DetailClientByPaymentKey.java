package igc.tech.com.client;


import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;


public class DetailClientByPaymentKey {
  public static void main(String[] args) throws JSONException {

	  ClientConfig config = new DefaultClientConfig();
	  Client client = Client.create(config);
	  client.addFilter(new LoggingFilter());
	  WebResource service = client.resource(getBaseURI());
	  
	  JSONObject jObject=new JSONObject();
	  
	
	//** for hotel**
	  jObject.put("paymentKey", "428eec04c3987b7aeca0166daf4585e0e1a2892cf2be52a806d91a533469d4f2");
	 
	  
	  JSONObject json1=service.path("rest").path("orderQuery").path("paymentKey").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, jObject);
	  
	  System.out.println(json1);
	//** for hotel**
  
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://192.168.6.3:8080/PaymentGatewayRest").build();
    
//    return UriBuilder.fromUri("http://192.168.8.4:8081/PaymentGatewayRest").build();
  }
} 
