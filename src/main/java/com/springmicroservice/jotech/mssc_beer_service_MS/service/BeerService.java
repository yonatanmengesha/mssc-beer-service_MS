package com.springmicroservice.jotech.mssc_beer_service_MS.service;

import com.springmicroservice.jotech.mssc_beer_service_MS.web.model.BeerDto;


import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);
}
