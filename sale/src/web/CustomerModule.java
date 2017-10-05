package web;

import dao.CustomerDao;
import dao.DAOException;
import domain.Customer;
import gui.helpers.ValidationHelper;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author liji8162
 */
public class CustomerModule extends Jooby {

	public CustomerModule(CustomerDao customerDao) {
ValidationHelper validationHelper = new ValidationHelper();

		get("/api/customers/:userName", (req) -> {
			String userName = req.param("userName").value();
			if (userName != null && customerDao.getCustomer(userName) == null) {
				throw new Err(Status.NOT_FOUND);
			}
			return customerDao.getCustomer(userName);

		});

		post("/api/register", (req, rsp) -> {
			try {
				Customer customer = req.body(Customer.class);
				boolean flag = validationHelper.isObjectValid(customer);
				if (flag) {
					customerDao.save(customer);
					rsp.status(Status.CREATED);
				}
			} catch (DAOException ex) {
				throw new DAOException(ex.getMessage(), ex);
			}
		});
	}
}
