package com.myapp.creditcardcalculator.tests;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.models.*;
import com.myapp.creditcardcalculator.services.MonthlyInterestService;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    CalculateInterestService calculateInterestService = new MonthlyInterestService();
    private final Mastercard mastercard = new Mastercard(calculateInterestService);
    private final Visa visa = new Visa(calculateInterestService);
    private final Discover discover = new Discover(calculateInterestService);


    @Test
    void TEST_onePersonThreeCards() {

        Person person1 = new Person();
        Wallet wallet = new Wallet();

        person1.setWallet(wallet);

        wallet.setCard(mastercard);
        wallet.setCard(visa);
        wallet.setCard(discover);


        HashMap<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("Visa", 0.10);
        expectedMap.put("Discover", 0.01);
        expectedMap.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap = person1.calculateTotalInterestPerCard(person1.getWallets());

        assertEquals(expectedMap, actualMap, "did not calc interest per card");
        assertEquals("0.16", person1.calculateTotalInterestPerPersonForAllCards(person1.getWallets()), "did not calc all interest as a total");

    }

    @Test
    void TEST_onePersonTwoWallets() {

        Person person1 = new Person();
        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        person1.setWallet(wallet1);
        person1.setWallet(wallet2);

        wallet1.setCard(visa);
        wallet1.setCard(discover);
        wallet2.setCard(mastercard);

        HashMap<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("Visa", 0.10);
        expectedMap.put("Discover", 0.01);
        expectedMap.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap = person1.calculateTotalInterestPerCard(person1.getWallets());

        assertEquals(expectedMap, actualMap, "did not calc interest per card");
        assertEquals("0.16", person1.calculateTotalInterestPerPersonForAllCards(person1.getWallets()), "did not calc all interest as a total");

    }

    @Test
    void TEST_twoPeopleTwoWallets() {

        Person person1 = new Person();
        Person person2 = new Person();

        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        person1.setWallet(wallet1);
        person2.setWallet(wallet2);

        wallet1.setCard(mastercard);
        wallet1.setCard(visa);

        wallet2.setCard(visa);
        wallet2.setCard(mastercard);

        //PERSON 1
        HashMap<String, Double> expectedMap1 = new HashMap<>();
        expectedMap1.put("Visa", 0.10);
        expectedMap1.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap1 = person1.calculateTotalInterestPerCard(person1.getWallets());

        assertEquals(expectedMap1, actualMap1, "did not calc interest per card");
        assertEquals("0.15", person1.calculateTotalInterestPerPersonForAllCards(person1.getWallets()), "did not calc all interest as a total");

        // PERSON 2
        HashMap<String, Double> expectedMap2 = new HashMap<>();
        expectedMap2.put("Visa", 0.10);
        expectedMap2.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap2 = person2.calculateTotalInterestPerCard(person2.getWallets());

        assertEquals(expectedMap2, actualMap2, "did not calc interest per card");
        assertEquals("0.15", person2.calculateTotalInterestPerPersonForAllCards(person2.getWallets()), "did not calc all interest as a total");

    }

    @Test
    void TEST_twoPeopleTwoWalletsPersonOneHasThreeCards() {

        Person person1 = new Person();
        Person person2 = new Person();

        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        person1.setWallet(wallet1);
        person2.setWallet(wallet2);

        wallet1.setCard(mastercard);
        wallet1.setCard(visa);
        wallet1.setCard(discover);

        wallet2.setCard(visa);

        //PERSON 1
        HashMap<String, Double> expectedMap1 = new HashMap<>();
        expectedMap1.put("Visa", 0.10);
        expectedMap1.put("Mastercard", 0.05);
        expectedMap1.put("Discover", 0.01);

        HashMap<String, Double> actualMap1 = person1.calculateTotalInterestPerCard(person1.getWallets());

        assertEquals(expectedMap1, actualMap1, "did not calc interest per card");
        assertEquals("0.16", person1.calculateTotalInterestPerPersonForAllCards(person1.getWallets()), "did not calc all interest as a total");

        // PERSON 2
        HashMap<String, Double> expectedMap2 = new HashMap<>();
        expectedMap2.put("Visa", 0.10);

        HashMap<String, Double> actualMap2 = person2.calculateTotalInterestPerCard(person2.getWallets());

        assertEquals(expectedMap2, actualMap2, "did not calc interest per card");
        assertEquals("0.10", person2.calculateTotalInterestPerPersonForAllCards(person2.getWallets()), "did not calc all interest as a total");

    }


}