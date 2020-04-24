package com.cesi.seatingplan;

import com.cesi.Main;
import com.cesi.seatingplan.model.customers.Customer;
import com.cesi.seatingplan.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.test.properties")
public class CustomerRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CustomerRepository customerRepository;

    private Customer validCustomer;
    private Customer invalidCustomer;

    @Before
    public void setUp() {
        this.validCustomer = new Customer("Lavimet", "Jeanne", "password123");
        this.invalidCustomer = new Customer("Lavimet", "Jeanne");
    }

    @Test
    public void testCustomerCanBeCreatedWithMvc() throws Exception {
        setUp();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(this.validCustomer);
        System.out.println(jsonStr);

        mvc.perform(post("/api/1.0/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(status().isOk());

    }

    /*@Test
    public void givenInvalidCustomer_whenTryToCreateCustomer_thenBadRequestWithReason() throws Exception {
        setUp();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(this.invalidCustomer);
        System.out.println(jsonStr);

        mvc.perform(post("/api/1.0/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(status().isBadRequest());

    }*/

    @Test
    public void testAGivenUserCanBeRetrieved() throws Exception {
        testCustomerCanBeCreatedWithMvc();

        String resContent = mvc.perform(get("/api/1.0/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(resContent);
    }
}
