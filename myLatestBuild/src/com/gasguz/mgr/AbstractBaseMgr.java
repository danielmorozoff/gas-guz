package com.gasguz.mgr;

import java.sql.Connection;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import com.gasguz.action.AbstractForm;
import com.gasguz.model.dao.GasGuzDAO;

public abstract class AbstractBaseMgr {

  protected SqlSession sqlSession;

  public AbstractBaseMgr(SqlSession sqlSession) {    
    if (sqlSession == null) {
      this.sqlSession = GasGuzDAO.getSession();
    } else {
      this.sqlSession = sqlSession;
    }
  }

    
  public Connection getConnection() {
    return sqlSession.getConnection();
  }

  protected void setMetaInsert(AbstractForm form) {
    Date now = new Date();
    form.setAddDttm(now);
    form.setLastupdateDttm(now);
  }

  protected void setMetaUpdate(AbstractForm form) {
    form.setLastupdateDttm(new Date());
  }
}
