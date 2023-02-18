package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.stereotype.Component;

@Component
public class Wallet {

    private Card mastercard;
    private Card visa;
    private Card discover;
    private Card card;


    public Card getMastercard() {
        return mastercard;
    }

    public void setMastercard(Card mastercard) {
        this.mastercard = mastercard;
    }

    public Card getVisa() {
        return visa;
    }

    public void setVisa(Card visa) {
        this.visa = visa;
    }

    public Card getDiscover() {
        return discover;
    }

    public void setDiscover(Card discover) {
        this.discover = discover;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        if(card.equals(getDiscover())) {
            this.discover = card;
        } else if (card.equals(getVisa())) {
            this.visa = card;
        } else if (card.equals(getMastercard())) {
           this.mastercard = card;
        }}
}
