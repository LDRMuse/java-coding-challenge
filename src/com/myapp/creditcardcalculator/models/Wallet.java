package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Wallet {

    private Card card;
    private final List<Card> cards = new ArrayList<>();

    public void setCard(Card card) {
        addCardToCardArray(card);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCardToCardArray(Card c) {
        cards.add(c);
    }


}