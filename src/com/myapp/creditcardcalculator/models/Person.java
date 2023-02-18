package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Person {

    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }


    public double getTotalInterestFromOneCard(Wallet wallet, Card card) {
        wallet.setCard(card);
        return card.calculateInterest();
    }

    public double getTotalInterestFromTwoCards(Wallet wallet, Card card1, Card card2) {
        wallet.setCard(card1);
        wallet.setCard(card2);
        return card1.calculateInterest() + card2.calculateInterest();
    }

    public double getTotalInterestFromThreeCards(Wallet wallet, Card card1, Card card2, Card card3) {
        wallet.setCard(card1);
        wallet.setCard(card2);
        wallet.setCard(card3);
        return card1.calculateInterest() + card2.calculateInterest() + card3.calculateInterest();
    }


    @PostConstruct
    public void methodOnInit() {
        System.out.println("Inside person object");
    }

}
