import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/** An abstract class which represents types of users
 * @author Darren Solorzano
 * @author Reynaldo Martinez
 * @author Chris Santos
 * @version 1.3
 * */
public class User {
	
	private int id;
	private String name;
	private String username;
	private String password;

	public User(int id, String name, String user, String pass) {
		this.setId(id);
		this.setName(name);
		user = username;
		pass = password;
	}

	/*Modifiers and Accessors for User class*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	protected Connection accessDatabase() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306","root","5jxaif72haq");
		return con;
	}
	/** Method that will create the initial database with basic tables and pre-set values
	 * */
	public void createDatabase() throws Exception{
		Statement stmt = accessDatabase().createStatement();
		stmt.execute("create database university;");
		stmt.execute("use university;");
		stmt.execute("create table course(courseName VARCHAR(40), id int not null, startTime VARCHAR(10), "
				+ "endTime VARCHAR(10), days VARCHAR(10), startDate DATE, endDate DATE);");
		stmt.execute("create table student(id int not null, firstName VARCHAR(20), lastName VARCHAR(20));");
		stmt.execute("create table faculty(id int not null, firstName VARCHAR(20), lastName VARCHAR(20));");
		
		stmt.execute("insert into student values (808080, 'Darren', 'Solorzano');");// Test statements
		stmt.execute("insert into student values (808081, 'Daniel', 'Quonones');");// Test statements
		stmt.execute("insert into student values (808082, 'John', 'Smith');");// Test statements
		stmt.execute("insert into student values (808083, 'Mac', 'book');");// Test statements
	}
}