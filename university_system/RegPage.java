package university_system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import university_system.HomePage.ButtonListener;
import system.Course;
public class RegPage extends SystemGUI{

	JFrame frame;
	JPanel p, center;
	JList<Course> deptList, courseList, selectList;
	DefaultListModel<Course> deptModel, courseModel, selectModel; 	
	JButton addButton, rmButton, selectButton;
	JComboBox schoolYear, department;
	
	GridBagConstraints gc;
	
	/* A few dummy Course Departments and school years */ 
	String[] depots = {"Computer Science","Physics","Chemistry","Mathematics","Psychology","None-Important"};
	String[] years = {"Summer 2016","Fall 2016","Spring 2017"};
	
	
	public RegPage(JFrame frame){
		this.frame = frame;
		frame.setTitle("University Registration System");
		frame.setSize(1000,500);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout()); // Frame Layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Creating buttons */
		addButton = new JButton("Add to schedule");
		rmButton = new JButton("Remove from list");
		selectButton = new JButton("Select");
		
		selectButton.addActionListener(new ButtonListener()); //button enabled
		addButton.addActionListener(new ButtonListener()); //button enabled
		rmButton.addActionListener(new ButtonListener()); //button enabled
		homeButton.addActionListener(new ButtonListener()); //button enabled
		
		/* Combo Boxes */
		schoolYear = new JComboBox(years);
		department = new JComboBox(depots);
		
		/* Creating lists to be used (A Models manages the list's content)*/
		deptModel = new DefaultListModel<Course>();  
		deptList = new JList<Course>(deptModel); // Department List
		deptList.setVisibleRowCount(10);
		deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		courseModel = new DefaultListModel<Course>(); // Course List
		courseList = new JList<Course>(courseModel);
		courseList.setVisibleRowCount(10);
		courseList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	
		
		selectModel = new DefaultListModel<Course>(); // Selection List
		selectList = new JList<Course>(selectModel);
		selectList.setVisibleRowCount(5);
		selectList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		/* ---------------------
		 * A FEW DUMMY COURSES
		 * ---------------------
		 * */
		Course c1 = new Course("Math", "today", 1650);
		Course c2 = new Course("Computer Science", "today", 2650);
		Course c3 = new Course("Physics", "today",3650);
		Course c4 = new Course("Chemistry", "today", 4650);
		
		courseModel.addElement(c1);
		courseModel.addElement(c2);
		courseModel.addElement(c3);
		courseModel.addElement(c4);
		for(int i = 1; i <= 20; i++){
			courseModel.addElement(new Course("Course "+i+"", "today", 1111));
		}
		
		/*
		 * END OF DUMMY COURSES
		 * 
		 * */
	
		
		/* North Panel */
		p = createHeaderPanel("Course Registration"); // Creates page header
		frame.add(p, BorderLayout.NORTH);
		
		/* Central Panel */
		center = new JPanel(new GridBagLayout());
		
	
		/*	-----------------------------------------------
			-----------------------------------------------
			    GridBagConstraints for Central Panel
			-----------------------------------------------
			----------------------------------------------- 
		*/

		
		/* Registration Button Constraints */
		
		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,0, 0,0,0,0);
		p = new JPanel(new GridBagLayout());
		p.add(department, gc);					
		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,0, 0,0,0,0); // Department List
		titleBorder(p, "Department");
		center.add(p, gc);



		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1, 0,0,0,0);
		p = new JPanel(new GridBagLayout());
		p.add(new JScrollPane(courseList), gc);		
		
		JPanel temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		temp.add(selectButton);
		gc.gridy = 1;		
		p.add(temp, gc);

		gc = bagConstraints(0,1,1,3, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,1, 0,0,0,0);	// Course List
		titleBorder(p, "Courses");
		center.add(p, gc);
	
		

		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,0, 0,0,0,0);
		p = new JPanel(new GridBagLayout());
		temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		temp.add(new JLabel("Academic Year"));
		temp.add(schoolYear);
		p.add(temp,gc);
		gc = bagConstraints(1,0,4,1, GridBagConstraints.BOTH,	// School Year Selection
				GridBagConstraints.CENTER,4,0, 0,0,0,0);
		titleBorder(p, "Select A School Year");
		center.add(p, gc);
		
		
		p = new JPanel(new GridBagLayout());
		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1, 0,0,20,0);
		p.add(new JScrollPane(selectList), gc);
		
		temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		temp.add(addButton);
		temp.add(rmButton);
		gc.gridy = 1;
		p.add(temp, gc);
		
		gc = bagConstraints(1,1,0,2, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,2, 0,0,0,0);	// Selection List
		titleBorder(p, "Selected Courses");
		center.add(p, gc);
		
		
		
		dashBorder(center); // Adds a dashed Border to central panel
		frame.add(center, BorderLayout.CENTER); // Adds central panel to frame 
		
		
		/*
			-----------------------------------------------
			-----------------------------------------------
			----------------------------------------------- 
		*/	



		
		frame.setVisible(true);
	}

	/*	-----------------------------------------------
		-----------------------------------------------
		    Button Action Handler Private Class
		----------------------------------------------- 
		------------------ -----------------------------
	*/	

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == selectButton){
				System.out.println("Selected Course");
				selectedCourses();
			}
			else if(e.getSource() == addButton){
				System.out.println("Added Course To Schedule");
				removeSelected();
			}
			else if(e.getSource() == rmButton){
				System.out.println("Removed Course From List");
				removeSelected();
			}
			else if(e.getSource() == homeButton){
				System.out.println("Home Button Pressed");
				frame.getContentPane().removeAll();
        		new HomePage(frame);
			}
		}
	}

	/*
		-----------------------------------------------
		-----------------------------------------------
		----------------------------------------------- 
		-----------------------------------------------
	*/
	
	public void selectedCourses(){
		this.selectModel.addElement(this.courseList.getSelectedValue());
	}
	
	public void removeSelected(){
		selectModel.removeElement(this.selectList.getSelectedValue());
	}

	
	/*
	 * Main program tester
	 * */
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegPage(new JFrame());
            }
        });
	}
}