package com.gasguz.mgr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.gasguz.model.mybatis.User;
import com.gasguz.model.mybatis.dao.UserMapper;

public class CustomerMgr extends AbstractBaseMgr {
  private static Log log = LogFactory.getLog(CustomerMgr.class);


  public CustomerMgr(SqlSession sqlSession) {
    super(sqlSession);
  }

  public int saveSignup(User account) throws Exception {
    try {
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      setMetaInsert(account);
      return mapper.insert(account);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      sqlSession.rollback(true);
      throw e;
    }
  }
}
