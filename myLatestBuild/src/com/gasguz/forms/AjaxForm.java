package com.gasguz.forms;

import org.apache.struts.action.ActionForm;

public class AjaxForm  extends ActionForm {
	
	private String ajaxObj = null;
	
	public String getAjaxObj() {
		System.out.println("GETTING AJAX OBJ");
		return ajaxObj;
	}
	public void setAjaxObj(String ajaxObj) {
		System.out.println("SETTING AJAX OBJ: "+ajaxObj);
		this.ajaxObj = ajaxObj;
	}

}
