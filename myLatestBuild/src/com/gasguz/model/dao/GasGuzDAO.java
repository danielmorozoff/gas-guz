package com.gasguz.model.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GasGuzDAO {
  private static Log log = LogFactory.getLog(GasGuzDAO.class);
  
  private static final String DB_CONFIG_FILE = "MyBatisConfig.xml";
  private static ThreadLocal<SqlSession> SESSION_CACHE = new ThreadLocal<SqlSession>();
  private static SqlSessionFactory sessionFactory = null;

  static {
    try {
      String env = System.getProperty("env");
      log.info("SqlSession using environment [" + env + "]");
      
      Reader reader = Resources.getResourceAsReader(DB_CONFIG_FILE);
      sessionFactory = new SqlSessionFactoryBuilder().build(reader, env);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
  
  public static SqlSession beginTransaction() {
    SqlSession session = sessionFactory.openSession(false);
    SESSION_CACHE.set(session);
    return session;
  }

  public static void endTransaction() {
    SqlSession session = (SqlSession)SESSION_CACHE.get();
    if (session == null) {
      log.error("Ending transaction but SqlSession is null");
    } else {
      session.commit();
      session.close();
      SESSION_CACHE.set(null);
    }
  }

  public static SqlSession getSession() {
    SqlSession session = (SqlSession)SESSION_CACHE.get();
    if (session == null) {
      log.error("SqlSession not initialized");
    }
    return session;
  }
}
