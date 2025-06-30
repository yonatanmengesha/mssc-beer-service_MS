package com.springmicroservice.jotech.mssc_beer_service_MS.web.controller;

import com.springmicroservice.jotech.mssc_beer_service_MS.service.BeerService;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


   private final  BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId){


        return new ResponseEntity<>(beerService.getBeerById(beerId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity  saveNewBeer(@RequestBody @Validated BeerDto beerDto){


        return new ResponseEntity<>(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateByBeerId(@PathVariable UUID beerId,@RequestBody @Validated  BeerDto beerDto){


        return new ResponseEntity<>(beerService.updateBeerById(beerId,beerDto),HttpStatus.NO_CONTENT);
    }
}
