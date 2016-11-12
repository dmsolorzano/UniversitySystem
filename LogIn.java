import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

/*
	LogIn Class searches a username and password pair in the 
	database and determines if they correspond to an existing user.
	If the pair corresponds to a user, the program extracts the user
	type and calls out the corresponding homepage for that specific 
	user type. 
*/

public class LogIn{
	//User userType;
	JFrame frame;
	JButton logInButton = new JButton("Log In");

	//LogIn intends to take a userType//
	public LogIn(){
		frame = new JFrame("Log In Page");
		//this.userType = userType;
		createGUI();
	}

	public void createGUI(){

		/* Default Frame Size of program */
		
		frame.setSize(1000,500);
		frame.setLayout(new FlowLayout()); // Frame Layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(logInButton);


		logInButton.addActionListener( new ActionListener()
		{
    		public void actionPerformed(ActionEvent e)
    		{
        		System.out.println("ButtonPressed");
        		//createFrame();
        		//frame.setVisible(false);
        		newFrame(frame);
        	// Create a method named "createFrame()", and set up an new frame there
        	// Call createFrame()
    		}
		});

		frame.setVisible(true);
	}

	public void newFrame(JFrame thisFrame){
		frame.setLayout(new FlowLayout());
		frame.setTitle("Another Page");
		frame.setSize(500,500);
		frame.add(logInButton);
		frame.setVisible(true);
	}

/*

==============================================

*/

public static void createFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try 
                {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                   e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);
                JTextArea textArea = new JTextArea(15, 50);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                textArea.setFont(Font.getFont(Font.SANS_SERIF));
                JScrollPane scroller = new JScrollPane(textArea);
                scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                JPanel inputpanel = new JPanel();
                inputpanel.setLayout(new FlowLayout());
                JTextField input = new JTextField(20);
                JButton button = new JButton("Enter");
                DefaultCaret caret = (DefaultCaret) textArea.getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                panel.add(scroller);
                inputpanel.add(input);
                inputpanel.add(button);
                panel.add(inputpanel);
                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
                input.requestFocus();
            }
        });
    }

	public static void main(String[] args){
		LogIn logPage = new LogIn();
	}



}