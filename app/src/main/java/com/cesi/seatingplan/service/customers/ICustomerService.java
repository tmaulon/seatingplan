package com.cesi.seatingplan.service.customers;

import com.cesi.seatingplan.dto.customers.CustomerDTO;
import com.cesi.seatingplan.exceptions.CustomerNotFoundException;
import com.cesi.seatingplan.model.customers.Customer;
import javax.validation.Valid;


public interface ICustomerService {
    public CustomerDTO getById(Long id) throws CustomerNotFoundException;
    public CustomerDTO create(@Valid Customer customer);
}
