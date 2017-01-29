/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import model.security.Role;

/**
 * Role Service
 * @author D
 */

@Stateless
public class RoleService extends BaseService<Role> {

    /**
     *
     */
    public RoleService() {
        super(Role.class);
    }

    @Override
    public List<Role> findAll() {
        return getEntityManager().createNamedQuery("Role.findAll", Role.class).getResultList();
    }
    
}
