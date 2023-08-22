package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    public CashierView(){
        TextField money = new TextField();
        money.setLabel("เงินทอน");
        money.setPlaceholder("$");
        Button btn = new Button("คำนวณเงินทอน");
        TextField b1000 = new TextField();
        b1000.setPlaceholder("$1000:");
        TextField b500 = new TextField();
        b500.setPlaceholder("$500:");
        TextField b100 = new TextField();
        b100.setPlaceholder("$100:");
        TextField b20 = new TextField();
        b20.setPlaceholder("$20:");
        TextField b10 = new TextField();
        b10.setPlaceholder("$10:");
        TextField b5 = new TextField();
        b5.setPlaceholder("$5:");
        TextField b1 = new TextField();
        b1.setPlaceholder("$1:");
        add(money,btn,b1000,b500,b100,b20,b10,b5,b1);
    }
}
