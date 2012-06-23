package com.gasguz.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.NDC;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gasguz.action.AbstractDispatchAction;


/**
 * Action class to handle HTTP errors such 403, 404, and 500. Methods for
 * handling specific error codes are named handle403, handle404, handle500, etc.
 * 
 * All methods should logError(request) to make sure the error is written to the
 * exception log. Additional logic might include forwarding to a display
 * template error page specific to that error or a general display template
 * error page.
 */
public class HandleError extends AbstractDispatchAction {
  private static Log log = LogFactory.getLog(HandleError.class);

  private static final String ERROR_KEY = "error";
  private static final String ERROR_403_KEY = "error403";
  private static final String ERROR_404_KEY = "error404";
  private static final String ERROR_500_KEY = "error500";

  // A String telling the URI of the resource causing problems
  private static final String ERROR_REQUEST_URI = "javax.servlet.error.request_uri";

  // An Integer telling the error status code, if any
  private static final String ERROR_STATUS_CODE = "javax.servlet.error.status_code";

  // A String telling the exception message, passed to the exception constructor
  private static final String ERROR_MESSAGE = "javax.servlet.error.message";

  // A Throwable object that is the actual exception thrown
  private static final String ERROR_EXCEPTION = "javax.servlet.error.exception";

  // This optional HTTP header field allows the client to specify, for the
  // server's benefit, the address ( URI ) of the document (or element within the
  // document) from which the URI in the request was obtained.
  //
  // BTW, the correct spelling should have been "Referrer". I guess the W3C
  // doesn't have access to a spell checker.
  private static final String HTTP_HEADER_REFERER = "Referer";

  /**
   * Handler for unspecified error code.
   * 
   * @param mapping struts action mapping
   * @param form struts form
   * @param request HTTP request
   * @param response HTTP response
   * @return struts forward
   * @throws Exception
   */
  protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    // Log the error
    logError(request);

    return mapping.findForward(ERROR_KEY);
  }

  /**
   * Handler for HTTP 403 Forbidden
   * 
   * @param mapping struts action mapping
   * @param form struts form
   * @param request HTTP request
   * @param response HTTP response
   * @return struts forward
   * @throws Exception
   */
  public ActionForward handle403(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    // Log the error
    logError(request);

    return mapping.findForward(ERROR_403_KEY);
  }

  /**
   * Handler for HTTP 404 Not Found
   * 
   * @param mapping struts action mapping
   * @param form struts form
   * @param request HTTP request
   * @param response HTTP response
   * @return struts forward
   * @throws Exception
   */
  public ActionForward handle404(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    // Log the error
    logError(request);

    // If there is no referer, we want to display the 404 as the user tried
    // to go directly to an invalid location.
    //
    // The other case is when the URI ends with .do which we consider to be
    // a dynamic request as opposed to a static request such as a .gif, .jpg,
    // etc.
    //
    if (getReferer(request) == null || getErrorUri(request).endsWith(".do")) {
      return mapping.findForward(ERROR_404_KEY);
    } else {
      return mapping.findForward(ERROR_KEY);
    }
  }

  /**
   * Handler for HTTP 500 Internal Server Error
   * 
   * @param mapping struts action mapping
   * @param form struts form
   * @param request HTTP request
   * @param response HTTP response
   * @return struts forward
   * @return
   * @throws Exception
   */
  public ActionForward handle500(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    // Log the error
    logError(request);

    return mapping.findForward(ERROR_500_KEY);
  }

  /**
   * Logs details about the error to the server log.
   * 
   * @param request HTTP request
   */
  private static void logError(HttpServletRequest request) {

    StringBuffer msg = new StringBuffer();

    // Error code.
    msg.append("Error ");
    msg.append(getErrorStatusCode(request));

    // Error URI.
    msg.append(" for URI: ");
    msg.append(getErrorUri(request));
    msg.append(" (");

    // Error message.
    if (getErrorMessage(request) != null) {
      msg.append(" message:");
      msg.append(getErrorMessage(request));
    }

    // Exception type and message.
    if (getErrorException(request) != null) {
      Throwable exception = getErrorException(request);

      // Use root cause exception, if it exists.
      while (exception.getCause() != null) {
        exception = exception.getCause();
        log.error(exception.getMessage(), exception);
      }

      msg.append(" exception:");
      msg.append(exception.getClass().getName());

      if (exception.getMessage() != null) {
        msg.append(" '");
        msg.append(exception.getMessage());
        msg.append("'");
      }
    }

    // HTTP Referer.
    if (getReferer(request) != null) {
      msg.append(" referer:");
      msg.append(getReferer(request));
    }

    msg.append(" )");

    NDC.push(request.getRemoteAddr());
    log.error(msg);
    NDC.clear();
  }

  /**
   * Get the URI that caused the HTTP error. If request does not contain error
   * URI, returns request URI.
   * 
   * @param request HTTP request
   * @return URI
   */
  private static String getErrorUri(HttpServletRequest request) {
    String errorUri = (String) request.getAttribute(ERROR_REQUEST_URI);

    // In case there is no error URI, fallback to request URI.
    //
    if (errorUri == null) {
      errorUri = request.getRequestURI();
    }

    return errorUri;
  }

  /**
   * Gets the error status code from the request.
   * 
   * @param request HTTP request
   * @return error status code
   */
  private static Integer getErrorStatusCode(HttpServletRequest request) {
    return (Integer) request.getAttribute(ERROR_STATUS_CODE);
  }

  /**
   * Gets the error message from the request.
   * 
   * @param request HTTP request
   * @return error message
   */
  private static String getErrorMessage(HttpServletRequest request) {
    return (String) request.getAttribute(ERROR_MESSAGE);
  }

  /**
   * Gets the error exception from the request.
   * 
   * @param request HTTP request
   * @return error exception
   */
  private static Throwable getErrorException(HttpServletRequest request) {
    return (Throwable) request.getAttribute(ERROR_EXCEPTION);
  }

  /**
   * Gets the HTTP "Referer" header.
   * 
   * @param request HTTP request
   * @return referer URI
   */
  private static String getReferer(HttpServletRequest request) {
    return (String) request.getHeader(HTTP_HEADER_REFERER);
  }
}
