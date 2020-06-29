/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rh.apirest;

import br.com.rh.apirest.application.dtos.PeopleDto;
import br.com.rh.apirest.services.api.controllers.PeopleController;
import br.com.rh.apirest.services.api.interfaces.service.IPeopleService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebMvcTest(PeopleController.class)
public class PeopleWebApiTest {
    
    @MockBean
    IPeopleService peopleService;
     
    ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    private MockMvc mockMvc;
   
    
    @Test
    public void it_should_validate_security() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/people"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    
    @Test
    @WithMockUser(username = "admin", password = "102030", roles = "USER")
    public void it_should_return_created_people() throws Exception {
        var people = new PeopleDto().setFirstName("People test")
                                    .setLastName("Test");
        
        when(peopleService.Create(any(PeopleDto.class))).thenReturn(people);
        
        mockMvc.perform( MockMvcRequestBuilders.post("/api/people")
                .content(mapper.writeValueAsString(people))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success!"));
    }
    
    @Test
    @WithMockUser(username = "admin", password = "102030", roles = "USER")
    public void it_should_return_all_people() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/people"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    @WithMockUser(username = "admin", password = "102030", roles = "USER")
    public void it_should_return_one_people() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/people/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
