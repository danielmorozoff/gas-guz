<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html"  uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<style type="text/css">
#wrapper {margin:0 0 0 215px;}

#header {margin:0; padding:0; height:90px; background-image:url('<c:url value="/images/red_header_bg.jpg"/>'); background-repeat:repeat-x;}
#header #logo {float:left; padding:15px 11px 0 0;}
#header #site {float:left; margin:22px 0px 0px 0px; padding:0px 0px 0px 17px; width:270px; height:47px; border-left:1px solid #c18a65;}
#header #name {margin:-0.4em 0px 0px 0px;}
#header #name a {font-size:1.9em; color:#ddcf99; font-variant:small-caps; font-family:Georgia, "Times New Roman", Times, serif; letter-spacing:0.05em;}
#header #slogan {margin:0px; font-size:1.4em; color:#ddcf99; font-variant:small-caps; font-family:Georgia, "Times New Roman", Times, serif; letter-spacing:0.05em;}

ul.links li{background:none;font-size:12px;margin:0 10px 0 0;padding:0;}
#nav {margin:0 auto;height:24px; width:100%; text-align:center; background-image:url(http://www.gasguz.com/images/nav/nav_topic_bg.jpg); background-repeat:repeat-x}
#nav ul {margin:0 auto; border-left:1px solid #8a887d; height:24px; padding:0;}
#nav li {margin:0; float:left; height:24px; list-style-type:none; text-align:left; border-right:1px solid #8a887d; padding-top:0px; background-image:url(http://www.gasguz.com/images/nav/nav_button_bg.jpg); background-repeat:no-repeat}
#nav li a {margin:0; display:block; height:24px; width:181px; text-decoration:none; padding-top:3px; padding-left:10px; font-size:12px; border:none; color:#3f3c30; font-weight:300; letter-spacing:1px}
#nav li:hover, #nav li.active {background-image:url(http://www.gasguz.com/images/nav/nav_button_bg_hover.jpg) }
#nav li.active a {color:#820000;}
</style>

<div id="layout">
  <div id="wrapper">
    <div id="header">
      <div id="logo">
        <a href="http://www.gasguz.com"><html:img page="/images/logo.png" border="0" alt="Gas Guz" /></a>
      </div>
      <div id="site">
        <div id="name"><a href="http://www.gasguz.com" title="Gas Guz Admin">Gas Guz Admin</a></div>
      </div>
    </div>    
    
    <div id="nav" style="clear:both;">
      <ul>
        <li><a href='<c:url value="/student/logout.do"/>'>Logout</a></li>
      </ul>
    </div>
  </div>
</div>
