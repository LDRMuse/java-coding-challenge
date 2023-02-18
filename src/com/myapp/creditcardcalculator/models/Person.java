package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Scope("prototype")
public class Person {

    private Wallet wallet;


    public Person(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    // Challenge stated: "calculate the total interest (simple interest) for this person and per card"
    public double calculateTotalInterestPerPerson(List<Card> cards) {
        double total = 0;
        for (Card card : cards) {
            total += card.calculateInterest();
        }
        return total;
    }

    // Challenge stated: "calculate the total interest (simple interest) for .... and per card"
    public void calculateTotalInterestPerCard(List<Card> cards) {
        for (Card card : cards) {
            card.calculateInterest();
            System.out.println("Card " + card + "has an interest value of " + card.calculateInterest());
        }
    }

    @PostConstruct
    public void methodOnInit() {
        System.out.println("Inside person object");
    }

}
