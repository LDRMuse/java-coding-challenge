package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.NumberFormat;
import java.util.*;

@Component
@Qualifier("person")
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


    public String calculateTotalInterestPerPersonForAllCards(ArrayList<Wallet> wallets) {
        double total = 0;

        for (Wallet w : wallets) {
            for (Card card : w.getCards()) {
                total += card.calculateInterest();
            }
        }
        return formatDouble(total);
    }


    public HashMap<String, Double> calculateTotalInterestPerCard(ArrayList<Wallet> wallets) {
        HashMap<String, Double> interestPerCard = new HashMap<>();

        for(Wallet w : wallets) {
            System.out.println(w.getCards());
            w.getCards().forEach(card -> interestPerCard.put(card.nameOfCard(), card.calculateInterest()));
        }
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

    @PostConstruct
    public void methodOnInit() {
        System.out.println("Inside person object");
    }

}
