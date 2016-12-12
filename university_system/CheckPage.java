package university_system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import university_system.HomePage.ButtonListener;

public class CheckPage extends SystemGUI{

	JFrame frame;
	JPanel p, center; // GridBagConstraints
	JButton evaluateButton;
	JComboBox major, firstMinor, secondMinor;
	GridBagConstraints gc;
	JTabbedPane tabbedPane;
	JTable evalTable;
	
	/*
	 * Arrays used for JComboBox's in this GUI
	 */
	final String[] majors = {"","Mathematics","Physics","Computer Science",
			"Psychology","Criminal Justice","Economics"};
	

	/*
	 * Arrays for preliminary tests with JTable, two examples
	 */
	String[] columnTitles = new String[]{"Course #","Courses Required","Credit Hours","Status"};
	Object[][] dataTest = new Object[][]{
		{"3331", "Advanced Object Oriented", 3, "Passed"},
		{"3350", "Automata", 3, "Missing"}
	};
	
	
	/*
	 * Column type definition for JTable
	 */
	final Class[] columnClasses = new Class[]{
			String.class, String.class, Integer.class, String.class
	};
	
	
	public CheckPage(JFrame frame){
		this.frame = frame;
		frame.setTitle("University Registration System");
		frame.setSize(1000,500);
		frame.setLayout(new BorderLayout()); // Frame Layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		/* Buttons */
		evaluateButton = new JButton("Evaluate");
		
		/*
		 *  Button enablers //
		 */
		homeButton.addActionListener(new ButtonListener()); //button enabled
		
		/*
		 * Creating the JComboBox's
		 */
		major = new JComboBox<String>(majors);
		firstMinor = new JComboBox<String>(majors);
		secondMinor = new JComboBox<String>(majors);
		
		/* North Panel*/		
		p = createHeaderPanel("Records"); // Creates page header 
		frame.add(p, BorderLayout.NORTH);	// Adds header to frame
		
		tabbedPane = new JTabbedPane();

		JPanel calendarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		calendarPanel.add(new JLabel("This is a Page 1"));

		JPanel degreeEvalPanel = createDegreeEvalGUI();
		JPanel transcriptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		transcriptPanel.add(new JLabel("This is a Page 3"));

		tabbedPane.add("Degree Evaluation", degreeEvalPanel);
		tabbedPane.add("Class Schedule", calendarPanel);
		tabbedPane.add("Transcript", transcriptPanel);
		
		frame.add(tabbedPane);
		frame.setVisible(true);
	}

	/*	-----------------------------------------------
		-----------------------------------------------
		    Button Action Handler Private Class
		----------------------------------------------- 
		-----------------------------------------------
	*/	

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == homeButton){
				System.out.println("Registration Button Pressed");
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
	private JPanel createDegreeEvalGUI(){
		JPanel panel = new JPanel(new BorderLayout());
		/*
		 * Adding JTABLE MODEL to center panel
		 */
		DefaultTableModel model = new DefaultTableModel(dataTest, columnTitles){
	
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column)
		    {
		        return false;
		    }

		    @Override
		    public Class<?> getColumnClass(int columnIndex)
		    {
		        return columnClasses[columnIndex];
		    }
		};
		
		/*
		 * Initializing JTable with model
		 */
		evalTable = new JTable(model);
		evalTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		evalTable.setFillsViewportHeight(true);

		
		/* Central Panel */
		center = new JPanel(new GridBagLayout());
		
		/*	-----------------------------------------------
			-----------------------------------------------
			    GridBagConstraints for Central Panel
			-----------------------------------------------
			----------------------------------------------- 
		*/
		
		/*
		 * Adding Search Courses By Section to center panel
		 */
		p = new JPanel(new GridBagLayout()); // Constraints Basis
		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1, 5,5,5,5); // Department Label
		p.add(new JLabel("Majors: "), gc); 					
		
		gc.gridx = 1; // Department ComboBox
		p.add(this.major, gc);
		
		gc.gridx = 0; // Course Name Label
		gc.gridy = 1;
		p.add(new JLabel("Minor: "), gc);					
		
		gc.gridx = 1; // Course Name Text Field
		p.add(firstMinor, gc);
		
		gc.gridx = 0; // CRN Label
		gc.gridy = 2;
		p.add(new JLabel("Second Minor (optional) "), gc);					
		
		gc.gridx = 1; // CRN Text Field
		p.add(secondMinor, gc);
		
		gc.gridx = 0; // CRN Label
		gc.gridy = 3;
		gc.gridwidth = 2;
		gc.weightx = 2;
		p.add(evaluateButton, gc);					
		
		
		titleBorder(p, "My Degree Evaluation"); // A titled Border
		 
		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,0, 0,0,0,0); // Adding to center panel
		center.add(p, BorderLayout.NORTH);
		
		/*
		 * Adding the JTable to center panel
		 */
		p = new JPanel(new BorderLayout()); // Re-using p panel
		p.add(new JScrollPane(evalTable), BorderLayout.CENTER);
		titleBorder(p, "Search Results"); // A titled Border
		
		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1, 0,0,0,0); // Last Name Label
//		center.add(p, BorderLayout.SOUTH); // Added JTable to center panel
		
		/*
		 * Mouse Listener for JTable when double clicking a table element 
		 */
		evalTable.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		            // your valueChanged overridden method
		        	System.out.println("Doubled Clicked! Check Records");
		        }
		    }
		});
		
		return this.p;
	}
	
	private JPanel createCalendarGUI(){
		JPanel panel = new JPanel();
		return panel;
	}
	
	private JPanel createTranscriptsGUI(){
		JPanel panel = new JPanel();
		return panel;
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		CheckPage mypage = new CheckPage(frame);
	}
}