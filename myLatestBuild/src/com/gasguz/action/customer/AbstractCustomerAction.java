package com.gasguz.action.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

import com.gasguz.action.AbstractBaseAction;

public abstract class AbstractCustomerAction extends AbstractBaseAction {
  private static Log log = LogFactory.getLog(AbstractCustomerAction.class);
  
  
  public int getRequestType() {
    return REQUEST_TYPE_CUSTOMER;
  }

  public ActionForward renderHomepage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	 /* 
	  User user = mgr.getUser(username, password);
	 if(user!=null){
		 request.setAttribute("user", user);
		 mapping.findForward("home");
	 }
	 */ 
	  return null;
  }

}
