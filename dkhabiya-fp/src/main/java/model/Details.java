/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.*;

/**
 * Details Entity
 * @author D
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Details.findDetails", query = "select d from Details d"),
        @NamedQuery(name = "Details.findDetailsByCustId", query = "select d from Details d where d.detailID=:detailID"),
        @NamedQuery(name = "Details.findByMaker", query = "select d from Details d where d.creatorName=:makerId"),
        @NamedQuery(name = "Details.findByChecker", query = "select d from Details d where d.authName=:checkerId"),
        @NamedQuery(name = "Details.findUnAuthTxns", query = "select d from Details d where d.authStatus='U'")
})
public class Details extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int detailID;
    private String driversLicence;
    private String SSN;
    private String passportNumber;
    private String stateID;
    private String streetLine1;
    private String streetLine2;    
    private String city;
    private String state;
    private String zipcode;
    @OneToOne(mappedBy = "details")
    private Customer customer;    

    /**
     * Default Constructor
     */
    public Details() {
    }

    /**
     *
     * @param driversLicence
     * @param SSN
     * @param passportNumber
     * @param stateID
     * @param streetLine1
     * @param streetLine2
     * @param city
     * @param state
     * @param zipcode
     * @param creatorName
     * @param authName
     * @param dateLastModified
     * @param authStatus
     */
    public Details(String driversLicence, String SSN, String passportNumber, String stateID, String streetLine1, String streetLine2, String city, String state, String zipcode, String creatorName, String authName, Date dateLastModified, String authStatus) {
        super( creatorName, authName, dateLastModified, authStatus);
        this.driversLicence = driversLicence;
        this.SSN = SSN;
        this.passportNumber = passportNumber;
        this.stateID = stateID;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    //Getter and Setter for each attribute
    
    /**
     * 
     * @return
     */
    public int getDetailID() {
        return detailID;
    }

    /**
     * 
     * @param detailID
     */
    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    /**
     *
     * @return
     */
    public String getDriversLicence() {
        return driversLicence;
    }

    /**
     *
     * @param driversLicence
     */
    public void setDriversLicence(String driversLicence) {
        this.driversLicence = driversLicence;
    }

    /**
     *
     * @return
     */
    public String getSSN() {
        return SSN;
    }

    /**
     *
     * @param SSN
     */
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    /**
     *
     * @return
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     *
     * @param passportNumber
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     *
     * @return
     */
    public String getStateID() {
        return stateID;
    }

    /**
     *
     * @param stateID
     */
    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    /**
     *
     * @return
     */
    public String getStreetLine1() {
        return streetLine1;
    }

    /**
     *
     * @param streetLine1
     */
    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    /**
     *
     * @return
     */
    public String getStreetLine2() {
        return streetLine2;
    }

    /**
     *
     * @param streetLine2
     */
    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     *
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //Overriding the toString method to print details of this entity.

    @Override
    public String toString() {
        return "Details{" + "detailID=" + detailID + ", driversLicence=" + driversLicence + ", SSN=" + SSN + ", passportNumber=" + passportNumber + ", stateID=" + stateID + ", streetLine1=" + streetLine1 + ", streetLine2=" + streetLine2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + '}';
    }
    
}
