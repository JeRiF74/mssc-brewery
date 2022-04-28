package az.micro.msscbrawery.controller;

import az.micro.msscbrawery.model.CustomerDto;
import az.micro.msscbrawery.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getById(@PathVariable UUID customerId) {

        return new ResponseEntity<>(customerService.getById(customerId) , HttpStatus.OK);
    }
}
