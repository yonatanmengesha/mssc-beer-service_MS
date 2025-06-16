package com.springmicroservice.jotech.mssc_beer_service_MS.web.controller;

import com.springmicroservice.jotech.mssc_beer_service_MS.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId){

        //todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity  saveNewBeer(@RequestBody @Validated BeerDto beerDto){

        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateByBeerId(@PathVariable UUID beerId,@RequestBody @Validated  BeerDto beerDto){

        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
