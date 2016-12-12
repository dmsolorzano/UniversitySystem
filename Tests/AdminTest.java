package Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import system.*;

public class AdminTest {

	/** Object to Test the JUnit test **/
	Student s = new Student(0, null, null, null);
	//Admin a = new Admin(0, null, null, null);
	Admin a = Admin.getInstance();
	Course c = new Course("CS 3331", "arbitarydate", 101);
	
	@Test
	public void CreateCourse_Test() throws Exception {
		/* Returns true or false if the object being created
		 * was of course type.
		 */
		Course temp = new Course(null, null, 0);
		assertEquals(temp, a.createCourse(s));
	}

	@Test
	public void RemoveCourse_Test() throws Exception {
		/* Should return true if it was able to enter
		 * the database and delete the course from it.
		 */
		assertTrue(a.removeCourse(c, s));
		
		/* Will do the opposite of the assertTrue method
		 * to check and see if it fails the first but
		 * but passes the assert method.
		 */
		assertFalse(a.removeCourse(c, s));
	}
	
	@Test
	public void CheckGraduation_Test(){
		/** Should return true if all courses are completed **/
		assertTrue(s.coursesCompleted.containsKey(true));
		
		/** Should return false instead if no course are completed **/
		assertFalse(s.coursesCompleted.containsKey(false));
	}
	
	@Test
	public void CreateAccount_Test(){
		/* We did not do a JUnit test on the createAccount
		 * method.  Because we might be deleting the method
		 * all together.
		 */
	}
}
