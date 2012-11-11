package Emailer;


import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import play.mvc.Http.Request;

public class SignupEmailer extends Emailer {

	
public void sendSignupEmail(String emailAddress, String inputedUsername, String fName, String secretEmailKey) throws Exception{
	   
	
		Properties props = new Properties();
	    props.put("mail.smtps.auth", "true");
	  
	    
	    Session session = Session.getDefaultInstance(props);	
	    
	    MimeMessage msg = new MimeMessage(session); 
	   	msg.setFrom(new InternetAddress("contact@gasguz.com"));
	   	
	   	InternetAddress[] addresses = {new InternetAddress(emailAddress),};
        msg.setRecipients(Message.RecipientType.TO, addresses);
        
        msg.setSubject("GasGuz Signup Information");
        msg.setSentDate(new Date());

        // Set message content
        msg.setText(fName+" welcome to GasGuz!\n \n" +
        		"Thank you for registering for a pre-Alpha account. Just link back to http://gasguz.com and sign-in. Once you confirm your email, by providing us with this key: " +secretEmailKey+"\n"+
        		"You will have full access to the GasGuz system. "+
        		"Start by filling out some additional information about yourself. This will enable you to purchase and track your gas consumption.\n\n" +
        			"Also, be sure to take a look at our videos to see how/why GasGuz works. " +
        			"If you run into any issues or problems, please contact us at: "+
        			"contact@gasguz.com \n" +
        			"Or if you prefer, you may leave us annonymous feedback through our website. \n \n"+
        			"We are working hard to improve our system and your thoughts are very important to us! Be sure you share them, especially if they are critical. \n \n"+
        			"Sincerely Yours, \n \n"+
        			"The GasGuz Team\n\n"+
        			"---Also for your records your GasGuz username is: "+inputedUsername+"---"
        		);
        		
        	
        
	    Transport t = session.getTransport("smtps");
	    try {
		t.connect(host, username, password);
		t.sendMessage(msg, msg.getAllRecipients());
	    } finally {
	    	//System.out.println("Emailing Transaction --  COMPLETE");
		t.close();
	    }
}

	
	public void adminHackinAttempt(String user,String pass, Date date, String rAddress, int port, String emailAddress ) throws AddressException, MessagingException{
		
		Properties props = new Properties();
	    props.put("mail.smtps.auth", "true");
	  
	    
	    Session session = Session.getDefaultInstance(props);	
	    
	    MimeMessage msg = new MimeMessage(session); 
	   	msg.setFrom(new InternetAddress("contact@gasguz.com"));
	   	
	   	InternetAddress[] addresses = {new InternetAddress(emailAddress),};
        msg.setRecipients(Message.RecipientType.TO, addresses);
        
        msg.setSubject("Patentula Admin Acnt Hack Attempt");
        msg.setSentDate(new Date());

        // Set message content
        msg.setText("Hey someone is trying to hack the admin account. There were 5 failed login attempts at the closed site. " +
        		"Here are all the last creds we got... \n" +
        		"Username: " + user+ "\n"+
        		"Password: " +pass+ "\n"+
        		"Date: "+ date+"\n"+
        		"Remote Address: "+rAddress+ "\n"+
        		"port: "+port
		);
        		
	      
		    Transport t = session.getTransport("smtps");
		    try {
			t.connect(host, username, password);
			t.sendMessage(msg, msg.getAllRecipients());
		    } finally {
		    	//System.out.println("Emailing Transaction --  COMPLETE");
			t.close();
		    }
	}

}

