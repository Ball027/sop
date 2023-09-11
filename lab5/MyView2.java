package com.example.lab05_2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;

@Route(value="index2")
public class MyView2 extends HorizontalLayout {
    private TextField tfWord, tfSentence;
    private TextArea taGoodSentence, taBadSentence;
    private ComboBox<String> cbGoodWord, cbBadWord;
    private Button btnAddGood, btnAddBad, btnAddSentence, btnShowSentence;
    public MyView2(){
        tfWord = new TextField("Add Word");
        tfSentence = new TextField("Add Sentence");
        taGoodSentence = new TextArea("Good Sentence");
        taBadSentence = new TextArea("Bad Sentece");
        cbGoodWord = new ComboBox<>();
        cbGoodWord.setLabel("Good Word");
        cbGoodWord.setItems("happy", "enjoy", "like");
        cbBadWord = new ComboBox<>();
        cbBadWord.setLabel("Bad Word");
        cbBadWord.setItems(Arrays.asList("fuck", "olo"));
        btnAddGood = new Button("Add Good Word");
        btnAddBad = new Button("Add Bad Word");
        btnAddSentence = new Button("Add Sentence");
        btnShowSentence = new Button("Show Sentence");
        FormLayout fl = new FormLayout(tfWord, btnAddGood, btnAddBad, cbGoodWord, cbBadWord);
        FormLayout fr = new FormLayout(tfSentence, btnAddSentence, taGoodSentence, taBadSentence, btnShowSentence);
        add(fl, fr);
        btnAddGood.addClickListener(event ->{
            String word = (tfWord.getValue());
            ArrayList out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addGood/"+word)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(ArrayList.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            cbGoodWord.setItems(out);
        });
        btnAddBad.addClickListener(event ->{
            String word = (tfWord.getValue());
            ArrayList out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addBad/"+word)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(ArrayList.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            cbBadWord.setItems(out);
        });
        btnAddSentence.addClickListener(event ->{
            String sentence = (tfSentence.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/proof/"+sentence)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            System.out.println(out);
            Notification.show(out);
        });
        btnShowSentence.addClickListener(event ->{
            Sentence out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getSentence")
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(Sentence.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            taGoodSentence.setValue(String.valueOf(out.goodSentences));
            taBadSentence.setValue(String.valueOf(out.badSentences));
        });



// Insert Code to Event Handler with Call REST API SERVICE
//        btnPlus.addClickListener(event ->{
//            double num1 = Double.parseDouble(n1.getValue());
//            double num2 = Double.parseDouble(n2.getValue());
//            String out = WebClient.create()
//                    .get()
//                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
//                    .retrieve() // ให้รอรับข้อมูลกลับมา
//                    .bodyToMono(String.class) // กําหนด Spec ของ Response
//                    .block(); // Blocking thread
//            ans.setValue(out);
//        });
//        btnMinus.addClickListener(event ->{
//            double num1 = Double.parseDouble(n1.getValue());
//            double num2 = Double.parseDouble(n2.getValue());
//            String out = WebClient.create()
//                    .get()
//                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
//                    .retrieve() // ให้รอรับข้อมูลกลับมา
//                    .bodyToMono(String.class) // กําหนด Spec ของ Response
//                    .block(); // Blocking thread
//            ans.setValue(out);
//        });
//        btnMulti.addClickListener(event ->{
//            double num1 = Double.parseDouble(n1.getValue());
//            double num2 = Double.parseDouble(n2.getValue());
//            String out = WebClient.create()
//                    .get()
//                    .uri("http://localhost:8080/multiply/"+num1+"/"+num2)
//                    .retrieve() // ให้รอรับข้อมูลกลับมา
//                    .bodyToMono(String.class) // กําหนด Spec ของ Response
//                    .block(); // Blocking thread
//            ans.setValue(out);
//        });
//        btnDivide.addClickListener(event ->{
//            double num1 = Double.parseDouble(n1.getValue());
//            double num2 = Double.parseDouble(n2.getValue());
//            String out = WebClient.create()
//                    .get()
//                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
//                    .retrieve() // ให้รอรับข้อมูลกลับมา
//                    .bodyToMono(String.class) // กําหนด Spec ของ Response
//                    .block(); // Blocking thread
//            ans.setValue(out);
//        });
//        btnMod.addClickListener(event ->{
//            double num1 = Double.parseDouble(n1.getValue());
//            double num2 = Double.parseDouble(n2.getValue());
//            String out = WebClient.create()
//                    .get()
//                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
//                    .retrieve() // ให้รอรับข้อมูลกลับมา
//                    .bodyToMono(String.class) // กําหนด Spec ของ Response
//                    .block(); // Blocking thread
//            ans.setValue(out);
//        });
//        btnMax.addClickListener(event ->{
//            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//            formData.add("num1", n1.getValue()); // key คือ n1, value คือ n1.getValue())
//            formData.add("num2", n2.getValue());
//            String out = WebClient.create()
//                    .post()
//                    .uri("http://localhost:8080/max")
//                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                    .body(BodyInserters.fromFormData(formData))
//                    .retrieve() // ให้รอรับข้อมูลกลับมา
//                    .bodyToMono(String.class) // กําหนด Spec ของ Response
//                    .block(); // Blocking thread
//            ans.setValue(out);
//        });
    }
}
