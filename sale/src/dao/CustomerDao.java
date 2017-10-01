package dao;

import domain.Customer;
import web.auth.CredentialsValidator;

/**
 *
 * @author liji8162
 */
public interface CustomerDao extends CredentialsValidator{
	void save(Customer customer);
	
	Customer getCustomer(String userName);
	
	
	
}
