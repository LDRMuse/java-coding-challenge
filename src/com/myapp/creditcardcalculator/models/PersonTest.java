package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.services.MonthlyInterestService;
import org.junit.jupiter.api.Test;

import org.springframework.test.util.ReflectionTestUtils;


import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private final ArrayList<Card> cards = new ArrayList<>();

    CalculateInterestService calculateInterestService = new MonthlyInterestService();
    ReflectionTestUtils testUtils;
    private final Mastercard mastercard = new Mastercard(calculateInterestService);
    private final Visa visa = new Visa(calculateInterestService);
    private final Discover discover = new Discover(calculateInterestService);


    @Test
    void TEST_CASE_ONE() {
        ReflectionTestUtils.setField(mastercard, "rate", "100");
        ReflectionTestUtils.setField(visa, "rate", "100");
        ReflectionTestUtils.setField(discover, "rate", "100");

        ReflectionTestUtils.setField(mastercard, "principal", "0.05");
        ReflectionTestUtils.setField(visa, "principal", "0.10");
        ReflectionTestUtils.setField(discover, "principal", "0.01");

        Person person1 = new Person();
        Wallet wallet = new Wallet();
        person1.setWallet(wallet);
        wallet.setMastercard(mastercard);
        wallet.setVisa(visa);
        wallet.setDiscover(discover);


        HashMap<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("Visa", 0.1);
        expectedMap.put("Discover", 0.01);
        expectedMap.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap = person1.calculateTotalInterestPerCard(person1.getWallets());

        assertEquals(expectedMap, actualMap);
        assertEquals("0.16", person1.calculateTotalInterestPerPersonForAllCards(person1.getWallets()));

    }

    @Test
    void TEST_CASE_TWO() {
        ReflectionTestUtils.setField(mastercard, "rate", "100");
        ReflectionTestUtils.setField(visa, "rate", "100");
        ReflectionTestUtils.setField(discover, "rate", "100");

        ReflectionTestUtils.setField(mastercard, "principal", "0.05");
        ReflectionTestUtils.setField(visa, "principal", "0.10");
        ReflectionTestUtils.setField(discover, "principal", "0.01");

        Person person1 = new Person();
        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        person1.setWallet(wallet1);
        person1.setWallet(wallet2);

        wallet1.setVisa(visa);
        wallet1.setDiscover(discover);
        wallet2.setMastercard(mastercard);

        HashMap<String, Double> expectedMap = new HashMap<>();
        expectedMap.put("Visa", 0.1);
        expectedMap.put("Discover", 0.01);
        expectedMap.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap = person1.calculateTotalInterestPerCard(person1.getWallets());

        assertEquals(expectedMap, actualMap);
        assertEquals("0.16", person1.calculateTotalInterestPerPersonForAllCards(person1.getWallets()));

    }

    @Test
    void TEST_CASE_THREE() {
        ReflectionTestUtils.setField(mastercard, "rate", "100");
        ReflectionTestUtils.setField(visa, "rate", "100");
        ReflectionTestUtils.setField(discover, "rate", "100");

        ReflectionTestUtils.setField(mastercard, "principal", "0.05");
        ReflectionTestUtils.setField(visa, "principal", "0.10");
        ReflectionTestUtils.setField(discover, "principal", "0.01");

        Person person1 = new Person();
        Person person2 = new Person();

        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        person1.setWallet(wallet1);
        person2.setWallet(wallet2);

        wallet1.setMastercard(mastercard);
        wallet1.setVisa(visa);

        wallet2.setVisa(visa);
        wallet2.setMastercard(mastercard);

        //PERSON 1
        HashMap<String, Double> expectedMap1 = new HashMap<>();
        expectedMap1.put("Visa", 0.1);
        expectedMap1.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap1 = person1.calculateTotalInterestPerCard(person1.getWallets());

        assertEquals(expectedMap1, actualMap1);
        assertEquals("0.15", person1.calculateTotalInterestPerPersonForAllCards(person1.getWallets()));

        // PERSON 2
        HashMap<String, Double> expectedMap2 = new HashMap<>();
        expectedMap2.put("Visa", 0.1);
        expectedMap2.put("Mastercard", 0.05);

        HashMap<String, Double> actualMap2 = person2.calculateTotalInterestPerCard(person2.getWallets());

        assertEquals(expectedMap2, actualMap2);
        assertEquals("0.15", person2.calculateTotalInterestPerPersonForAllCards(person2.getWallets()));

    }






}