package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value ="/getChange/{money}",method = RequestMethod.GET)
    public Change getChange(@PathVariable("money") int money){
        int b1000 = money/1000;
        int b500 = (money-(b1000*1000))/500;
        int b100 = (money-(b1000*1000)-(b500*500))/100;
        int b20 = (money-(b1000*1000)-(b500*500)-(b100*100))/20;
        int b10 = (money-(b1000*1000)-(b500*500)-(b100*100)-(b20*20))/10;
        int b5 = (money-(b1000*1000)-(b500*500)-(b100*100)-(b20*20)-(b10*10))/5;
        int b1 = (money-(b1000*1000)-(b500*500)-(b100*100)-(b20*20)-(b10*10)-(b5*5))/1;
        Change cost = new Change();
        cost.setB1000(b1000);
        cost.setB500(b500);
        cost.setB100(b100);
        cost.setB20(b20);
        cost.setB10(b10);
        cost.setB5(b5);
        cost.setB1(b1);
        return cost;
    }
}