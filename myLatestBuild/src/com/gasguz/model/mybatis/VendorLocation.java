package com.gasguz.model.mybatis;

import com.gasguz.action.AbstractForm;
import java.util.Date;

public class VendorLocation extends AbstractForm {
  private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.VENDOR_ID
     *
     * @mbggenerated
     */
    private Long vendorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.NAME
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.ADDRESS
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.PHONE
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.STATUS
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.DATE_CREATED
     *
     * @mbggenerated
     */
    private Date dateCreated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_VENDOR_LOCATION.DATE_MODIFIED
     *
     * @mbggenerated
     */
    private Date dateModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.ID
     *
     * @return the value of GG_VENDOR_LOCATION.ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.ID
     *
     * @param id the value for GG_VENDOR_LOCATION.ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.VENDOR_ID
     *
     * @return the value of GG_VENDOR_LOCATION.VENDOR_ID
     *
     * @mbggenerated
     */
    public Long getVendorId() {
        return vendorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.VENDOR_ID
     *
     * @param vendorId the value for GG_VENDOR_LOCATION.VENDOR_ID
     *
     * @mbggenerated
     */
    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.NAME
     *
     * @return the value of GG_VENDOR_LOCATION.NAME
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.NAME
     *
     * @param name the value for GG_VENDOR_LOCATION.NAME
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.ADDRESS
     *
     * @return the value of GG_VENDOR_LOCATION.ADDRESS
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.ADDRESS
     *
     * @param address the value for GG_VENDOR_LOCATION.ADDRESS
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.PHONE
     *
     * @return the value of GG_VENDOR_LOCATION.PHONE
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.PHONE
     *
     * @param phone the value for GG_VENDOR_LOCATION.PHONE
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.STATUS
     *
     * @return the value of GG_VENDOR_LOCATION.STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.STATUS
     *
     * @param status the value for GG_VENDOR_LOCATION.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.DATE_CREATED
     *
     * @return the value of GG_VENDOR_LOCATION.DATE_CREATED
     *
     * @mbggenerated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.DATE_CREATED
     *
     * @param dateCreated the value for GG_VENDOR_LOCATION.DATE_CREATED
     *
     * @mbggenerated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_VENDOR_LOCATION.DATE_MODIFIED
     *
     * @return the value of GG_VENDOR_LOCATION.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_VENDOR_LOCATION.DATE_MODIFIED
     *
     * @param dateModified the value for GG_VENDOR_LOCATION.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}