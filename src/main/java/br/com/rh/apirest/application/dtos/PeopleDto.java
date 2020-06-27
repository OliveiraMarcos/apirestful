/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author mar_a
 */
public class PeopleDto extends Identity{
    @JsonProperty(defaultValue = "first_name")
    @NotBlank(message = "First Name is mandatory")
    private String firstName;    

    @JsonProperty(defaultValue = "last_name")
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    
    @JsonProperty(defaultValue = "career")
    private String career;
    
    @JsonProperty(defaultValue = "sector")
    private SectorDto sector;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public PeopleDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
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
    public PeopleDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
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
    public PeopleDto setCareer(String career) {
        this.career = career;
        return this;
    }

    /**
     * @return the sector
     */
    public SectorDto getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public PeopleDto setSector(SectorDto sector) {
        this.sector = sector;
        return this;
        
    }
}
