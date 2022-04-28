package az.micro.msscbrawery.services;

import az.micro.msscbrawery.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID customerId);
}
