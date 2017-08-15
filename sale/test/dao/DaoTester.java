package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Product;
import java.math.BigDecimal;


/**
 *
 * @author liji8162
 */
public class DaoTester {
	ProductDao productDao;
	
	private Product prodOne;
	private Product prodTwo;
	private Product prodThree;
	
	
	
	@Before
	public void setUp() {
		this.prodOne = new Product(1,"name1","des1","cat1",new BigDecimal("11.00"),new Integer("22"));
		this.prodTwo = new Product(2,"name2","des2","cat2",new BigDecimal("33.00"),new Integer("44"));
		this.prodThree = new Product(3,"name3","des3","cat3",new BigDecimal("55.00"),new Integer("66"));
		
		productDao.addProduct(prodOne);
		productDao.addProduct(prodTwo);
		
	}
	
	@Test
	public void testDaoSave(){
		productDao.addProduct(prodThree);
		Product retrieved = productDao.findProduct(3);
		assertEquals("Retrieved product should be the same", prodThree, retrieved);
	}
	
	
	@After
	public void tearDown() {
		productDao.deleteProduct(prodOne);
		productDao.deleteProduct(prodTwo);
		productDao.deleteProduct(prodThree);
	}
	
	
}
