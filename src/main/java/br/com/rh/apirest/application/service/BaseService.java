/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.application.service;

import br.com.rh.apirest.application.dtos.Identity;
import br.com.rh.apirest.domain.entities.BaseEntity;
import br.com.rh.apirest.domain.interfaces.repository.IBaseRepository;
import br.com.rh.apirest.services.api.interfaces.service.IBaseService;
import com.google.common.reflect.TypeToken;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mar_a
 */
public class BaseService<TDto extends Identity,TEntity extends BaseEntity> implements IBaseService<TDto,TEntity> {

    @Autowired
    private ModelMapper modelMapper;
 
    private IBaseRepository<TEntity> _repository;
    
    public BaseService(IBaseRepository<TEntity> repository){
        this._repository = repository;
    }
    
    @Override
    public TDto GetById(long id) {
        Optional<TEntity> entity = this._repository.findById(id);
        if(entity.isPresent()){
            TDto dto = this.modelMapper.map(entity.get(), new TypeToken<TDto>(getClass()){}.getType());
            return dto;
        }else{
            return null;
        }
    }

    @Override
    public List<TDto> GetALL() {
        List<TEntity> entitys = this._repository.findAll();
        List<TDto> dtos = this.modelMapper.map(entitys, new TypeToken<List<TDto>>(getClass()){}.getType());
        return dtos;
    }

    @Override
    public TDto Create(TDto dto) {
        return SaveEntity(dto);
    }
    
    private TDto SaveEntity(TDto dto){
        TEntity entity = this.modelMapper.map(dto, new TypeToken<TEntity>(getClass()){}.getType());
        this._repository.save(entity);
        Commit();
        return dto;
    }

    @Override
    public TDto Update(TDto dto) {
        return SaveEntity(dto);
    }

    @Override
    public int Delete(long id) {
        this._repository.deleteById(id);
        return 1;
    }

    @Override
    public int Commit() {
        this._repository.flush();
        return 1;
    }

    protected ModelMapper getModelMapper(){
        return this.modelMapper;
    }
}
