package com.example.lab3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratePasswordService {
    @RequestMapping(value = "/{name}.generate", method = RequestMethod.GET)
    public String generate(@PathVariable("name") String name){
        return "Hi, "+name+"\n"+"Your new password is "+Math.round(Math.random()*1000000000)+".";

    }
}
