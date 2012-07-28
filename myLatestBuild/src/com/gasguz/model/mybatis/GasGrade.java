package com.gasguz.model.mybatis;

import com.gasguz.action.AbstractForm;
import java.util.Date;

public class GasGrade extends AbstractForm {
  private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_GAS_GRADE.ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_GAS_GRADE.NAME
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_GAS_GRADE.OCTANE
     *
     * @mbggenerated
     */
    private String octane;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_GAS_GRADE.DATE_CREATED
     *
     * @mbggenerated
     */
    private Date dateCreated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_GAS_GRADE.DATE_MODIFIED
     *
     * @mbggenerated
     */
    private Date dateModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_GAS_GRADE.ID
     *
     * @return the value of GG_GAS_GRADE.ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_GAS_GRADE.ID
     *
     * @param id the value for GG_GAS_GRADE.ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_GAS_GRADE.NAME
     *
     * @return the value of GG_GAS_GRADE.NAME
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_GAS_GRADE.NAME
     *
     * @param name the value for GG_GAS_GRADE.NAME
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_GAS_GRADE.OCTANE
     *
     * @return the value of GG_GAS_GRADE.OCTANE
     *
     * @mbggenerated
     */
    public String getOctane() {
        return octane;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_GAS_GRADE.OCTANE
     *
     * @param octane the value for GG_GAS_GRADE.OCTANE
     *
     * @mbggenerated
     */
    public void setOctane(String octane) {
        this.octane = octane == null ? null : octane.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_GAS_GRADE.DATE_CREATED
     *
     * @return the value of GG_GAS_GRADE.DATE_CREATED
     *
     * @mbggenerated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_GAS_GRADE.DATE_CREATED
     *
     * @param dateCreated the value for GG_GAS_GRADE.DATE_CREATED
     *
     * @mbggenerated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_GAS_GRADE.DATE_MODIFIED
     *
     * @return the value of GG_GAS_GRADE.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_GAS_GRADE.DATE_MODIFIED
     *
     * @param dateModified the value for GG_GAS_GRADE.DATE_MODIFIED
     *
     * @mbggenerated
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}