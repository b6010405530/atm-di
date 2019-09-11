package atmDataBase.atmdiJavaConfig;

import atmDataBase.database.DatabaseReader;
import atmDataBase.database.FileReader;
import atmDataBase.database.Reader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public Reader reader(){
        return new DatabaseReader("customers");
    }

    @Bean
    public DataSource dataSource(){
        return new DataSource(reader());
    }

    @Bean
    public Bank bank(){
        return new Bank(dataSource());
    }

    @Bean
    public ATM atm(){
        return new ATM(bank());
    }

    @Bean
    public ATMSimulator atmSimulator(){
        return new ATMSimulator(atm());
    }

}
