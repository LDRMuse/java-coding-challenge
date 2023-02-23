package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Qualifier("person")
public class Person {

    private final List<Wallet> wallets = new ArrayList<>();


    public void setWallet(Wallet wallet) {
        addWalletToWallets(wallet);
    }

    public List<Wallet> getWallets() {
        return wallets;
    }


    public String calculateTotalInterestPerPersonForAllCards(List<Wallet> wallets) {
        double total = 0;

        for (Wallet w : wallets) {
            for (Card card : w.getCards()) {
                total += card.calculateInterest();
            }
        }
        return formatDouble(total);
    }


    public HashMap<String, Double> calculateTotalInterestPerCard(List<Wallet> wallets) {
        HashMap<String, Double> interestPerCard = new HashMap<>();

        for(Wallet w : wallets) {
            w.getCards().forEach(card -> interestPerCard.put(card.nameOfCard(), card.calculateInterest()));
        }
        return interestPerCard;
    }

    public String formatDouble(Double d) {
        return String.format("%.2f", d);
    }


    public void addWalletToWallets(Wallet w) {
        wallets.add(w);
    }


}
