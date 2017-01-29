/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.*;

/**
 * BaseEntity
 * @author D
 */

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity {
    
    /**
     *
     */
    protected String creatorName;

    /**
     *
     */
    protected String authName;

    /**
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateLastModified;

    /**
     *
     */
    protected String authStatus;    

    /**
     *
     */
    public BaseEntity() {
    }

    /**
     *
     * @param creatorName
     * @param authName
     * @param dateLastModified
     * @param authStatus
     */
    public BaseEntity(String creatorName, String authName, Date dateLastModified, String authStatus) {
        this.creatorName = creatorName;
        this.authName = authName;
        this.dateLastModified = dateLastModified;
        this.authStatus = authStatus;
    }

    // Getter and setter methods

    /**
     *
     * @return
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     *
     * @param creatorName
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     *
     * @return
     */
    public String getAuthName() {
        return authName;
    }

    /**
     *
     * @param authName
     */
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    /**
     *
     * @return
     */
    public Date getDateLastModified() {
        return dateLastModified;
    }

    /**
     *
     * @param dateLastModified
     */
    public void setDateLastModified(Date dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    /**
     *
     * @return
     */
    public String getAuthStatus() {
        return authStatus;
    }

    /**
     *
     * @param authStatus
     */
    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }    
}
