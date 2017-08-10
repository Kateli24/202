import dao.ProductList;
import gui.*;
/**
 *
 * @author liji8162
 */

public class Administration{
	//private ProductDao productDao;
	
	public static void main (String [] args){
		ProductList productList = new ProductList();
		ProductMainMenu productMainMenu = new ProductMainMenu(productList);
		productMainMenu.setLocationRelativeTo(null);
		productMainMenu.setVisible(true);
		
	}
}
