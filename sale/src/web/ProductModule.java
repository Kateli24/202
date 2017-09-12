package web;

import dao.ProductDao;
import org.jooby.Jooby;

/**
 *
 * @author liji8162
 */
public class ProductModule extends Jooby{
	
	public ProductModule(ProductDao productDao){
		get("/api/products", () -> productDao.getProducts());
		
		get("/api/products/:id", (req) -> {
			String id = req.param("id").value();
			return productDao.findProduct((new Integer(id)));
		});
		
		get ("/api/categories", () -> productDao.getCategories());
		
		get("/api/categories/:cat", (req)->{
			String cat = req.param("cat").value();
			return productDao.productsByCategory(cat);
		});
	}
	
	
}
