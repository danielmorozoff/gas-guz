package com.gasguz.action.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gasguz.mgr.CustomerMgr;
import com.gasguz.model.dao.GasGuzDAO;
import com.gasguz.model.mybatis.Account;


public class CustomerAjaxAction extends AbstractCustomerAction {
  private static Log log = LogFactory.getLog(CustomerAjaxAction.class);

	/**
	 * Default action mapped
	 */
  public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    return signup(mapping, form, request, response);
  }
  

  public ActionForward signup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      Account oForm = (Account)form;
      CustomerMgr mgr = new CustomerMgr(GasGuzDAO.getSession());
      int result = mgr.saveSignup(oForm);
      sendResponse(response, "userCreated_"+oForm.getUsername(), "text/plain");
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      sendResponse(response, e.getMessage(), "text/plain");
    }
		return null;
	}
}
