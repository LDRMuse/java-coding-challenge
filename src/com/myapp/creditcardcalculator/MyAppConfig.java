package com.myapp.creditcardcalculator;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.models.*;
import com.myapp.creditcardcalculator.services.MonthlyInterestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/card.properties")
public class MyAppConfig {

    //define beans here
    @Bean
    public CalculateInterestService monthlyInterestService() {
        return new MonthlyInterestService();
    }

    @Bean
    public Mastercard mastercard() {
        return new Mastercard(monthlyInterestService());
    }
    @Bean
    public Visa visa() {
        return new Visa(monthlyInterestService());
    }

    @Bean
    public Discover discover() {
        return new Discover(monthlyInterestService());
    }


}
