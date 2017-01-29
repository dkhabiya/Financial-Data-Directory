/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.*;

/**
 * Preferences Entity
 * @author D
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Preferences.findAll", query = "select p from Preferences p"),
        @NamedQuery(name = "Preferences.selectPreferences", query = "select p from Preferences p where p.preferenceID=:prefId"),
        @NamedQuery(name = "Preferences.findByCustId", query = "select p from Preferences p where p.account.customer.custId=:custId"),
        @NamedQuery(name = "Preferences.findByAccountId", query = "select p from Preferences p where p.account.accountID=:accountId"),
        @NamedQuery(name = "Preferences.findByMaker", query = "select p from Preferences p where p.creatorName=:makerId"),
        @NamedQuery(name = "Preferences.findByChecker", query = "select p from Preferences p where p.authName=:checkerId"),
        @NamedQuery(name = "Preferences.findUnAuthTxns", query = "select p from Preferences p where p.authStatus='U'")
})
public class Preferences extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long preferenceID; 
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;
    private Boolean emailAlert;
    private String emailID;
    private Boolean phoneAlert;
    private long phoneNumber;
    
    @OneToOne(mappedBy = "preference")
    private Accounts account;    

    
    /**
     * Default Constructor
     */
    public Preferences() {
    }

    /**
     *
     * @param preferenceID
     * @param dateOfCreation
     * @param emailAlert
     * @param emailID
     * @param phoneAlert
     * @param phoneNumber
     */
    public Preferences(long preferenceID, Date dateOfCreation, Boolean emailAlert, String emailID, Boolean phoneAlert, long phoneNumber) {
        this.preferenceID = preferenceID;
        this.dateOfCreation = dateOfCreation;
        this.emailAlert = emailAlert;
        this.emailID = emailID;
        this.phoneAlert = phoneAlert;
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public long getPreferenceID() {
        return preferenceID;
    }

    /**
     *
     * @param preferenceID
     */
    public void setPreferenceID(long preferenceID) {
        this.preferenceID = preferenceID;
    }

    /**
     *
     * @return
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     *
     * @param dateOfCreation
     */
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**
     *
     * @return
     */
    public Boolean getEmailAlert() {
        return emailAlert;
    }

    /**
     *
     * @param emailAlert
     */
    public void setEmailAlert(Boolean emailAlert) {
        this.emailAlert = emailAlert;
    }

    /**
     *
     * @return
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     *
     * @param emailID
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     *
     * @return
     */
    public Boolean getPhoneAlert() {
        return phoneAlert;
    }

    /**
     *
     * @param phoneAlert
     */
    public void setPhoneAlert(Boolean phoneAlert) {
        this.phoneAlert = phoneAlert;
    }

    /**
     *
     * @return
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public Accounts getAccount() {
        return account;
    }

    /**
     *
     * @param account
     */
    public void setAccount(Accounts account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Preferences{" + "preferenceID=" + preferenceID + ", dateOfCreation=" + dateOfCreation + ", emailAlert=" + emailAlert + ", emailID=" + emailID + ", phoneAlert=" + phoneAlert + ", phoneNumber=" + phoneNumber + '}';
    }

}
