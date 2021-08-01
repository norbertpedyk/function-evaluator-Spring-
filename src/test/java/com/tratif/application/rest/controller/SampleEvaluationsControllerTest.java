package com.tratif.application.rest.controller;

import com.tratif.application.rest.dto.EvaluationResultDto;
import com.tratif.application.rest.service.SampleEvaluationsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SampleEvaluationsController.class)
class SampleEvaluationsControllerTest {

    @Autowired
    private SampleEvaluationsController sampleEvaluationsController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SampleEvaluationsService evaluationsService;

    @Test
    @DisplayName("should return dto with expected value when path variable is F1")
    void getEvaluation1() throws Exception {
        //when
        when(evaluationsService.sampleEvaluation("F1")).thenReturn(new EvaluationResultDto(30));
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/evaluation/F1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(30))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should return dto with expected value when path variable is F2")
    void getEvaluation2() throws Exception {
        //when
        when(evaluationsService.sampleEvaluation("F2")).thenReturn(new EvaluationResultDto(45));
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/evaluation/F2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(45))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should return status 404 when path variable is not one of F1, F2, F3")
    void getEvaluation3() throws Exception {
        //when
        when(evaluationsService.sampleEvaluation("F4")).thenReturn(new EvaluationResultDto(50));
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/evaluation/F4"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return dto with expected value when path variable is F3")
    void getEvaluation4() throws Exception {
        //when
        when(evaluationsService.sampleEvaluation("F3")).thenReturn(new EvaluationResultDto(70));
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/evaluation/F3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(70))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("should return dto with expected summed values")
    void getEvaluationAndSum() throws Exception {
        //when
        when(evaluationsService.sumOfSampleEvaluations()).thenReturn(new EvaluationResultDto(145));
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/evaluation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(145))
                .andExpect(status().isOk());
    }
}