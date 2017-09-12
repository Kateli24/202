package web;


import dao.CustomerCollectionsDAO;
import dao.CustomerDao;
import dao.ProductDao;
import dao.ProductDataManager;
import org.jooby.Jooby;
import org.jooby.json.Gzon;


/**
 *
 * @author liji8162
 */
public class Server extends Jooby {
	public static void main(String[] args) {
		new Server().start();
		
		
	}
	
	public Server(){
		port(6900);
		ProductDao productDao = new ProductDataManager();
		use(new ProductModule(productDao));
		use(new Gzon().doWith(gson ->{
			gson.setPrettyPrinting();
		}));
		
		CustomerDao customerDao = new CustomerCollectionsDAO();
		use(new CustomerModule(customerDao));
		assets("/**");
		assets("/","index.html");
	}
	
	
	
}