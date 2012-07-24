package com.gasguz.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.gasguz.model.dao.GasGuzDAO;

public class SessionFilter implements Filter {
  private static Log log = LogFactory.getLog(SessionFilter.class);

  public void init(FilterConfig filterconfig) throws ServletException {
    log.debug("init Session Filter");
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    // setup and teardown SQL Session for each request
    SqlSession sqlSession = GasGuzDAO.beginTransaction();
    log.info(sqlSession.toString());

    chain.doFilter(request, response);
    GasGuzDAO.endTransaction();
  }

  public void destroy() {
    log.debug("destroy Session Filter");
  }
}
