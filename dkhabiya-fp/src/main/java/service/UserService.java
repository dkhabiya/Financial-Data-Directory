/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.security.Role;
import model.security.User;

/**
 * User Service
 * @author D
 */

@Stateless
public class UserService extends BaseService<User> {

    private static final Logger LOG = Logger.getLogger(UserService.class.getName());

    /**
     *
     */
    public UserService() {
        super(User.class);
    }

    @Override
    public List<User> findAll() {
        return getEntityManager().createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    /**
     * Find user role from user
     * @param user
     * @return
     */
    public String findUserRole(String user) {
        Query q = getEntityManager().createNativeQuery("select r.roleName from user_role r where r.userName= ?");
        q.setParameter(1, user);
        return q.getSingleResult().toString();
    }
    
    /**
     * Find user
     * @param user
     * @return
     */
    public User findUser(String user) {
        
        User u = new User();
        
        try {
            u = getEntityManager().createNamedQuery("User.findUser", User.class).setParameter("userName", user).getSingleResult();
        } catch(NoResultException e) {
            LOG.info("Errrorrrr"+e.getMessage());
            return null;
        }
        
        return u;
    }
    
    /**
     * Find User Name
     * @param user
     * @return
     */
    public String findUserName(String user) {
        
        User u = new User();
        
        try {
            u = getEntityManager().createNamedQuery("User.findUser", User.class).setParameter("userName", user).getSingleResult();
        } catch(NoResultException e) {
            LOG.info("Errrorrrr"+e.getMessage());
            return null;
        }
        
        return u.getName();
    }
    
    /**
     * Create User
     * @param u
     * @param r
     */
    public void doCreateUser(User u, Role r) {
        u.setEnabled(Boolean.TRUE);
        u.addRole(r);
        
        create(u);
    }
    
}
