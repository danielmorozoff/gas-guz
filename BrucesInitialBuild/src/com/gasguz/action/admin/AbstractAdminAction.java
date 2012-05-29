package com.gasguz.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gasguz.action.AbstractBaseAction;

public abstract class AbstractAdminAction extends AbstractBaseAction {
  private static Log log = LogFactory.getLog(AbstractAdminAction.class);

  public int getRequestType() {
    return REQUEST_TYPE_ADMIN;
  }


  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    return super.execute(mapping, form, request, response);
  }

}
