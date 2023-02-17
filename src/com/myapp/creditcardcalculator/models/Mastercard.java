package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Mastercard implements Card {

    private double principal;
    @Value("${foo.mastercardInterest}")
    private String rate;
    private CalculateInterestService calculateInterest;
    @Autowired
    public Mastercard(CalculateInterestService calculateInterest) {
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public double getRate() {
        return Double.parseDouble(rate);
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getPrincipal() {
        return principal;
    }

    @Override
    public double calculateInterest() {
        return calculateInterest.calculateInterest(getPrincipal(), getRate());
    }


    @PostConstruct
    public void sayHiAtStartup() {
        System.out.println(rate.toString());
    }
}
