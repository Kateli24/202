package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author liji8162
 */
public class ProductList {
	/**Product should be implemented in an ArrayList because it allows duplicates*/
	private static Collection<Product> products = new ArrayList<>();
	/**categories should be implemented in a TreeSet collection because 
	 * categories are unique and we expect them to be sorted*/
	private static Collection<String> categories = new TreeSet<>();
	
	
	public void addProduct(Product product){
		products.add(product);
		String category = product.getCategory();
		categories.add(category);
		
	}
	
	public Collection<String> getCategories(){
		return categories;
		
	}
	
	public Collection<Product> getProducts(){
		return products;
		
	}
			
			
		
	}
	

