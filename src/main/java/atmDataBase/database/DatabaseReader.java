package atmDataBase.database;



import atmDataBase.atmdiJavaConfig.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseReader implements Reader {
    private String tableName;

    public DatabaseReader(String tableName){
        this.tableName = tableName;
    }

    public Map<Integer, Customer> read() throws Exception {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

        Class.forName("org.sqlite.JDBC");
        String dbURL = "jdbc:sqlite:dataBase.db";
        Connection connection = DriverManager.getConnection(dbURL);

        String query = "Select * from ".concat(this.tableName);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            int pin = resultSet.getInt(2);
            double balance = resultSet.getDouble(3);

            Customer customer = new Customer(id, pin, balance);
            customers.put(customer.getCustomerNumber(), customer);
        }

        connection.close();
        return customers;
    }
}
