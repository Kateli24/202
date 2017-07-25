package dao;

import domain.Product;
import java.util.ArrayList;

/**
 *
 * @author liji8162
 */
public class ProductList {
	private static ArrayList<Product> products = new ArrayList<>();
	private static ArrayList<String> categories = new ArrayList<>();
	
	
	public void addProduct(Product product){
		products.add(product);
		String category = product.getCategory();
		categories.add(category);
		
	}
	
	public ArrayList<String> getCategories(){
		return categories;
		
	}
	
	public ArrayList<Product> getProducts(){
		return products;
		
	}
			
			
		
	}
	

