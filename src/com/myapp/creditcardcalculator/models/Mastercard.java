package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Mastercard implements Card {

    @Value("${foo.cardBalance}")
    private String principal;
    @Value("${foo.mastercardInterest}")
    private String rate;

    private final CalculateInterestService calculateInterest;

    public Mastercard(CalculateInterestService theCalculateInterest) {
        calculateInterest = theCalculateInterest;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public double getRate() {
        return Double.parseDouble(rate);
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public double getPrincipal() {
        return Double.parseDouble(principal);
    }

    @Override
    public double calculateInterest() {
        return calculateInterest.calculateInterest(getPrincipal(), getRate());
    }

    @Override
    public String nameOfCard() {
        return "Mastercard";
    }

}
