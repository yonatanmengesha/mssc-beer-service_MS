package com.springmicroservice.jotech.mssc_beer_service_MS.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.model.BeerDto;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

          BeerDto beerDto = getValidBeerDto();

          String beerDtoJson = objectMapper.writeValueAsString(beerDto);

          mockMvc.perform(post("/api/v1/beer")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(beerDtoJson))
                  .andExpect(status().isCreated());
    }

    @Test
    void updateByBeerId() throws Exception {

        BeerDto beerDto = getValidBeerDto();
        String beerDtoJson= objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(123456780L)
                .build();
    }
}