import com.myapp.creditcardcalculator.MyAppConfig;

import com.myapp.creditcardcalculator.models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Just left this in to show how I was testing before writing the J-Unit tests;

        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        // get bean from spring container
        Mastercard mastercard = context.getBean("mastercard", Mastercard.class);
        Visa visa = context.getBean("visa", Visa.class);
        Discover discover = context.getBean("discover", Discover.class);

        Person person = new Person();
        Wallet wallet = new Wallet();
        Wallet wallet2 = new Wallet();


        person.setWallet(wallet);
        person.setWallet(wallet2);

        wallet.setMastercard(mastercard);
        wallet2.setVisa(visa);
        wallet2.setDiscover(discover);


        System.out.println(person.calculateTotalInterestPerPersonForAllCards(person.getWallets()));
        System.out.println(person.calculateTotalInterestPerCard(person.getWallets()));

        //close the context
        context.close();
    }

}