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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * Role Entity
 * @author D
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "select g from Role g")
public class Role implements Serializable {

    @Id
    private String roleName;
    private String roleDesc;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    /**
     *
     */
    public Role() {
    }

    /**
     *
     * @param roleName
     * @param roleDesc
     */
    public Role(String roleName, String roleDesc) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    /**
     * Get the value of roleName
     *
     * @return the value of roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set the value of roleName
     *
     * @param roleName new value of roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Get the value of roleDesc
     *
     * @return the value of roleDesc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * Set the value of roleDesc
     *
     * @param roleDesc new value of roleDesc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" + "roleName=" + roleName + ", roleDesc=" + roleDesc + '}';
    }
}
