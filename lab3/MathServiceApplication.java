package com.example.mathservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MathServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MathServiceApplication.class, args);
    }
    @RequestMapping(value = "/add/{num1}/{num2}", method = RequestMethod.GET)
    public String add(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return Double.toString(num1+num2);
    }
    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public String minus(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return Double.toString(num1-num2);
    }
    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public String multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return Double.toString(num1*num2);
    }
    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public String divide(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return Double.toString(num1/num2);
    }
}
