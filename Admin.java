import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/** The administrator class which represents users with administrative access
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.3
 * */
public class Admin extends User{

	public Admin(int id, String name, String user, String pass) {
		super(id, name, user, pass);
		// TODO Auto-generated constructor stub
	}
	/**Create Course method - creates a new txt file in the courses folder which will represent a new course
	 * @param name Name of the course to be printed onto the txt file
	 * @param crn2 Course Reference Number(CRN) to be printed into the txt file
	 * */
	public void createCourse(String name, int crn2) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("../UniversityRegistration/courses.txt",true));
		writer.newLine();
		writer.write(name +" "+ crn2);
		writer.close();
		System.out.println("Course "+name+" succesfully created.");
	}
	/**Remove Course method - will search for a line in the Courses.txt file and then remove the line
	 * @param courseToDrop method will search for this string and the crnToDrop parameter together to remove
	 * @param crnToDrop method will search for this string and the courseToDrop parameter together to remove
	 * */
	public void removeCourse(String courseToDrop, int crnToDrop) throws IOException{
		Scanner scan = new Scanner(System.in);

		File inputFile = new File("Courses.txt");
		File tempFile = new File("myTempFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = courseToDrop + " " + crnToDrop;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
			// trim newline when comparing with lineToRemove
			String trimmedLine = currentLine.trim();
			if(trimmedLine.equals(lineToRemove)) {
				System.out.println("Course Succesfully Removed");
				continue;
			}
			writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		tempFile.renameTo(inputFile);
	}
	/**Create account method - creates a new txt file based on student or faculty access 
	 * and places into the /Students folder.
	 * @return Returns a reference to an Object file of either:Student, Faculty or Null type
	 * */
	public Object createAccount() throws IOException{	
		Scanner scan = new Scanner(System.in);
		System.out.println("Are you a student or faculty");
		String accountType = scan.next();
		if(accountType.toLowerCase().equals("student")){
			System.out.println("Enter ID");
			int id = scan.nextInt();
			System.out.println("Enter Name");
			String name = scan.next();
			System.out.println("Enter Username");
			String user = scan.next();
			System.out.println("Enter Password");
			String pass = scan.next();

			Student s = new Student(id, name, user, pass);
			File inputFile = new File("../UniversityRegistration/Accounts/Students/"+s.getName()+".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
			writer.write(id + "\n" + name + "\n" + user + "\n" + pass);
			writer.close();
			System.out.println("Account successfully created.");
			return s;
		}

		if(accountType.toLowerCase().equals("faculty")){
			System.out.println("Enter ID");
			int id = scan.nextInt();
			System.out.println("Enter Name");
			String name = scan.next();
			System.out.println("Enter Username");
			String user = scan.next();
			System.out.println("Enter Password");
			String pass = scan.next();

			Faculty f = new Faculty(id, name, user, pass);
			File inputFile = new File("../UniversityRegistration/Accounts/Faculty/"+f.getName()+".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
			writer.write(id + "\n" + name + "\n" + user + "\n" + pass);
			writer.close();
			System.out.println("Account successfully created.");
			return f;
		}
		return null;
	}
}
