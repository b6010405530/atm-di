package atmDataBase.database;


import atmDataBase.atmdiJavaConfig.Customer;

import java.util.Map;

public interface Reader {
    public Map<Integer, Customer> read() throws Exception;
}


