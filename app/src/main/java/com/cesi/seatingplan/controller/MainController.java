package com.cesi.seatingplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/1.0") // This means URL's start with /1.0 (after Application path)
public class MainController {

    @GetMapping(path="/test")
    public @ResponseBody String test() {
        return "API IS READY MOTHERFUCKER";
    }
}
