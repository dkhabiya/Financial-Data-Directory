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
import model.Preferences;

/**
 * Accounts Service
 * @author D
 */
@Named
@Stateless
public class AccountsService extends BaseService<Accounts> {

    private final String UNAUTH = "U";
    private final String AUTH = "A";    
    
    private static final Logger LOG = Logger.getLogger(AccountsService.class.getName());
    
    /**
     * Default constructor
     */
    public AccountsService() {
        super(Accounts.class);
    }

    /**
     * Implementing the abstract method of BaseService
     * @return
     */
    @Override
    public List<Accounts> findAll() {
        return getEntityManager().createNamedQuery("Accounts.findAll", Accounts.class).getResultList();
    }
    
    /**
     * Find Accounts by Maker
     * @param userName
     * @return
     */
    public List<Accounts> findByMaker(String userName) {
        return getEntityManager().createNamedQuery("Accounts.findByMaker", Accounts.class).setParameter("makerId", userName).getResultList();
    }
    
    /**
     * Find Accounts by Checker
     * @param userName
     * @return
     */
    public List<Accounts> findByChecker(String userName) {
        return getEntityManager().createNamedQuery("Accounts.findByChecker", Accounts.class).setParameter("checkerId", userName).getResultList();
    }
    
    /**
     * Find Accounts by Customer ID
     * @param custId
     * @return
     */
    public List<Accounts> findByCustId(Long custId) {
        return getEntityManager().createNamedQuery("Accounts.findByCustId", Accounts.class).setParameter("custId", custId).getResultList();
    }
    
    /**
     * Find Accounts by Account ID
     * @param accountId
     * @return
     */
    public Accounts findByAccountId(long accountId) {
       return getEntityManager().createNamedQuery("Accounts.findByAccountId",Accounts.class).setParameter("accountId", accountId).getSingleResult();
    }
    
    /**
     * Create Accounts
     * @param a
     * @param p
     * @param c
     * @param userName
     */
    public void doCreate(Accounts a, Preferences p, Customer c, String userName ) {
        a.setAuthStatus(UNAUTH);
        a.setCreatorName(userName);
        a.setDateLastModified(new Date());
        a.setDateOfCreation(new Date());
        a.setPreference(p);
        
        a.setCustomer(c);
               
        create(a);
    }
    
    /**
     * Update Accounts
     * @param a
     * @param userName
     */
    public void doUpdate(Accounts a, String userName) {

        a.setAuthStatus(UNAUTH);
        a.setCreatorName(userName);
        a.setDateLastModified(new Date());
        
        update(a);
    }
    
    /**
     * Delete Accounts
     * @param a
     */
    public void doDelete(Accounts a) {
        delete(a);
    }
 
    /**
     * Find Un Authorised Transactions
     * @return
     */
    public List<Accounts> findUnAuthTxns() {
        return getEntityManager().createNamedQuery("Accounts.findUnAuthTxns", Accounts.class).getResultList();
    }
    
    /**
     * Authorise Accounts
     * @param a
     * @param p
     * @param userName
     */
    public void doAuth(Accounts a, Preferences p, String userName) {
        a.setAuthStatus(AUTH);
        a.setAuthName(userName);
        a.setDateLastModified(new Date());
        a.setPreference(p);
        
        update(a);
    }
}
