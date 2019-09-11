package atmDataBase.database;



import atmDataBase.atmdiJavaConfig.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader implements Reader {
    private String fileName;

    public FileReader(String fileName){
        this.fileName = fileName.concat(".txt");
    }

    public Map<Integer, Customer> read() throws Exception {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

        Scanner ip = new Scanner(new java.io.FileReader(fileName));

        while (ip.hasNext()){
            int number = ip.nextInt();
            int pin = ip.nextInt();
            double balance = ip.nextDouble();
            Customer customer = new Customer(number, pin, balance);
            customers.put(customer.getCustomerNumber(), customer);
        }
        ip.close();

        return customers;
    }
}
