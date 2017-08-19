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

	ProductDao productDao = new ProductDataManager("jdbc:h2:tcp://localhost:8067/project-testing;IFEXISTS=TRUE");

	private Product prodOne;
	private Product prodTwo;
	private Product prodThree;
	private Product prodFour;

	@Before
	public void setUp() {
		this.prodOne = new Product(1, "name1", "des1", "cat1", new BigDecimal("11.00"), new Integer("22"));
		this.prodTwo = new Product(2, "name2", "des2", "cat2", new BigDecimal("33.00"), new Integer("44"));
		this.prodThree = new Product(3, "name3", "des3", "cat3", new BigDecimal("55.00"), new Integer("66"));
		/**
		 * for testing products in the same category only
		 */
		this.prodFour = new Product(4, "name4", "des4", "cat1", new BigDecimal("44.00"), new Integer("9"));

		productDao.addProduct(prodOne);
		productDao.addProduct(prodTwo);

	}

	@Test
	public void testDaoSave() {
		productDao.addProduct(prodThree);
		Product retrieved = productDao.findProduct(3);
		assertEquals("Retrieved product should be the same", prodThree, retrieved);

	}

	@Test
	public void testEdit() {
		prodOne.setName("editedName");
		productDao.addProduct(prodOne);
		Product retrieved = productDao.findProduct(1);
		assertEquals("the names should the changed", "editedName", retrieved.getName());
		assertEquals("the id should be the same", new Integer(1), retrieved.getId());
		assertEquals("the description should be the same", "des1", retrieved.getDescription());
		assertEquals("the category should be the same", "cat1", retrieved.getCategory());
		assertEquals("the price should be the same", new BigDecimal("11.00"), retrieved.getPrice());
		assertEquals("the quantity should be the same", new Integer(22), retrieved.getQuantity());
	}

	@Test
	public void testDaoDelete() {
		productDao.deleteProduct(prodOne);
		Product retrieved = productDao.findProduct(1);
		assertNull("Product should no longer exist", retrieved);
	}

	@Test
	public void testGetCategories() {
		Collection<String> testCategories = productDao.getCategories();
		assertTrue("the category of prodOne should exist", testCategories.contains("cat1"));
		assertTrue("the category of prodTwo should exist", testCategories.contains("cat2"));
		assertEquals("Only 2 categories in result", 2, testCategories.size());

	}

	@Test
	public void testDaoGetAll() {
		Collection<Product> products = productDao.getProducts();

		assertTrue("prodOne should exist", products.contains(prodOne));
		assertTrue("prodTwo should exist", products.contains(prodTwo));
		assertEquals("Only 2 products in result", 2, products.size());
		for (Product p : products) {
			if (p.equals(prodOne)) {
				assertEquals(prodOne.getId(), p.getId());
				assertEquals(prodOne.getName(), p.getName());
				assertEquals(prodOne.getDescription(), p.getDescription());
				assertEquals(prodOne.getCategory(), p.getCategory());
				assertEquals(prodOne.getPrice(), p.getPrice());
				assertEquals(prodOne.getQuantity(), p.getQuantity());
			}
		}
	}

	@Test
	public void testDaoFindProduct() {
		Product productOne = productDao.findProduct(1);
		assertEquals("products should be the same", prodOne, productOne);
		assertEquals(prodOne.getId(), productOne.getId());
		assertEquals(prodOne.getName(), productOne.getName());
		assertEquals(prodOne.getDescription(), productOne.getDescription());
		assertEquals(prodOne.getCategory(), productOne.getCategory());
		assertEquals(prodOne.getPrice(), productOne.getPrice());
		assertEquals(prodOne.getQuantity(), productOne.getQuantity());

		Product notExist = productDao.findProduct(0);
		assertNull("product shouls not exist", notExist);

	}

	@Test
	public void testGetProductsByCategory() {

		productDao.addProduct(prodFour);
		Collection<Product> testProducts = productDao.productsByCategory("cat1");
		assertTrue("prodOne should exist", testProducts.contains(prodOne));
		assertTrue("prodFour shoud exist", testProducts.contains(prodFour));
		assertEquals("Only 2 products in result", 2, testProducts.size());
		for (Product p : testProducts) {
			if (p.equals(prodOne)) {
				assertEquals(prodOne.getId(), p.getId());
				assertEquals(prodOne.getName(), p.getName());
				assertEquals(prodOne.getDescription(), p.getDescription());
				assertEquals(prodOne.getCategory(), p.getCategory());
				assertEquals(prodOne.getPrice(), p.getPrice());
				assertEquals(prodOne.getQuantity(), p.getQuantity());
			}
		}

	}

	@After
	public void tearDown() {
		productDao.deleteProduct(prodOne);
		productDao.deleteProduct(prodTwo);
		productDao.deleteProduct(prodThree);
		productDao.deleteProduct(prodFour);

	}

}
