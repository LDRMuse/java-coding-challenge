package com.myapp.creditcardcalculator;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.models.*;
import com.myapp.creditcardcalculator.services.MonthlyInterestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:/card.properties")
public class MyAppConfig {

    //define beans here
    @Bean
    public CalculateInterestService monthlyInterestService() {
        return new MonthlyInterestService();
    }

    @Bean
    public Card mastercard() {
        return new Mastercard(monthlyInterestService());
    }
    @Bean
    public Card visa() {
        return new Visa(monthlyInterestService());
    }

    @Bean
    public Card discover() {
        return new Discover(monthlyInterestService());
    }

    @Bean
    @Scope("prototype")
    public Wallet wallet() {
        return new Wallet();
    }

    @Bean
    @Scope("prototype")
    public Person person() {
        return new Person(wallet());
    }



}
