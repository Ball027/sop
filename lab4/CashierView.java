package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    public CashierView(){
        TextField money = new TextField();
        money.setLabel("เงินทอน");
        money.setPrefixComponent(new Span("$"));
        Button btn = new Button("คำนวณเงินทอน");
        TextField b1000 = new TextField();
        b1000.setPrefixComponent(new Span("$1000:"));
        TextField b500 = new TextField();
        b500.setPrefixComponent(new Span("$500:"));
        TextField b100 = new TextField();
        b100.setPrefixComponent(new Span("$100:"));
        TextField b20 = new TextField();
        b20.setPrefixComponent(new Span("$20:"));
        TextField b10 = new TextField();
        b10.setPrefixComponent(new Span("$10:"));
        TextField b5 = new TextField();
        b5.setPrefixComponent(new Span("$5:"));
        TextField b1 = new TextField();
        b1.setPrefixComponent(new Span("$1:"));
        add(money,btn,b1000,b500,b100,b20,b10,b5,b1);

        btn.addClickListener(Event -> {
            int cost = Integer.parseInt(money.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8081/getChange/" + cost)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();
            assert out != null;
            b1000.setValue(String.valueOf(out.getB1000()));
            b500.setValue(String.valueOf(out.getB500()));
            b100.setValue(String.valueOf(out.getB100()));
            b20.setValue(String.valueOf(out.getB20()));
            b10.setValue(String.valueOf(out.getB10()));
            b5.setValue(String.valueOf(out.getB5()));
            b1.setValue(String.valueOf(out.getB1()));
            System.out.println(out.getB1());
        });
    }
}