package com.example.lab05_2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceConsumer {
    @Autowired
    protected Sentence sentences;
    @RabbitListener(queues = "GetQueue")
    public Sentence getSentencs(){
        return sentences;
    }
    @RabbitListener(queues = "BadWordQueue")
    public void addBadSentence(String s){
        sentences.badSentences.add(s);
        System.out.println("In addBadSentence Method : "+sentences.badSentences);
    }
    @RabbitListener(queues = "GoodWordQueue")
    public void addGoodSentence(String s){
        sentences.goodSentences.add(s);
        System.out.println("In addGoodSentence Method : "+sentences.goodSentences);
    }}
