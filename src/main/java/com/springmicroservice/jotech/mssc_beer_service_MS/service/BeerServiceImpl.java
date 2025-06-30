package com.springmicroservice.jotech.mssc_beer_service_MS.service;

import com.springmicroservice.jotech.mssc_beer_service_MS.domain.Beer;
import com.springmicroservice.jotech.mssc_beer_service_MS.repositories.BeerRepository;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.controller.NotFoundException;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.mappers.BeerMapper;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    private final BeerMapper beerMapper;
    @Override
    public BeerDto getBeerById(UUID beerId) {


            return beerMapper.beerToBeerDto(
                    beerRepository.findById(beerId)
                            .orElseThrow(()-> new NotFoundException()));

    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository
                .save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().toString());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
