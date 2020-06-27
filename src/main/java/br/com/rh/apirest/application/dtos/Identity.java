/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mar_a
 */
public class Identity {
    @JsonProperty(defaultValue = "id")
    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public Identity setId(Long id) {
        this.id = id;
        return this;
    }
}
