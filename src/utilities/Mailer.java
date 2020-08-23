package utilities;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailer {



    public void SendMail(String pin ,String address) throws MessagingException {


         Properties mailServerProperties;
         Session getMailSession;
         MimeMessage generateMailMessage;

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("andreadepaolis99@gmail.com"));
        generateMailMessage.setSubject(loadTitle());
        String emailBody = loadEmailText(pin);
        generateMailMessage.setContent(emailBody, "text/html");

        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "andreadepaolis99@gmail.com", "gattomio99");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

    }

    private String loadTitle() {
        return "New Pin";
    }

    private String loadEmailText(String pin) {

        return "Dear user your new pin is: " + pin + "; thanks for using our app :)";
    }
}
