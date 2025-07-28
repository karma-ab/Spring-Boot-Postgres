package com.project.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.demo.dto.MayorDTO;
import com.project.demo.entity.MayorMaster;
import com.project.demo.service.interfaces.ICityService;

@WebMvcTest(MayorRestController.class)
class MayorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICityService cityService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<MayorDTO> mockMayors;
    private List<MayorMaster> mockMayorMasters;

    @BeforeEach
    void setUp() {
        mockMayors = Arrays.asList(
            new MayorDTO(1L, "John Doe", 45),
            new MayorDTO(2L, "Jane Smith", 52)
        );

        mockMayorMasters = Arrays.asList(
            new MayorMaster(1L, "John Doe", 45),
            new MayorMaster(2L, "Jane Smith", 52)
        );
    }

    @Test
    void getAllMayors_ShouldReturnListOfMayors() throws Exception {
        when(cityService.findMayors()).thenReturn(mockMayors);

        mockMvc.perform(get("/api/v1/mayors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].mayorId").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].age").value(45))
                .andExpect(jsonPath("$[1].mayorId").value(2))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"))
                .andExpect(jsonPath("$[1].age").value(52));
    }

    @Test
    void createMayors_ShouldReturnCreatedMayors() throws Exception {
        List<MayorDTO> newMayors = Arrays.asList(
            new MayorDTO(null, "Bob Johnson", 48)
        );

        List<MayorMaster> createdMayors = Arrays.asList(
            new MayorMaster(3L, "Bob Johnson", 48)
        );

        when(cityService.addMayor(any())).thenReturn(createdMayors);

        mockMvc.perform(post("/api/v1/mayors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newMayors)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].mayorId").value(3))
                .andExpect(jsonPath("$[0].name").value("Bob Johnson"))
                .andExpect(jsonPath("$[0].age").value(48));
    }
}