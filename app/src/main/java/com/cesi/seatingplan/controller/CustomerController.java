package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dto.customers.CustomerDTO;
import com.cesi.seatingplan.exceptions.CustomerNotFoundException;
import com.cesi.seatingplan.model.customers.Customer;
import com.cesi.seatingplan.repository.CustomerRepository;
import com.cesi.seatingplan.service.customers.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;

@RestController
@RequestMapping(path="api/1.0") // This means URL's start with /1.0 (after Application path)
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customers")
    public @ResponseBody Iterable<Customer> all() {
        return customerRepository.findAll();
    }

    @RequestMapping("/customers/{id}")
    public @ResponseBody
    CustomerDTO show(@PathVariable Long id) {
        try {
            return customerService.getById(id);
        } catch (CustomerNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer not found at id " + id + "."
            );
        }
    }

    @PostMapping(path="/customers")
    public @ResponseBody CustomerDTO create (@Valid @RequestBody Customer cus) {
        return customerService.create(cus);
    }
}
