package com.gasguz.model.mybatis.dao;

import com.gasguz.model.mybatis.GasGrade;
import com.gasguz.model.mybatis.GasGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasGradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int countByExample(GasGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int deleteByExample(GasGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int insert(GasGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int insertSelective(GasGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    List<GasGrade> selectByExample(GasGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    GasGrade selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") GasGrade record, @Param("example") GasGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") GasGrade record, @Param("example") GasGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GasGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GG_GAS_GRADE
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GasGrade record);
}