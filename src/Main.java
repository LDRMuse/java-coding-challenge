import com.myapp.creditcardcalculator.MyAppConfig;
import com.myapp.creditcardcalculator.interfaces.Card;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

        // get bean from spring containers
        Card mc = context.getBean("mastercard", Card.class);

        // call method on the bean
        System.out.println(mc);

        //close the context
        context.close();
    }

}