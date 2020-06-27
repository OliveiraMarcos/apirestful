/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.application.service;

import br.com.rh.apirest.application.dtos.PeopleDto;
import br.com.rh.apirest.domain.entities.People;
import br.com.rh.apirest.domain.interfaces.repository.IPeopleRepository;
import br.com.rh.apirest.services.api.interfaces.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar_a
 */
@Service
public class PeopleService extends BaseService<PeopleDto,People> implements IPeopleService{
    
    @Autowired
    public PeopleService(IPeopleRepository repository) {
        super(repository);
    }
    
}
