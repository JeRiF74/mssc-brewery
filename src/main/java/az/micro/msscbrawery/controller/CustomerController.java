package az.micro.msscbrawery.controller;

import az.micro.msscbrawery.model.CustomerDto;
import az.micro.msscbrawery.services.CustomerService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
@Validated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getById(@PathVariable UUID customerId) {

        return new ResponseEntity<>(customerService.getById(customerId) , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNewCustomer (@RequestBody @Valid CustomerDto customerDto) {
        CustomerDto savedCustomerDto = customerService.saveCustomer(customerDto);
        return new ResponseEntity(savedCustomerDto , HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer (@PathVariable UUID customerId , @Valid @RequestBody CustomerDto customerDto) {

        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer (@PathVariable UUID customerId) {
        customerService.deleteById(customerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {

        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(
                constraintViolation -> errors.add(
                        constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage()
                )
        );
        return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);
    }
}
