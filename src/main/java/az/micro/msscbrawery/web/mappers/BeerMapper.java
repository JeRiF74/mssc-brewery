package az.micro.msscbrawery.web.mappers;

import az.micro.msscbrawery.domain.Beer;
import az.micro.msscbrawery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto (Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
