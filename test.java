/** The test class is used to run simulations to ensure the system is working as intended
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.5
 * */
public class test{
	public static void main(String[] args) throws Exception{
		try {
			Admin temp = new Admin(0011, "john", "admin", "admin");
			temp.createDatabase();
			temp.accessLogIn();
		} catch (Exception e){
			System.out.println("didn't work");
		}
	}
}
