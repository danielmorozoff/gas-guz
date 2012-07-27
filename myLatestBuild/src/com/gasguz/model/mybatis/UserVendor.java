package com.gasguz.model.mybatis;

import com.gasguz.action.AbstractForm;
import java.util.Date;

public class UserVendor extends AbstractForm {
  private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_VENDOR.USER_ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_VENDOR.VENDOR_ID
     *
     * @mbggenerated
     */
    private Long vendorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_VENDOR.STATUS
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_VENDOR.DATE_CREATED
     *
     * @mbggenerated
     */
    private Date dateCreated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_USER_VENDOR.DATE_MODIFIED
     *
     * @mbggenerated
     */
    private Date dateModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_VENDOR.USER_ID
     *
     * @return the value of GG_USER_VENDOR.USER_ID
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_VENDOR.USER_ID
     *
     * @param userId the value for GG_USER_VENDOR.USER_ID
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_VENDOR.VENDOR_ID
     *
     * @return the value of GG_USER_VENDOR.VENDOR_ID
     *
     * @mbggenerated
     */
    public Long getVendorId() {
        return vendorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_VENDOR.VENDOR_ID
     *
     * @param vendorId the value for GG_USER_VENDOR.VENDOR_ID
     *
     * @mbggenerated
     */
    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_VENDOR.STATUS
     *
     * @return the value of GG_USER_VENDOR.STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_VENDOR.STATUS
     *
     * @param status the value for GG_USER_VENDOR.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_VENDOR.DATE_CREATED
     *
     * @return the value of GG_USER_VENDOR.DATE_CREATED
     *
     * @mbggenerated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_VENDOR.DATE_CREATED
     *
     * @param dateCreated the value for GG_USER_VENDOR.DATE_CREATED
     *
     * @mbggenerated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_USER_VENDOR.DATE_MODIFIED
     *
     * @return the value of GG_USER_VENDOR.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_USER_VENDOR.DATE_MODIFIED
     *
     * @param dateModified the value for GG_USER_VENDOR.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}