
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author liji8162
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
dao.DaoTester.class,
gui.ProductDialogTest.class,
gui.ViewProductDialogTest.class})
public class AllTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
}
