package com.gasguz.model.mybatis.dao;

import com.gasguz.model.mybatis.VendorLocation;
import com.gasguz.model.mybatis.VendorLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorLocationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int countByExample(VendorLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int deleteByExample(VendorLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int insert(VendorLocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int insertSelective(VendorLocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    List<VendorLocation> selectByExample(VendorLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    VendorLocation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") VendorLocation record, @Param("example") VendorLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") VendorLocation record, @Param("example") VendorLocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(VendorLocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_VENDOR_LOCATION
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(VendorLocation record);
}