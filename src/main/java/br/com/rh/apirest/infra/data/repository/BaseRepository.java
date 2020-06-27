/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.infra.data.repository;

import br.com.rh.apirest.domain.entities.BaseEntity;
import br.com.rh.apirest.domain.interfaces.repository.IBaseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mar_a
 */
public class BaseRepository<TEntity extends BaseEntity> implements IBaseRepository<TEntity>{
    
    @Autowired
    private JpaRepository<TEntity,Long> repository;

    @Override
    public List<TEntity> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<TEntity> findAll(Sort sort) {
        return this.repository.findAll(sort);
    }

    @Override
    public List<TEntity> findAllById(Iterable<Long> itrbl) {
        return this.repository.findAllById(itrbl);
    }

    @Override
    public <S extends TEntity> List<S> saveAll(Iterable<S> itrbl) {
        return this.repository.saveAll(itrbl);
    }

    @Override
    public void flush() {
        this.repository.flush();
    }

    @Override
    public <S extends TEntity> S saveAndFlush(S s) {
        return this.repository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<TEntity> itrbl) {
        this.repository.deleteInBatch(itrbl);
    }

    @Override
    public void deleteAllInBatch() {
        this.repository.deleteAllInBatch();
    }

    @Override
    public TEntity getOne(Long id) {
        return this.repository.getOne(id);
    }

    @Override
    public <S extends TEntity> List<S> findAll(Example<S> exmpl) {
        return this.repository.findAll(exmpl);
    }

    @Override
    public <S extends TEntity> List<S> findAll(Example<S> exmpl, Sort sort) {
        return this.repository.findAll(exmpl, sort);
    }

    @Override
    public Page<TEntity> findAll(Pageable pgbl) {
        return this.repository.findAll(pgbl);
    }

    @Override
    public <S extends TEntity> S save(S s) {
        return this.repository.save(s);
    }

    @Override
    public Optional<TEntity> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return this.repository.existsById(id);
    }

    @Override
    public long count() {
        return this.repository.count();
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void delete(TEntity t) {
        this.repository.delete(t);
    }

    @Override
    public void deleteAll(Iterable<? extends TEntity> itrbl) {
        this.repository.deleteAll(itrbl);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }

    @Override
    public <S extends TEntity> Optional<S> findOne(Example<S> exmpl) {
        return this.repository.findOne(exmpl);
    }

    @Override
    public <S extends TEntity> Page<S> findAll(Example<S> exmpl, Pageable pgbl) {
        return this.repository.findAll(exmpl, pgbl);
    }

    @Override
    public <S extends TEntity> long count(Example<S> exmpl) {
        return this.repository.count(exmpl);
    }

    @Override
    public <S extends TEntity> boolean exists(Example<S> exmpl) {
        return this.repository.exists(exmpl);
    }
}
