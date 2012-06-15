package com.gasguz.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class AbstractBaseAction extends AbstractDispatchAction {
  private static Log log = LogFactory.getLog(AbstractBaseAction.class);
  
  protected static final String SOBJECT = "sObject";

  protected static final int REQUEST_TYPE_ADMIN = 1;
  protected static final int REQUEST_TYPE_VENDOR = 2;
  protected static final int REQUEST_TYPE_CUSTOMER = 4;

//  public abstract boolean hasAccess(HttpServletRequest request, Role role, String method);
  public abstract int getRequestType();
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//    HttpSession session = request.getSession(false);
//    
//    if (session == null) {
//      request.setAttribute("errorMsg", getResources(request).getMessage("error.no.session"));
//      log.info(request.getAttribute("errorMsg"));
//      return mapping.findForward("error500");
//    }
//    
//    HARPSessionObject sObject = (HARPSessionObject) session.getAttribute(SOBJECT);
//    if (sObject == null) {
//      request.setAttribute("errorMsg", getResources(request).getMessage("error.no.login"));
//      try {
//        session.invalidate();
//      }
//      catch (Exception ignored) {          
//      }
//      log.info(request.getAttribute("errorMsg"));
//      return mapping.findForward("error500");
//    } else {
//      String strSunetID = sObject.getStrSunetID();
//      if (strSunetID == null) {
//        request.setAttribute("errorMsg", getResources(request).getMessage("error.no.sunet"));
//        try {
//          session.invalidate();
//        }
//        catch (Exception ignored) {
//        }
//        log.info(request.getAttribute("errorMsg"));
//        return mapping.findForward("error500");
//      }
//    }
//
//    if (sObject.getRole() == null) {
//      // set the user roles
//      UserMgr mgr = new UserMgr((HARPSessionObject)sObject, SamDAO.getSession());
//
//      List<UserRole> userRoles = mgr.getRoles(sObject.getStrSunetID());
//      List<UserObject> userObjects = mgr.getUserObjects(sObject.getStrSunetID());
//      sObject.setRole(new Role(userRoles, userObjects));
//    }
//
//    if (!hasAccess(request, sObject.getRole(), request.getParameter("method"))) {
//      request.setAttribute("errorMsg", getResources(request).getMessage("error.no.authorization"));
//      log.info(request.getAttribute("errorMsg"));
//
//      // the request may have been via ajax
//      JSONArray objs = new JSONArray();
//      JSONObject obj = new JSONObject();
//      obj.put("error", "Session mis-match");
//      objs.put(obj);
//      sendResponse(response, objs, "text/json; charset=UTF-8");
//      
//      return mapping.findForward("error500");
//    }
//    
//    // Clean out the sessions errors
//    sObject.clearEColl();
//    log.debug(sObject);
//
//    ActionMessages msgs = getMessages(request);
//    ActionMessages errors = getErrors(request);
//
//    try {
//      log.debug(mapping.toString());
//      
      ActionForward result = super.execute(mapping, form, request, response);
//      
//      log.debug("AbstractBaseAction execute(complete)");
//
//      // Create Action Messages to send to view
//      if (sObject.getEColl().getCount() > 0) {
//        ImiExceptionCollection exceptions = sObject.getEColl();
//        for (int i=0; i<exceptions.getCount(); i++) {
//          ImiException e = exceptions.getException(i);
//          String msgType = null;
//          if (e instanceof ImiInfoException) {
//            msgType = "info";
//          } else if (e instanceof ImiWarningException) {
//            msgType = "warn";
//          } else {
//            msgType = "error";
//          }
//          
//          Throwable tmp = e;
//          boolean processed = false;
//          do {
//            if (tmp instanceof SQLException) {
//              SQLException sqlE = (SQLException)tmp;
//              if (sqlE.getErrorCode() == 1) {
//                request.setAttribute("errorMsg", getResources(request).getMessage("error.record.exists"));
//                msgs.add("error", new ActionMessage("error.record.exists"));
//                processed = true;
//                break;
//              }
//            }
//            tmp = tmp.getCause();
//          } while (tmp != null);
//
//
//          if (!processed) {
//            if (e.getMessage() != null) {
//              msgs.add(msgType, new ActionMessage("msg.generic", e.getMessage()));
//              request.setAttribute("errorMsg", e.getStrLogString());
//            }
//            if (e.getStrLogString() != null && (e.getMessage() == null || !e.getStrLogString().equals(e.getMessage()))) {
//              msgs.add(msgType, new ActionMessage("msg.generic", e.getStrLogString()));
//              request.setAttribute("errorMsg", e.getStrLogString());
//            }
//          }
//        }
//        if (!msgs.isEmpty()) {
//          saveMessages(request, msgs);
//        }
//      }
//
//      MessageResources mr = getResources(request);
//      Iterator<ActionMessage> iter = msgs.get();
//      while (iter.hasNext()) {
//        ActionMessage msg = (ActionMessage)iter.next();
//        log.info("ActionMessage: " + mr.getMessage(msg.getKey(), msg.getValues()));
//      }
//      iter = errors.get();
//      while (iter.hasNext()) {
//        ActionMessage msg = (ActionMessage)iter.next();
//        log.info("ActionError: " +mr.getMessage(msg.getKey(), msg.getValues()));
//      }
//      
//      return result;
//    } catch (Exception e) {
//      log.error(e.getMessage(), e);
//
//      // Try to make the error message more user friendly by first determining what the error could be
//      Throwable tmp = e;
//      do {
//        if (tmp instanceof SQLException) {
//          SQLException sqlE = (SQLException)tmp;
//          // Integrity or unique constraint error
////          if (sqlE.getErrorCode() == 2291 || sqlE.getErrorCode() == 1) {
//          if (sqlE.getErrorCode() == 1) {
//            request.setAttribute("errorMsg", getResources(request).getMessage("error.record.exists"));
//            msgs.add("error", new ActionMessage("error.record.exists"));
//            saveMessages(request, msgs);
//            break;
//          }
//        } else if (tmp instanceof PersistenceException) {
//          errors.add("", new ActionMessage("error.system"));
//          saveErrors(request, errors);
//        } else if (tmp instanceof RuntimeException) {
//          errors.add("", new ActionMessage("error.system"));
//          saveErrors(request, errors);
//        } else if (tmp instanceof NullPointerException) {
//          errors.add("", new ActionMessage("error.system"));
//          saveErrors(request, errors);
//        } else {
//          errors.add("", new ActionMessage("error.generic", e.getMessage()));
//          saveErrors(request, errors);
//        }
//        tmp = tmp.getCause();
//      } while (tmp != null);
//
//      // errors look different based on who's using the app and where the app occurred.
//      if (getRequestType() == REQUEST_TYPE_BO) {
//        return mapping.findForward("error-bo");
//      } else if (getRequestType() == REQUEST_TYPE_STUDENT) {
//        return mapping.findForward("error-student");
//      } else if (getRequestType() == REQUEST_TYPE_ADMIN) {
//        return mapping.findForward("error-admin");
//      } else {
//        return mapping.findForward("error500");
//      }
//    }
    return result;
  }
  
//  protected HARPSessionObject getSessionObj(HttpSession session) {
//    return (HARPSessionObject)session.getAttribute("sObject");
//  }
//  protected HARPSessionObject getSessionObj(HttpServletRequest request) {
//    return (HARPSessionObject)request.getSession().getAttribute("sObject");
//  }
  

  protected void sendResponse(HttpServletResponse response, Object obj, String type) throws IOException {
    response.setContentType(type);
    PrintWriter pWriter = response.getWriter();
    pWriter.println(obj);
    pWriter.flush();
  }
}
