/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 * Base Controller
 * @author D
 */
public abstract class BaseController {

    /**
     *
     */
    protected FacesContext context;

    /**
     *
     */
    protected Flash flash;
    
    /**
     *
     */
    protected BaseController() {
    }
    
    /**
     *
     */
    @PostConstruct
    protected void postConstruct(){
        context = FacesContext.getCurrentInstance();
        flash = context.getExternalContext().getFlash();
    }
    
}