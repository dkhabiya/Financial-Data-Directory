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
import model.Preferences;

/**
 * Preferences Service
 * @author D
 */
@Named
@Stateless
public class PreferencesService extends BaseService<Preferences> {
    
    private final String UNAUTH = "U";
    private final String AUTH = "A";    
    
    private static final Logger LOG = Logger.getLogger(PreferencesService.class.getName());

    /**
     * Implementing the abstract method of BaseService
     * Default constructor
     */
    public PreferencesService() {
        super(Preferences.class);
    }

    /**
     * Find all preferences
     * @return
     */
    @Override
    public List<Preferences> findAll() {
        return getEntityManager().createNamedQuery("Preferences.findAll", Preferences.class).getResultList();
    }
    
    /**
     * Find preference by maker
     * @param userName
     * @return
     */
    public List<Preferences> findByMaker(String userName) {
        return getEntityManager().createNamedQuery("Preferences.findByMaker", Preferences.class).setParameter("makerId", userName).getResultList();
    }
    
    /**
     * Find preference by checker
     * @param userName
     * @return
     */
    public List<Preferences> findByChecker(String userName) {
        return getEntityManager().createNamedQuery("Preferences.findByChecker", Preferences.class).setParameter("checkerId", userName).getResultList();
    }
    
    /**
     * Find preferences by Customer ID
     * @param custId
     * @return
     */
    public List<Preferences> findByCustId(long custId) {
        return getEntityManager().createNamedQuery("Preferences.findByCustId", Preferences.class).setParameter("custId", custId).getResultList();
    }
    
    /**
     * Find preferences by Account ID
     * @param accountId
     * @return
     */
    public Preferences findByAccountId(long accountId) {
        return getEntityManager().createNamedQuery("Preferences.findByAccountId", Preferences.class).setParameter("accountId", accountId).getSingleResult();
    }
    
    /**
     * Create preferences
     * @param p
     * @param userName
     */
    public void doCreate( Preferences p, String userName){
        p.setAuthStatus(UNAUTH);
        p.setCreatorName(userName);
        p.setDateLastModified(new Date());
        p.setDateOfCreation(new Date());
    }
    
    /**
     * Update preferences
     * @param p
     * @param userName
     */
    public void doUpdate(Preferences p, String userName) {
        p.setAuthStatus(UNAUTH);
        p.setCreatorName(userName);
        p.setDateLastModified(new Date());
        
        update(p);
    }
    
    /**
     * Delete Preferences
     * @param p
     */
    public void doDelete(Preferences p) {
        delete(p);
    }
    
    /**
     * Find Un Authorised Preferences
     * @return
     */
    public List<Preferences> findUnAuthTxns() {
        return getEntityManager().createNamedQuery("Preferences.findUnAuthTxns", Preferences.class).getResultList();
    }
    
    /**
     * Authorise Preferences
     * @param p
     * @param userName
     */
    public void doAuth(Preferences p, String userName) {
        p.setAuthStatus(AUTH);
        p.setAuthName(userName);
        p.setDateLastModified(new Date());
    }
}
