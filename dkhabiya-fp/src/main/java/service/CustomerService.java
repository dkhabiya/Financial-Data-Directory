/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import model.Accounts;
import model.Customer;
import model.Details;

/**
 * Customer Service
 * @author D
 */
@Named
@Stateless
public class CustomerService extends BaseService<Customer> {

    private final String UNAUTH = "U";
    private final String AUTH = "A";
    
    private static final Logger LOG = Logger.getLogger(CustomerService.class.getName());
    
    /**
     * Default constructor
     */
    public CustomerService() {
        super(Customer.class);
    }

    /**
     * Implementing the abstract method of BaseService
     * @return
     */
    @Override
    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
    
    /**
     * Find Customer by Maker
     * @param userName
     * @return
     */
    public List<Customer> findByMaker(String userName) {
        return getEntityManager().createNamedQuery("Customer.findByMaker", Customer.class).setParameter("makerId", userName).getResultList();
    }
    
    /**
     * Find Customer by Checker
     * @param userName
     * @return
     */
    public List<Customer> findByChecker(String userName) {
        return getEntityManager().createNamedQuery("Customer.findByChecker", Customer.class).setParameter("checkerId", userName).getResultList();
    }
    
    /**
     * Find Customer by Customer ID
     * @param custId
     * @return
     */
    public Customer findByCustId(Long custId) {
        return getEntityManager().createNamedQuery("Customer.findByCustID",Customer.class).setParameter("custId", custId).getResultList().get(0);
    }
    
    /**
     * Create Customer
     * @param c
     * @param d
     * @param userName
     * @return
     */
    public long doCreate(Customer c, Details d, String userName) {
    
        c.setAuthStatus(UNAUTH);
        c.setCreatorName(userName);
        c.setDateLastModified(new Date());
        c.setDateOfCreation(new Date());
        c.setDetails(d);
        
        create(c);
        
        return c.getCustId();
    }
    
    /**
     * Update Customer
     * @param c
     * @param d
     * @param userName
     */
    public void doUpdate(Customer c, Details d, String userName) {
        c.setAuthStatus(UNAUTH);
        c.setCreatorName(userName);
        c.setDateLastModified(new Date());
        c.setDetails(d);
        
        update(c);
    }
    
    /**
     * Delete Customer
     * @param c
     */
    public void doDelete(Customer c) {
        delete(c);
    }
    
    /**
     * Link Customer and Account
     * @param a
     */
    public void doAccountLink(Accounts a) {
        Customer c = findByCustId(a.getCustomer().getCustId());
        List<Accounts> aList = (List<Accounts>) a;
        c.setCustAccounts(aList);
        
        update(c);
    }
    
    /**
     * Find Un Authorised Customer
     * @return
     */
    public List<Customer> findUnAuthTxns() {
        return getEntityManager().createNamedQuery("Customer.findUnAuthTxns", Customer.class).getResultList();
    }
    
    /**
     * Authorise Customer
     * @param c
     * @param d
     * @param userName
     */
    public void doAuth(Customer c, Details d, String userName) {
        c.setAuthStatus(AUTH);
        c.setAuthName(userName);
        c.setDateLastModified(new Date());
        c.setDetails(d);
        
        update(c);
    }
}
