/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest.application.service;

import br.com.rh.apirest.application.dtos.PeopleDto;
import br.com.rh.apirest.application.dtos.SectorDto;
import br.com.rh.apirest.domain.entities.People;
import br.com.rh.apirest.domain.entities.Sector;
import br.com.rh.apirest.domain.interfaces.repository.IPeopleRepository;
import br.com.rh.apirest.services.api.interfaces.service.IPeopleService;
import com.google.common.reflect.TypeToken;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar_a
 */
@Service
public class PeopleService extends BaseService<PeopleDto,People> implements IPeopleService{
    
    private IPeopleRepository _peopleRepository;
    //@Autowired
    public PeopleService(IPeopleRepository repository) {
        super(repository);
        _peopleRepository = repository;
    }
    
    @Override
    public PeopleDto Create(PeopleDto dto) {
        return SaveEntity(dto);
    }

    @Override
    public PeopleDto Update(PeopleDto dto) {
        return SaveEntity(dto);
    }
    
    private PeopleDto SaveEntity(PeopleDto dto){
        var entity = this.getModelMapper().map(dto, People.class);
        var sector = dto.getSector();
        if(sector != null && sector.getId() > 0){
            entity.setSectorId(sector.getId());
        }
        this._peopleRepository.save(entity);
        Commit();
        return dto;
    }

    @Override
    public List<PeopleDto> GetListBySector(SectorDto sector) {
        var entity = this.getModelMapper().map(sector, Sector.class);
        var entitys = this._peopleRepository.findByIdOrName(entity.getId(),entity.getName());
        return this.getModelMapper().map(entitys, new TypeToken<List<PeopleDto>>(getClass()){}.getType());
    }
    
}
