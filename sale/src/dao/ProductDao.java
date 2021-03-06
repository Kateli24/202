package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author liji8162
 */
public interface ProductDao {

	void addProduct(Product product);

	/**
	 * delete product by its id
	 */
	void deleteProduct(Product product);

	Product findProduct(Integer id);

	Collection<String> getCategories();

	Collection<Product> getProducts();

	Collection<Product> productsByCategory(String category);

}
