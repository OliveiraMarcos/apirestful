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
public class SectorDto extends Identity {
    
    @JsonProperty(defaultValue = "name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public SectorDto setName(String name) {
        this.name = name;
        return this;
    }
    
}
