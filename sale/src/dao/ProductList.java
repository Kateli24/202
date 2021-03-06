package dao;

import domain.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author liji8162
 */
public class ProductList implements ProductDao {

	/**
	 * Product should be implemented in a TreeMap because we are able to use
	 * unique identifier to avoid duplicates. A type of product has an unique ID
	 * instead of a product has an ID. when users typed a product that the system
	 * has already had, then the product will not be saved Also we want a sorted
	 * collection, so TreeMap is better
	 */
	private static Map<Integer, Product> products = new TreeMap<>();
	/**
	 * categories should be implemented in a TreeSet collection because
	 * categories are unique and we expect them to be sorted
	 */
//	private static TreeSet<String> categories = new TreeSet<>();
//	private static Map<Integer, Product> searchProduct = new HashMap<>();
	private static Map<String, TreeSet<Product>> filterCategory = new HashMap<>();

	@Override
	public void addProduct(Product product) {
		/**
		 * may implement codes to handle what's gonna happen when users try to
		 * save a product twice. getQuantity() and then set again
		 */

		products.put(product.getId(), product);
		String category = product.getCategory();
//		categories.add(category);
//		searchProduct.put(product.getId(), product);

		/**
		 * if the product's category is exist, then add the product to the
		 * existing TreeSet, it is it not, create a new TreeSet corresponding to
		 * new Category
		 */
		boolean doesExist = filterCategory.containsKey(category);
		if (doesExist) {
			TreeSet<Product> currentProductsByCategory = filterCategory.get(category);
			currentProductsByCategory.add(product);
		} else {
			TreeSet<Product> newProductsByNewCategory = new TreeSet<>();
			newProductsByNewCategory.add(product);
			filterCategory.put(category, newProductsByNewCategory);
		}

	}

	/**
	 * delete product by its id
	 */
	@Override
	public void deleteProduct(Product product) {
		if (products.containsKey(product.getId())) {
			products.remove(product.getId());
			/**
			 * the product we wanna delete should be removed from searchProduct as
			 * well. otherwise deleted product still can be searched.
			 */
//		searchProduct.remove(product.getId());
			/**
			 * remove the product in filterCategory collection
			 */
			TreeSet<Product> currentProductsByCategory = filterCategory.get(product.getCategory());
			currentProductsByCategory.remove(product);
		}
	}

	@Override
	public Product findProduct(Integer id) {
		boolean doesExist = products.containsKey(id);
		if (doesExist) {
			return products.get(id);
		} else {
			return null;
		}
	}

	@Override
	public Collection<String> getCategories() {
		return filterCategory.keySet();
	}

	@Override
	public Collection<Product> getProducts() {
		return products.values();

	}

	@Override
	public Collection<Product> productsByCategory(String category) {
		return filterCategory.get(category);
	}

}
