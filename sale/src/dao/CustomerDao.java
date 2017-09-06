package dao;

import domain.Customer;

/**
 *
 * @author liji8162
 */
public interface CustomerDao {
	void save(Customer customer);
	
	Customer getCustomer(String userName);
	
	Boolean validateCredentials(String userName, String password);
	
}
