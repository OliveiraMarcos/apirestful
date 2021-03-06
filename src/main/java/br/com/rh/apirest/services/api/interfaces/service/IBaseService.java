/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.services.api.interfaces.service;

import br.com.rh.apirest.application.dtos.Identity;
import br.com.rh.apirest.domain.entities.BaseEntity;
import java.util.List;

/**
 *
 * @author mar_a
 * @param <TDto>
 */
public interface IBaseService<TDto extends Identity,TEntity extends BaseEntity> {
    TDto GetById(long id);
    List<TDto> GetALL();
    TDto Create(TDto dto);
    TDto Update(TDto dto);
    int Delete(long id);
    int Commit();
}
