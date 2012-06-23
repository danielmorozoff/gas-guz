<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<style type="text/css">
.portal {width: 200px; color:black; font-family:Arial,Verdana,Helvetica,Sans-serif; font-size:13px; font-weight:bold; padding:5px;}
.portal .header {background-image:url('<c:url value="/images/left_nav_head_bg.jpg"/>'); margin-bottom:1px; text-transform:uppercase; padding:7px 0 7px 7px;}

.portal .menu {list-style-type:none; margin:0; padding:0;}
.portal .menu li {padding-bottom:1px;}
.portal .menu li a {font-family:Arial,Verdana,Helvetica,Sans-serif; font-size:13px; font-weight:bold; color:black; background-image:url('<c:url value="/images/left_nav_head_bg.jpg"/>'); display:block; padding:5px 0 5px 7px; line-height:17px; text-decoration:none;}
.portal .menu li a:visited {color:black;}
.portal .menu li a:hover {background:#fbf9f2;}

.portal .submenu {list-style-type:none; margin:0; padding:0;}
.portal .submenu li {padding-bottom:1px;}
.portal .submenu li a {font-family:Arial,Verdana,Helvetica,Sans-serif; font-size:12px; font-weight:bold; color:black; background:#D8D8D8; display:block; padding:5px 0 5px 25px; line-height:17px; text-decoration:none;}
.portal .submenu li a:visited {color:black;}
.portal .submenu li a:hover {background:#fbf9f2;}
</style>

<div class="portal">      
  <div class="header">Left Nav Option A</div>
  <ul class="submenu">
    <li><a href='<c:url value="/student/application.do"/>'>Left Nav SubOption A</a></li>
    <li><a href='<c:url value="/student/renewApplication.do"/>'>Left Nav SubOption B</a></li>
    <li><a href='<c:url value="/student/reviewApplication.do"/>'>Left Nav SubOption A</a></li>
          <li><a href='<c:url value="/student/applicationEdit.do"/>'>Left Nav SubOption D</a></li>
    <li><a href='<c:url value="/student/withdrawApplication.do"/>'>Left Nav SubOption E</a></li>
    <li><a href='<c:url value="/student/applicationResults.do"/>'>Left Nav SubOption F</a></li>
    <li><a href='<c:url value="/student/reassignApplication.do"/>'>Left Nav SubOption G</a></li>
  </ul>        
  <div class="header">Left Nav Option B</div>
  <ul class="submenu">
    <li><a href='<c:url value="/student/contractsView.do"/>'>Left Nav SubOption B</a></li>
    <li><a href='<c:url value="/student/cancelAssignment.do"/>'>Left Nav SubOption B</a></li>
    <li><a href='<c:url value="/student/toc.do"/>'>Left Nav SubOption B</a></li>
  </ul>
  <ul class="menu">
    <li><a href='<c:url value="/student/petition.do"/>'>Left Nav Option C</a></li>
  </ul>      
</div>
