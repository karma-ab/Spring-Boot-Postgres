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
import com.project.demo.dto.CityDTO;
import com.project.demo.dto.CityMayorDTO;
import com.project.demo.dto.MessageDTO;
import com.project.demo.entity.CityMaster;
import com.project.demo.service.interfaces.ICityService;

@WebMvcTest(CityRestController.class)
class CityRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICityService cityService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<CityDTO> mockCities;
    private List<CityMaster> mockCityMasters;

    @BeforeEach
    void setUp() {
        mockCities = Arrays.asList(
            new CityDTO(1L, "New York", 8000000),
            new CityDTO(2L, "Los Angeles", 4000000)
        );

        mockCityMasters = Arrays.asList(
            new CityMaster(1L, "New York", 8000000),
            new CityMaster(2L, "Los Angeles", 4000000)
        );
    }

    @Test
    void getAllCities_ShouldReturnListOfCities() throws Exception {
        when(cityService.findAll()).thenReturn(mockCities);

        mockMvc.perform(get("/api/v1/cities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("New York"))
                .andExpect(jsonPath("$[0].population").value(8000000))
                .andExpect(jsonPath("$[1].name").value("Los Angeles"))
                .andExpect(jsonPath("$[1].population").value(4000000));
    }

    @Test
    void createCities_ShouldReturnCreatedCities() throws Exception {
        List<CityDTO> newCities = Arrays.asList(
            new CityDTO(null, "Chicago", 2700000)
        );

        List<CityMaster> createdCities = Arrays.asList(
            new CityMaster(3L, "Chicago", 2700000)
        );

        when(cityService.addCity(any())).thenReturn(createdCities);

        mockMvc.perform(post("/api/v1/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newCities)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Chicago"))
                .andExpect(jsonPath("$[0].population").value(2700000));
    }

    @Test
    void assignMayorToCity_ShouldReturnSuccessMessage() throws Exception {
        Long cityId = 1L;
        List<CityMayorDTO> cityMayors = Arrays.asList(
            new CityMayorDTO(cityId, 1L)
        );

        MessageDTO successMessage = new MessageDTO("Mayor assigned successfully");
        when(cityService.addCityMayor(any())).thenReturn(successMessage);

        mockMvc.perform(post("/api/v1/cities/{cityId}/mayors", cityId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cityMayors)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Mayor assigned successfully"));
    }
}