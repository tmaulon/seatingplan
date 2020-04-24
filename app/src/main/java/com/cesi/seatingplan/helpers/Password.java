package com.cesi.seatingplan.helpers;

import org.springframework.stereotype.Component;

@Component
public class Password {
    public String hashPassword(String password) {
        return password;
    }
}
