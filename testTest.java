import static org.junit.Assert.*;
import org.junit.Test;

public class testTest {

	@Test
	public void ImportCourses_Test() throws Exception {
		/** Returns true if imported courses was successful **/
		assertTrue(test.importCourses());
		
		/** Returns false if imported courses was successful **/
		assertFalse(test.importCourses());
	}
}
