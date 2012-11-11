package Emailer;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPassEmailer extends Emailer{
	
	public void sendForgotPassEmail(String emailAddress, String fName,String pubUId, String uniqueKey) throws Exception{
		   
		
		Properties props = new Properties();
	    props.put("mail.smtps.auth", "true");
	  
	    
	    Session session = Session.getDefaultInstance(props);	
	    
	    MimeMessage msg = new MimeMessage(session); 
	   	msg.setFrom(new InternetAddress("contact@gasguz.com"));
	   	
	   	InternetAddress[] addresses = {new InternetAddress(emailAddress),};
        msg.setRecipients(Message.RecipientType.TO, addresses);
        
        msg.setSubject("GasGuz Password Reseting");
        msg.setSentDate(new Date());

        String resetLink= urlForPasswordReset+"/"+pubUId+"/"+uniqueKey;
        // Set message content
        msg.setText(fName+" seems like you forgot your password.\n \n" +
        		"If so here is a link that will enable you to reset it. \n\n"+
        		resetLink+"\n\n"+
        		"If this was not you who requested this ignore this email. Click here and we will stop this hacker from spamming you for the near future." +
        		"\n\n"+
        		"We are  putting ourselves to the fullest possible use. Have a nice day. \n" +
        		"The GasGuz Team"
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
