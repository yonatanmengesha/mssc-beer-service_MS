package com.springmicroservice.jotech.mssc_beer_service_MS.repositories;

import com.springmicroservice.jotech.mssc_beer_service_MS.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
