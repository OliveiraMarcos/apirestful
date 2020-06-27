/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.services.api.controllers;

import br.com.rh.apirest.application.dtos.SectorDto;
import br.com.rh.apirest.services.api.interfaces.service.ISectorService;
import br.com.rh.apirest.services.api.response.Result;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mar_a
 */
@RestController
public class SectorController extends ApiController {
    @Autowired
    private ISectorService _sectorService;
    
    @RequestMapping(value = "api/sector", method = RequestMethod.GET)
    public ResponseEntity<Result<List<SectorDto>>> Get() {
        try{
            var list = _sectorService.GetALL();
            return ResponseSuccess(list, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
        
    }
    
    @RequestMapping(value = "api/sector/{id}", method = RequestMethod.GET)
    public ResponseEntity<Result<SectorDto>> GetById(@PathVariable(value = "id") long id) {
        try{
            var entity = _sectorService.GetById(id);
            return ResponseSuccess(entity, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }
    
    @RequestMapping(value = "api/sector", method =  RequestMethod.POST)
    public ResponseEntity<Result<SectorDto>> Post(@Valid @RequestBody SectorDto sector)
    {
        try{
            var entity = _sectorService.Create(sector);
            return ResponseSuccess(entity, HttpStatus.CREATED);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }   
    
    @RequestMapping(value = "api/sector", method =  RequestMethod.PUT)
    public ResponseEntity<Result<SectorDto>> Put(@Valid @RequestBody SectorDto sector)
    {
        try{
            var entity = _sectorService.Update(sector);
            return ResponseSuccess(entity, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }

    @RequestMapping(value = "api/sector/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Result<SectorDto>> Delete(@PathVariable(value = "id") long id)
    {
        var entity = this._sectorService.GetById(id);
        try{
            var ok = _sectorService.Delete(id);
            if (ok > 0) {
                return ResponseSuccess(entity, HttpStatus.OK);
            }else{
                return ResponseErro(HttpStatus.NOT_FOUND, null, entity);
            }
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex, entity);
        }
    }
}
