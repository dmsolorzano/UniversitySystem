package system;

/** The test class is used to run simulations to ensure the system is working as intended
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.5
 * */
public class test{
	public static void main(String[] args) throws Exception {
		try {
			Admin temp = Admin.getInstance();
			User u = new User(0, null, "adminU", "adminP");
			Student s = new Student(0, null, "adminU", "adminP");
			Course c = new Course(null, null, 0);
			// TODO
			System.out.println("test");;
			
		} catch (Exception e){
			System.out.println(e);  // Will catch and print any exception you had
		}
	}
}
