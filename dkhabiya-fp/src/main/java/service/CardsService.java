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
import model.Cards;

/**
 * Cards Service
 * @author D
 */
@Named
@Stateless
public class CardsService extends BaseService<Cards> {

    private final String UNAUTH = "U";
    private final String AUTH = "A";
    
    private static final Logger LOG = Logger.getLogger(CardsService.class.getName());
    
    /**
     * Default constructor
     */
    public CardsService() {
        super(Cards.class);
    }

    /**
     * Implementing the abstract method of BaseService
     * @return
     */
    @Override
    public List<Cards> findAll() {
        return getEntityManager().createNamedQuery("Cards.findAll", Cards.class).getResultList();
    }
    
    /**
     *
     * @param cardNo
     * @return
     */
    public Cards findByCardNo(long cardNo) {
        return getEntityManager().createNamedQuery("Cards.findByCardNo", Cards.class).setParameter("cardNo", cardNo).getSingleResult();
    }
    
    /**
     * Find Cards by Maker
     * @param userName
     * @return
     */
    public List<Cards> findByMaker(String userName) {
        return getEntityManager().createNamedQuery("Cards.findByMaker", Cards.class).setParameter("makerId", userName).getResultList();
    }
    
    /**
     * Find Cards by Checker
     * @param userName
     * @return
     */
    public List<Cards> findByChecker(String userName) {
        return getEntityManager().createNamedQuery("Cards.findByChecker", Cards.class).setParameter("checkerId", userName).getResultList();
    }
    
    /**
     * Find Cards by Customer ID
     * @param custId
     * @return
     */
    public List<Cards> findByCustId(long custId) {
        return getEntityManager().createNamedQuery("Cards.findByCustId", Cards.class).setParameter("custId", custId).getResultList();
    }
    
    /**
     * Find Cards by Account ID
     * @param accountId
     * @return
     */
    public List<Cards> findByAccountId(long accountId) {
        return getEntityManager().createNamedQuery("Cards.findByAccountId", Cards.class).setParameter("accountId", accountId).getResultList();
    }
    
    /**
     * Create Cards
     * @param cd
     * @param userName
     * @param a
     */
    public void doCreate(Cards cd, String userName, Accounts a) {
        cd.setAuthStatus(UNAUTH);
        cd.setDateLastModified(new Date());
        cd.setDateOfCreation(new Date());
        cd.setCreatorName(userName);
        cd.setAccount(a);
        
        create(cd);
    }
    
    /**
     * Delete Cards
     * @param cd
     */
    public void doDelete(Cards cd) {
        delete(cd);
    }
    
    /**
     * Update Cards
     * @param cd
     * @param userName
     */
    public void doUpdate(Cards cd, String userName){
        
        cd.setCreatorName(userName);
        cd.setDateLastModified(new Date());
        cd.setAuthStatus(UNAUTH);
        
        update(cd);        
    }
    
    /**
     * Find Un Authorised Cards
     * @return
     */
    public List<Cards> findUnAuthTxns() {
        return getEntityManager().createNamedQuery("Cards.findUnAuthTxns", Cards.class).getResultList();
    }
    
    /**
     * Authorise Cards
     * @param cd
     * @param userName
     */
    public void doAuth(Cards cd, String userName) {
        cd.setAuthStatus(AUTH);
        cd.setAuthName(userName);
        cd.setDateLastModified(new Date());
        
        update(cd);
    }    
}
