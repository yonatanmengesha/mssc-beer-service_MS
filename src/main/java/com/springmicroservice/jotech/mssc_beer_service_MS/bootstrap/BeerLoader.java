package com.springmicroservice.jotech.mssc_beer_service_MS.bootstrap;

import com.springmicroservice.jotech.mssc_beer_service_MS.domain.Beer;
import com.springmicroservice.jotech.mssc_beer_service_MS.service.BeerService;
import com.springmicroservice.jotech.mssc_beer_service_MS.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerService beerService;
    private final BeerMapper beerMapper;
    public static final String  BEER_1_UPC = "0631234200036";
    public static final String   BEER_2_UPC = "0631234300019";
    public static final String  BEER_3_UPC = "0083783375213";



    @Override
    public void run(String... args) throws Exception {

           loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerService.count()==0){
            beerService.saveNewBeer(beerMapper.beerToBeerDto(
                    Beer.
                            builder()
                            .beerName("Mango Bobs")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .minOnHand(12)
                            .upc(BEER_1_UPC)
                            .price(new BigDecimal("12.95"))
                            .build()));


            beerService.saveNewBeer(beerMapper.beerToBeerDto(Beer.
                    builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("11.95"))
                    .build()));

            beerService.saveNewBeer(beerMapper.beerToBeerDto(Beer.
                    builder()
                    .beerName("No Hammers On The Bar")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("11.95"))
                    .build()));
        }


    }
}
