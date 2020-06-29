/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.services.api.interfaces.service;

import br.com.rh.apirest.application.dtos.PeopleDto;
import br.com.rh.apirest.application.dtos.SectorDto;
import br.com.rh.apirest.domain.entities.People;
import java.util.List;

/**
 *
 * @author mar_a
 */
public interface IPeopleService extends IBaseService<PeopleDto, People> {
    List<PeopleDto> GetListBySector(SectorDto sector);
}
