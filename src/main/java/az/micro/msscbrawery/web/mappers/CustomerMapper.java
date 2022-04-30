package az.micro.msscbrawery.web.mappers;

import az.micro.msscbrawery.domain.Customer;
import az.micro.msscbrawery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer (CustomerDto customerDto);

    CustomerDto customerToCustomerDto (Customer customer);
}
