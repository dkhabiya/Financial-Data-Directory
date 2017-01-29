/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import model.Details;

/**
 * Details Service
 * @author D
 */
@Named
@Stateless
public class DetailsService extends BaseService<Details> {
    
    private final String UNAUTH = "U";
    private final String AUTH = "A";    

    private static final Logger LOG = Logger.getLogger(DetailsService.class.getName());
    
    /**
     * Default constructor
     */
    public DetailsService() {
        super(Details.class);
    }

    /**
     * Implementing the abstract method of BaseService 
     * @return
     */
    @Override
    public List<Details> findAll() {
        return getEntityManager().createNamedQuery("Details.findDetails", Details.class).getResultList();
    }
    
    /**
     * Find Details by Maker
     * @param userName
     * @return
     */
    public List<Details> findByMaker(String userName) {
        return getEntityManager().createNamedQuery("Details.findByMaker", Details.class).setParameter("makerId", userName).getResultList();
    }
    
    /**
     * Find Details by Checker
     * @param userName
     * @return
     */
    public List<Details> findByChecker(String userName) {
        return getEntityManager().createNamedQuery("Details.findByChecker", Details.class).setParameter("checkerId", userName).getResultList();
    }
    
    /**
     * Find by Customer Detail ID
     * @param detailId
     * @return
     */
    public Details findByCustDetailId(int detailId) {
        return getEntityManager().createNamedQuery("Details.findDetailsByCustId", Details.class).setParameter("detailID", detailId).getSingleResult();
    }
    
    /**
     * Create Details
     * @param d
     * @param userName
     */
    public void doCreate(Details d, String userName) {

        d.setAuthStatus(UNAUTH);
        d.setCreatorName(userName);
        d.setDateLastModified(new Date());
        
        create(d);
    }
    
    /**
     * Delete Details
     * @param d
     */
    public void doDelete(Details d) {
        delete(d);
    }
    
    /**
     * Find Unauthorised Details
     * @return
     */
    public List<Details> findUnAuthTxns() {
        return getEntityManager().createNamedQuery("Details.findUnAuthTxns", Details.class).getResultList();
    }
    
    /**
     * Authorise Details
     * @param d
     * @param userName
     */
    public void doAuth(Details d, String userName) {
        d.setAuthStatus(AUTH);
        d.setAuthName(userName);
        d.setDateLastModified(new Date());
        //update(d); 
    }
}
