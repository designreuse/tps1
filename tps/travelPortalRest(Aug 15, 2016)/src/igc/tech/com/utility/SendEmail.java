package igc.tech.com.utility;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

public class SendEmail {

    public String access(String userName, String emailId, String pwd, String host, String port, String emailTo,
                         String subject, String emailValue, List<Map> list) {
        final String emailid = emailId;
        final String password = pwd;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
//						try{
                        return new PasswordAuthentication(emailid, password);
//						}catch(Exception e){
//							e.printStackTrace();
//
//						}
                    }
                });


		/*Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						try{
						return new PasswordAuthentication(emailid, AESencrp.decrypt(password));
						}catch(Exception e){
							throw new CustomGenericException("01",e.getLocalizedMessage());
						}
					}
				});*/

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName + "<" + emailid + ">"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            if ( !list.isEmpty()) {
                String emailList = "";
                for (Map map : list) {
                    if (emailList == "") {
                        emailList = emailList.concat(map.get("EMAIL_ID").toString());
                    } else {
                        emailList = emailList.concat(",");
                        emailList = emailList.concat(map.get("EMAIL_ID").toString());
                    }

                }
                message.setRecipients(Message.RecipientType.BCC,
                        InternetAddress.parse(emailList));


            }


            message.setSubject(subject);


            message.setContent(emailValue, "text/html");

            Transport.send(message);

            return "done";

        } catch (MessagingException e) {

            return e.getMessage();
        }

    }

    public static void main(String[] args) {

        List<Map> list = new ArrayList<Map>();
    /*    Map map = new HashMap();
        map.put("EMAIL_ID", "ganga@igctech.com.np");
        list.add(map);
        map.put("EMAIL_ID", "searchganga@yahoo.com");
        list.add(map);
    */    System.out.println(new SendEmail().access("IGC Testing", "igctesting123@gmail.com", "igctesting@123", "smtp.gmail.com", "587", "tilakpeace0000@gmail.com", "test", "hello", new ArrayList<Map>()));


    }

}
