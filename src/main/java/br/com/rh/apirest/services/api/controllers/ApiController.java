/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.services.api.controllers;


import br.com.rh.apirest.services.api.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 *"
 * @author mar_a
 */
public abstract class ApiController {
    public <T extends Object> ResponseEntity<Result<T>> ResponseErro(HttpStatus code, Exception ex){
        return ResponseErro(code, ex, null);
    }
    public <T extends Object> ResponseEntity<Result<T>> ResponseErro(HttpStatus code, Exception ex, T entity){
        var result = new Result<T>();
        result.setCode(code)
              .setMessage("Error!")
              .setObjectResponse(entity)
              .addError(ex.getMessage());
        return new ResponseEntity<Result<T>>(
        result, code
        );
    }
    
    public <T extends Object> ResponseEntity<Result<T>> ResponseSuccess(T entity, HttpStatus code){
        var result = new Result<T>();
        result.setCode(code)
              .setMessage("Success!")
              .setObjectResponse(entity);
        return new ResponseEntity<Result<T>>(
        result, code
        );
    }
}
