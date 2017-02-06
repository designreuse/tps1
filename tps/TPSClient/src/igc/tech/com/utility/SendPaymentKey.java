package igc.tech.com.utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendPaymentKey {
	 public int webServiceCall(String url, String userName, String password){
		 URL postURL=null;
		 HttpURLConnection conn=null;
		 int rc=0;
			try 
			{
				postURL = new URL( url );
				conn = (HttpURLConnection)postURL.openConnection();

				// Set connection parameters. We need to perform input and output, 
		        // so set both as true. 
				conn.setDoInput (true);
				conn.setDoOutput (true);

				// Set the content type we are POSTing. We impersonate it as 
				// encoded form data 
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//				conn.setRequestProperty( "User-Agent", agent );

				//conn.setRequestProperty( "Content-Type", type );
//				conn.setRequestProperty( "Content-Length", String.valueOf( encodedData.length()) );
				conn.setRequestMethod("POST");
				
				
		        // get the output stream to POST to. 
				DataOutputStream output = new DataOutputStream( conn.getOutputStream());
				output.writeBytes( "j_username="+userName );
				output.writeBytes( "j_password="+password );
				output.flush();
		        output.close ();
				
				// Read input from the input stream.
//				DataInputStream  in = new DataInputStream (conn.getInputStream()); 
		    	rc = conn.getResponseCode();
		    	System.out.println("responseCode: "+rc);
		    	System.out.println("message :"+conn.getResponseMessage()); 
		    	
		    	InputStream error = ((HttpURLConnection) conn).getErrorStream();
		    	
				if ( rc != 200)
				{
					BufferedReader is = new BufferedReader(new InputStreamReader( conn.getErrorStream()));
					String _line = null;
					while(((_line = is.readLine()) !=null))
					{
//						respText = respText + _line;
						System.out.println(_line);
					}			
//					nvp = respText ;
				}
		    	
				
				return rc;
			}catch( Exception e )
			{
				// handle the error here
				e.printStackTrace();
				return rc;
			}finally{
				
		        if (conn != null)
		        {
		           conn.disconnect();
		        }
		        return rc;
		   }
		 
	 }
	 
	 public static void main(String[] args) {
		int test=new SendPaymentKey().webServiceCall("/j_spring_security_check", "admin","admin");
//		int test=new SendPaymentKey().webServiceCall("http://gonepalguide.com/beta/sansui/index.php/payment_api/send_request", "ffc5a8a45c673d664f5a4e40e9e4c4611afb5bef27322ffb518499edc05bc82e");
		System.out.println(test);
	}
	 

}
