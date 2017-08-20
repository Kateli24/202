package gui;

import dao.ProductDao;
import domain.Product;
import gui.helpers.SimpleListModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 *
 * @author liji8162
 */
public class ViewProductDialogTest {
	private ProductDao productDao;
	private DialogFixture fixture;
	private Robot robot;
	private Product prodOne = new Product(1, "name1", "des1", "cat1", new BigDecimal("11.00"), new Integer("22"));
	private Product prodTwo = new Product(2, "name2", "des2", "cat2", new BigDecimal("33.00"), new Integer("44"));
	private Product prodThree = new Product(3, "name3", "des3", "cat3", new BigDecimal("55.00"), new Integer("66"));
	
	@Before
	public void setUp() {
		robot = BasicRobot.robotWithNewAwtHierarchy();
		robot.settings().delayBetweenEvents(100);
		
		
		
		Map<Integer, Product> products = new TreeMap<>();
		
		products.put(prodOne.getId(),prodOne);
		products.put(prodTwo.getId(),prodTwo);
		products.put(prodThree.getId(),prodThree);
		
		productDao = mock(ProductDao.class);
		
		when(productDao.getProducts()).thenReturn(products.values());
		 
	}
	
	@After
	public void tearDown() {
		fixture.cleanUp();
	}
	
	@Test
	public void testView(){
		ViewProductDialog testView = new ViewProductDialog(null,true,productDao);
		fixture = new DialogFixture(robot,testView);
		fixture.show().requireVisible();
		
		SimpleListModel model = (SimpleListModel) fixture.list("currentProductList").target().getModel();
		assertTrue("List contains the expected product",model.contains(prodOne));
		assertTrue("List contains the expected product",model.contains(prodTwo));
		assertTrue("List contains the expected product",model.contains(prodThree));
		assertEquals("List contains the correct number of products",3,model.getSize());
	}
	
}
