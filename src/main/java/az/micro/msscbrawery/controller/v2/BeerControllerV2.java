package az.micro.msscbrawery.controller.v2;

import az.micro.msscbrawery.model.v2.BeerDtoV2;
import az.micro.msscbrawery.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
@Validated
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable UUID beerId) {

        return new ResponseEntity(beerService.getBeerById(beerId) , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @NotNull @Valid  BeerDtoV2 beerDto) {
        BeerDtoV2 savedDto = beerService.generateNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location" , "/api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity(httpHeaders , HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer (@PathVariable UUID beerId ,@NotNull @Valid @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer (@PathVariable UUID beerId) {
        beerService.deleteById(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
