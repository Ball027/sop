package com.example.lab3;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Customer {
    private String ID;
    private String name;
    private String sex;
    private int age;

    public Customer(){
        this("",null,"female",0);
    }
    public  Customer(String ID,String name,String sex,int age){
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        if(sex.equals("Male") && sex.equals("male")){
            this.sex = "male";
        }
        else if(sex.equals("Female") && sex.equals("female")){
            this.sex =  "female";
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age<0){
            this.age = 0;
        }
        this.age = age;
    }

}
