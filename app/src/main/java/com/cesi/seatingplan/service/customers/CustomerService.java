package com.cesi.seatingplan.service.customers;

import com.cesi.seatingplan.dto.customers.CustomerDTO;
import com.cesi.seatingplan.dto.customers.CustomerMapper;
import com.cesi.seatingplan.exceptions.CustomerNotFoundException;
import com.cesi.seatingplan.model.customers.Customer;
import com.cesi.seatingplan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //@Autowired
    //private Password password;

    private CustomerMapper customerMapper = new CustomerMapper();

    @Override
    public CustomerDTO getById(Long id) throws CustomerNotFoundException {
        Optional<Customer> found = customerRepository.findById(id);
        if (found.isPresent()) {
            return customerMapper.map(found.get(), new CustomerDTO());
        } else {
            throw new CustomerNotFoundException(id);
        }
    }

    @Validated(OnCreate.class)
    @Override
    public CustomerDTO create(@Valid Customer customer) {
        // TODO MAKE THIS BREAK FFS ......
        //customer.setPassword(password.hashPassword(customer.getPassword()));
        return customerMapper.map(customerRepository.save(customer), new CustomerDTO());
    }
}
