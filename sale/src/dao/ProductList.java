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
public class ProductList{
	/**Product should be implemented in a TreeMap because we are able to use
	 * unique identifier to avoid duplicates. 
	 * A type of product has an unique ID instead of a product has an ID. 
	 * when users typed a product that the system has already had,
	 * then the product will not be saved
	 * Also we want a sorted collection, so TreeMap is better */
	private static Map<Integer, Product > products = new TreeMap<>();
	/**categories should be implemented in a TreeSet collection because 
	 * categories are unique and we expect them to be sorted*/
	private static Collection<String> categories = new TreeSet<>();
	private static Map<Integer, Product> searchProduct = new HashMap<>();
	
	
	
	public void addProduct(Product product){
		/**may implement codes to handle what's gonna happen 
		 * when users try to save a product twice. 
		 * getQuantity() and then set again*/
		products.put(product.getId(),product);
		String category = product.getCategory();
		categories.add(category);
		searchProduct.put(product.getId(),product);
		
	}
	/**delete product by its id*/ 
	public void deleteProduct(Product product){
		products.remove(product.getId());
	}
	
	public Product findProduct(Integer id) {
		boolean doesExist = searchProduct.containsKey(id);
		if (doesExist) {
			return searchProduct.get(id);
		} else {
			return null;
		}
	}

	public Collection<String> getCategories(){
		return categories;
		
	}
	
	public Collection<Product> getProducts(){
		return products.values();
		
	}

	
			
		
	}
	

