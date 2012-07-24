package com.gasguz.action.customer;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gasguz.action.AbstractBaseAction;

public abstract class AbstractCustomerAction extends AbstractBaseAction {
  private static Log log = LogFactory.getLog(AbstractCustomerAction.class);
  
  
  public int getRequestType() {
    return REQUEST_TYPE_CUSTOMER;
  }

  // NOT NEEDED
//  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
//	  AjaxForm aForm = (AjaxForm)form;
//    log.debug("In execute");
//	  return null;  
//  }
 


}
