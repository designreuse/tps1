package igc.tech.com.utility;

import igc.tech.com.model.EsewaResponse;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class HttpURLConnectionExample {

   // private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://dev.esewa.com.np/epay/transrec?amt=100&scd=eSewa_IGC&pid=11111&rid=0007C8B";

    private static final String POST_URL = "https://dev.esewa.com.np/epay/transrec";

    private static final String POST_PARAMS = "userName=Pankaj";

    public static void main(String[] args) throws IOException, JAXBException {

       // sendGET();
      //  System.out.println("GET DONE");
       sendPOST();
      System.out.println("POST DONE");

       // System.out.println(httpcall());
    }

    private static void sendGET() throws IOException {

        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};

// Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ;
        }


        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
      //  con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

    }

    private static void sendPOST() throws IOException, JAXBException {

        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public X509Certificate[] getAcceptedIssuers(){return null;}
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};

// Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ;
        }

        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
      //  con.setRequestProperty("User-Agent", USER_AGENT);

        String encodedData = "amt=100&scd=eSewa_IGC&pid=11111&rid=0007C8B";

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(encodedData.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());

            String xx=response.toString();

            EsewaResponse esewaResponse = (EsewaResponse) new Utility().convertXmlToObject(xx, EsewaResponse.class);
            System.out.println(esewaResponse.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }


    public static String httpcall()
    {

        String version = "2.3";
        String agent = "Mozilla/4.0";
        String respText = "";

        String gv_APIEndpoint="https://dev.esewa.com.np/epay/transrec?amt=100&scd=eSewa_IGC&pid=11111&rid=0007C8B";

        //deformatNVP( nvpStr );
        String encodedData = "amt=100&scd=eSewa_IGC&pid=11111&rid=0007C8B";

        System.out.println("encodedData"+ "***"+encodedData );
        try
        {
            URL postURL = new URL( gv_APIEndpoint );
            HttpURLConnection conn = (HttpURLConnection)postURL.openConnection();

            // Set connection parameters. We need to perform input and output,
            // so set both as true.
            conn.setDoInput (true);
            conn.setDoOutput (true);

            // Set the content type we are POSTing. We impersonate it as
            // encoded form data
          //  conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "User-Agent", agent );

            //conn.setRequestProperty( "Content-Type", type );
            conn.setRequestProperty( "Content-Length", String.valueOf( encodedData.length()) );
            conn.setRequestMethod("GET");

            // get the output stream to POST to.
            DataOutputStream output = new DataOutputStream( conn.getOutputStream());
          //  output.writeBytes( encodedData );
            output.flush();
            output.close ();

            // Read input from the input stream.
            DataInputStream  in = new DataInputStream (conn.getInputStream());
            int rc = conn.getResponseCode();
            if ( rc != -1)
            {
                BufferedReader is = new BufferedReader(new InputStreamReader( conn.getInputStream()));
                String _line = null;
                while(((_line = is.readLine()) !=null))
                {
                    respText = respText + _line;
                }
              //  nvp = deformatNVP( respText );
            }

            return respText;

         //   return nvp;
        }
        catch( IOException e )
        {
            // handle the error here
            return null;
        }
    }
}