/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Accounts Entity
 * @author D
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Accounts.findAll", query = "select a from Accounts a"),
        @NamedQuery(name = "Accounts.findByCustId", query = "select a from Accounts a where a.customer.custId = :custId"),
        @NamedQuery(name = "Accounts.findByAccountId", query = "select a from Accounts a where a.accountID = :accountId"),
        @NamedQuery(name = "Accounts.findByMaker", query = "select a from Accounts a where a.creatorName = :makerId"),
        @NamedQuery(name = "Accounts.findByChecker", query = "select a from Accounts a where a.authName = :checkerId"),
        @NamedQuery(name = "Accounts.findUnAuthTxns", query = "select a from Accounts a where a.authStatus='U'")
})
@SequenceGenerator(name="accountSeq", initialValue=1000, allocationSize=10)
public class Accounts extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accountSeq")
    private long accountID; 
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;
    private String typeOfAccount;
    private Float balance;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name="CustomerAccounts",
                joinColumns = @JoinColumn(name="accountID"),
                inverseJoinColumns = @JoinColumn(name="custId"))
    private Customer customer;
    
    @OneToMany(mappedBy="account")
    private List<Cards> accountCards = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="preferenceID",unique = true)
    private Preferences preference;

    /**
     * Default Constructor
     */
    public Accounts() {
    }

    /**
     *
     * @param dateOfCreation
     * @param typeOfAccount
     * @param balance
     * @param creatorName
     * @param authName
     * @param dateLastModified
     * @param authStatus
     */
    public Accounts(Date dateOfCreation, String typeOfAccount, Float balance, String creatorName, String authName, Date dateLastModified, String authStatus) {
        super(creatorName, authName, dateLastModified, authStatus);
        this.dateOfCreation = dateOfCreation;
        this.typeOfAccount = typeOfAccount;
        this.balance = balance;
    }

    //Getter and setter methods of entity attributes
    
    /**
     *
     * @return
     */
    public long getAccountID() {
        return accountID;
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
    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    /**
     *
     * @param typeOfAccount
     */
    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    /**
     *
     * @return
     */
    public Float getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(Float balance) {
        this.balance = balance;
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

    /**
     *
     * @return
     */
    public List<Cards> getAccountCards() {
        return accountCards;
    }

    /**
     *
     * @param accountCards
     */
    public void setAccountCards(List<Cards> accountCards) {
        this.accountCards = accountCards;
    }

    /**
     *
     * @return
     */
    public Preferences getPreference() {
        return preference;
    }

    /**
     *
     * @param preference
     */
    public void setPreference(Preferences preference) {
        this.preference = preference;
    }
    
    //Overriding toString method to print entity attributes

    @Override
    public String toString() {
        return "Accounts{" + "accountID=" + accountID + ", dateOfCreation=" + dateOfCreation + ", typeOfAccount=" + typeOfAccount + ", balance=" + balance + '}';
    }
}
