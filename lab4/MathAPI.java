package com.example.lab4;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
@SpringBootApplication
@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public String myPlus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return Double.toString(n1+n2);
    }
    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public String myMinus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return Double.toString(n1-n2);
    }
    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return Double.toString(n1*n2);
    }
    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return Double.toString(n1/n2);
    }
    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public String myMod(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return Double.toString(n1%n2);
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestBody Mynumber n) {
        return Double.toString(Math.max(n.getN1(), n.getN2()));
    }
}