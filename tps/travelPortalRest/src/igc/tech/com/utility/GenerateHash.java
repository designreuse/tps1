package igc.tech.com.utility;

import java.security.MessageDigest;


public class GenerateHash {

	/**
	 * table to convert a nibble to a hex char.
	 */
	static final char[] hexChar = {
	'0' , '1' , '2' , '3' ,
	'4' , '5' , '6' , '7' ,
	'8' , '9' , 'a' , 'b' ,
	'c' , 'd' , 'e' , 'f'};

	/**
	 * Fast convert a byte array to a hex string
	 * with possible leading zero.
	 * @param b array of bytes to convert to string
	 * @return hex representation, two chars per byte.
	 */
	public static String encodeHexString ( byte[] b )
	   {
	   StringBuffer sb = new StringBuffer( b.length * 2 );
	for ( int i=0; i<b.length; i++ )
	      {
	// look up high nibble char
	      sb.append( hexChar [( b[i] & 0xf0 ) >>> 4] );

	// look up low nibble char
	      sb.append( hexChar [b[i] & 0x0f] );
	      }
	return sb.toString();
	   }



	public  String generateHash(String Data) throws Exception
	{
	  MessageDigest md = MessageDigest.getInstance("SHA-256");

	  md.update((Data).getBytes("UTF-8"));

	return encodeHexString(md.digest());
	}
	


	public static void main(String[] args) {
		/*try {
			System.out.println (generateHash("sdfsdfs"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
