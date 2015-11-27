package mz.gov.sgec.controller;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailController {

    public void enviarEmail(String emaildestinatario, String titulo, String mensagem){

          final String username = "eltonlaice95@gmail.com";
          final String password = "824477994";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("eltonlaice95@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emaildestinatario));
            message.setSubject(titulo);
            message.setText(mensagem);

            Transport.send(message);

            System.out.println("Mail sent succesfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}