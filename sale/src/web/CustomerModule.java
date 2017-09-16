package web;

import dao.CustomerDao;
import domain.Customer;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author liji8162
 */
public class CustomerModule extends Jooby {
	public CustomerModule(CustomerDao customerDao){
		get("/api/customers/:userName", (req) -> {
			String userName = req.param("userName").value();
			/**set password to null so that it will not be sent to the client side*/
			if(userName!=null){
			customerDao.getCustomer(userName).setPassword(null);
			return customerDao.getCustomer(userName);
			}
			else{
				throw new Err(Status.NOT_FOUND);
			}
			
		});
		
		post("/api/register", (req,rsp) ->{
			Customer customer = req.body(Customer.class);
			customerDao.save(customer);
			rsp.status(Status.CREATED);
		});
	}
}
