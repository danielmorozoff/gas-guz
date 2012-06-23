package com.gasguz.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class LogonAction extends AbstractAdminAction {
  private static Log log = LogFactory.getLog(LogonAction.class);

  
  public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    return home(mapping, form, request, response);
  }

  
  public ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    DynaActionForm oForm = (DynaActionForm)form;
    
    log.debug("logon attempt from " + oForm.getString("username"));
    System.out.println("ADMIN LOGON!");
    return mapping.findForward("home");
  }


}
