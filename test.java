/** The test class is used to run simulations to ensure the system is working as intended
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.5
 * */
public class test{
	public static void main(String[] args) throws Exception {
		try {
			Admin a = Admin.getInstance();
			User u = new User(000002, "Test User", "dsolor", "secret");
			Student s = new Student(000003, "Test Student", "jsmith", "password2");
			
			//TODO To test your code stubs
			
		} catch (Exception e){
			System.out.println(e);  // Will catch and print any exception you had
		}
	}
}
