package az.micro.msscbrawery.services.impl;

import az.micro.msscbrawery.model.BeerDto;
import az.micro.msscbrawery.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
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

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.info("For example purpose only {update method is working}");
    }

    @Override
    public void deleteById(UUID beerId) {
        log.info("Deleting a beer");
    }

}
