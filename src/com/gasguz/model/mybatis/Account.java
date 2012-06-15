package com.gasguz.model.mybatis;

import com.gasguz.model.AbstractAccount;

public class Account extends AbstractAccount {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_ACCOUNT.USERNAME
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_ACCOUNT.PASSWORD
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_ACCOUNT.LNAME
     *
     * @mbggenerated
     */
    private String lname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column GG_ACCOUNT.EMAIL
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_ACCOUNT.USERNAME
     *
     * @return the value of GG_ACCOUNT.USERNAME
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_ACCOUNT.USERNAME
     *
     * @param username the value for GG_ACCOUNT.USERNAME
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_ACCOUNT.PASSWORD
     *
     * @return the value of GG_ACCOUNT.PASSWORD
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_ACCOUNT.PASSWORD
     *
     * @param password the value for GG_ACCOUNT.PASSWORD
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_ACCOUNT.LNAME
     *
     * @return the value of GG_ACCOUNT.LNAME
     *
     * @mbggenerated
     */
    public String getLname() {
        return lname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_ACCOUNT.LNAME
     *
     * @param lname the value for GG_ACCOUNT.LNAME
     *
     * @mbggenerated
     */
    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GG_ACCOUNT.EMAIL
     *
     * @return the value of GG_ACCOUNT.EMAIL
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GG_ACCOUNT.EMAIL
     *
     * @param email the value for GG_ACCOUNT.EMAIL
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}