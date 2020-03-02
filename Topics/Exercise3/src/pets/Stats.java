package pets;

import java.util.List;

import db.CustomerDAO;

public class Stats {

    public static void main(String[] args) throws Exception {
        
        List<Customer> customers = CustomerDAO.getAllCustomers();
        for(Customer c : customers) {
            System.out.println(c);
        }
        
        Customer c = CustomerDAO.getCustomer(4);
        System.out.println(c);
        
        c = CustomerDAO.createCustomer("TOPHER", 99, 55);
        System.out.println(c);
    }

}
