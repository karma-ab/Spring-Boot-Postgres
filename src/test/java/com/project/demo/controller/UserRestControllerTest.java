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
import com.project.demo.dto.MongoUserDTO;
import com.project.demo.service.MongoService;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MongoService mongoService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<MongoUserDTO> mockUsers;

    @BeforeEach
    void setUp() {
        mockUsers = Arrays.asList(
            new MongoUserDTO("1", "john@example.com", "John Doe"),
            new MongoUserDTO("2", "jane@example.com", "Jane Smith")
        );
    }

    @Test
    void getAllUsers_ShouldReturnListOfUsers() throws Exception {
        when(mongoService.getUsers()).thenReturn(mockUsers);

        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].userId").value("1"))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].userId").value("2"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));
    }

    @Test
    void createUsers_ShouldReturnCreatedUsers() throws Exception {
        List<MongoUserDTO> newUsers = Arrays.asList(
            new MongoUserDTO(null, "bob@example.com", "Bob Johnson")
        );

        List<MongoUserDTO> createdUsers = Arrays.asList(
            new MongoUserDTO("3", "bob@example.com", "Bob Johnson")
        );

        when(mongoService.saveUsers(any())).thenReturn(createdUsers);

        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUsers)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].userId").value("3"))
                .andExpect(jsonPath("$[0].name").value("Bob Johnson"));
    }
}