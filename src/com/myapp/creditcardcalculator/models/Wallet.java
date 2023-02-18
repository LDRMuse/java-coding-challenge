package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class Wallet {

    private Card mastercard;
    private Card visa;
    private Card discover;
    private Card card;
    private final ArrayList<Card> cards = new ArrayList<>();


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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
    }


    public void setCard(Card card) {
        addCardToCardArray(card);
        if(card.equals(getDiscover())) {
            this.discover = card;
        } else if (card.equals(getVisa())) {
            this.visa = card;
        } else if (card.equals(getMastercard())) {
            this.mastercard = card;
        }}

    public void addCardToCardArray(Card c) {
        cards.add(c);
        setCards(cards);
    }


}
