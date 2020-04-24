package com.cesi.seatingplan;

import com.cesi.seatingplan.dto.customers.CustomerDTO;
import com.cesi.seatingplan.exceptions.CustomerNotFoundException;
import com.cesi.seatingplan.model.customers.Customer;
import com.cesi.seatingplan.service.customers.CustomerService;
import com.cesi.seatingplan.service.customers.ICustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(
        locations = "classpath:application.test.properties")
public class CustomerServiceTest {
    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
        @Bean
        public CustomerService customerService() {
            return new CustomerService();
        }
    }

    private Customer validCustomer;
    private Customer invalidCustomer;
    private ArrayList<Integer> list = new ArrayList<>();

    @Autowired
    private ICustomerService customerService;


    @Before
    public void setUp() {
        this.validCustomer = new Customer("Georget", "Kevin", "password123");
        this.invalidCustomer = new Customer("G", "Ke");
        this.list.add(1);
        this.list.add(666);
    }


    @Test
    public void mutationTest() {
        Customer customer = new Customer("Laroque", "Michelle", "pedaledouce");
        System.out.println(customer.getLastName());
    }

    @Test
    public void testInjectedDependenciesAreNotNull() throws Exception {
        assertThat(customerService).isNotNull();
    }

    @Test
    public void testCustomerCanBeCreatedAndRetrievedAsDTOWithService() throws Exception {
        System.out.println(validCustomer.getLastName());
        CustomerDTO freshCustomer = customerService.create(validCustomer);
        assertThat(freshCustomer).isInstanceOf(CustomerDTO.class);

        CustomerDTO cus = customerService.getById(freshCustomer.getId());
        assertThat(cus).isInstanceOf(CustomerDTO.class);
        assertThat(cus.getFirstName()).isEqualTo(freshCustomer.getFirstName());
        assertThat(cus.getLastName()).isEqualTo(freshCustomer.getLastName());
        System.out.println(cus.getFullName());
        assertThat(cus.getFullName()).isEqualTo(freshCustomer.getFirstName() + " " + freshCustomer.getLastName());
    }

    @Test
    public void givenCustomerCreatedAtId1_whenITryToRetrieveCustomerAtBadId_thenItThrowsTheRightException()
            throws Exception {
        CustomerDTO freshCustomer = customerService.create(validCustomer);
        Long badId = 999999999999L;
        try {
            CustomerDTO cus = customerService.getById(badId);
            assertThat(cus).isNotInstanceOf(CustomerDTO.class);
            System.out.println(cus);
        } catch(Exception e) {
            assertThat(e).isInstanceOf(CustomerNotFoundException.class);
        }
    }

   /* @Test
    public void givenInvalidCustomer_whenTryToCreateCustomer_thenConstraintViolationException() throws Exception {
        assertThrows(ConstraintViolationException.class, () -> {
            CustomerDTO freshCustomer = customerService.create(invalidCustomer);
            System.out.println(freshCustomer.getFullName());
            System.out.println(customerService.getById(1L).getFullName());
        });
    }*/
}
