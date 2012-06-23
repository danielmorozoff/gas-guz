package com.gasguz.util;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

public class SendMail {
  private static Log log = LogFactory.getLog(SendMail.class);

  public static void main (String args[]) throws Exception {
	  send(args);
  }
  
  public static void send(String args[]) throws Exception {
	  send(args[0], args[1], args[2], args[3], args[4]);
  }

  public static void send(String host, String from, String to, String subject, String msg) throws Exception {
    send(host, from, null, to, null, subject, msg, "text/plain");
  }
  
  public static void send(String host, String from, String personal, String to, Object[] cc, String subject, String msg, String contentType) 
  throws Exception {
	  try {
	    // Get system properties
	    Properties props = System.getProperties();
	
	    // Set the session properties
	    Session session = getSession(props, host);

	    // Define message
	    MimeMessage message = new MimeMessage(session);
	
	    // Set the from address
      InternetAddress fromInternetAddress = new InternetAddress(from);
      if (personal != null) {
        fromInternetAddress.setPersonal(personal);
      }
      message.setFrom(fromInternetAddress);
	
	    // Set the to address
	    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
      // Set the cc addresses
      if (cc != null) {
        for (int i=0; i<cc.length; i++) {
          message.addRecipient(Message.RecipientType.CC, new InternetAddress((String)cc[i]));
        }
      }
  
	    // Set the subject
	    message.setSubject(subject);      

      // Set the content
      message.setContent(msg, contentType);
//	    message.setText(msg);
	
	    // Send message
	    Transport.send(message);

	    // This configuration also works but the above static method is simplier
//      Transport transport = session.getTransport("smtps");
//      transport.connect();
//      transport.sendMessage(message, message.getAllRecipients());
//      transport.close();
	  }
	  catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
  
  public static void send(String host, String from, String personal, String to, Object[] cc, Object[] bcc, String subject, String msg, String[] images) 
  throws Exception {
    // Setup mail server
    Properties props = new Properties();
    
    // Set the session properties
    Session session = getSession(props, host);

    Message message = new MimeMessage(session);

    // Set the FROM address
    InternetAddress fromInternetAddress = new InternetAddress(from);
    if (personal != null) {
      fromInternetAddress.setPersonal(personal);
    }
    message.setFrom(fromInternetAddress);

    // Set the TO address
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

    // Set the CC addresses
    if (cc != null) {
      for (int i=0; i<cc.length; i++) {
        message.addRecipient(Message.RecipientType.CC, new InternetAddress((String)cc[i]));
      }
    }

    // Set the BCC addresses
    if (bcc != null) {
      for (int i=0; i<bcc.length; i++) {
        message.addRecipient(Message.RecipientType.BCC, new InternetAddress((String)bcc[i]));
      }
    }

    // Set the subject
    message.setSubject(subject);      

    // Create a multipart (html part and image part) message
    Multipart multipart = new MimeMultipart("related");

    // Set the html content part (main message body)
    BodyPart htmlPart = new MimeBodyPart();
    htmlPart.setContent(msg, "text/html");
    multipart.addBodyPart(htmlPart);
    
    // Set the image part    
    for (int i=0; i<images.length; i++) {
      BodyPart imgPart=new MimeBodyPart();
      
      // Loading the image
      DataSource ds = new FileDataSource(images[i]);
      imgPart.setDataHandler(new DataHandler(ds));
  
      //Setting the header
      imgPart.setHeader("Content-ID", "image"+i);
      multipart.addBodyPart(imgPart);    
    }
   
    // attaching the multi-part to the message
    message.setContent(multipart);

    Transport.send(message);
//    Transport transport = session.getTransport("smtp");
//    transport.connect("<user>", "<password>");
//    transport.sendMessage(message, message.getAllRecipients());
//    transport.close();
  }

  public static void send(String host, String from, String personal, String to, Object[] cc, Object[] bcc, String subject, String msg, Object[] attachments) 
  throws Exception {
    // Setup mail server
    Properties props = new Properties();

    // Set the session properties
    Session session = getSession(props, host);

    Message message = new MimeMessage(session);

    // Set the FROM address
    InternetAddress fromInternetAddress = new InternetAddress(from);
    if (personal != null) {
      fromInternetAddress.setPersonal(personal);
    }
    message.setFrom(fromInternetAddress);

    // Set the TO address
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

    // Set the CC addresses
    if (cc != null) {
      for (int i=0; i<cc.length; i++) {
        message.addRecipient(Message.RecipientType.CC, new InternetAddress((String)cc[i]));
      }
    }

    // Set the BCC addresses
    if (bcc != null) {
      for (int i=0; i<bcc.length; i++) {
        message.addRecipient(Message.RecipientType.BCC, new InternetAddress((String)bcc[i]));
      }
    }

    // Set the subject
    message.setSubject(subject);      

    // Create a multipart (html part and image part) message
    Multipart multipart = new MimeMultipart();

    // Set the html content part (main message body)
    BodyPart htmlPart = new MimeBodyPart();
    htmlPart.setContent(msg, "text/html");
    multipart.addBodyPart(htmlPart);
    htmlPart.setDisposition("inline");
    
    // Set the attachment part    
    for (int i=0; i<attachments.length; i++) {
      FormFile attachment = (FormFile)attachments[i];
      BodyPart filePart = new MimeBodyPart();      
      DataSource ds = new SendMail().new ByteArrayDataSource(attachment.getFileName(), attachment.getContentType(), attachment.getFileData());
      filePart.setDataHandler(new DataHandler(ds));  
      filePart.setFileName(attachment.getFileName());
      filePart.setDisposition("attachment");
      multipart.addBodyPart(filePart);    
    }
   
    // attaching the multi-part to the message
    message.setContent(multipart);
    Transport.send(message);
  }

  class ByteArrayDataSource implements DataSource {
    byte[] bytes;
    String contentType;
    String name;

    ByteArrayDataSource(String name, String contentType, byte[] bytes) {
      this.name = name;
      this.bytes = bytes;
      this.contentType = contentType;
    }

    public String getContentType() {
      return contentType;
    }

    public InputStream getInputStream() {
      return new ByteArrayInputStream(bytes);
    }

    public String getName() {
      return name;
    }

    public OutputStream getOutputStream() throws IOException {
      throw new FileNotFoundException();
    }
  }

  public static boolean isValidEmailAddress(String emailAddress){
    if (emailAddress == null) {
      return false;
    }
    
    boolean result = true;
    try {
      // just see it if throws an exception
      new InternetAddress(emailAddress);
      if (!hasNameAndDomain(emailAddress) ) {
        result = false;
      }
    }
    catch (AddressException ex){
      result = false;
    }
    return result;
  }

  private static boolean hasNameAndDomain(String emailAddress){
    String[] tokens = emailAddress.split("@");
    return tokens.length == 2 && textHasContent(tokens[0]) && textHasContent(tokens[1]);
  }
  
  private static boolean textHasContent(String text) {
    return (text != null) && (!text.trim().equals(""));
  }

  private static Session getSession(Properties props, String host) {
    // Setup mail server
    props.put("mail.debug", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "25");
    props.put("mail.transport.protocol", "smtp");


    // Set the session properties
    Session session = Session.getDefaultInstance(props, null);

    // set the protocol as it may get over rided by another address mapping found in the classpath.
    session.setProtocolForAddress("rfc822", "smtp");

    return session;
  }

  /**
   * Used to encrypt emails. Tomcat configuration must have:
   * 
   * -Djavax.net.ssl.trustStore=/opt/gasguz/tomcat/conf/.keystore -Djava.security.debug=certpath -Djavax.net.debug=trustmanager -Djavax.net.debug=all
   * 
   * NOTE: keystore must have valid cert (for a self-signed cert you'll need your own trustmanager
   * 
   * @param props
   * @param host
   * @return
   */
  private static Session getSSLSession(Properties props, String host) {
    // Setup mail server
    props.put("mail.debug", "true");

    props.put("mail.smtps.host", host);
    props.put("mail.smtps.port", "465");
    props.put("mail.transport.protocol", "smtps");
    props.put("mail.smtp.starttls.enable", "true");    

    props.put("mail.smtp.ssl.enable", "true");

    // Set the session properties
    Session session = Session.getDefaultInstance(props, null);

    // set the protocol as it may get over rided by another address mapping found in the classpath.
    session.setProtocolForAddress("rfc822", "smtps");

    return session;
  }
}
