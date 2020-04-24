package com.cesi.seatingplan.model.customers;

import com.cesi.seatingplan.model.CurrentAccount;
import com.cesi.seatingplan.service.customers.OnCreate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class Customer implements java.io.Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 2, max = 25)
    private String lastName;

    @NotBlank(message = "First Name is mandatory")
    @Size(min = 3, max = 25)
    private String firstName;

    @NotBlank(message = "Password is mandatory", groups = OnCreate.class)
    private String password;

    private ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();

    public Customer() {
    }

    public Customer(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Customer(String lastName, String firstName, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.setPassword(password);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
