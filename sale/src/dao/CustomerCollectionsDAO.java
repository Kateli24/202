package dao;

import domain.Customer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark George
 */
public final class CustomerCollectionsDAO implements CustomerDao {

	private static final Map<String, Customer> customers = new HashMap<String, Customer>();

	public CustomerCollectionsDAO() {
		// some dummy data for testing
		Customer boris = new Customer();
		boris.setUsername("boris");
		boris.setName("Boris McNorris");
		boris.setPassword("guest");
		boris.setShippingAddress("123 Some Street, Somewhere");
		boris.setEmail("boris@fakemail.net");
		boris.setCreditCardDetail("Visa 1234-2345-3456-4567, Exp 11/2017");
		
		Customer doris = new Customer();
		doris.setUsername("doris");
		doris.setName("Doris Dolores");
		doris.setPassword("guest");
		doris.setShippingAddress("321 Anywere Ave, Anywhere");
		doris.setEmail("doris@fakemail.net");
		doris.setCreditCardDetail("Visa 7654-6543-5432-4321, Exp 05/2019");
		
		save(boris);
		save(doris);
	}

	@Override
	public void save(Customer customer) {
		System.out.println("Saving customer: " + customer);
		customers.put(customer.getUsername(), customer);
	}

	@Override
	public Customer getCustomer(String username) {
		return customers.get(username);
	}

	@Override
	public Boolean validateCredentials(String userName, String password) {
		if (customers.containsKey(userName)) {
			return customers.get(userName).getPassword().equals(password);
		} else {
			return false;
		}
	}

}
