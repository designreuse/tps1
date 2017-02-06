package igc.tech.com.utility;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.transform.Source;

import sun.misc.*;

public class Encryption {

    private final String ALGO = "AES";
    private final byte[] keyValue =
            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};


    public String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

    public  String generateHashSha256(String Data) throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update((Data).getBytes("UTF-8"));
        byte[] b=  md.digest();

        System.out.println();

        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(0xff & b[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();


    }

    public static void main(String[] args) throws Exception {

      /*  System.out.println(new Encryption().encrypt("tilak"));

        System.out.println(new Encryption().decrypt("K6S+OLGGKxhnWKQu74Uv0A=="));*/

        String test=new Encryption().generateHashSha256("icgtech_uaticgtech@uat-api");

        String test2="3367e240b90ac610ee1e93c320442cd3278b3a74630c7d6d82ba563fab2fa292";

       String test3= "3367E240B90AC610EE1E93C320442CD3278B3A74630C7D6D82BA563FAB2FA292";

        System.out.println(test);
        System.out.println(test2);
        System.out.println(test3.toLowerCase().equals(test));


    }
}
