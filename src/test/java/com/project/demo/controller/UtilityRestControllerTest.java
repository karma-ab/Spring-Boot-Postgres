package com.project.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.project.demo.service.AdhocService;
import com.project.demo.service.ThreadService;

@WebMvcTest(UtilityRestController.class)
class UtilityRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ThreadService threadService;

    @MockBean
    private AdhocService adhocService;

    @Test
    void startThreads_ShouldReturnTrue() throws Exception {
        when(threadService.startThreads()).thenReturn(true);

        mockMvc.perform(post("/api/v1/utilities/threads/start"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    void flattenJson_ShouldReturnFlattenedJson() throws Exception {
        String inputJson = "{\"name\":\"John\",\"address\":{\"city\":\"New York\"}}";
        String flattenedJson = "{\"name\":\"John\",\"address.city\":\"New York\"}";
        
        when(adhocService.getJsonFlat(any())).thenReturn(flattenedJson);

        mockMvc.perform(post("/api/v1/utilities/json/flatten")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("\"" + flattenedJson + "\""));
    }
}