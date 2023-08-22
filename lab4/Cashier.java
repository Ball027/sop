package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value ="/getChange/{money}",method = RequestMethod.GET)
    public Change getChange(@PathVariable("money") int money){

        return null;
    }
}
