package com.sendemail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	final String email = "@gmail.com"; //your email address
	final String password = "**********";
	final String emailSMTPServer = "smtp.gmail.com"; // hotmail = smtp-mail.outlook.com
	final String emailServerPort = "465"; //hotmail = 587
	String receiverEmail = "@gmail.com";
	String emailSubject;
	String emailBody;
	
	
	
	public SendMail(String receiverEmail, String emailSubject, String emailBody) {
		super();
		this.receiverEmail = receiverEmail;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;

        // Recipient's email ID needs to be mentioned.
        String to = "@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("@gmail.com", "*************");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(emailSubject);

            // Now set the actual message
            message.setText(emailBody);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }



	public SendMail(String dayOfWeek, String string) {
		// TODO Auto-generated constructor stub
	}

}