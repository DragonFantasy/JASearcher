package com.JASearcher;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Mail 
{
	public static void sendMail(String subject, String content, String recipient) throws AddressException, MessagingException
	{
		Properties prop = System.getProperties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.ym.163.com");
		MailAuthenticator auth = new MailAuthenticator("summer@wingjoys.com", "880717");
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(prop, auth));
		message.setFrom("summer@wingjoys.com");
		message.addRecipient(RecipientType.TO, new InternetAddress(recipient));
		message.setSubject(subject);
		message.setContent(content, "text/html;charset=utf-8");
		Transport.send(message);
	}
}
class MailAuthenticator extends Authenticator
{
	String user_name,password;
	public MailAuthenticator(String un, String pw)
	{
		user_name = un;
		password = pw;
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user_name, password);
	}
}