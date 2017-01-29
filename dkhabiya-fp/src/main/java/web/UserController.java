/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import model.security.Role;
import model.security.User;
import service.RoleService;
import service.UserService;

/**
 * User Controller
 * @author D
 */

@Named
@Stateless
public class UserController extends BaseController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    @Inject LoginController loginController;
    @EJB UserService userService;
    @EJB RoleService roleService;
    
    private User user;
    private Role role;
    
    /**
     * Default constructor
     */
    public UserController() {
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public Role getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     *
     */
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        role = new Role();
        user = new User();
    }

    /**
     * Create Empty User
     * @param u
     * @return
     */
    public String doCreateEmpty(User u){
        this.user = new User();
        return loginController.userRoute("signUp.xhtml");
    }
    
    /**
     * Create User
     * @param u
     * @param r
     * @return
     */
    public String doCreateUser(User u, Role r) {
        
        User user = userService.findUser(u.getUserName());
        
        if ( user == null ) {
            userService.doCreateUser(u, r);
            return loginController.userRoute("login.xhtml");
        } else {
            return loginController.userRoute("userError.xhtml");
        }
        
    }
    
}
