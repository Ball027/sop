package com.example.lab4;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Route(value = "index1")
public class MathView extends FormLayout {
    public MathView(){
        HorizontalLayout h1 = new HorizontalLayout();
        VerticalLayout v1 = new VerticalLayout();
        TextField Number1 = new TextField();
        Number1.setLabel("Number1");
        TextField Number2 = new TextField();
        Number2.setLabel("Number2");
        Button plus = new Button("+");
        Button minus = new Button("-");
        Button multi = new Button("x");
        Button divide = new Button("/");
        Button mod = new Button("Mod");
        Button max = new Button("Max");
        TextField Answer = new TextField();
        Answer.setLabel("Answer");
        h1.add(plus,minus,multi,divide,mod,max);
        v1.add(Number1,Number2,h1,Answer);
        add(v1);

        plus.addClickListener(Event -> {
            double num1 = Double.parseDouble(Number1.getValue());
            double num2 = Double.parseDouble(Number2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8081/plus/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            Answer.setValue(out);
        });
        minus.addClickListener(Event -> {
            double num1 = Double.parseDouble(Number1.getValue());
            double num2 = Double.parseDouble(Number2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8081/minus/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            Answer.setValue(out);
        });
        multi.addClickListener(Event -> {
            double num1 = Double.parseDouble(Number1.getValue());
            double num2 = Double.parseDouble(Number2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8081/multi/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            Answer.setValue(out);
        });
        divide.addClickListener(Event -> {
            double num1 = Double.parseDouble(Number1.getValue());
            double num2 = Double.parseDouble(Number2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8081/divide/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            Answer.setValue(out);
        });
        mod.addClickListener(Event -> {
            double num1 = Double.parseDouble(Number1.getValue());
            double num2 = Double.parseDouble(Number2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8081/mod/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            Answer.setValue(out);
        });
        max.addClickListener(event->{

            double num1 = Double.parseDouble(Number1.getValue());
            double num2 = Double.parseDouble(Number2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8081/max")
                    .body(Mono.just(new Mynumber(num1, num2)), Mynumber.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            Answer.setValue(out);
        });
    }
}