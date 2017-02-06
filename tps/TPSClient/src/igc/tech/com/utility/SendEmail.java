package igc.tech.com.utility;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {




	public String access(String userName, String emailId, String pwd, String host, String port, String emailTo,
			String subject, String emailValue) {

		final String emailid = emailId;
		final String password = pwd;

		System.out.println(userName+" "+emailId+" "+pwd+" "+host);
		System.out.println(port+" "+emailTo+" "+subject);
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

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(emailid));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(emailTo));
			msg.setSubject("Your Example.com account has been activated");
			msg.setText("ganga");
//			msg.setContent(emailValue,"text/html");
			Transport.send(msg);


			/*Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName+"<"+emailid+">"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailTo));
			
			message.setSubject(subject);

			
			message.setContent(emailValue, "text/html");

			Transport.send(message);*/

			return "done";

		} catch (MessagingException e) {
			e.printStackTrace();

			return e.getMessage();
		}

	}
	
	public static void main(String[] args) {
		
	  System.out.println( new SendEmail()
			  .access("igc","mailbox.ganga@gmail.com","igctesting@123","smtp.gmail.com", "587",

					  "mailbox.ganga@gmail.com", "test", 	"this is testingn"));
		
		
	}

}
