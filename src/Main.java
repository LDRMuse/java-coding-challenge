import com.myapp.creditcardcalculator.MyAppConfig;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Just left this in to show how I was testing before writing the J-Unit tests;

        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        // get bean from spring container
        CalculateInterestService monthlyInterestService = context.getBean("monthlyInterestService", CalculateInterestService.class);

        Card visa = new Visa(monthlyInterestService);
        Card discover = new Discover(monthlyInterestService);
        Card mastercard = new Mastercard(monthlyInterestService);

        Person person = new Person();
        Wallet wallet = new Wallet();
        Wallet wallet2 = new Wallet();

        person.setWallet(wallet);
        person.setWallet(wallet2);

        wallet.setCard(mastercard);
        wallet2.setCard(visa);
        wallet2.setCard(discover);


        System.out.println(person.calculateTotalInterestPerPersonForAllCards(person.getWallets()));
        System.out.println(person.calculateTotalInterestPerCard(person.getWallets()));

        //close the context
        context.close();
    }

}