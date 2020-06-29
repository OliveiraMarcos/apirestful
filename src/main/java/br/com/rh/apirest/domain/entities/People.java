/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.domain.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;



/**
 *
 * @author mar_a
 */
@Entity
@Component
@Table(name = "RH_People")
public class People extends BaseEntity implements Serializable {
    
    @Column(name = "first_name", nullable = false)
    private String firstName;    

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "career", nullable = true)
    private String career;
    
    @Column(name = "sector_id", nullable = true)
    private Long sector_id;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Sector.class)
    @JoinColumn(name = "sector_id", insertable = false, updatable = false)
    private Sector sector;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the career
     */
    public String getCareer() {
        return career;
    }

    /**
     * @param career the career to set
     */
    public void setCareer(String career) {
        this.career = career;
    }

    /**
     * @return the sector
     */
    public Sector getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /**
     * @return the sector_id
     */
    public Long getSectorId() {
        return sector_id;
    }

    /**
     * @param sector_id the sector_id to set
     */
    public void setSectorId(Long sector_id) {
        this.sector_id = sector_id;
    }
}
