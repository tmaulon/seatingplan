package com.cesi.seatingplan.exceptions;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(Long id) {
        super("Le client avec l'id " + id + " n'existe pas");
    }
}
