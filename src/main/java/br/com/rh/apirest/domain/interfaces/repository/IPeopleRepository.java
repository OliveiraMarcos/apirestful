/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.domain.interfaces.repository;

import br.com.rh.apirest.domain.entities.People;
import br.com.rh.apirest.domain.entities.Sector;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mar_a
 */
@Repository
public interface IPeopleRepository extends IBaseRepository<People>{
    @Query("select p from People p join p.sector s where p.sector_id = ?1 or s.name like %?2")
    List<People> findByIdOrName(Long id, String name);
}
