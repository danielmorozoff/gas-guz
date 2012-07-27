package com.gasguz.model.mybatis.dao;

import com.gasguz.model.mybatis.UserVendor;
import com.gasguz.model.mybatis.UserVendorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVendorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int countByExample(UserVendorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int deleteByExample(UserVendorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int insert(UserVendor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int insertSelective(UserVendor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    List<UserVendor> selectByExample(UserVendorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    UserVendor selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserVendor record, @Param("example") UserVendorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserVendor record, @Param("example") UserVendorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserVendor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_USER_VENDOR
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserVendor record);
}