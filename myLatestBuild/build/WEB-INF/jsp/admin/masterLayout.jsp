<%@ page contentType="text/html;charset=utf-8" language="java" errorPage="" isErrorPage="false"%>

<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<html>
<head>
<title><tiles:getAsString name="title"/></title>

<meta http-equiv="Content-Type" content="text/html;">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<meta HTTP-EQUIV="Expires" content="-1"> 

<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/tablesorter.css"/>' />
<link rel="Stylesheet" type="text/css" href='<c:url value="/css/blitzer/jquery-ui-1.8.2.custom.css"/>' /> 

<script type="text/javascript" src='<c:url value="/js/jquery-1.4.2.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery-ui-1.8.16.custom.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery.tablesorter.min.js"/>'></script>

<style type="text/css">
</style>

</head>
  
<body>
<table class="stretch">
  <tr>
    <td class="NoSpace">
      <tiles:insert attribute="header"/>
    </td>
  </tr>
  	
  <tr>
  	<td>
      <tiles:insert attribute="leftNav"/>
  	</td>
		<td align="center" valign="top" width="100%">
      <table class="stretch">
        <tr> 
          <td id="bodyContent">
            <tiles:insert attribute="errorMsg"/>
          </td>
        </tr>
        <tr> 
          <td id="bodyContent">
            <tiles:insert attribute="body"/>
          </td>
        </tr>
			</table>
		</td>
  </tr>
</table>
</body>
</html>