/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest;

import br.com.rh.apirest.application.dtos.SectorDto;
import br.com.rh.apirest.services.api.controllers.SectorController;
import br.com.rh.apirest.services.api.interfaces.service.ISectorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;




/**
 *
 * @author mar_a
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SectorController.class)
public class SectorWebApiTest {
    
    @MockBean
    ISectorService sectorService;
    
    ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    private MockMvc mockMvc;
   
    
    @Test
    public void it_should_validate_security() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/sector"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    
    @Test
    @WithMockUser(username = "admin", password = "102030", roles = "USER")
    public void it_should_return_created_sector() throws Exception {
        var sector = new SectorDto().setName("Sector test");
        
        when(sectorService.Create(any(SectorDto.class))).thenReturn(sector);
        
        mockMvc.perform( MockMvcRequestBuilders.post("/api/sector")
                .content(mapper.writeValueAsString(sector))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success!"));
    }
    
    @Test
    @WithMockUser(username = "admin", password = "102030", roles = "USER")
    public void it_should_return_all_sector() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/sector"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    @WithMockUser(username = "admin", password = "102030", roles = "USER")
    public void it_should_return_one_sector() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/sector/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    
    
    
}
