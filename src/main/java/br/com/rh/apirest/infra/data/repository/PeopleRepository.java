
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.infra.data.repository;

import br.com.rh.apirest.domain.entities.People;
import br.com.rh.apirest.domain.interfaces.repository.IPeopleRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mar_a
 */
@Repository
public class PeopleRepository extends BaseRepository<People> implements IPeopleRepository {
    
}
