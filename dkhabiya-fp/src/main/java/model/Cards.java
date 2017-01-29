/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.*;

/**
 * Cards Entity
 * @author D
 * This class defines the Customer entity. It includes customer id[primary], 
 * first name, last name, DOB, type of customer, date of customer creation, gender.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Cards.findAll", query = "select cd from Cards cd"),
        @NamedQuery(name = "Cards.findByCardNo", query = "select cd from Cards cd where cd.cardNo=:cardNo"),
        @NamedQuery(name = "Cards.findByCustId", query = "select cd from Cards cd where cd.account.customer.custId=:custId"),
        @NamedQuery(name = "Cards.findByAccountId", query = "select cd from Cards cd where cd.account.accountID=:accountId"),
        @NamedQuery(name = "Cards.findByMaker", query = "select cd from Cards cd where cd.creatorName = :makerId"),
        @NamedQuery(name = "Cards.findByChecker", query = "select cd from Cards cd where cd.authName = :checkerId"),
        @NamedQuery(name = "Cards.findUnAuthTxns", query = "select cd from Cards cd where cd.authStatus='U'")
})
@SequenceGenerator(name="cardSeq", initialValue=1000000000, allocationSize=100)
public class Cards extends BaseEntity {
    
    //Customer Entity Attributes
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cardSeq")
    private long cardNo;
    private String cardType;
    
    @Temporal(TemporalType.DATE)
    private Date cardExpiry;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name="AccountCards",
                joinColumns = @JoinColumn(name="cardNo"),
                inverseJoinColumns = @JoinColumn(name="accountID"))
    private Accounts account;
    
    /**
     * Default constructor
     */
    public Cards() {
    }

    /**
     *
     * @param cardNo
     * @param cardType
     * @param cardExpiry
     * @param dateOfCreation
     * @param account
     * @param creatorName
     * @param authName
     * @param dateLastModified
     * @param authStatus
     */
    public Cards(long cardNo, String cardType, Date cardExpiry, Date dateOfCreation, Accounts account, String creatorName, String authName, Date dateLastModified, String authStatus) {
        super(creatorName, authName, dateLastModified, authStatus);
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.cardExpiry = cardExpiry;
        this.dateOfCreation = dateOfCreation;
        this.account = account;
    }

    /**
     *
     * @return
     */
    public long getCardNo() {
        return cardNo;
    }

    /**
     *
     * @param cardNo
     */
    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    /**
     *
     * @return
     */
    public String getCardType() {
        return cardType;
    }

    /**
     *
     * @param cardType
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     *
     * @return
     */
    public Date getCardExpiry() {
        return cardExpiry;
    }

    /**
     *
     * @param cardExpiry
     */
    public void setCardExpiry(Date cardExpiry) {
        this.cardExpiry = cardExpiry;
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
        return "Cards{" + "cardNo=" + cardNo + ", cardType=" + cardType + ", cardExpiry=" + cardExpiry + ", dateOfCreation=" + dateOfCreation + '}';
    }
}