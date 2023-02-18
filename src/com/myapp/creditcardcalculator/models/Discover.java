package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Discover implements Card {
    @Value("${foo.cardBalance}")
    private String principal;
    @Value("${foo.discoverInterest}")
    private String rate;
    private CalculateInterestService calculateInterest;
    @Autowired
    public Discover(CalculateInterestService theCalculateInterest) {
        calculateInterest = theCalculateInterest; }

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
}
