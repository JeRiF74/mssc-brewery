package az.micro.msscbrawery.controller;

import az.micro.msscbrawery.model.CustomerDto;
import az.micro.msscbrawery.services.CustomerService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity addNewCustomer (@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomerDto = customerService.saveCustomer(customerDto);
        return new ResponseEntity(savedCustomerDto , HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer (@PathVariable UUID customerId , @RequestBody CustomerDto customerDto) {

        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer (@PathVariable UUID customerId) {
        customerService.deleteById(customerId);
    }


}
