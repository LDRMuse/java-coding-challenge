import com.myapp.creditcardcalculator.MyAppConfig;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.models.Person;
import com.myapp.creditcardcalculator.models.Wallet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        // get bean from spring containers
        Card mc = context.getBean("mastercard", Card.class);
        Card visa = context.getBean("visa", Card.class);
        Card discover = context.getBean("discover", Card.class);
        Person person = context.getBean("person", Person.class);
        Wallet wallet = context.getBean("wallet", Wallet.class);

        //TODO: figure out how to have a person have multiple wallets
        Person person2 = context.getBean("person", Person.class);


        // call method on the bean

        System.out.println(person.getTotalInterestFromOneCard(wallet, mc));
        System.out.println(person.getTotalInterestFromTwoCards(wallet, mc, discover));
        System.out.println(person.getTotalInterestFromThreeCards(wallet, mc, discover, visa));


        //close the context
        context.close();
    }

}