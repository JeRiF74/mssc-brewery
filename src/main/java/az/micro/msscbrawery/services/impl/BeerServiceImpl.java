package az.micro.msscbrawery.services.impl;

import az.micro.msscbrawery.model.BeerDto;
import az.micro.msscbrawery.services.BeerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Great cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto generateNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Generated Beer")
                .build();
    }

}
