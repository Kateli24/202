package web;


import dao.ProductDao;
import dao.ProductDataManager;
import org.jooby.Jooby;


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
		ProductDao newProductDao = new ProductDataManager();
		get("/api/products/:id", (req) -> {
			String id = req.param("id").value();
			return newProductDao.findProduct((new Integer(id)));
		});
		
	}
	
	
	
}
