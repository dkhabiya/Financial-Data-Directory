/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author D
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "select u from User u"),
    @NamedQuery(name = "User.findUser", query = "select u from User u where u.userName= :userName")
})
public class User implements Serializable {

    @Id
    private String userName;
    private String password;
    private String name;
    private Boolean userStatus;

    @ManyToMany
    
    @JoinTable(
            joinColumns = @JoinColumn(name = "userName"),
            inverseJoinColumns = @JoinColumn(name = "roleName"))
    private List<Role> roles = new ArrayList<>();

    /**
     *
     */
    public User() {
    }
       
    /**
     *
     * @param userName
     * @param password
     * @param name
     */
    public User(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        hashPassword();
        this.name = name;
    }

    /**
     *
     * @param role
     */
    public void addRole(Role role) {
        if (!this.roles.contains(role)) {
            this.roles.add(role);
        }
        if (!role.getUsers().contains(this)) {
            role.getUsers().add(this);
        }
    }

    /**
     *
     * @return
     */
    public Boolean getUserStatus() {
        return userStatus;
    }

    /**
     *
     * @param userStatus
     */
    public void setEnabled(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     *
     * @return
     */
    public Boolean isEnabled() {
        return userStatus;
    }
    
    @PrePersist
    @PreUpdate
    private void hashPassword(){
        String digestPassword = DigestUtils.sha256Hex(this.password);
        this.password = digestPassword;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", name=" + name + ", userStatus=" + userStatus + '}';
    }
}
