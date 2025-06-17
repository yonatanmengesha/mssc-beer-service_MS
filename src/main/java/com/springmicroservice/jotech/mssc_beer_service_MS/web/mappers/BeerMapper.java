package com.springmicroservice.jotech.mssc_beer_service_MS.web.mappers;

import com.springmicroservice.jotech.mssc_beer_service_MS.domain.Beer;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
