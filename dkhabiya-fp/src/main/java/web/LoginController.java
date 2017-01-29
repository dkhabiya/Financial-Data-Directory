/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import service.UserService;

/**
 * Login Controller
 * @author D
 */
@Named
@RequestScoped
public class LoginController extends BaseController implements Serializable {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
    
    @EJB UserService userService;
    
    private String username;
    private String password;
    
    /**
     *
     */
    public LoginController() {
    }
    
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
    }

    /**
     *
     * @param username
     * @param password
     */
    public LoginController(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Login
     * @return
     */
    public String doLogin() {
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        
        try {
            LOG.log(Level.INFO, "========LoginController========={0}", username);
            req.login(username, password);
            
        } catch (ServletException ex) {
            LOG.log(Level.WARNING, "Login Failed for : {0} !", username);
            LOG.log(Level.SEVERE, null, ex);
            return "/error.xhtml";
        }

        return userRoute("welcome.xhtml");
    }

    /**
     * Get User Name
     * @return
     */
    public String getRemoteUser(){
        return context.getExternalContext().getRemoteUser();
    }
    
    /**
     * Get User Role
     * @return
     */
    public String getRemoteUserRole(){
        if ( context.getExternalContext().isUserInRole("MAKER")) {
            return "MAKER";
        } else {
            if ( context.getExternalContext().isUserInRole("CHECKER")) {
                 return "CHECKER";
            }
        }
        return null;
    }
    
    /**
     * Logout
     * @return
     */
    public String doLogout() {
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        
        try {
            this.username = null;
            req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return "/error.xhtml";
        }
        
        return userRoute("goodbye.xhtml");
    }
    
    /**
     * Create User Route
     * @param path
     * @return
     */
    public String userRoute(String path) {
        
        if ( context.getExternalContext().isUserInRole("MAKER") ) {
            return "/maker/" + path;
        } else {
            if ( context.getExternalContext().isUserInRole("CHECKER") ) {
                return "/checker/" + path;
            } 
        }
        
        return "/"+path;
    }
    
    /**
     * Get User Full Name
     * @return
     */
    public String getFullName() {
        return userService.findUserName(username);
    }
}
