package com.matc.entity;
// TODO Add instance variable for the date of birth
// TODO Add a calculation for the user's age. Age should not be stored, it should be calculated only.

import java.util.Date;
//import java.time.LocalDate;
import java.time.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.jar.Pack200;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@SuppressWarnings("ALL")
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private Date birthDate;
    private Integer userAge;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param birthDate the user date of birth
     */
    public User(String firstName, String lastName, String userid, Date birthDate, Integer userAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.birthDate = birthDate;
        this.userAge = userAge;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets birthdate.
     *
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birthDate.
     *
     * @param birthDate the user birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Calculate the age of user based on birthday set it
     *
     */
    public void calculateAge() {
        LocalDate ld = new java.sql.Date(birthDate.getTime()).toLocalDate();
        LocalDate today = LocalDate.now();
        Period p = Period.between(ld, today);

        // set age
        userAge = p.getYears();

    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserAge() {

        return userAge;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", bdate='" + birthDate + '\'' +
//                ", age='" + userAge + '\'' +
//                ", userid='" + userid + '\'' +
//                '}';
//    }


}
