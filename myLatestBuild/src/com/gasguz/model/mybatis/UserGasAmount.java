package com.gasguz.model.mybatis;

import com.gasguz.action.AbstractForm;
import java.math.BigDecimal;
import java.util.Date;

public class UserGasAmount extends AbstractForm {
  private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_GAS_AMOUNT.USER_ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_GAS_AMOUNT.VENDOR_LOCATION_ID
     *
     * @mbggenerated
     */
    private Long vendorLocationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_GAS_AMOUNT.GAS_GRADE_ID
     *
     * @mbggenerated
     */
    private Long gasGradeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_GAS_AMOUNT.AMOUNT
     *
     * @mbggenerated
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_GAS_AMOUNT.DATE_CREATED
     *
     * @mbggenerated
     */
    private Date dateCreated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_GAS_AMOUNT.DATE_MODIFIED
     *
     * @mbggenerated
     */
    private Date dateModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_GAS_AMOUNT.USER_ID
     *
     * @return the value of GG_USER_GAS_AMOUNT.USER_ID
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_GAS_AMOUNT.USER_ID
     *
     * @param userId the value for GG_USER_GAS_AMOUNT.USER_ID
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_GAS_AMOUNT.VENDOR_LOCATION_ID
     *
     * @return the value of GG_USER_GAS_AMOUNT.VENDOR_LOCATION_ID
     *
     * @mbggenerated
     */
    public Long getVendorLocationId() {
        return vendorLocationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_GAS_AMOUNT.VENDOR_LOCATION_ID
     *
     * @param vendorLocationId the value for GG_USER_GAS_AMOUNT.VENDOR_LOCATION_ID
     *
     * @mbggenerated
     */
    public void setVendorLocationId(Long vendorLocationId) {
        this.vendorLocationId = vendorLocationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_GAS_AMOUNT.GAS_GRADE_ID
     *
     * @return the value of GG_USER_GAS_AMOUNT.GAS_GRADE_ID
     *
     * @mbggenerated
     */
    public Long getGasGradeId() {
        return gasGradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_GAS_AMOUNT.GAS_GRADE_ID
     *
     * @param gasGradeId the value for GG_USER_GAS_AMOUNT.GAS_GRADE_ID
     *
     * @mbggenerated
     */
    public void setGasGradeId(Long gasGradeId) {
        this.gasGradeId = gasGradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_GAS_AMOUNT.AMOUNT
     *
     * @return the value of GG_USER_GAS_AMOUNT.AMOUNT
     *
     * @mbggenerated
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_GAS_AMOUNT.AMOUNT
     *
     * @param amount the value for GG_USER_GAS_AMOUNT.AMOUNT
     *
     * @mbggenerated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_GAS_AMOUNT.DATE_CREATED
     *
     * @return the value of GG_USER_GAS_AMOUNT.DATE_CREATED
     *
     * @mbggenerated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_GAS_AMOUNT.DATE_CREATED
     *
     * @param dateCreated the value for GG_USER_GAS_AMOUNT.DATE_CREATED
     *
     * @mbggenerated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_GAS_AMOUNT.DATE_MODIFIED
     *
     * @return the value of GG_USER_GAS_AMOUNT.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_GAS_AMOUNT.DATE_MODIFIED
     *
     * @param dateModified the value for GG_USER_GAS_AMOUNT.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}