package com.gasguz.action;

import java.beans.PropertyDescriptor;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public abstract class AbstractForm extends ActionForm {
  private static final long serialVersionUID = 1L;

  private Long id = new Long(-1);
  private String addUerId;
  private Date addDttm;
  private String lastupdateUserId;
  private Date lastupdateDttm;
  

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getIdStr() {
    return id.toString();
  }
  public void setIdStr(String id) {
    if (id == null || id.isEmpty()) {
      this.id = new Long(-1);
    } else {
      this.id = new Long(id);
    }
  }

  public String getAddUerId() {
    return addUerId;
  }
  public void setAddUerId(String addUerId) {
    this.addUerId = addUerId == null ? null : addUerId.trim();
  }

  public Date getAddDttm() {
    return addDttm;
  }
  public void setAddDttm(Date addDttm) {
    this.addDttm = addDttm;
  }

  public String getLastupdateUserId() {
    return lastupdateUserId;
  }
  public void setLastupdateUserId(String lastupdateUserId) {
    this.lastupdateUserId = lastupdateUserId == null ? null : lastupdateUserId.trim();
  }

  public Date getLastupdateDttm() {
    return lastupdateDttm;
  }
  public void setLastupdateDttm(Date lastupdateDttm) {
    this.lastupdateDttm = lastupdateDttm;
  }
  
  
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    ActionErrors errors = new ActionErrors();

    return errors;
  }

  protected boolean validateDate(String date, boolean nullable) {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    
    try {
      if (date != null && !date.trim().isEmpty()) {
        sdf.parse(date);
      } else if (!nullable) {
        sdf.parse(date);
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public String toString() {
    StringBuffer buf = new StringBuffer();    
    PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(this);
    
    for (int i=0; i<properties.length; i++) {
      String name = properties[i].getName();
      if ("multipartRequestHandler".equals(name) ||
          "servlet".equals(name) ||
          "servletWrapper".equals(name) ) {
        continue;
      }

      buf.append(", ");
      buf.append(name);
      buf.append("=");

      try {
        Object property = PropertyUtils.getProperty(this, name);
        if (property == null) {
          buf.append("null");
        } else {
          buf.append(property.toString());
        }
      } catch (Exception e) {
        buf.append("EXCEPTION");
      }
    }

    return buf.substring(2);
  }
}
