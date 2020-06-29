/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.services.api.response;

import br.com.rh.apirest.application.dtos.Identity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

/**
 *
 * @author mar_a
 */
public class Result<T extends Object> {
    @JsonProperty(defaultValue = "code")
    private HttpStatus code;
    
    @JsonProperty(defaultValue = "message")
    private String message;
    
    @JsonProperty(defaultValue = "objectResponse")
    private T objectResponse;
    
    @JsonProperty(defaultValue = "errors")
    private List<String> errors;

    /**
     * @return the code
     */
    public HttpStatus getCode() {
        return code;
    }

    /**
     * @param code the code to set
     * @return 
     */
    public Result setCode(HttpStatus code) {
        this.code = code;
        return this;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * @return the objectResponse
     */
    public T getObjectResponse() {
        return objectResponse;
    }

    /**
     * @param objectResponse the objectResponse to set
     */
    public Result setObjectResponse(T objectResponse) {
        this.objectResponse = objectResponse;
        return this;
    }

    /**
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public Result setErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }
    
    public Result addError(String error){
        if(this.errors == null){
            this.errors = new ArrayList();
        }
        this.errors.add(error);
        return this;
    }
}
