package az.micro.msscbrawery.services.impl;

import az.micro.msscbrawery.model.CustomerDto;
import az.micro.msscbrawery.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getById(UUID customerId) {

        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Ulvi Rustamzade")
                .build();
    }
}
