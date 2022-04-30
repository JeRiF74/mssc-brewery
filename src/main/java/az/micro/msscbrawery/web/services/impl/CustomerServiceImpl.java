package az.micro.msscbrawery.web.services.impl;

import az.micro.msscbrawery.web.model.CustomerDto;
import az.micro.msscbrawery.web.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getById(UUID customerId) {

        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Ulvi Rustamzade")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {

        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Ulvi Rustamzade")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.info("For example purpose only {update method is working}");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.info("For example purpose only {delete method is working}");
    }


}
