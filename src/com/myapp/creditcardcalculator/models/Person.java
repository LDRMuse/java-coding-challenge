package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println("Total interest of all cards per person, per month: " + formatDouble(total));
        return total;
    }

    // Challenge stated: "calculate the total interest (simple interest) for .... and per card"
    //should return key value
    public HashMap<String, Double> calculateTotalInterestPerCard(List<Card> cards) {
        HashMap<String, Double> interestPerCard = new HashMap<>();
        for (Card card : cards) {
            interestPerCard.put(card.nameOfCard(), card.calculateInterest());
        }
        System.out.println("Total interest per card, per month: " + interestPerCard);
        return interestPerCard;
    }

    public String formatDouble(Double d) {
        return String.format("%.2f", d);
    }

    // I wanted to format the value to show a percentage sign, but I kept getting an exception error
    // I then tried to replace the "%" symbol with "", but it defeated the purpose of the whole method
    // I kept this method to perhaps keep working at this
    public HashMap<String, Double> formatPercentageValue(HashMap<String, Double> map) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();

        for(Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            String formattedValue = percentFormat.format(value);
            map.put(key, Double.valueOf(formattedValue.replace("%", "")));
        }
        return map;
    }

    public void addWalletToWallets(Wallet w) {
        wallets.add(w);
        setWallets(wallets);
    }

    // Wanted feedback to show me where I am
    @PostConstruct
    public void methodOnInit() {
        System.out.println("Inside person object");
    }

}
