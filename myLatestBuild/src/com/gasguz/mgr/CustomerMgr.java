package com.gasguz.mgr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.gasguz.model.mybatis.Account;
import com.gasguz.model.mybatis.dao.AccountMapper;

public class CustomerMgr extends AbstractBaseMgr {
  private static Log log = LogFactory.getLog(CustomerMgr.class);


  public CustomerMgr(SqlSession sqlSession) {
    super(sqlSession);
  }

  public int saveSignup(Account account) throws Exception {
    try {
      AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);      
      return mapper.insert(account);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      sqlSession.rollback(true);
      throw e;
    }
  }
}
