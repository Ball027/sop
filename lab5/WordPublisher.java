package com.example.lab05_2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class WordPublisher {
    @Autowired private RabbitTemplate rabbitTemplate;
    @Autowired protected Word words;
    @RequestMapping(value = "/addBad/{word}", method = {RequestMethod.GET, RequestMethod.POST})
    public ArrayList<String> addBadWord(@PathVariable("word") String s){
        words.badWords.add(s);
        return (words.badWords);
    }

    @RequestMapping(value = "/delBad/{word}", method = RequestMethod.GET)
    public ArrayList<String> deleteBadWord(@PathVariable("word") String s){
        words.badWords.remove(s);
        return (words.badWords);
    }
    @RequestMapping(value = "/addGood/{word}", method = {RequestMethod.GET, RequestMethod.POST})
    public ArrayList<String> addGoodWord(@PathVariable("word") String s){
        words.goodWords.add(s);
        return (words.goodWords);
    }
    @RequestMapping(value = "/delGood/{word}", method = RequestMethod.GET)
    public ArrayList<String> deleteGoodWord(@PathVariable("word") String s){
        words.goodWords.remove(s);
        return (words.goodWords);
    }
    @RequestMapping(value = "/proof/{sentence}", method = {RequestMethod.GET, RequestMethod.POST})
    public String proofSentence(@PathVariable("sentence") String s){
        String sentence = s;
        boolean foundGood = false;
        boolean foundBad = false;
        for (String word : words.goodWords){
            if(sentence.contains(word)){
                foundGood = true;
                break;
            }
        }
        for (String word : words.badWords){
            if(sentence.indexOf(word) != -1){
                foundBad = true;
                break;
            }
        }
        if(foundGood && foundBad){
            rabbitTemplate.convertAndSend("Fanout", "", sentence);
            return ("Found Bad & Good Word");
        }else if(foundGood){
            rabbitTemplate.convertAndSend("Direct", "good", sentence);
            return ("Found Good Word");
        }else if(foundBad){
            rabbitTemplate.convertAndSend("Direct", "bad", sentence);
            return ("Found Bad Word");}

        return ("Dont Found");
    }
    @RequestMapping(value = "/getSentence", method = RequestMethod.GET)
    public Sentence getSentencs(){
        Object sentences = rabbitTemplate.convertSendAndReceive
                ("Direct", "", "");
        return ((Sentence) sentences);}

//    @RequestMapping(value = "/addBad/{word}", method = RequestMethod.GET)
//    public ArrayList<String> addBadWord(@PathVariable("word") String s){
//        Object badWord = rabbitTemplate.convertSendAndReceive("Direct", "bad", s);
//        return ((ArrayList<String>) badWord);
//    }

}
