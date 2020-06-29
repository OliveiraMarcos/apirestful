/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.services.api.controllers;

import br.com.rh.apirest.application.dtos.PeopleDto;
import br.com.rh.apirest.services.api.interfaces.service.IPeopleService;
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
@RequestMapping("/api/people")
public class PeopleController extends ApiController{
    
    @Autowired
    private IPeopleService _peopleService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Result<List<PeopleDto>>> Get() {
        try{
            var list = _peopleService.GetALL();
            return ResponseSuccess(list, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Result<PeopleDto>> GetById(@PathVariable(value = "id") long id) {
        try{
            var entity = _peopleService.GetById(id);
            return ResponseSuccess(entity, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }
    
    @RequestMapping( method =  RequestMethod.POST)
    public ResponseEntity<Result<PeopleDto>> Post(@Valid @RequestBody PeopleDto people)
    {
        try{
            var entity = _peopleService.Create(people);
            return ResponseSuccess(entity, HttpStatus.CREATED);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }
    
    @RequestMapping( method =  RequestMethod.PUT)
    public ResponseEntity<Result<PeopleDto>> Put(@Valid @RequestBody PeopleDto people)
    {
        try{
            var entity = _peopleService.Update(people);
            return ResponseSuccess(entity, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Result<PeopleDto>> Delete(@PathVariable(value = "id") long id)
    {
        var entity = this._peopleService.GetById(id);
        try{
            var ok = _peopleService.Delete(id);
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
