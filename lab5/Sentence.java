package com.example.lab05_2;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
@Service
public class Sentence implements Serializable {
    public ArrayList<String> badSentences;
    public ArrayList<String> goodSentences;

    public Sentence(){
        badSentences = new ArrayList<>();
        goodSentences = new ArrayList<>();
    }
}
