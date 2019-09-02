import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServerDemo {

    /**
     * @param args
     * @throws MessagingException
     * @throws AddressException
     */
    public static void main(String[] args) throws AddressException, MessagingException {
        String server = args[0];
        Properties mailSessionProperties = new Properties();
        mailSessionProperties.put("mail.smtp.host", server);
        mailSessionProperties.put("mail.from", "korobskd@od.nih.gov");
        mailSessionProperties.put("mail.transport.protocol", "smtp");

        Session mailSession = Session.getDefaultInstance(mailSessionProperties);

        MimeMessage msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress("korobskd@od.nih.gov"));
        msg.setRecipients(Message.RecipientType.TO, "korobskd@od.nih.gov");
        msg.setSubject("[MailServerDemo]");
        msg.setHeader("X-Mailer", "JavaMail");
        msg.setText("Test - please ignore");
        /*
        mailSession.getTransport().sendMessage(msg, new Address[] {
                new InternetAddress("korobskd@od.nih.gov")
        });
        */
        Transport.send(msg);
        System.out.println("E-mail has been sent via " + server + ".");
   }
}
