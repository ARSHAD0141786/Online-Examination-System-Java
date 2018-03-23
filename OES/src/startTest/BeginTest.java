package startTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import database.Connect;
import main.MainFrame;

public class BeginTest extends JPanel {

	/**
	 * Create the panel.
	 */
	private static String username;
	private static String courseName;
	QuestionPanel questionPanel;
	static int eachMarks;
	private int HH=0;
	private int MM=0;
	private int SS=0;
	
	public BeginTest()
	{
		
	}
	private static String[] computeResult()
	{
		String Result[]=new String[9];
		int totalQuestions=QuestionPanel.qInfo.length;
		int timeTaken=Clock.time;
		int CQ=0;
		for(String s[]:QuestionPanel.qInfo)
		{
			if(s[1].equals(s[2]) && !(s[1].equals("-1")))
				CQ++;
		}
		String time;
		int temp=timeTaken%60;
		time=":"+temp;
		temp=(timeTaken-temp)/60;
		time=":"+(temp%60)+time;
		temp=(temp-temp%60)/60;
		time=temp+time;
		
		Result[0]=courseName;
		Result[1]=time;//timeTaken;
		Result[2]=""+totalQuestions;  //total questions
		Result[3]=""+QuestionPanel.q_attempted;//attemptedQuestion;
		Result[4]=""+CQ;//correct questions;
		Result[5]=""+(QuestionPanel.q_attempted-CQ);//wrong;
		Result[6]=""+(CQ*eachMarks);//marksobtained;
		Result[7]=""+(totalQuestions*eachMarks);//total marks;
		Result[8]=""+(((float)(CQ*eachMarks)/(totalQuestions*eachMarks))*100);//percentage;
		return Result;
	}
	
	private void executeQuery()
	{
		Connect c=new Connect("root","");
		try{
			Statement st=c.con.createStatement();
			String temp="select time from course_details where course_name='"+courseName+"'";
			ResultSet rs=st.executeQuery(temp);
			rs.next();
			temp=rs.getString(1);

			HH=Integer.parseInt(temp.substring(0, 2));
			MM=Integer.parseInt(temp.substring(3, 5));
			SS=Integer.parseInt(temp.substring(6, 8));
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	static void endTest()
	{
		//Compute result , show result
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MainFrame.AddPanel(new ShowResult(computeResult(),username));
		QuestionPanel.q_attempted=0;
		Clock.time=0;
	}
	
	public BeginTest(String Username,String CourseName,String eachMarks) {
		courseName=CourseName;
		username=Username;
		executeQuery();
		BeginTest.eachMarks=Integer.parseInt(eachMarks);
		makeGUI();
	}
	private Clock c;
	public void makeGUI()
	{
		
		JLabel lblCourseName = new JLabel("COURSE NAME : "+courseName);
		lblCourseName.setForeground(new Color(175, 238, 238));
		lblCourseName.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 20));
		lblCourseName.setBounds(10, 26, 382, 34);
		add(lblCourseName);
		//addTimer
		
		c=new Clock(HH,MM,SS);
		c.setBounds(720,11,260,124);
		add(c);
		//add QuestionPanel
		questionPanel= new QuestionPanel(courseName);
		questionPanel.setBounds(10, 71, 689, 427);
		add(questionPanel);
		
		//add submit button 
		setLayout(null);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				endTest();
				c.t.stop();//if submit button clicks then stop the thread of clock
			}
		});
		btnSubmit.setForeground(new Color(138, 43, 226));
		btnSubmit.setFont(new Font("Castellar", Font.BOLD, 25));
		btnSubmit.setBackground(new Color(50, 205, 50));
		btnSubmit.setBounds(787, 228, 152, 116);
		btnSubmit.setFocusable(false);
		add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC30.PNG"));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBorder(new LineBorder(new Color(210, 180, 140), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
		
	}
}
