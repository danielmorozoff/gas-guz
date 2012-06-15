package com.gasguz.action.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

import com.gasguz.action.AbstractBaseAction;

public abstract class AbstractCustomerAction extends AbstractBaseAction {
  private static Log log = LogFactory.getLog(AbstractCustomerAction.class);
  
  public int getRequestType() {
    return REQUEST_TYPE_CUSTOMER;
  }


}
