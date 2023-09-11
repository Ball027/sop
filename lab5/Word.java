package com.example.lab05_2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Word {
    public ArrayList<String> badWords;
    public ArrayList<String> goodWords;
    public Word(){
        badWords = new ArrayList<>(Arrays.asList("fuck", "olo"));
        goodWords = new ArrayList<>(Arrays.asList("happy", "enjoy", "like"));
    }
}
