package atmDataBase.atmdiJavaConfig;

import atmDataBase.database.Reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataSource {

    private Reader reader;

    public DataSource(Reader reader) {
        this.reader = reader;
    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, Customer> readCustomers() throws Exception {
       return this.reader.read();
    }
}
