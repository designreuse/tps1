package igc.tech.com.utility;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by Ganga on 8/28/2016.
 */
public class EmailApi {

    public static String sendRegistraionEmail(String baseUri, String hotelName, String token, String toAddress) throws Exception{
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client. addFilter(new LoggingFilter());
        URI baseUri1 = UriBuilder.fromUri(baseUri).build();
        WebResource service = client.resource(baseUri1);

        JSONObject json=new JSONObject();
        json.put("hotelName", hotelName);
        json.put("token", token);
        json.put("emailId", toAddress);

        JSONObject json1=service.path("email").path("registrationStartUp").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
        System.out.println(json1.get("status"));
        return json1.get("status").toString();
    }

    public static String sendAgreementEmail(String baseUri, String hotelName, String username, String toAddress) throws Exception{
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client. addFilter(new LoggingFilter());
        URI baseUri1 = UriBuilder.fromUri(baseUri).build();
        WebResource service = client.resource(baseUri1);

        JSONObject json=new JSONObject();
        json.put("hotelName", hotelName);
        json.put("userName", username);
        json.put("emailId", toAddress);

        JSONObject json1=service.path("email").path("registrationComplete").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
        System.out.println(json1.get("status"));
        return json1.get("status").toString();
    }

    public static String sendActivationEmail(String baseUri, String hotelName, String username, String toAddress) throws Exception{
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client. addFilter(new LoggingFilter());
        URI baseUri1 = UriBuilder.fromUri(baseUri).build();
        WebResource service = client.resource(baseUri1);

        JSONObject json=new JSONObject();
        json.put("hotelName", hotelName);
        json.put("userName", username);
        json.put("emailId", toAddress);

        JSONObject json1=service.path("email").path("clientAccess").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, json);
        System.out.println(json1.get("status"));
        return json1.get("status").toString();
    }




}
