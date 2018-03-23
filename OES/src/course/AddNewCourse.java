package course;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.JTextField;
import com.mysql.jdbc.PreparedStatement;
import database.Connect;

public class AddNewCourse extends JPanel implements FocusListener {
	private JTextField courseName;
	private JTextField HH;
	private JTextField MM;
	private JTextField SS;
	private int questionMark=0;
	private JComboBox<Integer> eachMark;
	/**
	 * Create the panel.
	 */
	private boolean addCourse(String courseName,String time)
	{
		Connect c=new Connect("root","");
		try{
			String query="INSERT INTO course_details (course_name,time,date_of_creation,question_mark) VALUES(?,?,current_timestamp,?)";
			PreparedStatement ps=(PreparedStatement)c.con.prepareStatement(query);
			ps.setString(1, courseName);
			ps.setString(2, time);
			ps.setInt(3, questionMark);
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			return false;
		}
		catch(SQLException e)
		{
			System.out.println("Course cant be added : "+e);
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public AddNewCourse() {
		setLayout(null);
		
		JButton btnShowCourse = new JButton("ADD COURSE");
		btnShowCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String time=""+HH.getText()+":"+MM.getText()+":"+SS.getText()+"";
				if(addCourse(courseName.getText(), time))
				{
					//course add successfully go back
					MainFrame.AddPanel(new CoursePanel());
					JOptionPane.showMessageDialog(null,"Course added successfully");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Course not added successfully.\nPlease check details you filled.");
					//course not add .
				}
			}
		});
		
		SS = new JTextField();
		SS.setForeground(Color.LIGHT_GRAY);
		SS.setText("SECOND");
		SS.setFont(new Font("Mangal", Font.PLAIN, 18));
		SS.setColumns(10);
		SS.setBounds(610, 221, 89, 36);
		add(SS);
		SS.addFocusListener(this);
		
		MM = new JTextField();
		MM.setForeground(Color.LIGHT_GRAY);
		MM.setText("MINUTE");
		MM.setFont(new Font("Mangal", Font.PLAIN, 18));
		MM.setColumns(10);
		MM.setBounds(451, 221, 89, 36);
		add(MM);
		MM.addFocusListener(this);
		
		JLabel lblEachMark = new JLabel("EACH MARK");
		lblEachMark.setFont(new Font("Papyrus", Font.BOLD, 18));
		lblEachMark.setForeground(new Color(248, 248, 255));
		lblEachMark.setBounds(291, 303, 181, 33);
		add(lblEachMark);
		
		eachMark= new JComboBox<Integer>();
		eachMark.setFont(new Font("SimSun", Font.BOLD, 19));
		eachMark.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3,4,5,6,7,8}));
		eachMark.setBounds(482, 302, 57, 21);
		add(eachMark);
		eachMark.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				questionMark=(Integer)eachMark.getSelectedItem();
				
			}
		});
		
		HH = new JTextField();
		HH.setForeground(Color.LIGHT_GRAY);
		HH.setText("HOUR");
		HH.setFont(new Font("Mangal", Font.PLAIN, 18));
		HH.setColumns(10);
		HH.setBounds(291, 221, 89, 36);
		add(HH);
		HH.addFocusListener(this);
		
		courseName = new JTextField();
		courseName.setForeground(Color.LIGHT_GRAY);
		courseName.setFont(new Font("Mangal", Font.PLAIN, 18));
		courseName.setText("COURSE NAME");
		courseName.setBounds(291, 162, 408, 36);
		add(courseName);
		courseName.setColumns(10);
		courseName.addFocusListener(this);
		
		btnShowCourse.setForeground(new Color(218, 112, 214));
		btnShowCourse.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnShowCourse.setBounds(472, 417, 256, 36);
		add(btnShowCourse);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new CoursePanel());
			}
		});
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton.setBounds(10, 511, 89, 36);
		add(btnNewButton);
		
		JLabel lblOnlineExamination = new JLabel("ADD COURSE");
		lblOnlineExamination.setForeground(new Color(176, 224, 230));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Lucida Handwriting", Font.BOLD, 41));
		lblOnlineExamination.setBounds(194, 30, 603, 105);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC16.PNG"));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 128, 0), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
	}

	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==HH && HH.getForeground()==Color.LIGHT_GRAY)
		{
			HH.setText("");
			HH.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
			HH.setForeground(Color.BLACK);
		}
		if(arg0.getSource()==MM && MM.getForeground()==Color.LIGHT_GRAY)
		{
			MM.setText("");
			MM.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
			MM.setForeground(Color.BLACK);
		}
		if(arg0.getSource()==SS && SS.getForeground()==Color.LIGHT_GRAY)
		{
			SS.setText("");
			SS.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
			SS.setForeground(Color.BLACK);
		}
		if(arg0.getSource()==courseName && courseName.getForeground()==Color.LIGHT_GRAY)
		{
			courseName.setText("");
			courseName.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
			courseName.setForeground(Color.BLACK);
		}
	}

	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if(HH.getText().equals(""))
		{
			HH.setForeground(Color.LIGHT_GRAY);
			HH.setFont(new Font("Mangal", Font.PLAIN, 18));
			HH.setText("HOUR");
		}
		if(MM.getText().equals(""))
		{
			MM.setForeground(Color.LIGHT_GRAY);
			MM.setFont(new Font("Mangal", Font.PLAIN, 18));
			MM.setText("MINUTE");
		}
		if(SS.getText().equals(""))
		{
			SS.setForeground(Color.LIGHT_GRAY);
			SS.setFont(new Font("Mangal", Font.PLAIN, 18));
			SS.setText("SECOND");
		}
		if(courseName.getText().equals(""))
		{
			courseName.setForeground(Color.LIGHT_GRAY);
			courseName.setFont(new Font("Mangal", Font.PLAIN, 18));
			courseName.setText("COURSE NAME");
		}
	}
}
