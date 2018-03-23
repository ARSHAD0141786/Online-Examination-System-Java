package user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import main.MainFrame;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import database.FormData;
import java.awt.SystemColor;


public class RegistrationForm extends JPanel implements ActionListener {
	
	//public because FormData class is using these values
	public JTextField USERNAME;
	public JTextField PASSWORD;
	public JTextField FIRST;
	public JTextField MIDDLE;
	public JTextField LAST;
	public JTextField EMAIL;
	public JTextField MOBILE;
	public JTextField COLLEGE;
	public JTextArea ADDRESS;
	public char Gender;
	public int Date;
	public int Month;
	public int Year;
	
	private String ErrMsg;
	
	//panel variables
	JComboBox<String> year;
	JComboBox<String> month;
	JComboBox<String> date;
	/**
	 * Create the panel.
	 */
	public boolean saveData()
	{
		return FormData.saveData(this);
	}
	public boolean checkData()
	{
		if(USERNAME.getText().equals(""))
		{
			ErrMsg="Username cant be empty.";
			return false;
		}
		else if(PASSWORD.getText().equals(""))
		{
			ErrMsg="Password cant be empty.";
			return false;
		}
		else if(FIRST.getText().equals(""))
		{
			ErrMsg="Firstname cant be empty.";
			return false;
		}
		else if(EMAIL.getText().equals(""))
		{
			ErrMsg="Email cant be empty.";
			return false;
		}
		else if(MOBILE.getText().equals(""))
		{
			ErrMsg="Mobile number cant be empty.";
			return false;
		}
		else if(COLLEGE.getText().equals(""))
		{
			ErrMsg="Plese enter college name";
			return false;
		}
		else if(ADDRESS.getText().equals(""))
		{
			ErrMsg="Please select address";
			return false;
		}
		else if(!(Gender=='M' ||Gender=='F' ||Gender=='O'))
		{
			ErrMsg="Please select gender.";
			return false;
		}
		else
			return true;
	}
	

	public RegistrationForm() {
		setLayout(null);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkData())
				{
					if(saveData())
					{
						//add Successful panel
						JOptionPane.showMessageDialog(null, "You have registered successfully");
						MainFrame.AddPanel(new UserLogin());
						
					}
				}
				else
				{
					//Something is missing error
					JOptionPane.showMessageDialog(null, ErrMsg);
				}
			}
		});
		submit.setForeground(new Color(0, 0, 0));
		submit.setFont(new Font("Sakkal Majalla", Font.BOLD, 32));
		submit.setBounds(477, 470, 127, 35);
		add(submit);
		
		JButton reset = new JButton("RESET");
		reset.setForeground(new Color(0, 0, 0));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new RegistrationForm());
			}
		});
		reset.setFont(new Font("Sakkal Majalla", Font.BOLD, 32));
		reset.setBounds(295, 470, 116, 35);
		add(reset);
		
		ADDRESS = new JTextArea("");
		ADDRESS.setBounds(276, 340, 331, 64);
		add(ADDRESS);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(240, 255, 255));
		lblAddress.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblAddress.setBounds(181, 339, 85, 26);
		add(lblAddress);
		
		COLLEGE = new JTextField("");
		COLLEGE.setFont(new Font("Tahoma", Font.BOLD, 14));
		COLLEGE.setColumns(10);
		COLLEGE.setBounds(276, 305, 331, 20);
		add(COLLEGE);
		
		JLabel lblCollege = new JLabel("COLLEGE");
		lblCollege.setForeground(new Color(240, 255, 255));
		lblCollege.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblCollege.setBounds(181, 302, 85, 26);
		add(lblCollege);
		
		year = new JComboBox<String>();
		Year=1951;
		year.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		year.setModel(new DefaultComboBoxModel<String>(new String[] {"1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006"}));
		year.setBounds(467, 268, 69, 20);
		add(year);
		year.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Year=Integer.parseInt((String)year.getSelectedItem());
			}
		});
		
		month = new JComboBox<String>();
		Month=01;
		month.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		month.setModel(new DefaultComboBoxModel<String>(new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}));
		month.setBounds(360, 268, 97, 20);
		add(month);
		month.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String s=(String)month.getSelectedItem();
				if(s.equals("JANUARY"))
					Month=1;
				else if(s.equals("FEBRUARY"))
					Month=2;
				else if(s.equals("MARCH"))
					Month=3;
				else if(s.equals("APRIL"))
					Month=4;
				else if(s.equals("MAY"))
					Month=5;
				else if(s.equals("JUNE"))
					Month=6;
				else if(s.equals("JULY"))
					Month=7;
				else if(s.equals("AUGUST"))
					Month=8;
				else if(s.equals("SEPTEMBER"))
					Month=9;
				else if(s.equals("OCTOBER"))
					Month=10;
				else if(s.equals("NOVEMBER"))
					Month=11;
				else if(s.equals("DECEMBER"))
					Month=12;
				else
					Month=0;
			}
		});
		
		date = new JComboBox<String>();
		Date=01;
		date.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		date.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		date.setBounds(276, 268, 74, 20);
		add(date);
		date.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Date=Integer.parseInt((String)date.getSelectedItem());	
			}
		});
		
		
		JLabel label = new JLabel("MOBILE NO.");
		label.setForeground(new Color(240, 255, 255));
		label.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		label.setBounds(522, 192, 99, 26);
		add(label);
		
		MOBILE = new JTextField("");
		MOBILE.setFont(new Font("Tahoma", Font.BOLD, 14));
		MOBILE.setColumns(10);
		MOBILE.setBounds(617, 193, 116, 20);
		add(MOBILE);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setForeground(new Color(240, 255, 255));
		lblDob.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblDob.setBounds(181, 265, 85, 26);
		add(lblDob);
		
		EMAIL = new JTextField("");
		EMAIL.setFont(new Font("Tahoma", Font.BOLD, 14));
		EMAIL.setColumns(10);
		EMAIL.setBounds(276, 231, 331, 20);
		add(EMAIL);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setForeground(new Color(240, 255, 255));
		lblEmail.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblEmail.setBounds(181, 228, 85, 26);
		add(lblEmail);
		
		JRadioButton other = new JRadioButton("OTHER");
		other.setOpaque(false);
		other.setForeground(new Color(245, 222, 179));
		other.setFont(new Font("SimSun-ExtB", Font.BOLD, 13));
		other.setBounds(413, 193, 73, 23);
		add(other);
		other.addActionListener(this);
		
		JRadioButton female = new JRadioButton("FEMALE");
		female.setOpaque(false);
		female.setForeground(new Color(245, 222, 179));
		female.setFont(new Font("SimSun-ExtB", Font.BOLD, 13));
		female.setBounds(338, 193, 73, 23);
		add(female);
		female.addActionListener(this);
		
		JRadioButton male = new JRadioButton("MALE");
		male.setFont(new Font("SimSun-ExtB", Font.BOLD, 13));
		male.setForeground(new Color(245, 222, 179));
		male.setOpaque(false);
		male.setBounds(276, 193, 60, 23);
		add(male);
		male.addActionListener(this);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		bg.add(other);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setForeground(new Color(240, 255, 255));
		lblGender.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblGender.setBounds(181, 191, 85, 26);
		add(lblGender);
		
		LAST = new JTextField("");
		LAST.setFont(new Font("Tahoma", Font.BOLD, 14));
		LAST.setColumns(10);
		LAST.setBounds(528, 157, 116, 20);
		add(LAST);
		
		MIDDLE = new JTextField("");
		MIDDLE.setFont(new Font("Tahoma", Font.BOLD, 14));
		MIDDLE.setColumns(10);
		MIDDLE.setBounds(402, 157, 116, 20);
		add(MIDDLE);
		
		FIRST = new JTextField("");
		FIRST.setFont(new Font("Tahoma", Font.BOLD, 14));
		FIRST.setColumns(10);
		FIRST.setBounds(276, 157, 116, 20);
		add(FIRST);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(240, 255, 255));
		lblName.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblName.setBounds(181, 154, 85, 26);
		add(lblName);
		
		PASSWORD = new JTextField("");
		PASSWORD.setFont(new Font("Tahoma", Font.BOLD, 14));
		PASSWORD.setColumns(10);
		PASSWORD.setBounds(617, 120, 116, 20);
		add(PASSWORD);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(186, 85, 211));
		separator.setBounds(239, 73, 513, 2);
		add(separator);
		
		USERNAME = new JTextField("");
		USERNAME.setFont(new Font("Tahoma", Font.BOLD, 14));
		USERNAME.setBounds(276, 120, 116, 20);
		add(USERNAME);
		USERNAME.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(240, 255, 255));
		lblUsername.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblUsername.setBounds(181, 117, 85, 26);
		add(lblUsername);
		
		JButton back = new JButton("BACK");
		back.setBounds(10, 511, 99, 35);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new UserLogin());
			}
		});
		back.setForeground(new Color(0, 0, 0));
		back.setBackground(SystemColor.controlHighlight);
		back.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		add(back);
		
		JLabel lblOnlineExamination = new JLabel("REGISTRATION FORM");
		lblOnlineExamination.setBounds(228, 18, 535, 57);
		lblOnlineExamination.setForeground(new Color(0, 0, 0));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Times New Roman", Font.BOLD, 41));
		add(lblOnlineExamination);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(240, 255, 255));
		lblPassword.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblPassword.setBounds(522, 117, 85, 26);
		add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC32.PNG"));
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 990, 558);
		lblNewLabel.setBorder(new LineBorder(new Color(65, 105, 225), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel);

	}

	
	//Details updation methods
	
	private boolean updateData()
	{
		return FormData.updateData(this);
	}
	
	public RegistrationForm(EditDetails e) {
		setLayout(null);
		
		JButton submit = new JButton("SAVE");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkData())
				{
					if(updateData())
					{
						//Data updated Successfully login again
						System.out.println("Login Again.");
						MainFrame.AddPanel(new UserLogin());					
					}
					else
					{
						//error in updating Data
						System.out.println("Data not updated");
					}
				}
				else
				{
					//Something is missing error
					JOptionPane.showMessageDialog(null, ErrMsg);
				}
			}
		});
		
		JLabel label_2 = new JLabel(e.RegDate);
		label_2.setForeground(new Color(240, 255, 255));
		label_2.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		label_2.setBounds(568, 86, 242, 26);
		add(label_2);
		
		JLabel lblRegDate = new JLabel("REG Date : ");
		lblRegDate.setForeground(new Color(240, 255, 255));
		lblRegDate.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblRegDate.setBounds(468, 86, 109, 26);
		add(lblRegDate);
		
		JLabel label_1 = new JLabel(e.RegNo);
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		label_1.setBounds(149, 90, 85, 26);
		add(label_1);
		
		JLabel lblRegNo = new JLabel("REG NO. : ");
		lblRegNo.setForeground(new Color(240, 255, 255));
		lblRegNo.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblRegNo.setBounds(58, 90, 97, 26);
		add(lblRegNo);
		submit.setForeground(new Color(50, 205, 50));
		submit.setFont(new Font("Sakkal Majalla", Font.ITALIC, 32));
		submit.setBounds(623, 489, 116, 35);
		add(submit);
		
		ADDRESS = new JTextArea(e.ADDRESS);
		ADDRESS.setBounds(277, 359, 331, 64);
		add(ADDRESS);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(240, 255, 255));
		lblAddress.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblAddress.setBounds(182, 358, 85, 26);
		add(lblAddress);
		
		COLLEGE = new JTextField(e.COLLEGE);
		COLLEGE.setFont(new Font("Tahoma", Font.BOLD, 14));
		COLLEGE.setColumns(10);
		COLLEGE.setBounds(277, 324, 331, 20);
		add(COLLEGE);
		
		JLabel lblCollege = new JLabel("COLLEGE");
		lblCollege.setForeground(new Color(240, 255, 255));
		lblCollege.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblCollege.setBounds(182, 321, 85, 26);
		add(lblCollege);
		
		year = new JComboBox<String>();
		year.setEnabled(false);
		year.setFocusable(false);
		year.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		year.setModel(new DefaultComboBoxModel<String>(new String[] {"1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006"}));
		year.setSelectedIndex(e.Year-1951);
		year.setBounds(468, 287, 69, 20);
		add(year);
		Year=e.Year;
		
		
		month = new JComboBox<String>();
		month.setEnabled(false);
		month.setFocusable(false);
		month.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		month.setModel(new DefaultComboBoxModel<String>(new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"}));
		month.setSelectedIndex(e.Month-1);
		month.setBounds(361, 287, 97, 20);
		add(month);
		Month=e.Month;
		
		date = new JComboBox<String>();
		date.setEnabled(false);
		date.setFocusable(false);
		date.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		date.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		date.setSelectedIndex(e.Date-1);
		date.setBounds(277, 287, 74, 20);
		add(date);
		Date=e.Date;
		
		JLabel label = new JLabel("MOBILE NO.");
		label.setForeground(new Color(240, 255, 255));
		label.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		label.setBounds(523, 211, 99, 26);
		add(label);
		
		MOBILE = new JTextField(e.MOBILE);
		MOBILE.setFont(new Font("Tahoma", Font.BOLD, 14));
		MOBILE.setColumns(10);
		MOBILE.setBounds(618, 212, 116, 20);
		add(MOBILE);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setForeground(new Color(240, 255, 255));
		lblDob.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblDob.setBounds(182, 284, 85, 26);
		add(lblDob);
		
		EMAIL = new JTextField(e.EMAIL);
		EMAIL.setFont(new Font("Tahoma", Font.BOLD, 14));
		EMAIL.setColumns(10);
		EMAIL.setBounds(277, 250, 331, 20);
		add(EMAIL);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setForeground(new Color(240, 255, 255));
		lblEmail.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblEmail.setBounds(182, 247, 85, 26);
		add(lblEmail);
		
		JRadioButton other = new JRadioButton("OTHER");
		other.setEnabled(false);
		other.setOpaque(false);
		other.setForeground(new Color(245, 222, 179));
		other.setFont(new Font("SimSun-ExtB", Font.BOLD, 13));
		other.setBounds(414, 212, 73, 23);
		add(other);
		
		JRadioButton female = new JRadioButton("FEMALE");
		female.setEnabled(false);
		female.setOpaque(false);
		female.setForeground(new Color(245, 222, 179));
		female.setFont(new Font("SimSun-ExtB", Font.BOLD, 13));
		female.setBounds(339, 212, 73, 23);
		add(female);
		
		JRadioButton male = new JRadioButton("MALE");
		male.setEnabled(false);
		male.setFont(new Font("SimSun-ExtB", Font.BOLD, 13));
		male.setForeground(new Color(245, 222, 179));
		male.setOpaque(false);
		male.setBounds(277, 212, 60, 23);
		add(male);
				
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setForeground(new Color(240, 255, 255));
		lblGender.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblGender.setBounds(182, 210, 85, 26);
		add(lblGender);
		Gender=e.Gender.charAt(0);
		switch(Gender)
		{
		case 'M' :male.setSelected(true);break;
		case 'F' :female.setSelected(true);break;
		case 'O' :other.setSelected(true);break;
		}
		
		LAST = new JTextField(e.LAST);
		LAST.setEditable(false);
		LAST.setFont(new Font("Tahoma", Font.BOLD, 14));
		LAST.setColumns(10);
		LAST.setBounds(529, 176, 116, 20);
		add(LAST);
		
		MIDDLE = new JTextField(e.MIDDLE);
		MIDDLE.setEditable(false);
		MIDDLE.setFont(new Font("Tahoma", Font.BOLD, 14));
		MIDDLE.setColumns(10);
		MIDDLE.setBounds(403, 176, 116, 20);
		add(MIDDLE);
		
		FIRST = new JTextField(e.FIRST);
		FIRST.setEditable(false);
		FIRST.setFont(new Font("Tahoma", Font.BOLD, 14));
		FIRST.setColumns(10);
		FIRST.setBounds(277, 176, 116, 20);
		add(FIRST);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(240, 255, 255));
		lblName.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblName.setBounds(182, 173, 85, 26);
		add(lblName);
		
		PASSWORD = new JTextField(e.PASSWORD);
		PASSWORD.setFont(new Font("Tahoma", Font.BOLD, 14));
		PASSWORD.setColumns(10);
		PASSWORD.setBounds(618, 139, 116, 20);
		add(PASSWORD);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(186, 85, 211));
		separator.setBounds(239, 73, 513, 2);
		add(separator);
		
		USERNAME = new JTextField(e.USERNAME);
		USERNAME.setFont(new Font("Tahoma", Font.BOLD, 14));
		USERNAME.setBounds(277, 139, 116, 20);
		add(USERNAME);
		USERNAME.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(240, 255, 255));
		lblUsername.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblUsername.setBounds(182, 136, 85, 26);
		add(lblUsername);
		
		JButton back = new JButton("BACK");
		back.setBounds(10, 511, 99, 35);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//Resuming User Panel
					MainFrame.AddPanel(new UserPanel(USERNAME.getText()));
			}
		});
		back.setForeground(new Color(255, 69, 0));
		back.setBackground(SystemColor.controlHighlight);
		back.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		add(back);
		
		JLabel lblOnlineExamination = new JLabel("USER DETAILS");
		lblOnlineExamination.setBounds(228, 18, 535, 57);
		lblOnlineExamination.setForeground(new Color(240, 255, 240));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Lucida Handwriting", Font.BOLD, 41));
		add(lblOnlineExamination);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(240, 255, 255));
		lblPassword.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 13));
		lblPassword.setBounds(523, 136, 85, 26);
		add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC32.PNG"));
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 990, 558);
		lblNewLabel.setBorder(new LineBorder(new Color(65, 105, 225), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel);

	}
	public void actionPerformed(ActionEvent arg0) {
		Gender=(arg0.getActionCommand()).charAt(0);	
	}
}
