package com.example.lab3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class CustomerController {
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public CustomerController(){
        customers.add(new Customer("1010","John","Male",25));
        customers.add(new Customer("1018","Peter","Male",24));
        customers.add(new Customer("1019","Sara","Female",23));
        customers.add(new Customer("1110","Rose","Female",23));
        customers.add(new Customer("1001","Emma","Female",30));
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getID().equals(ID)){
                return customers.get(i);
            };
        }
        return null;
    }
    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("n") String n){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getName().equals(n)){
                return customers.get(i);
            };
        }
        return null;
    }
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        customers.remove(this.getCustomerByID(ID));
        return true;
    }
    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String n){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getName().equals(n)){
                customers.remove(i);
            };
        }
        return true;
    }
}