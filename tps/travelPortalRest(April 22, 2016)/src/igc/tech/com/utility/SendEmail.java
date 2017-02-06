package igc.tech.com.utility;


import igc.tech.com.model.MailServerSettingModel;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SendEmail {

    private MailServerSettingModel mailServerSettingModel;

    private List<Map> bccList;
    private String emailTo;
    private String subject;
    private String emailValue;

    public List<Map> getBccList() {
        return bccList;
    }

    public void setBccList(List<Map> bccList) {
        this.bccList = bccList;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public MailServerSettingModel getMailServerSettingModel() {
        return mailServerSettingModel;
    }

    public void setMailServerSettingModel(MailServerSettingModel mailServerSettingModel) {
        this.mailServerSettingModel = mailServerSettingModel;
    }

    public String access() throws  Exception {

        System.out.println("mail testing:"+mailServerSettingModel.toString());

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailServerSettingModel.getHost());
        props.put("mail.smtp.port", mailServerSettingModel.getPort());

        final String password= new  AESencrp().decrypt(mailServerSettingModel.getPassword());

        Authenticator authenticator = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailServerSettingModel.getEmailId(),password );
            }
        };

        Session session = Session.getInstance(props, authenticator);



            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailServerSettingModel.getUserName() + "<" + mailServerSettingModel.getEmailId() + ">"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));


            if (bccList != null) {
                String emailList = "";
                for (Map map : bccList) {

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


    }

    public boolean emailValidator(String email) {
        boolean isValid = false;
        try {
            //
            // Create InternetAddress object and validated the supplied
            // address which is this case is an email address.
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            isValid = true;
        } catch (AddressException e) {
            System.out.println("You are in catch block -- Exception Occurred for: " + email);
        }
        return isValid;
    }


    public static void main(String[] args) throws Exception {

        System.out.println(new SendEmail().emailValidator("sdfsdfsdfsdgmail.com"));

       /* *//**//*PackageEmailModel packageEmailModel = new PackageEmailModel();

        PackageBookingModel packageBookingModel = new PackageBookingModel();

        packageBookingModel.setAmount("3333");
        packageBookingModel.setDiscountAmount("3333");
        packageBookingModel.setTotalAmount("3333");


        packageEmailModel.setPackageBookingModel(packageBookingModel);

        packageEmailModel.setPaymentType("-");*//**//*

        HotelEmailModel hotelEmailModel=new HotelEmailModel();

        HotelBookingModel hotelBookingModel=new HotelBookingModel();

        hotelBookingModel.setAmount("3333");
        hotelBookingModel.setDiscountAmount("3333");
        hotelBookingModel.setTotalAmount("3333");

        hotelEmailModel.setHotelBookingModel(hotelBookingModel);

        //System.out.println(packageEmailModel.getEmailBody());

        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        map.put("EMAIL_ID", "tilak@igctech.com.np");
        list.add(map);


        System.out.println(new SendEmail().access("IGC Testing", "igctesting123@gmail.com", new AESencrp().decrypt("6X8W47tHDqbUz7gw8INRCg=="),
                "smtp.gmail.com", "587", "tilakpeace0000@gmail.com", "test", hotelEmailModel.getEmailBody(), null));
*/

    }

}
