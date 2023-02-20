package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Wallet {

    private Mastercard mastercard;
    private Visa visa;
    private Discover discover;
    private final ArrayList<Card> cards = new ArrayList<>();

    public Mastercard getMastercard() {
        return mastercard;
    }

    public void setMastercard(Mastercard mastercard) {
        addCardToCardArray(mastercard);
        this.mastercard = mastercard;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        addCardToCardArray(visa);
        this.visa = visa;
    }

    public Discover getDiscover() {
        return discover;
    }

    public void setDiscover(Discover discover) {
        addCardToCardArray(discover);
        this.discover = discover;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
    }


    public void addCardToCardArray(Card c) {
        cards.add(c);
        setCards(cards);
    }


}