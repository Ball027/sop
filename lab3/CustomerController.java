package com.example.lab3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<Customer>();
//    customers.add(new Customer("1010","John","Male",25));
//    customers.add(new Customer("1018","Peter","Male",24));
//    customers.add(new Customer("1019","Sara","Female",23));
//    customers.add(new Customer("1110","Rose","Female",23));
//    customers.add(new Customer("1001","Emma","Female",30));
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
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
//    @RequestMapping(value = "/customersbyname/{n}", method = RequestMethod.GET)
//    public Customer getCustomerByName(@PathVariable("n") String n){
//        return ;
//    }
}
