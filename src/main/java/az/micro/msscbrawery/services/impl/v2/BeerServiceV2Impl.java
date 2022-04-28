package az.micro.msscbrawery.services.impl.v2;

import az.micro.msscbrawery.model.v2.BeerDtoV2;
import az.micro.msscbrawery.model.v2.BeerStyleEnum;
import az.micro.msscbrawery.services.v2.BeerServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Great cat")
                .beerStyle(BeerStyleEnum.KOZEL)
                .build();
    }

    @Override
    public BeerDtoV2 generateNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("Generated Beer")
                .beerStyle(BeerStyleEnum.KOZEL)
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        log.info("For example purpose only {update method is working}");
    }

    @Override
    public void deleteById(UUID beerId) {
        log.info("Deleting a beer");
    }
}
