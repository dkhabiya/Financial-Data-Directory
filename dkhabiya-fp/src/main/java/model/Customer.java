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
 * Customer Entity
 * @author D
 * This class defines the Customer entity. It includes customer id[primary], 
 * first name, last name, DOB, type of customer, date of customer creation, gender.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer c"),
        @NamedQuery(name = "Customer.findByCustID", query = "select c from Customer c where c.custId=:custId"),
        @NamedQuery(name = "Customer.findByMaker", query = "select c from Customer c where c.creatorName=:makerId"),
        @NamedQuery(name = "Customer.findByChecker", query = "select c from Customer c where c.authName=:checkerId"),
        @NamedQuery(name = "Customer.findUnAuthTxns", query = "select c from Customer c where c.authStatus='U'")
})
@SequenceGenerator(name="custSeq", initialValue=100, allocationSize=10)
public class Customer extends BaseEntity{
    
    /**
     * Query constant
     */
    public static final String SELECT_ALL = "selectAll";
    
    //Customer Entity Attributes
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="custSeq")
    private long custId;
    private String custType;
    private String custTitle;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;    

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="detailID",unique = true)
    private Details details;
    
    @OneToMany(mappedBy="Customer")
    private List<Accounts> custAccounts = new ArrayList<>();
    
    /**
     * Default constructor
     */
    public Customer() {
    }

    /**
     *
     * @param custType
     * @param custTitle
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param gender
     * @param dateOfCreation
     * @param details
     * @param creatorName
     * @param authName
     * @param dateLastModified
     * @param authStatus
     */
    public Customer(String custType, String custTitle, String firstName, String lastName, Date dateOfBirth, String gender, Date dateOfCreation, Details details, String creatorName, String authName, Date dateLastModified, String authStatus) {
        super(creatorName, authName, dateLastModified, authStatus);
        this.custType = custType;
        this.custTitle = custTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.dateOfCreation = dateOfCreation;
        this.details = details;
    }

    //Getter and setter for entity attributes
    
    /**
     *
     * @param custAccounts
     */
    public Customer(List<Accounts> custAccounts) {
        this.custAccounts = custAccounts;
    }

    /**
     * Get Customer ID
     * @return
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * Get Customer Age
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Set Customer Age
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get Customer Type
     * @return
     */
    public String getCustType(){
        return custType;
    }
    
    /**
     * Set Customer Type
     * @param custType
     */
    public void setCustType(String custType) {
        this.custType = custType;
    }
    
    /**
     * Get Customer Title
     * @return
     */
    public String getCustTitle(){
        return custTitle;
    }
    
    /**
     * Set Customer Title
     * @param custTitle
     */
    public void setCustTitle(String custTitle) {
        this.custTitle = custTitle;
    }
    
    /**
     * Get Customer First Name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set Customer First Name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Get Customer Last Name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Customer Last Name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Get Customer Date of Birth
     * @return
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set Customer Date of Birth
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * Get Customer Gender
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set Customer Gender
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    /**
     * Get Customer Date of Creation
     * @return
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * Set Customer Date of Creation
     * @param dateOfCreation
     */
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
   
    /**
     *
     * @return
     */
    public Details getDetails() {
        return details;
    }

    /**
     *
     * @param details
     */
    public void setDetails(Details details) {
        this.details = details;
    }    

    /**
     *
     * @return
     */
    public List<Accounts> getCustAccounts() {
        return custAccounts;
    }

    /**
     *
     * @param custAccounts
     */
    public void setCustAccounts(List<Accounts> custAccounts) {
        this.custAccounts = custAccounts;
    }
    
    /**
     *
     * @param acct
     */
    public void add( Accounts acct) {
        
        this.custAccounts.add(acct);
    }

    @Override
    public String toString() {
        return "Customer{" + "custId=" + custId + ", custType=" + custType + ", custTitle=" + custTitle + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", gender=" + gender + ", dateOfCreation=" + dateOfCreation + ", details=" + details + '}';
    }
}