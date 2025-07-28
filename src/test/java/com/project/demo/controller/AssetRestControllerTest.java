package com.project.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.project.demo.dto.AssetDTO;
import com.project.demo.service.AssetService;

@WebMvcTest(AssetRestController.class)
class AssetRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssetService assetService;

    private List<AssetDTO> mockAssets;

    @BeforeEach
    void setUp() {
        mockAssets = Arrays.asList(
            new AssetDTO(1L, "Asset1", 1000.0),
            new AssetDTO(2L, "Asset2", 2000.0)
        );
    }

    @Test
    void getAssets_ShouldReturnSortedAssets() throws Exception {
        when(assetService.sortAsset()).thenReturn(mockAssets);

        mockMvc.perform(get("/api/v1/assets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].assetName").value("Asset1"))
                .andExpect(jsonPath("$[0].assetPrice").value(1000))
                .andExpect(jsonPath("$[1].assetName").value("Asset2"))
                .andExpect(jsonPath("$[1].assetPrice").value(2000));
    }

    @Test
    void getAssets_WithSortParameter_ShouldReturnSortedAssets() throws Exception {
        when(assetService.sortAsset()).thenReturn(mockAssets);

        mockMvc.perform(get("/api/v1/assets")
                .param("sort", "price"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }
}