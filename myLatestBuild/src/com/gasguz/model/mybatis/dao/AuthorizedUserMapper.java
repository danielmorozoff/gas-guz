package com.gasguz.model.mybatis.dao;

import com.gasguz.model.mybatis.AuthorizedUser;
import com.gasguz.model.mybatis.AuthorizedUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorizedUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int countByExample(AuthorizedUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int deleteByExample(AuthorizedUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int insert(AuthorizedUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int insertSelective(AuthorizedUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    List<AuthorizedUser> selectByExample(AuthorizedUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    AuthorizedUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AuthorizedUser record, @Param("example") AuthorizedUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AuthorizedUser record, @Param("example") AuthorizedUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AuthorizedUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_AUTHORIZED_USER
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AuthorizedUser record);
}