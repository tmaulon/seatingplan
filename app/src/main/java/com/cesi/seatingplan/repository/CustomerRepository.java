package com.cesi.seatingplan.repository;

import com.cesi.seatingplan.model.customers.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
