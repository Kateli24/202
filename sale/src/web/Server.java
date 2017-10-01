package web;

import dao.CustomerDao;
import dao.CustomerDataManager;
import dao.ProductDao;
import dao.ProductDataManager;
import dao.SaleDAO;
import dao.SaleJdbcDAO;
import java.util.Arrays;
import java.util.List;
import org.jooby.Jooby;
import org.jooby.json.Gzon;
import web.auth.BasicHttpAuthenticator;

/**
 *
 * @author liji8162
 */
public class Server extends Jooby {

	public static void main(String[] args) {
		new Server().start();

	}

	public Server() {
		port(6900);
		ProductDao productDao = new ProductDataManager();
		CustomerDao customerDao = new CustomerDataManager();
		SaleDAO saleDAO = new SaleJdbcDAO();
		
		List<String> noAuth = Arrays.asList("/api/register");
		use(new BasicHttpAuthenticator(customerDao, noAuth));

		
		use(new ProductModule(productDao));
		use(new Gzon().doWith(gson -> {
			gson.setPrettyPrinting();
		}));

		use(new CustomerModule(customerDao));
		assets("/**");
		assets("/", "index.html");
		
		use(new SaleModule(saleDAO));
	}

}
