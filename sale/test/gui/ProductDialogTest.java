package gui;

import dao.ProductDao;
import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.TreeSet;
import static junit.framework.Assert.assertEquals;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author liji8162
 */
public class ProductDialogTest {
	
	private ProductDao productDao;
	private DialogFixture fixture;
	private Robot robot;
	
	
	@Before
	public void setUp() {
		robot = BasicRobot.robotWithNewAwtHierarchy();
		
		robot.settings().delayBetweenEvents(50);
		
		TreeSet<String> categories = new TreeSet<>();
		categories.add("Junk");
		categories.add("Organic");
		
		productDao = mock(ProductDao.class);
		when(productDao.getCategories()).thenReturn(categories);
		
	}
	
	@After
	public void tearDown() {
		fixture.cleanUp();
		
	}
	
	@Test
	public void testEdit(){
		Product aProduct = new Product(4,"name4","des4","Junk",new BigDecimal("66.00"),new Integer("33"));
		ProductDialog testDialog = new ProductDialog(null,true,aProduct,productDao);
		fixture = new DialogFixture(robot,testDialog);
		fixture.show().requireVisible();
		
		fixture.textBox("txtID").requireText("4");
		fixture.textBox("txtName").requireText("name4");
		fixture.textBox("txtDescription").requireText("des4");
		fixture.comboBox("comboCategory").requireSelection("Junk");
		fixture.textBox("txtPrice").requireText("66.00");
		fixture.textBox("txtQuantity").requireText("33");
		
		fixture.textBox("txtName").selectAll().deleteText().enterText("name5");
		fixture.comboBox("comboCategory").selectItem("Organic");
		
		fixture.button("saveButton").click();
		
		ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
		verify(productDao).addProduct(argument.capture());
		
		Product editedProduct = argument.getValue();
		
		assertEquals("Enture the name was changed","name5",editedProduct.getName());
		assertEquals("Enture the category was changed", "Organic", editedProduct.getCategory());	
		
	}
	@Test
	public void testSave(){
		ProductDialog testProductDialog= new ProductDialog(null,true,productDao);
		
		fixture = new DialogFixture(robot,testProductDialog);
		fixture.show().requireVisible();
		
		fixture.textBox("txtID").enterText("4");
		fixture.textBox("txtName").enterText("name4");
		fixture.textBox("txtDescription").enterText("des4");
		fixture.comboBox("comboCategory").selectItem("Junk");
		fixture.textBox("txtPrice").enterText("88.00");
		fixture.textBox("txtQuantity").enterText("44");
		
		
		fixture.button("saveButton").click();
		
		ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
		verify(productDao).addProduct(argument.capture());
		Product savedProduct = argument.getValue();
		
		assertEquals("Ensure the ID was saved", new Integer(4), savedProduct.getId());
		assertEquals("Enture the name was saved", "name4", savedProduct.getName());
		assertEquals("Enture the description was saved", "des4", savedProduct.getDescription());
		assertEquals("Enture the category was saved","Junk",savedProduct.getCategory());
		/**when converting string to BigDecimal, brackets are needed*/
		assertEquals("Enture the price was saved",new BigDecimal("88.00"),savedProduct.getPrice());
		assertEquals("Enture the quantity was saved", new Integer(44), savedProduct.getQuantity());
		
	}
	

}
