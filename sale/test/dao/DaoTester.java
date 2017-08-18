package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;


/**
 *
 * @author liji8162
 */
public class DaoTester {
	ProductDao productDao = new ProductDataManager("jdbc:h2:tcp://localhost:8067/project-testing");
	
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
	
	@Test
	public void testDaoDelete(){
		productDao.deleteProduct(prodOne);
		Product retrieved = productDao.findProduct(1);
		assertNull("Product should no longer exist",retrieved);
	
	}
	
	@Test
	public void testDaoGetAll(){
		Collection<Product> products= productDao.getProducts();
		
		assertTrue("prodOne should exist", products.contains(prodOne));
		assertTrue("prodTwo should exist", products.contains(prodTwo));
		assertEquals("Only 2 products in result", 2, products.size());
		for(Product p:products){
			if(p.equals(prodOne)){
				assertEquals(prodOne.getId(),p.getId());
				assertEquals(prodOne.getName(),p.getName());
				assertEquals(prodOne.getDescription(),p.getDescription());
				assertEquals(prodOne.getCategory(),p.getCategory());
				assertEquals(prodOne.getPrice(),p.getPrice());
				assertEquals(prodOne.getQuantity(),p.getQuantity());
			}
		}
	}
	
	@Test
	public void testDaoFindProduct(){
		Product productOne = productDao.findProduct(1);
		assertEquals("products should be the same",prodOne, productOne);
		assertEquals(prodOne.getId(),productOne.getId());
		assertEquals(prodOne.getName(),productOne.getName());
		assertEquals(prodOne.getDescription(),productOne.getDescription());
		assertEquals(prodOne.getCategory(),productOne.getCategory());
		assertEquals(prodOne.getPrice(),productOne.getPrice());
		assertEquals(prodOne.getQuantity(),productOne.getQuantity());
		
		Product notExist = productDao.findProduct(0);
		assertNull("product shouls not exist",notExist);
		
		
	}
	
	
	@After
	public void tearDown() {
		productDao.deleteProduct(prodOne);
		productDao.deleteProduct(prodTwo);
		productDao.deleteProduct(prodThree);
	}
	
	
}
