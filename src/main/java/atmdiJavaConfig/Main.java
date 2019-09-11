package atmdiJavaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);

        atmSimulator.run();

//        DataSource dataSource = new DataSource("customers.txt");
//        Bank bank = new Bank(dataSource);
//        ATM atm = new ATM(bank);
//        ATMSimulator atmSimulator = new ATMSimulator(atm);

    }
}
