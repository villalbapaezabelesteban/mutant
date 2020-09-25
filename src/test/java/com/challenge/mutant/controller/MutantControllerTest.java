package com.challenge.mutant.controller;

import com.challenge.mutant.filter.MutantFilterTest;
import com.challenge.mutant.view.PersonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MutantControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(MutantControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

    @Test
    public void testIsMutant() throws Exception {

        PersonView personView = new PersonView();
        personView.setDna(Arrays.asList(MutantFilterTest.MUTANT_DNA));

        String response = mockMvc.perform(post("/mutant")
                .content(objectmapper.writeValueAsString(personView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
    }

    //@Test
    public void testIsNotMutant() throws Exception {
        PersonView personView = new PersonView();
        personView.setDna(Arrays.asList(MutantFilterTest.NOT_MUTANT_DNA));

        String response = mockMvc.perform(post("/mutant")
                .content(objectmapper.writeValueAsString(personView))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.FORBIDDEN.value()))
                .andReturn().getResponse().getContentAsString();
    }
}