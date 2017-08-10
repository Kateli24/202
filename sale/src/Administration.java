import dao.ProductDataManager;
import gui.*;
/**
 *
 * @author liji8162
 */

public class Administration{
	//private ProductDao productDao;
	
	public static void main (String [] args){
		//ProductList productList = new ProductList();
		ProductDataManager aProductDataManager = new ProductDataManager();
		ProductMainMenu productMainMenu = new ProductMainMenu(aProductDataManager);
		productMainMenu.setLocationRelativeTo(null);
		productMainMenu.setVisible(true);
		
	}
}
