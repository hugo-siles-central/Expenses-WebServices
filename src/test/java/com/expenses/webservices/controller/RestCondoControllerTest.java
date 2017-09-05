package com.expenses.webservices.controller;

import com.expenses.business.model.Condo;
import com.expenses.business.services.CondoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class RestCondoControllerTest {

    private MockMvc mockMvc;
    @Mock
    private CondoService condoService;
    @InjectMocks
    private RestCondoController controller;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    public void registerCondo_CheckCallToService() throws Exception {
        Condo aCondo = new Condo();
        aCondo.setId(1);
        aCondo.setName("name");
        aCondo.setPhone("1234");
        String jsonCondo = "{\n" +
                "\t\"condo\":{\n" +
                "\t\"id\": 1,\n" +
                "\t\"name\": \"test mortal 2\",\n" +
                "\t\"phone\": \"2\"\n" +
                "\t\t\n" +
                "\t}\n" +
                "\n" +
                "}";
        when(condoService.registerCondo(isA(Condo.class))).thenReturn(aCondo);
        mockMvc.perform(put("/condos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCondo))
                .andExpect(status().isOk());
        verify(condoService, times(1)).registerCondo(isA(Condo.class));
        verifyNoMoreInteractions(condoService);
    }

    @Test
    public void registerCondo_CheckErrorWhenCondoIsEmpty() throws Exception {
        Condo aCondo = new Condo();
        aCondo.setId(1);
        aCondo.setName("name");
        aCondo.setPhone("1234");
        String jsonCondo = "";
        mockMvc.perform(put("/condos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCondo))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void registerCondo_CheckErrorWhenCondoIsBadFormed() throws Exception {
        Condo aCondo = new Condo();
        aCondo.setId(1);
        aCondo.setName("name");
        aCondo.setPhone("1234");
        String jsonCondo = "id:12";
        mockMvc.perform(put("/condos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCondo))
                .andExpect(status().isBadRequest());
    }

}