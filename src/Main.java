import com.myapp.creditcardcalculator.MyAppConfig;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.models.Person;
import com.myapp.creditcardcalculator.models.Wallet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        // get bean from spring containers
        Card mc = context.getBean("mastercard", Card.class);
        Card visa = context.getBean("visa", Card.class);
        Card discover = context.getBean("discover", Card.class);

        // Create Person and two wallets and set wallet to person
        Person person = new Person();
        Wallet wallet = new Wallet();
        Wallet wallet2 = new Wallet();

        person.setWallet(wallet);
        person.setWallet(wallet2);

        // Set cards in wallets
        wallet.setCard(mc);
        wallet.setCard(discover);
        wallet.setCard(visa);
        wallet.setCard(visa);

        wallet2.setCard(discover);
        wallet2.setCard(mc);

        person.calculateTotalInterestPerPerson(wallet.getCards());
        person.calculateTotalInterestPerCard(wallet.getCards());

        System.out.println("-------------------------------------");

        person.calculateTotalInterestPerPerson(wallet2.getCards());
        person.calculateTotalInterestPerCard(wallet2.getCards());

        //close the context
        context.close();
    }

}