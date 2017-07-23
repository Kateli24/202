package dao;

import domain.Product;
import java.util.ArrayList;

/**
 *
 * @author liji8162
 */
public class ProductList {
	private static ArrayList<Product> products = new ArrayList<>();
	
	
	public void addProduct(Product product){
		products.add(product);
	}
	
	public ArrayList<Product> getProducts(){
		return products;
		
	}
			
			
		
	}
	

