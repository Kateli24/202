
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author liji8162
 */
public class NewEmptyJUnitTest {
 static Integer result  = 10;
	
	public NewEmptyJUnitTest() {
	}
	
	
	@Test 
	public void testAddtion(){
		result +=10;
		assertEquals(new Integer(20), result);
	}
	
	@Before
	public void setUp() {
		result = 10;
	}
	
	
	@Test
	public void testSubtraction(){
		result -=10;
		assertEquals(new Integer(0), result);
	}
	
	@After
	public void tearDown() {
	}
	
	
}
