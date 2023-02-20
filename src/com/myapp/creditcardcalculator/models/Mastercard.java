package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Qualifier("mastercard")
@Scope("prototype")
public class Mastercard implements Card {

    @Value("${foo.cardBalance}")
    private String principal;
    @Value("${foo.mastercardInterest}")
    private String rate;
    @Autowired
    private CalculateInterestService monthlyInterestService;

    public Mastercard(CalculateInterestService theCalculateInterest) {
        monthlyInterestService = theCalculateInterest;
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
        return monthlyInterestService.calculateInterest(getPrincipal(), getRate());
    }

    @Override
    public String nameOfCard() {
        return "Mastercard";
    }

}
