package com.gasguz.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.NDC;
import org.apache.log4j.PropertyConfigurator;

public class LogFilter implements Filter {
  private static Log log = LogFactory.getLog(LogFilter.class);

  /**
   * {@inheritDoc}
   */
  public void init(FilterConfig config) throws ServletException {
    long rate = 60000L;
    String prefix =  config.getServletContext().getRealPath("/");
    String file = config.getInitParameter("log4j-prop-file");
    
    String refreshRate = config.getInitParameter("refresh-rate");
    try {
      if (refreshRate != null && !"".equals(refreshRate)) {
        rate = Long.parseLong(refreshRate);
      }
    } catch (NumberFormatException e) {
      System.err.println("refresh-rate init param must be numeric (defaulting to 60 seconds) [" + refreshRate + "]");
      e.printStackTrace();
    }
      
    if (file == null) {
      System.err.println("log4j property file not found");
    } else {
      PropertyConfigurator.configureAndWatch(prefix+file, rate);
    }
    
    log.info("");
    log.info(prefix+file);
  }

  /**
   * {@inheritDoc}
   */
  public void destroy() {
    log.debug("");
  }

  /**
   * {@inheritDoc}
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    if (log.isInfoEnabled()) {
      HttpServletRequest httpRequest = (HttpServletRequest) request;

      // Conditionally select and set the character encoding to be used
      if (httpRequest.getCharacterEncoding() == null) {
        log.info("charEncoding from response is null setting to UTF-8");
        httpRequest.setCharacterEncoding("UTF-8");
      }

      String uri = httpRequest.getRequestURI();
      
      // indicate which part of SAM they're accessing
      StringBuffer pushString = new StringBuffer();    
      if (uri != null) {
        if (uri.startsWith("/gasguz/vendor")) {
          pushString.append("V:");
        } else if (uri.startsWith("/gasguz/customer")) {
          pushString.append("C:");
        } else if (uri.startsWith("/gasguz/admin")) {
          pushString.append("A:");
        } else {
          pushString.append("O:");
        }
      }
      pushString.append(request.getRemoteAddr());      
      NDC.push(pushString.toString());

      log.info("START " + request.getRemoteHost() + " : " + request.getRemoteAddr());
      
      StringBuffer msg = new StringBuffer();
      msg.append("URI=[");
      msg.append(uri);
      if (httpRequest.getQueryString() == null) {
        msg.append("]");
      } else {
        msg.append("/");
        msg.append(httpRequest.getQueryString());
      }
      log.info(msg.toString());

      log.info("host         [" + httpRequest.getHeader("host") + "]");
      log.info("user-agent   [" + httpRequest.getHeader("user-agent") + "]");
      log.info("content-type [" + httpRequest.getContentType() + "]");
      log.info("charEncoding [" + httpRequest.getCharacterEncoding() + "]");
      
      logRequestParameters(httpRequest);
    }

    chain.doFilter(request, response);
    
    if (log.isInfoEnabled()) {
      log.info("END " + request.getRemoteHost() + " : " + request.getRemoteAddr());
      NDC.clear();
    }
  }
  
  private void logRequestParameters(HttpServletRequest request)
  {
    String msg;
    Enumeration<String> names = request.getParameterNames();
    while (names.hasMoreElements()) {
      String name = (String)names.nextElement();
      msg = (new StringBuilder()).append("Request Param: ").append(name).append("=").append(request.getParameter(name)).toString();
      log.info(msg);
    }
  }
}
