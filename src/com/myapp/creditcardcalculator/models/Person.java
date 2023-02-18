package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Person {

    private Wallet wallet;
    private final ArrayList<Wallet> wallets = new ArrayList<>();


    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        addWalletToWallets(wallet);
        this.wallet = wallet;
    }

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(ArrayList<Wallet> wallets) {
    }


    // Challenge stated: "calculate the total interest (simple interest) for a person ..."
    //should return double
    public double calculateTotalInterestPerPerson(List<Card> cards) {
        double total = 0;
        for (Card card : cards) {
            total += card.calculateInterest();
        }
        System.out.println("Total interest of all cards per person, per month: " + total);
        return total;
    }

    // Challenge stated: "calculate the total interest (simple interest) for .... and per card"
    //should return arraylist
    public ArrayList<Double> calculateTotalInterestPerCard(List<Card> cards) {
        ArrayList<Double> interestPerCard = new ArrayList<>();
        for (Card card : cards) {
            interestPerCard.add(card.calculateInterest());
        }
        return interestPerCard;
    }

    public void addWalletToWallets(Wallet w) {
        wallets.add(w);
        setWallets(wallets);
    }


    @PostConstruct
    public void methodOnInit() {
        System.out.println("Inside person object");
    }

}
