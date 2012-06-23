package com.gasguz.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public abstract class AbstractDispatchAction extends DispatchAction {
  private static Log log = LogFactory.getLog(AbstractDispatchAction.class);

  public static final String LOG_FATAL = "fatal"; 
  public static final String LOG_ERROR = "error"; 
  public static final String LOG_WARN = "warn"; 
  public static final String LOG_INFO = "info";
  public static final String LOG_DEBUG = "debug";
  

  /**
   * Log what method the DispatchAction is going to call.
   */
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  throws Exception {
    String parameter = getParameter(mapping, form, request, response);
    String name = getMethodName(mapping, form, request, response, parameter);
    log.warn("Calling method: " + (name==null ? "unspecified" : name));
    return super.execute(mapping, form, request, response);
  }

  protected void logURI(HttpServletRequest request, Log log, String logLevel) {
    StringBuffer msg = new StringBuffer();
    msg.append("URI=[");
    msg.append(request.getRequestURI());
    if (request.getQueryString() == null) {
      msg.append("]");
    } else {
      msg.append("/");
      msg.append(request.getQueryString());
    }
    logIt(log, logLevel, msg.toString());
  }

  protected void logRequestAttributes(HttpServletRequest request, Log log, String logLevel) {
    Enumeration<String> names = request.getAttributeNames();
    while (names.hasMoreElements()) {
      String name = names.nextElement();
      String msg = "Request Attr  " + name + "=" + request.getAttribute(name);
      logIt(log, logLevel, msg);
    }
  }

  private void logIt(Log log, String logLevel, String msg) {
    if (LOG_FATAL.equals(logLevel)) {
      log.fatal(msg);
    } else if (LOG_ERROR.equals(logLevel)) {
      log.error(msg);
    } else if (LOG_WARN.equals(logLevel)) {
      log.warn(msg);
    } else if (LOG_INFO.equals(logLevel)) {
      log.info(msg);
    } else {
      log.debug(msg);
    }
  }
}
