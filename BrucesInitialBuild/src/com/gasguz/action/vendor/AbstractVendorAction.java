package com.gasguz.action.vendor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gasguz.action.AbstractBaseAction;
import com.gasguz.action.customer.AbstractCustomerAction;

public abstract class AbstractVendorAction extends AbstractBaseAction {
  private static Log log = LogFactory.getLog(AbstractVendorAction.class);
  
  public int getRequestType() {
    return REQUEST_TYPE_VENDOR;
  }


}
