package az.micro.msscbrawery.services;

import az.micro.msscbrawery.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto generateNewBeer(BeerDto beerDto);
}
