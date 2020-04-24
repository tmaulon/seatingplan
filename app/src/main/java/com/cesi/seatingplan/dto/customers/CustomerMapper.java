package com.cesi.seatingplan.dto.customers;
import com.cesi.seatingplan.model.customers.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements IMapper<Customer, CustomerDTO> {
    @Override
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Override
    public CustomerDTO map(Customer customer, CustomerDTO customerDTO) {
       return this.getModelMapper().map(customer, customerDTO.getClass());
    }
}
