/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.application.service;

import br.com.rh.apirest.application.dtos.SectorDto;
import br.com.rh.apirest.domain.entities.Sector;
import br.com.rh.apirest.domain.interfaces.repository.ISectorRepository;
import br.com.rh.apirest.services.api.interfaces.service.ISectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar_a
 */
@Service
public class SectorService extends BaseService<SectorDto,Sector> implements ISectorService{
    
    //@Autowired
    public SectorService(ISectorRepository repository) {
        super(repository);
    }
    
}
