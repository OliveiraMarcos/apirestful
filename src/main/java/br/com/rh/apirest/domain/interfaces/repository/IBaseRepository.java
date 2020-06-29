/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.domain.interfaces.repository;

import br.com.rh.apirest.domain.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mar_a
 * @param <TEntity>
 */
public interface IBaseRepository<TEntity extends BaseEntity> extends JpaRepository<TEntity, Long>{
    
}
